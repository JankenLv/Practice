package com.random.lottery.model;

import java.util.Date;

public class SignupGroupMemberT {
    private Integer id;

    private Integer signupGroupConfigId;

    private Integer signupConfigId;

    private Integer memberId;

    private Date startDate;

    private Byte smsNoticeCount;

    private Integer createdUserId;

    private Date createDate;

    private Integer updatedUserId;

    private Date updateDate;

    private Byte status;

    private String batchCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSignupGroupConfigId() {
        return signupGroupConfigId;
    }

    public void setSignupGroupConfigId(Integer signupGroupConfigId) {
        this.signupGroupConfigId = signupGroupConfigId;
    }

    public Integer getSignupConfigId() {
        return signupConfigId;
    }

    public void setSignupConfigId(Integer signupConfigId) {
        this.signupConfigId = signupConfigId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Byte getSmsNoticeCount() {
        return smsNoticeCount;
    }

    public void setSmsNoticeCount(Byte smsNoticeCount) {
        this.smsNoticeCount = smsNoticeCount;
    }

    public Integer getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Integer createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(Integer updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode == null ? null : batchCode.trim();
    }
}