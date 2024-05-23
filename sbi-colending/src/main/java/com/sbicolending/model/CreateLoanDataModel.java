package com.sbicolending.model;

import lombok.Data;

import java.util.Date;

@Data
public class CreateLoanDataModel {



    private String customer_type_sp;
    private String first_name_ia;
    private String current_address_ia;
    private String State_ia;
    private String customer_category_sp;
    private String client_customer_id_sp;
    private String title_ia;
    private String last_name_ia;
    private String gender_ia;
    private String mobile_number_ia;
    private String place_of_birth_ia;
    private String City_ia;
    private String current_district_ia;
    private String current_pincode_ia;
    private String residence_current_address_ic;
    private String permanent_district_ia;
    private String permanent_pincode_ia;
    private String residence_permanent_address_ic;
    private String religion_ia;
    private String caste_ia;
    private String occupation_ic;
    private String income_source_addcolum;
    private String property_ownership_flag_addcolum;
    private String business_udhyam_regn_number_nia;
    private String name_of_bureau_sp;
    private String bureau_score_sp;
    private String product_id_addcolum;
    private String application_id_addcolum;
    private String category_addcolum;
    private String sub_category_addcolum;
    private String purpose_sp;
    private String disbursement_type_addcolum;
    private String number_of_tranches_addcolum;
    private String tenure_sp;
    private String number_of_repayments_sp;
    private String psl_description_addcolum;
    private String impacted_industry_description_addcolum;
    private String applicant_never_in_30_plus_sma_sub_last_12m_addcolum;
    private String tax_slab_sp;
    private String psl_msme_type_of_enterprise_sp;
    //private String current_address_ia;(Repeate)
    private String cersai_security_int_id_ac;
    private String repayment_frequency_sp;
    private String father_first_name_ia;
    private String father_last_name_ia;
    private String total_value_of_security_sp;
    private String tenure_frequency_addcolum;
    private String marital_status_ia;
    private String ckyc_id_ia;
    private String date_of_birth_ia;
    private String first_repayment_date_sp;
    private String itr_filed_date_current_fy_addcolumn;
    private Date application_date_sp;
    private String fcu_done_date_sp;
    private String e_verification_of_kyc_done_date_sp;
    private String pd_done_date_sp;
    private String search_with_registrar_of_companies_obtained_date_sp;
    private String cersai_registration_reference_number_verification_date_sp;
    private String cibil_report_done_date_sp;
    private Date repayment_period_end_date_sp;
    private String date_of_sanction_by_nbfc_sp;
    private String date_of_documentation_by_nbfc_sp;
    private String annual_income_sp_addcolumn;
    private int principal_amount_sp;
    private int interest_rate_sp;
    private int loan_emi_sp;
    private float applicant_age_at_maturity_ia;

    //===========Business=====================================

    private String name_of_business_nia;
    private String nature_of_business_nia;
    private String type_of_constitution_nia;
    private Date registration_date_nia;
    private Date incorporation_date_nia;
    private String industry_type_nia;
    private String sector_type_nic;
    private String sub_sector_type_nia;
    private Date business_vintage_nia;
    private String business_registered_office_address_nia;
    private String business_mailing_office_city_nia;
    private String business_registered_office_state_addcolumn;
    private String business_mailing_office_pincode_nia;
    private String business_mailing_office_address1_nia;
   // private String business_mailing_office_city_nia;(Repeate)
   // private String business_mailing_office_pincode_nia;(Repeate)
    private String business_phone_number_nia;
    private String business_email_id_nia;
    private String property_ownership_flag_nic;
    private String business_pan_number_nia;
    private String business_rc_number_nia;
  //  private String business_udhyam_regn_number_nia;(Repeate)
  //  private String business_mailing_office_address1_nia;(Repeate)
    private String business_mailing_office_address2_nia;
    private String business_mailing_office_address3_nia;
    private String enterprise_activity_addcolumn;
    private String customer_type_nia;
    private String exisiting_shareholding_of_promoters_nia;
    private String exisiting_shareholding_of_mutual_funds_nia;
    private String exisiting_shareholding_of_financial_institutions_banks_nia;
    private String exisiting_shareholding_of_others_nia;
    private String exisiting_shareholding_total_nia;
    private String proposed_shareholding_of_promoters_nia;
    private String proposed_shareholding_of_mutual_funds_nia;
    private String proposed_shareholding_of_financial_institutions_banks_nia;
    private String proposed_shareholding_of_others_nia;
    private String proposed_shareholding_total_nia;
    private String annual_income_nia;
    private String Balance_sheet_year_nia;
    private String ckyc_id_ni;

    //==========Guarantors==========================

    private String date_of_birth_ig;
    private String gender_ig;
    private String current_address_ig;
    private String current_district_ig;
    private String City_ig;
    private String State_ig;
    private String current_pincode_ig;
    private String permanent_district_ig;
    private String permanent_pincode_ig;
    private String mobile_number_ig;
    private String marital_status_ig;
    private String religion_ig;
    private String bureau_score_ig;
    private String age_at_maturity_ig;
    private String employment_details_designation_sp;
    private String caste_addcolumn;
    private String father_first_name_ig;
    private String father_last_name_ig;
    private String occupation_ig;
    private String place_of_birth_ig;
    private String title_ig;
    private String income_source_addcolumn;
    private String current_address_line1_ig;
    private String education_ig;
    private String other_than_agricultural_income_ig;
    private String total_net_worth_addcolumn;
    private String customer_type_ig;
    private String ckyc_id_ig;
    private String annual_income_ig;

    //=======CoApplicants==============================

    private String relationship_with_applicant_addcolumn;
    private String first_name_ic;
    private String last_name_ic;
    private String gender_ic;
    //private String occupation_ic;(Dublicate)
    private String date_of_birth_ic;
    private String mobile_number_ic;
    private String current_address_ic;
    private String City_ic;
    private String current_district_ic;
    private String State_ic;
    private String current_pincode_ic;
    private String permanent_district_ic;
    private String permanent_pincode_ic;
    private String marital_status_ic;
    private String religion_ic;
    private String education_ic;
    private float annual_income_ic;
    private int bureau_score_ic;
    private String age_at_maturity_ic;
    //private String employment_details_designation_sp;(Dublicate)
    private String caste_ic;
    private String father_first_name_ic;
    private String father_last_name_ic;
    private String place_of_birth_ic;
    private String title_ic;
   // private String income_source_addcolumn;(Dublicate)
   // private String current_address_ic;(Dublicate)
  //  private String total_net_worth_addcolumn;(Dublicate)
    private String customer_type_ic;
    private String ckyc_id_addcolumn;



}
