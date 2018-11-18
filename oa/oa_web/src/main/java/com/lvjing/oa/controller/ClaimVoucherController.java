package com.lvjing.oa.controller;

import com.lvjing.oa.biz.ClaimVoucherBiz;
import com.lvjing.oa.dto.ClaimVoucherInfo;
import com.lvjing.oa.entity.DealRecord;
import com.lvjing.oa.entity.Employee;
import com.lvjing.oa.global.Contant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@Controller
@RequestMapping("/claim_voucher")
public class ClaimVoucherController {

    @Autowired
    private ClaimVoucherBiz claimVoucherBiz;

    @RequestMapping(value = "/to_add", method = GET)
    public String toAdd(Map<String, Object> map) {
        map.put("items", Contant.getItems());
        map.put("info", new ClaimVoucherInfo());
        return "claim_voucher_add";
    }

    @RequestMapping(value = "/add", method = POST)
    public String add(HttpSession session,ClaimVoucherInfo info) {
        Employee employee = (Employee) session.getAttribute("employee");
        info.getClaimVoucher().setCreateSn(employee.getSn());
        claimVoucherBiz.save(info.getClaimVoucher(),info.getItems());
        return "redirect:deal";
    }

    @RequestMapping(value = "/detail/{id}",method = GET)
    public String detail(@PathVariable Integer id, Map<String, Object> map) {
        map.put("claimVoucher",claimVoucherBiz.get(id));
        map.put("items",claimVoucherBiz.getItems(id));
        map.put("recodes",claimVoucherBiz.getRecord(id));
        return "claim_voucher_detail";
    }

    @RequestMapping(value = "/self", method = GET)
    public String self(HttpSession session, Map<String, Object> map) {
        Employee employee = (Employee) session.getAttribute("employee");
        map.put("claimVouchers",claimVoucherBiz.getForSelf(employee.getSn()));
        return "claim_voucher_self";
    }

    @RequestMapping(value = "/deal", method = GET)
    public String deal(HttpSession session, Map<String, Object> map) {
        Employee employee = (Employee) session.getAttribute("employee");
        map.put("claimVouchers",claimVoucherBiz.getForDeal(employee.getSn()));
        return "claim_voucher_deal";
    }

    @RequestMapping(value = "/to_update/{id}", method = GET)
    public String toUpdate(@PathVariable Integer id, Map<String, Object> map) {
        map.put("costs",Contant.getItems());
        ClaimVoucherInfo info = new ClaimVoucherInfo();
        info.setClaimVoucher(claimVoucherBiz.get(id));
        info.setItems(claimVoucherBiz.getItems(id));
        map.put("info",info);
        return "claim_voucher_update";
    }

    @RequestMapping(value = "/update",method = PUT)
    public String update(ClaimVoucherInfo info) {
        claimVoucherBiz.update(info.getClaimVoucher(),info.getItems());
        return "redirect:deal";
    }

    @RequestMapping(value = "/submit/{id}",method = PUT)
    public String submit(@PathVariable Integer id) {
        claimVoucherBiz.submit(id);
        return "redirect:../deal";
    }

    @RequestMapping(value = "/to_check/{id}",method = GET)
    public String toCheck(@PathVariable Integer id, Map<String, Object> map) {
        map.put("claimVoucher",claimVoucherBiz.get(id));
        map.put("items",claimVoucherBiz.getItems(id));
        map.put("recodes",claimVoucherBiz.getRecord(id));
        DealRecord record = new DealRecord();
        record.setClaimVoucherId(id);
        map.put("recode", record);
        return "claim_voucher_check";
    }

    @RequestMapping(value = "/check", method = PUT)
    public String deal(HttpSession session, DealRecord dealRecord) {
        Employee employee = (Employee) session.getAttribute("employee");
        dealRecord.setDealSn(employee.getSn());
        claimVoucherBiz.deal(dealRecord);
        return "redirect:deal";
    }
}
