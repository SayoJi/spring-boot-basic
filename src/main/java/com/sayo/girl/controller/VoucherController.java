package com.sayo.girl.controller;

import com.sayo.girl.valueobject.VoucherApprovalView;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Shuangyao
 * 7:19 2018/1/31
 */

@RestController
public class VoucherController {

    @GetMapping(value = "/getVoucherApproval")
    public List<VoucherApprovalView> getVoucherAppr(@RequestParam(value = "batchNo", required = false) String batchNo,
                                                    @RequestParam(value = "voucherNo", required = false) String voucherNo,
                                                    @RequestParam(value = "policyNo", required = false) String policyNo,
                                                    @RequestParam(value = "location", required = false) String location) {

        List<VoucherApprovalView> voucherApprovalViewList = new ArrayList<>();
        for(int i=0; i<10; i++) {
            VoucherApprovalView voucherApprovalView = new VoucherApprovalView();
            if(voucherNo!=null) {
                voucherApprovalView.setVoucherNo(voucherNo);
            }else {
                voucherApprovalView.setVoucherNo("voucherNo"+i);
            }
            voucherApprovalView.setVoucherCurr("USD");
            voucherApprovalView.setVoucherAmt(new BigDecimal("1254345.23"));
            voucherApprovalView.setVoucherDate(new Date());
            voucherApprovalView.setApprType("LargePay");
            if(batchNo!=null){
                voucherApprovalView.setBatchNo(batchNo);
            }else {
                voucherApprovalView.setBatchNo("batchNo"+i);
            }
            voucherApprovalView.setIdCopy("N");
            voucherApprovalView.setLocation("PT");
            voucherApprovalView.setRemark("Over2.000.000.00");
            voucherApprovalView.setApproval(false);

            voucherApprovalViewList.add(voucherApprovalView);
        }
        return voucherApprovalViewList;
    }

//    @RequestMapping(value = "/updateVoucherApproval", method = RequestMethod.POST)
//    public boolean updateVoucherApproval() {
//
//    }
}
