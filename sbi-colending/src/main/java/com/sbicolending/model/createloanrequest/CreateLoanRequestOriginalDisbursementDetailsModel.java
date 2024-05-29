package com.sbicolending.model.createloanrequest;

import lombok.Data;

import java.util.Date;

@Data
public class CreateLoanRequestOriginalDisbursementDetailsModel {

    private float disbursement_amount;
    private Date disbursement_date;


  /*  public String bank_branch_ifsc;
    public String bank_account_number;
    public String bank_details_verification_status;
    public List<String> dealer_funding_ack_link;
    public String bank_account_type;
    public String utr_number;
    public String bank_name;
    public double disbursement_amount;
    public String disbursement_date;
    public String bank_account_name;
    public List<String> dealer_funding_ack_link_password;
    public String utr_type;
    public String bank_branch_name;*/


}
