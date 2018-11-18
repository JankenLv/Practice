package com.lvjing.oa.biz.impl;

import com.lvjing.oa.biz.ClaimVoucherBiz;
import com.lvjing.oa.dao.ClaimVoucherDao;
import com.lvjing.oa.dao.ClaimVoucherItemDao;
import com.lvjing.oa.dao.DealRecordDao;
import com.lvjing.oa.dao.EmployeeDao;
import com.lvjing.oa.entity.ClaimVoucher;
import com.lvjing.oa.entity.ClaimVoucherItem;
import com.lvjing.oa.entity.DealRecord;
import com.lvjing.oa.entity.Employee;
import com.lvjing.oa.global.Contant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("claimVoucherBiz")
public class ClaimVoucherBizImpl implements ClaimVoucherBiz {

    @Resource
    private ClaimVoucherDao claimVoucherDao;

    @Resource
    private ClaimVoucherItemDao claimVoucherItemDao;

    @Resource
    private DealRecordDao dealRecordDao;

    @Resource
    private EmployeeDao employeeDao;

    public void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items) {
        claimVoucher.setCreateTime(new Date());
        claimVoucher.setNextDealSn(claimVoucher.getCreateSn());
        claimVoucher.setStatus(Contant.CLAIMVOUCHER_CREATED);
        claimVoucherDao.insert(claimVoucher);

        for (ClaimVoucherItem item : items) {
            item.setClaimVoucherId(claimVoucher.getId());
            claimVoucherItemDao.insert(item);
        }
    }

    public void update(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items) {
        claimVoucher.setCreateTime(new Date());
        claimVoucher.setNextDealSn(claimVoucher.getCreateSn());
        claimVoucher.setStatus(Contant.CLAIMVOUCHER_CREATED);
        claimVoucherDao.update(claimVoucher);

        // 在数据库中取出所有表单详情信息
        List<ClaimVoucherItem> olds = claimVoucherItemDao.selectByClaimVoucher(claimVoucher.getId());
        // 删除操作
        for (ClaimVoucherItem old : olds) {
            // 设置一个状态isHave为false
            boolean isHave = false;
            for (ClaimVoucherItem item : items) {
                if (old.getId() == item.getId()) {
                    // 数据库中的数据与用户传过来的数据能对应得上，设置状态isHave为true
                    isHave = true;
                    break;
                }
            }
            // 遍历完用户传过来的信息，isHave还是为false，说明原来的数据已经被删掉了
            if (!isHave) {
                // 从数据库中存在的，而又没有包含在用户传过来的信息中的，删除
                claimVoucherItemDao.delete(old.getId());
            }
        }

        // 更新或修改操作
        for (ClaimVoucherItem item : items) {
            item.setClaimVoucherId(claimVoucher.getId());
            if (item.getId() != null && item.getId() > 0) {
                // id>0,说明是在原来的数据上修改的，执行更新操作
                claimVoucherItemDao.update(item);
            } else {
                // id为空，执行插入操作
                claimVoucherItemDao.insert(item);
            }
        }

    }

    public ClaimVoucher get(Integer id) {
        return claimVoucherDao.select(id);
    }

    public List<ClaimVoucher> getForSelf(String sn) {
        return  claimVoucherDao.selectByCreateSn(sn);
    }

    public List<ClaimVoucher> getForDeal(String sn) {
        return claimVoucherDao.selectByNextDealSn(sn);
    }

    public List<ClaimVoucherItem> getItems(Integer cid) {
        return claimVoucherItemDao.selectByClaimVoucher(cid);
    }

    public List<DealRecord> getRecord(Integer cid) {
        return dealRecordDao.selectByClaimVoucherId(cid);
    }

    public void submit(Integer id) {
        ClaimVoucher claimVoucher = claimVoucherDao.select(id);
        Employee employee = employeeDao.selectById(claimVoucher.getCreateSn());

        claimVoucher.setNextDealSn(employeeDao.selectByDepartmentAndPost(employee.getDepartmentSn(),Contant.POST_FM).get(0).getSn());
        claimVoucher.setStatus(Contant.CLAIMVOUCHER_SUBMIT);
        claimVoucherDao.update(claimVoucher);

        DealRecord record = new DealRecord();
        record.setClaimVoucherId(claimVoucher.getId());
        record.setComment("无");
        record.setDealSn(employee.getSn());
        record.setDealTime(new Date());
        record.setDealWay(Contant.DEAL_SUBMIT);
        record.setDealResult(Contant.CLAIMVOUCHER_SUBMIT);
        dealRecordDao.insert(record);
    }

    public void deal(DealRecord dealRecord) {
        ClaimVoucher claimVoucher = claimVoucherDao.select(dealRecord.getClaimVoucherId());
        Employee employee = employeeDao.selectById(dealRecord.getDealSn());
        dealRecord.setDealTime(new Date());

        if (dealRecord.getDealWay().equals(Contant.DEAL_PASS)) {
            if (claimVoucher.getTotalAmount() <= Contant.LIMIT_CHECK || employee.getPost().equals(Contant.POST_GM)) {
                claimVoucher.setNextDealSn(employeeDao.selectByDepartmentAndPost(null, Contant.POST_CASHIER).get(0).getSn());
                claimVoucher.setStatus(Contant.CLAIMVOUCHER_APPROVED);

                dealRecord.setDealResult(Contant.CLAIMVOUCHER_APPROVED);
            } else {
                claimVoucher.setNextDealSn(employeeDao.selectByDepartmentAndPost(null, Contant.POST_GM).get(0).getSn());
                claimVoucher.setStatus(Contant.CLAIMVOUCHER_RECHECK);

                dealRecord.setDealResult(Contant.CLAIMVOUCHER_RECHECK);
            }
        } else if (dealRecord.getDealWay().equals(Contant.DEAL_BACK)) {
            claimVoucher.setNextDealSn(claimVoucher.getCreateSn());
            claimVoucher.setStatus(Contant.CLAIMVOUCHER_BACK);

            dealRecord.setDealResult(Contant.CLAIMVOUCHER_BACK);
        } else if (dealRecord.getDealWay().equals(Contant.DEAL_PAID)) {
            claimVoucher.setNextDealSn(null);
            claimVoucher.setStatus(Contant.CLAIMVOUCHER_PAID);

            dealRecord.setDealResult(Contant.CLAIMVOUCHER_PAID);
        } else if (dealRecord.getDealWay().equals(Contant.DEAL_REJECT)) {
            claimVoucher.setNextDealSn(null);
            claimVoucher.setStatus(Contant.CLAIMVOUCHER_TERMINATED);

            dealRecord.setDealResult(Contant.CLAIMVOUCHER_TERMINATED);
        }

        claimVoucherDao.update(claimVoucher);
        dealRecordDao.insert(dealRecord);

    }
}
