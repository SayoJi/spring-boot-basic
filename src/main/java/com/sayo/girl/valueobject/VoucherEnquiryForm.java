package com.sayo.girl.valueobject;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Shuangyao
 * 8:06 2018/1/31
 */
public class VoucherEnquiryForm {
    private String voucherNo;
    private String propPolNo;
    private Date voucherDateFrom;
    private Date voucherDateTo;
    private String remittance;
    private String currency;
    private BigDecimal paymentAmount;
    private String creditCardNo;
    private String paymentRefe;
    private String receiptNo;

    @Override
    public String toString() {
        return "VoucherEnquiryForm{" +
                "voucherNo='" + voucherNo + '\'' +
                ", propPolNo='" + propPolNo + '\'' +
                ", voucherDateFrom=" + voucherDateFrom +
                ", voucherDateTo=" + voucherDateTo +
                ", remittance='" + remittance + '\'' +
                ", currency='" + currency + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", creditCardNo='" + creditCardNo + '\'' +
                ", paymentRefe='" + paymentRefe + '\'' +
                ", receiptNo='" + receiptNo + '\'' +
                '}';
    }
}
