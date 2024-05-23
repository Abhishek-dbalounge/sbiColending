package com.sbicolending.utils;

public class DBQuery {

    public static final String CREATE_LOAN_DATA ="select distinct \n" +
            "customer_type_sp,\n" +
            "first_name_ia,\n" +
            "current_address_ia,\n" +
            "State_ia,\n" +
            "customer_category_sp,\n" +
            "client_customer_id_sp,\n" +
            "title_ia,\n" +
            "last_name_ia,\n" +
            "gender_ia,\n" +
            "mobile_number_ia,\n" +
            "place_of_birth_ia,\n" +
            "City_ia,\n" +
            "current_district_ia,\n" +
            "current_pincode_ia,\n" +
            "residence_current_address_ic,\n" +
            "permanent_district_ia,\n" +
            "permanent_pincode_ia,\n" +
            "residence_permanent_address_ic,\n" +
            "religion_ia,\n" +
            "caste_ia,\n" +
            "occupation_ic,\n" +
            "null income_source_addcolum,\n" +
            "null property_ownership_flag_addcolum,\n" +
            "business_udhyam_regn_number_nia,\n" +
            "name_of_bureau_sp,\n" +
            "bureau_score_sp,\n" +
            //"bureau_report_link_sp,\n" +
            "null product_id_addcolum,\n" +
            "null application_id_addcolum,\n" +
            "null category_addcolum,\n" +
            "null sub_category_addcolum,\n" +
            "purpose_sp,\n" +
            "null disbursement_type_addcolum,\n" +
            "null number_of_tranches_addcolum,\n" +
            "tenure_sp,\n" +
            "number_of_repayments_sp,\n" +
            "null psl_description_addcolum,\n" +
            "null impacted_industry_description_addcolum,\n" +
            "null applicant_never_in_30_plus_sma_sub_last_12m_addcolum,\n" +
            "tax_slab_sp,\n" +
            "psl_msme_type_of_enterprise_sp,\n" +
            //"current_address_ia,\n" +(Repeate)
            "cersai_security_int_id_ac,\n" +
            "repayment_frequency_sp,\n" +
            "father_first_name_ia,\n" +
            "father_last_name_ia,\n" +
            "total_value_of_security_sp,\n" +
            "null tenure_frequency_addcolum,\n" +
            "marital_status_ia,\n" +
            "ckyc_id_ia,\n" +
            "date_of_birth_ia,\n" +
            "first_repayment_date_sp,\n" +
            "null itr_filed_date_current_fy_addcolumn,\n" +
            "application_date_sp,\n" +
            "fcu_done_date_sp,\n" +
            "e_verification_of_kyc_done_date_sp,\n" +
            "pd_done_date_sp,\n" +
            "search_with_registrar_of_companies_obtained_date_sp,\n" +
            "cersai_registration_reference_number_verification_date_sp,\n" +
            "cibil_report_done_date_sp,\n" +
            "repayment_period_end_date_sp,\n" +
            "date_of_sanction_by_nbfc_sp,\n" +
            "date_of_documentation_by_nbfc_sp,\n" +
            "null annual_income_sp_addcolumn,\n" +
            "principal_amount_sp,\n" +
            "interest_rate_sp,\n" +
            "loan_emi_sp,\n" +
            "applicant_age_at_maturity_ia,\n" +
    //=========Bussiness=============================
            "name_of_business_nia,\n" +
            "nature_of_business_nia,\n" +
            "type_of_constitution_nia,\n" +
            "registration_date_nia,\n" +
            "incorporation_date_nia,\n" +
            "industry_type_nia,\n" +
            "sector_type_nic,\n" +
            "sub_sector_type_nia,\n" +
            "business_vintage_nia,\n" +
            "business_registered_office_address_nia,\n" +
            "business_mailing_office_city_nia,\n" +
            "null business_registered_office_state_addcolumn,\n" +
            "business_mailing_office_pincode_nia,\n" +
            "business_mailing_office_address1_nia,\n" +
           // "business_mailing_office_city_nia,\n" +
           // "business_mailing_office_pincode_nia,\n" +
            "business_phone_number_nia,\n" +
            "business_email_id_nia,\n" +
            "property_ownership_flag_nic,\n" +
            "business_pan_number_nia,\n" +
            "business_rc_number_nia,\n" +
           // "business_udhyam_regn_number_nia,\n" +
           // "business_mailing_office_address1_nia,\n" +
            "business_mailing_office_address2_nia,\n" +
            "business_mailing_office_address3_nia,\n" +
            "null enterprise_activity_addcolumn,\n" +
            "customer_type_nia,\n" +
            "exisiting_shareholding_of_promoters_nia,\n" +
            "exisiting_shareholding_of_mutual_funds_nia,\n" +
            "exisiting_shareholding_of_financial_institutions_banks_nia,\n" +
            "exisiting_shareholding_of_others_nia,\n" +
            "exisiting_shareholding_total_nia,\n" +
            "proposed_shareholding_of_promoters_nia,\n" +
            "proposed_shareholding_of_mutual_funds_nia,\n" +
            "proposed_shareholding_of_financial_institutions_banks_nia,\n" +
            "proposed_shareholding_of_others_nia,\n" +
            "proposed_shareholding_total_nia,\n" +
            "annual_income_nia,\n" +
            "Balance_sheet_year_nia,\n" +
            "ckyc_id_nia, \n" +
            //=========Guarantors=============================
            "date_of_birth_ig,\n" +
            "gender_ig,\n" +
            "current_address_ig,\n" +
            "current_district_ig,\n" +
            "City_ig,\n" +
            "State_ig,\n" +
            "current_pincode_ig,\n" +
            "permanent_district_ig,\n" +
            "permanent_pincode_ig,\n" +
            "mobile_number_ig,\n" +
            "marital_status_ig,\n" +
            "religion_ig,\n" +
            "bureau_score_ig,\n" +
            "age_at_maturity_ig,\n" +
            "employment_details_designation_sp,\n" +
            "null caste_addcolumn,\n" +
            "father_first_name_ig,\n" +
            "father_last_name_ig,\n" +
            "occupation_ig,\n" +
            "place_of_birth_ig,\n" +
            "title_ig,\n" +
            "null income_source_addcolumn,\n" +
            "current_address_line1_ig,\n" +
            "education_ig,\n" +
            "other_than_agricultural_income_ig,\n" +
            "null total_net_worth_addcolumn,\n" +
            "customer_type_ig,\n" +
            "ckyc_id_ig,\n" +
            "annual_income_ig,\n" +
            //==========CoApplicants====================
            "null relationship_with_applicant_addcolumn,\n" +
            "first_name_ic,\n" +
            "last_name_ic,\n" +
           // "gender_ic,\n" +
            "occupation_ic,\n" +
            "date_of_birth_ic,\n" +
            "mobile_number_ic,\n" +
            "current_address_ic,\n" +
            "City_ic,\n" +
            "current_district_ic,\n" +
            "State_ic,\n" +
            "current_pincode_ic,\n" +
            "permanent_district_ic,\n" +
            "permanent_pincode_ic,\n" +
            "marital_status_ic,\n" +
            "religion_ic,\n" +
            "education_ic,\n" +
            "annual_income_ic,\n" +
            "bureau_score_ic,\n" +
            "age_at_maturity_ic,\n" +
            //"employment_details_designation_sp,\n" +
            "caste_ic,\n" +
            "father_first_name_ic,\n" +
            "father_last_name_ic,\n" +
            "place_of_birth_ic,\n" +
            "title_ic,\n" +
            //"null income_source_addcolumn,\n" +
            //"current_address_ic,\n" +
            //"null total_net_worth_addcolumn,\n" +
            "customer_type_ic,\n" +
            "null ckyc_id_addcolumn,\n" +
            //==========BankStatement==================
            "sma_account_sp,\n" +
            "business_transactions_sp,\n" +
            //==============FinancialData==================
            "annual_business_turnover_sp,\n" +
            //==============BusinessCoApplicants=============
            "name_of_business_nic,\n" +
            "nature_of_business_nic,\n" +
            "type_of_constitution_nic,\n" +
            "registration_date_nic,\n" +
            "incorporation_date_nic,\n" +
            "industry_type_nic,\n" +
           // "sector_type_nic,\n" +
            "sub_sector_type_nic,\n" +
            "business_vintage_nic,\n" +
            "business_registered_office_address_nic,\n" +
            "business_mailing_office_city_nic,\n" +
            "State_nic ,\n" +
            "business_mailing_office_pincode_nic,\n" +
           // "business_registered_office_address_nic,\n" +
            "business_mailing_office_address1_nic,\n" +
            "business_mailing_office_address2_nic,\n" +
            "business_mailing_office_address3_nic,\n" +
           // "business_mailing_office_city_nic,\n" +
           // "business_mailing_office_pincode_nic,\n" +
            "business_phone_number_nic,\n" +
            "business_pan_number_nic,\n" +
           // "business_pan_link_nic,\n" +
            "business_rc_number_nic,\n" +
           // "business_rc_link_nic,\n" +
           // "annual_business_turnover_sp,\n" +
            "ckyc_id_nic\n," +
            //===========OriginalDisbursementDetails============
            "disbursement_amount_sp, \n" +
            "disbursement_date_sp, \n" +
            //=========================
            "collateral_created_date_ac,\n" +
            "cersai_date_ac,\n" +
            "security_valuation_ac,\n" +
            "survey_or_gat_number_ac,\n" +
            "bound_by_north_ac,\n" +
            "bound_by_south_ac,\n" +
            "bound_by_east_ac,\n" +
            "bound_by_west_ac,\n" +
            "purchase_cost_ac,\n" +
            "purchase_date_ac,\n" +
            "carpet_area_unit_ac,\n" +
            "plot_id_number_ac,\n" +
            "property_nature_ac,\n" +
            "property_locality_ac,\n" +
            "valuation_date_ac\n" +
            "from public.create_loan  where lan_sp = ?";

}