package com.lvjing.oa.biz;

import com.lvjing.oa.entity.ClaimVoucher;
import com.lvjing.oa.entity.ClaimVoucherItem;
import com.lvjing.oa.entity.DealRecord;

import java.util.List;

public interface ClaimVoucherBiz {
    void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> claimVoucherItems);

    void update(ClaimVoucher claimVoucher, List<ClaimVoucherItem> claimVoucherItems);

    ClaimVoucher get(Integer id);

    List<ClaimVoucher> getForSelf(String sn);

    List<ClaimVoucher> getForDeal(String sn);

    List<ClaimVoucherItem> getItems(Integer cid);

    List<DealRecord> getRecord(Integer cid);

    void submit(Integer id);

    void deal(DealRecord dealRecord);

}
