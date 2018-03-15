package com.sayo.girl.valueobject;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Shuangyao
 * 7:20 2018/1/31
 */
public class VoucherApprovalView {

    @NotNull
    private String voucherNo;
    private String voucherCurr;
    private BigDecimal voucherAmt;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date voucherDate;
    private String voucherStatus;
    private String apprType;
    private String batchNo;
    private String idCopy;
    private String location;
    private String remark;
    private boolean isApproval;


    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public String getVoucherCurr() {
        return voucherCurr;
    }

    public void setVoucherCurr(String voucherCurr) {
        this.voucherCurr = voucherCurr;
    }

    public BigDecimal getVoucherAmt() {
        return voucherAmt;
    }

    public void setVoucherAmt(BigDecimal voucherAmt) {
        this.voucherAmt = voucherAmt;
    }

    public Date getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(Date voucherDate) {
        this.voucherDate = voucherDate;
    }

    public String getVoucherStatus() {
        return voucherStatus;
    }

    public void setVoucherStatus(String voucherStatus) {
        this.voucherStatus = voucherStatus;
    }

    public String getApprType() {
        return apprType;
    }

    public void setApprType(String apprType) {
        this.apprType = apprType;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getIdCopy() {
        return idCopy;
    }

    public void setIdCopy(String idCopy) {
        this.idCopy = idCopy;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isApproval() {
        return isApproval;
    }

    public void setApproval(boolean approval) {
        isApproval = approval;
    }
}
