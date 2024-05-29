package com.sbicolending.model;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerDetailDataModel {


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
    private String income_source_sp;//(new)
    private String property_ownership_flag_sp;//(new)
    private String business_udhyam_regn_number_nia;
    private String name_of_bureau_sp;
    private String bureau_score_sp;
    private String product_id_sp;//(new)
    private String application_id_sp;//(new)
    private String category_sp;//(new)
    private String sub_category_sp;//(new)
    private String purpose_sp;
    private String disbursement_type_sp;//(new)
    private int number_of_tranches_sp;//(int)//(new)
    private int tenure_sp;
    private int number_of_repayments_sp;
    private String psl_description_sp;//(new)
    private String impacted_industry_description_sp;//(new)
    private String applicant_never_in_30_plus_sma_sub_last_12m_sp;//(new)
    private String tax_slab_sp;
    private String psl_msme_type_of_enterprise_sp;
    private String cersai_security_int_id_ac;
    private String repayment_frequency_sp;
    private String father_first_name_ia;
    private String father_last_name_ia;
    private String total_value_of_security_sp;//(numeric)
    private String tenure_frequency_sp;//(new)
    private String marital_status_ia;
    private String ckyc_id_ia;
    private Date date_of_birth_ia;
    private Date first_repayment_date_sp;
    private Date itr_filed_date_current_fy_sp;//(Date)//(new)
    private Date application_date_sp;//(Date)//(new)
    private Date fcu_done_date_sp;
    private Date e_verification_of_kyc_done_date_sp;
    private Date pd_done_date_sp;
    private Date search_with_registrar_of_companies_obtained_date_sp;
    private Date cersai_registration_reference_number_verification_date_sp;
    private Date cibil_report_done_date_sp;
    private Date repayment_period_end_date_sp;//(Date)
    private Date date_of_sanction_by_nbfc_sp;
    private Date date_of_documentation_by_nbfc_sp;
    private String annual_income_sp;
    private int principal_amount_sp;//(numeric)
    private int interest_rate_sp;//(numeric)
    private int loan_emi_sp;//(numeric)
    private float applicant_age_at_maturity_ia;//(Double)
    //===========Business=====================================
    private String name_of_business_nia;
    private String nature_of_business_nia;
    private String type_of_constitution_nia;
    private Date registration_date_nia;//(Date)
    private Date incorporation_date_nia;//(Date)
    private String industry_type_nia;
    private String sector_type_nic;
    private String sub_sector_type_nia;
    private Double business_vintage_nia;//(Double)
    private String business_registered_office_address_nia;
    private String business_registered_office_state_nia;//(new)
    private String business_mailing_office_city_nia;
    private String business_mailing_office_pincode_nia;
    private String business_mailing_office_address1_nia;
    private String business_phone_number_nia;
    private String business_email_id_nia;
    private String property_ownership_flag_nic;
    private String business_pan_number_nia;
    private String business_rc_number_nia;
    private String business_mailing_office_address2_nia;
    private String business_mailing_office_address3_nia;
    private String enterprise_activity_nia;//(new)
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
    private Date Balance_sheet_year_nia;
    private String ckyc_id_nia;
    //==========Guarantors==========================
    private Date date_of_birth_ig;
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
    private String caste_ig;//(new)
    private String father_first_name_ig;
    private String father_last_name_ig;
    private String occupation_ig;
    private String place_of_birth_ig;
    private String title_ig;
    private String income_source_ig;//(new)
    private String current_address_line1_ig;
    private String education_ig;
    private String other_than_agricultural_income_ig;
    private String total_net_worth_ig;//(new)//(double)
    private String customer_type_ig;
    private String ckyc_id_ig;
    private String annual_income_ig;
    //=======CoApplicants==============================
    private String relationship_with_applicant_ic;//(new)
    private String first_name_ic;
    private String last_name_ic;
    private String gender_ic;
    private Date date_of_birth_ic;
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
    private String annual_income_ic;//(numeric)
    private String bureau_score_ic;//(integer)
    private String age_at_maturity_ic;
    private String caste_ic;
    private String father_first_name_ic;
    private String father_last_name_ic;
    private String place_of_birth_ic;
    private String title_ic;
    private String income_source_ic;//(new)
    //private String current_address_ic;
    private String total_net_worth_ic;//(new)
    private String customer_type_ic;
    private String ckyc_id_ic;//(new)
    //====================BankStatement===========================
    private String sma_account_sp;
    private String business_transactions_sp;
    //===========FinancialData============
    private String annual_business_turnover_sp;//(numeric)
    //============tranche=================
    private int tranche_number;
    private int principal_amount;
    //===========LinkedLoanInfosModel================
    private String linked_loan_id;
    private String foreclosure;
    //========RelatedParties==========================
    private String connected_with_rp;
    private String connection_name_rp;
    private String rp_type_rp;
    private String name_rp;
    private String share_holding_rp;
    private String designation_rp;
    private String proposed_share_holding_rp;
    //==============BusinessCoApplicants=======================
    private String name_of_business_nic;
    private String nature_of_business_nic;
    private String type_of_constitution_nic;
    private Date registration_date_nic;//(Date)
    private Date incorporation_date_nic;//(Date)
    private String industry_type_nic;
    private String sub_sector_type_nic;
    private String business_vintage_nic;//(Double)
    private String business_registered_office_address_nic;
    private String business_mailing_office_city_nic;
    private String State_nic;
    private String business_mailing_office_pincode_nic;
    private String business_mailing_office_address1_nic;
    private String business_mailing_office_address2_nic;
    private String business_mailing_office_address3_nic;
    private String business_phone_number_nic;
    private String business_pan_number_nic;
    private String business_pan_link_nic;
    private String business_rc_number_nic;
    private String business_rc_link_nic;
    private String ckyc_id_nic;
    //============OriginalDisbursementDetails====
    private String disbursement_amount_sp;//(numeric)
    private Date disbursement_date_sp;//(Date)
    //=========Assets============================
    private float sanction_ltv_ac;
    private Date collateral_created_date_ac;
    private Date cersai_date_ac;
    private String security_valuation_ac;//(numric)
    private String survey_or_gat_number_ac;
    private String bound_by_north_ac;
    private String bound_by_south_ac;
    private String bound_by_east_ac;
    private String bound_by_west_ac;
    private String purchase_cost_ac;//(numeric)
    private Date purchase_date_ac;//(TimeStamp with TimeZone)
    private String carpet_area_unit_ac;
    private String plot_id_number_ac;
    private String property_nature_ac;
    private String property_locality_ac;
    private Date valuation_date_ac;


}
