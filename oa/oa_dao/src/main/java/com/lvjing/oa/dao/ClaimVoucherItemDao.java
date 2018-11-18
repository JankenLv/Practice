package com.lvjing.oa.dao;

import com.lvjing.oa.entity.ClaimVoucherItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("claimVoucherItemDao")
public interface ClaimVoucherItemDao {
    void insert(ClaimVoucherItem claimVoucherItem);

    void delete(Integer id);

    void update(ClaimVoucherItem claimVoucherItem);

    List<ClaimVoucherItem> selectByClaimVoucher(Integer cid);
}
