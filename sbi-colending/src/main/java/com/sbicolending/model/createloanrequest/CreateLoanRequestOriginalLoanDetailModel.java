package com.sbicolending.model.createloanrequest;

import lombok.Data;

@Data
public class CreateLoanRequestOriginalLoanDetailModel {

    /*private float loan_amount;
    private int tenure;
    private String tenure_frequency;*/


    public double pos_excl_insurance;
    public String sanction_date;
    public String consent_time_stamp;
    public String insurance_application_form_link;
    public String nach_enach_mandate_link;
    public String sanction_letter_link;
    public String tele_verification_report_link;
    public double loan_amount;
    public int cibil_score;
    public String dpn_link;
    public String drf_link;
    public String credit_discussion_mail_link;
    public int seasoning;
    public String loan_status;
    public double original_sanctioned_amount;
    public double original_rate_type;
    public String self_declaration_form_link;
    public int tenure;
    public String vehicle_inspection_report_link;
    public String entire_set_of_loan_agreements_link;
    public String tenure_frequency;
    public String fatca_declaration_link;
    public String pool_id;
    public int original_no_of_repayments;
    public double future_pos;
    public String field_verification_report_link;

}
