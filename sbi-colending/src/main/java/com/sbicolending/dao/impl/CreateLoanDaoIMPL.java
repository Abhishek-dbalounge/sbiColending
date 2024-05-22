package com.sbicolending.dao.impl;

import com.sbicolending.dao.CreateLoanDao;
import com.sbicolending.model.BusinessNonIndividualApplicanteModel;
import com.sbicolending.model.CommonResponseModel;
import com.sbicolending.model.CreateLoanResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CreateLoanDaoIMPL implements CreateLoanDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CreateLoanResponseModel> getCreateLoanDetails(String lanSp) {

        List<CreateLoanResponseModel>  createLoanResponseList = null;
        try {

            String sql = "select  \n" +
                    "customer_type_SP AS Customer_Type,\n" +
                    "customer_category_SP AS Customer_Category, \n" +
                    "client_customer_id_SP AS Client_Customer_ID,\n" +
                    "residence_current_address_IC AS residential_status1,\n" +
                  //  "-- tdcaac.Residence_Type_Current_Address as residence_type_current_address_AAC  (----CHECk-----)\n" +
                    "permanent_pincode_SP AS Permanent_Pincode,\n" +
                    "-- tdic.residential_status1 as residence_permanent_address_IC (----CHECk-----)\n" +
                    "residence_type_permanent_address_SP AS Residence_Type_Current_Address,\n" +
                    "name_of_bureau_SP AS Name_of_Bureau,\n" +
                    "bureau_score_SP AS Bureau_Score,\n" +
                  //  "-- tdsp.Bureau_Report_Link as bureau_report_link_SP (-----CHECK-----)\n" +
                    "purpose_SP AS Purpose,\n" +
                    "principal_amount_SP AS Principal_Amount,\n" +
                    "interest_rate_SP AS interest_rate,\n" +
                    "interest_type_SP AS Interest_Type,\n" +
                    "tenure_SP AS Tenure,\n" +
                    "repayment_frequency_SP AS Repayment_Frequency,\n" +
                    "number_of_repayments_SP AS Number_of_Repayments,\n" +
                    "first_repayment_date_SP AS First_Repayment_Date,\n" +
                    "loan_emi_SP AS First_EMI,\n" +
                    "psl_msme_type_of_enterprise_SP AS PSL_MSME_Type_of_Enterprise, \n" +
                    "application_date_SP AS Application_Date,\n" +
                    "e_verification_of_kyc_done_date_SP AS e_Verification_of_KYC_Done_Date,\n" +
                    "pd_done_date_SP AS PD_Done_Date,\n" +
                    "fcu_done_date_SP AS FCU_Done_Date, \n" +
                    "search_with_registrar_of_companies_obtained_date_SP AS Search_with_Registrar_of_Companies_Obtained_Date,\n" +
                    "cersai_registration_reference_number_verification_date_SP AS Cersai_Registration_Reference_Number_Verification_Date,\n" +
                    "cibil_report_done_date_SP AS Cibil_Report_Done_Date,\n" +
                    "repayment_period_end_date_SP AS Repayment_Period_End_Date,\n" +
                    "date_of_sanction_by_nbfc_SP As Date_of_Sanction_by_NBFC,\n" +
                    "date_of_documentation_by_nbfc_SP AS Date_of_Documentation_by_NBFC,\n" +
                    "total_value_of_security_SP AS Total_Value_of_Security,\n" +
                    "roc_search_report_date_SP AS ROC_Search_Report_Date,\n" +
                    "tax_slab_SP AS TAX_Slab,\n" +
                  //  "-- tdsp.Loan_Details_Link as loan_details_link_SP (----CHECK----)\n" +
                    "employment_details_designation_SP AS Employment_Details_Designation\n" +
                    "from public.create_loan  where lan_sp ='" + lanSp + "'";


           /* String sql =  "select lan_sp ,\n" +
                    " customer_type_sp AS Customer_Type,\n" +
                    " customer_category_sp AS Customer_Category,\n" +
                    " client_customer_id_sp AS Client_Customer_ID,\n" +
                    " residence_current_address_ic AS residential_status1,\n" +
                    " residence_type_current_address_aac AS Residence_Type_Current_Address\n" +
                    "from create_loan where lan_sp ='" + lanSp + "'";*/

            /*String sql = "select lan_sp\n" +
                    "from create_loan where lan_sp ='" + lanSp + "'";*/

            createLoanResponseList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CreateLoanResponseModel.class));
        } catch (Exception e) {
            System.out.println("=======something error in DB quary.============");
            System.out.println(e);
        }

        return createLoanResponseList;
    }



    @Override
    public List<BusinessNonIndividualApplicanteModel> getBusinessNonIndividualApplicanteDetails(String lanSp) {
        List<BusinessNonIndividualApplicanteModel> BusinessNonIndividualApplicanteList = null;
        try {

            String sql ="Select \n" +
                    "name_of_business_NIA AS Name_of_Business,\n" +
                    "nature_of_business_NIA AS Nature_of_Business_Description ,\n" +
                    "type_of_constitution_NIA AS Type_of_Constitution_Description,\n" +
                    "registration_date_NIA AS Registration_Date,\n" +
                    "incorporation_date_NIA AS Incorporation_Date,\n" +
                    "industry_type_NIA AS Industry_Type,\n" +
                   // "sector_type_NIA AS Sector_Type,\n" +(NOT AVAIBALE IN DB)
                    "sub_sector_type_NIA AS Sub_Sector_Type,\n" +
                    "business_vintage_NIA AS Business_Vintage_Years,\n" +
                    "business_mailing_office_city_NIA AS Business_Mailing_Office_City,\n" +
                    "business_mailing_office_pincode_NIA AS Business_Mailing_Office_Pincode,\n" +
                    "business_registered_office_address_NIA AS Business_Registered_Office_Address,\n" +
                    "business_registered_office_address2_NIA AS Business_Registered_Office_Address2,\n" +
                    "business_registered_office_address3_NIA AS Business_Registered_Office_Address3,\n" +
                    "Flat_Number_NIA AS Business_Mailing_Office_Flat,\n" +
                    "current_district_NIA AS Current_District,\n" +
                    "care_of_NIA AS Care_Of,\n" +
                    "sub_district_NIA AS Sub_District,\n" +
                    "business_phone_number_NIA AS Business_Phone_Number,\n" +
                    "business_email_id_NIA AS Business_Email_ID,\n" +
                    "business_pan_number_NIA AS Business_PAN_Number,\n" +
                    //"business_pan_link_NIA AS Business_PAN_Link,\n" +(ARRAY GET ANOTHER WAY)
                    "Form_60_submission_date_NIA AS Form_60_Submission_Date,\n" +
                    "other_income_NIA AS Other_Income,\n" +
                    "agricultural_income_NIA AS Agricultural_Income,\n" +
                    //"business_gst_number_NIA AS Customer_GST,\n" +(NOT AVAIBALE IN DB)
                    //"business_gst_copy_link_NIA AS Business_GST_copy_Link,\n" + (ARRAY GET ANOTHER WAY)

                    "business_udhyam_regn_number_NIA AS Business_Udhyam_regn_Number,\n" +
                    //"business_udhyam_regn_link_NIA AS Business_Udhyam_regn_Link,\n" +(ARRAY GET ANOTHER WAY)
                    "business_mailing_office_address1_NIA AS Business_Mailing_Office_Address1,\n" +
                    "business_mailing_office_address2_NIA AS Business_Mailing_Office_Address2,\n" +
                    "business_mailing_office_address3_NIA AS Business_Mailing_Office_Addres3,\n" +
                    "customer_type_NIA AS Customer_Type1,\n" +
                    "exisiting_shareholding_of_promoters_NIA AS exisiting_shareholding_of_promoters,\n" +
                    "exisiting_shareholding_of_mutual_funds_NIA AS exisiting_shareholding_of_mutual_funds,\n" +
                    "exisiting_shareholding_of_financial_institutions_banks_NIA AS exisiting_shareholding_of_financial_institutions_banks,\n" +
                    "exisiting_shareholding_of_others_NIA AS exisiting_shareholding_of_others,\n" +
                    "exisiting_shareholding_total_NIA AS exisiting_shareholding_total,\n" +
                    "proposed_shareholding_of_promoters_NIA AS proposed_shareholding_of_prcintnrs,\n" +
                    "proposed_shareholding_of_mutual_funds_NIA AS proposed_shareholding_of_mutual_funds,\n" +
                    "proposed_shareholding_of_financial_institutions_banks_NIA AS proposed_shareholding_of_financial_institutions_banks,\n" +
                    "proposed_shareholding_of_others_NIA AS proposed_shareholding_of_others,\n" +
                    "proposed_shareholding_total_NIA AS proposed_shareholding_total,\n" +
                    "ckyc_id_NIA AS ckyc_id,\n" +
                    "Balance_sheet_year_NIA AS balance_sheet_year,\n" +
                    "annual_income_NIA AS annual_income,\n" +
                    "cin_number_NIA AS cin_number,\n" +
                    "coi_number_NIA AS coi_number,\n" +
                    "aoa_number_NIA AS aoa_number,\n" +
                    "partnership_Deed_number_NIA AS partnership_deed_number,\n" +
                    "board_resolution_number_NIA AS board_resolution_number,\n" +
                    "business_rc_number_NIA AS business_rc_number\n" +
                    //"aoa_link_NIA AS aoa_link,\n" +(ARRAY GET ANOTHER WAY)
                    //"board_resoultion_link_NIA AS board_resoultion_link,\n" +(ARRAY GET ANOTHER WAY)
                    //"partnership_deed_link_NIA AS partnership_deed_link,\n" +(ARRAY GET ANOTHER WAY)
                    //"certificate_of_incorporation_link_NIA AS certificate_of_incorporation_link,\n" +(ARRAY GET ANOTHER WAY)
                    //"business_rc_link_NIA AS business_rc_link\n" +(ARRAY GET ANOTHER WAY)
                    "from public.create_loan  where lan_sp ='" + lanSp + "'";



            BusinessNonIndividualApplicanteList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BusinessNonIndividualApplicanteModel.class));

        } catch (Exception e) {
            System.out.println(e);
        }

        return BusinessNonIndividualApplicanteList;
    }
}
