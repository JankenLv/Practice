package com.random.lottery.model;

import java.math.BigDecimal;
import java.util.Date;

public class MemberAttendanceRateT {
    private Integer id;

    private Integer memberId;

    private String nameCn;

    private String nameEn;

    private String idType;

    private String idCode;

    private BigDecimal arValue;

    private BigDecimal dsejArValue;

    private BigDecimal idArValue;

    private Integer createdUserId;

    private Date createDate;

    private Integer updatedUserId;

    private Date updateDate;

    private Byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn == null ? null : nameCn.trim();
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType == null ? null : idType.trim();
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode == null ? null : idCode.trim();
    }

    public BigDecimal getArValue() {
        return arValue;
    }

    public void setArValue(BigDecimal arValue) {
        this.arValue = arValue;
    }

    public BigDecimal getDsejArValue() {
        return dsejArValue;
    }

    public void setDsejArValue(BigDecimal dsejArValue) {
        this.dsejArValue = dsejArValue;
    }

    public BigDecimal getIdArValue() {
        return idArValue;
    }

    public void setIdArValue(BigDecimal idArValue) {
        this.idArValue = idArValue;
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
}