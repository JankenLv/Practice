package com.lvjing.oa.dao;

import com.lvjing.oa.entity.ClaimVoucher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("claimVoucherDao")
public interface ClaimVoucherDao {
    void insert(ClaimVoucher claimVoucher);

    void delete(Integer id);

    void update(ClaimVoucher claimVoucher);

    ClaimVoucher select(Integer id);

    List<ClaimVoucher> selectByCreateSn(String createSn);

    List<ClaimVoucher> selectByNextDealSn(String nextDealSn);
}
