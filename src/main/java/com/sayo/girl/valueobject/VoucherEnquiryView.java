package com.sayo.girl.valueobject;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Shuangyao
 * 8:11 2018/1/31
 */
public class VoucherEnquiryView {

    private String voucherNo;
    private BigDecimal voucherAmt;
    private Date voucherDate;
    private String status;
    private String lockedBy;
    private String paymentRefe;
    private Date paidDate;
    private BigDecimal paymentAmt;
    private String payCode;
    private String payBy;
    private List<PolicyInfo> policyInfoList;

    public static class PolicyInfo {
        private String policyNo;
        private String billingNo;
        private String policyOwner;
        private String settleAmt;
        private String receiptNo;
        private String batchNo;
        private String batchCreator;

        public String getPolicyNo() {
            return policyNo;
        }

        public void setPolicyNo(String policyNo) {
            this.policyNo = policyNo;
        }

        public String getBillingNo() {
            return billingNo;
        }

        public void setBillingNo(String billingNo) {
            this.billingNo = billingNo;
        }

        public String getPolicyOwner() {
            return policyOwner;
        }

        public void setPolicyOwner(String policyOwner) {
            this.policyOwner = policyOwner;
        }

        public String getSettleAmt() {
            return settleAmt;
        }

        public void setSettleAmt(String settleAmt) {
            this.settleAmt = settleAmt;
        }

        public String getReceiptNo() {
            return receiptNo;
        }

        public void setReceiptNo(String receiptNo) {
            this.receiptNo = receiptNo;
        }

        public String getBatchNo() {
            return batchNo;
        }

        public void setBatchNo(String batchNo) {
            this.batchNo = batchNo;
        }

        public String getBatchCreator() {
            return batchCreator;
        }

        public void setBatchCreator(String batchCreator) {
            this.batchCreator = batchCreator;
        }
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLockedBy() {
        return lockedBy;
    }

    public void setLockedBy(String lockedBy) {
        this.lockedBy = lockedBy;
    }

    public String getPaymentRefe() {
        return paymentRefe;
    }

    public void setPaymentRefe(String paymentRefe) {
        this.paymentRefe = paymentRefe;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public BigDecimal getPaymentAmt() {
        return paymentAmt;
    }

    public void setPaymentAmt(BigDecimal paymentAmt) {
        this.paymentAmt = paymentAmt;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public String getPayBy() {
        return payBy;
    }

    public void setPayBy(String payBy) {
        this.payBy = payBy;
    }

    public List<PolicyInfo> getPolicyInfoList() {
        return policyInfoList;
    }

    public void setPolicyInfoList(List<PolicyInfo> policyInfoList) {
        this.policyInfoList = policyInfoList;
    }
}
