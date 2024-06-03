package com.sbicolending.service.impl;

import com.sbicolending.exception.SystemException;
import com.sbicolending.model.updatecustomerdetailsrequest.CustomerDetailUpdateModel;
import com.sbicolending.service.CustomerDetailUpdateService;
import com.sbicolending.utils.DataTypeConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerDetailUpdateServiceIMPL  implements CustomerDetailUpdateService {

    @Autowired
    private DataTypeConversion dataTypeConversion;

    @Override
    public void updateCustomerDetails(CustomerDetailUpdateModel customerDetailUpdateRequest) {


        String customer_type_sp = customerDetailUpdateRequest.getPrimary_borrower_type();
        String first_name_ia = customerDetailUpdateRequest.getFirst_name();
        String current_address_ia = customerDetailUpdateRequest.getCurrent_address();
        String state_ia = customerDetailUpdateRequest.getCurrent_state();
        String customer_category_sp = customerDetailUpdateRequest.getCustomer_category();
        String client_customer_id_sp = customerDetailUpdateRequest.getClient_customer_id();
        String title_ia = customerDetailUpdateRequest.getTitle();
        String last_name_ia = customerDetailUpdateRequest.getLast_name();
        String gender_ia = customerDetailUpdateRequest.getGender();
        String mobile_number_ia = customerDetailUpdateRequest.getMobile_number();
        String place_of_birth_ia = customerDetailUpdateRequest.getPlace_of_birth();
        String city_ia = customerDetailUpdateRequest.getCurrent_city();
        String current_district_ia = customerDetailUpdateRequest.getCurrent_district();
        try {
            Integer current_pincode_ia_conversion = customerDetailUpdateRequest.getCurrent_pincode();
            String current_pincode_ia = dataTypeConversion.getIntFromString(current_pincode_ia_conversion);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable current_pincode_ia");
        }
        String residence_permanent_address_ic = customerDetailUpdateRequest.getResidence_type_current_address();
        String permanent_district_ia = customerDetailUpdateRequest.getPermanent_district();
        try {
            Integer permanent_pincode_ia_conversion = customerDetailUpdateRequest.getPermanent_pincode();
            String permanent_pincode_ia = dataTypeConversion.getIntFromString(permanent_pincode_ia_conversion);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable permanent_pincode_ia");
        }
        //(Repate)String residence_permanent_address_ic = customerDetailUpdateRequest.getResidence_type_permanent_address();
        String religion_ia = customerDetailUpdateRequest.getReligion();
        String caste_ia = customerDetailUpdateRequest.getCaste();
        String occupation_ic = customerDetailUpdateRequest.getOccupation();
        String income_source_sp = customerDetailUpdateRequest.getIncome_source();
        String property_ownership_flag_sp = customerDetailUpdateRequest.getProperty_ownership_flag();
        String business_udhyam_regn_number_nia = customerDetailUpdateRequest.getUdyam_number();
        String name_of_bureau_sp = customerDetailUpdateRequest.getName_of_bureau();
        try {
            Integer bureau_score_sp_conversion = customerDetailUpdateRequest.getBureau_score();
            String bureau_score_sp = dataTypeConversion.getIntFromString(bureau_score_sp_conversion);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable bureau_score_sp");
        }
        //List<String> bureau_report_link_SP = getBureauReportLinkSP();
        //customerDetailUpdateRequest.getBureau_report_link(bureau_report_link_SP);

        String product_id_sp = customerDetailUpdateRequest.getProduct_id();
        String application_id_sp = customerDetailUpdateRequest.getApplication_id();
        String category_sp = customerDetailUpdateRequest.getCategory();
        String sub_category_sp = customerDetailUpdateRequest.getSub_category();
        String purpose_sp = customerDetailUpdateRequest.getPurpose();
        String disbursement_type_sp = customerDetailUpdateRequest.getDisbursement_type();
        Integer number_of_tranches_sp = customerDetailUpdateRequest.getNumber_of_tranches();
        Integer tenure_sp = customerDetailUpdateRequest.getTenure();
        Integer number_of_repayments_sp = customerDetailUpdateRequest.getNumber_of_repayments();
        String psl_description_sp = customerDetailUpdateRequest.getPsl_description();
        String impacted_industry_description_sp = customerDetailUpdateRequest.getImpacted_industry_description();
        String applicant_never_in_30_plus_sma_sub_last_12m_sp = customerDetailUpdateRequest.getApplicant_never_in_30_plus_sma_sub_last_12m();
        String tax_slab_sp = customerDetailUpdateRequest.getTax_slab();
        String psl_msme_type_of_enterprise_sp = customerDetailUpdateRequest.getPsl_msme_type_of_enterprise();
        //(Repate)String current_address_ia = customerDetailUpdateRequest.getCurrent_address_line1();
        String cersai_security_int_id_ac = customerDetailUpdateRequest.getCersai_security_int_id();
        String repayment_frequency_sp = customerDetailUpdateRequest.getRepayment_frequency();
        String father_first_name_ia = customerDetailUpdateRequest.getFather_first_name();
        String father_last_name_ia = customerDetailUpdateRequest.getFather_last_name();
        String total_value_of_security_sp = customerDetailUpdateRequest.getTotal_value_of_security();
        String tenure_frequency_sp = customerDetailUpdateRequest.getTenure_frequency();
        String marital_status_ia = customerDetailUpdateRequest.getMarital_status();
        String ckyc_id_ia = customerDetailUpdateRequest.getCkyc_id();

        try {
            String date_of_birth_ia_conversion  = customerDetailUpdateRequest.getDate_of_birth();
            Date date_of_birth_ia =dataTypeConversion.getDateFromString("yyyy-MM-dd",date_of_birth_ia_conversion);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable date_of_birth_ia");
        }
        try {
            String first_repayment_date_sp_conversion = customerDetailUpdateRequest.getFirst_repayment_date();
            Date first_repayment_date_sp =dataTypeConversion.getDateFromString("yyyy-MM-dd",first_repayment_date_sp_conversion);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable first_repayment_date_sp");
        }
        try {
            String itr_filed_date_current_fy_conversion = customerDetailUpdateRequest.getItr_filed_date_current_fy();
            Date itr_filed_date_current_fy = dataTypeConversion.getDateFromString("yyyy-MM-dd",itr_filed_date_current_fy_conversion);
        }catch (Exception e) {
            throw new SystemException("1110","Unparseable itr_filed_date_current_fy");
        }
        try {
            String application_date_sp_conversion = customerDetailUpdateRequest.getApplication_date();
            Date application_date_sp = dataTypeConversion.getDateFromString("yyyy-MM-dd",application_date_sp_conversion);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable application_date_sp");
        }
        try {
            String fcu_done_date_sp_conversion = customerDetailUpdateRequest.getFcu_done_date();
            Date fcu_done_date_sp = dataTypeConversion.getDateFromString("yyyy-MM-dd",fcu_done_date_sp_conversion);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable fcu_done_date_sp");
        }
        try {
            String e_verification_of_kyc_done_date_sp_conversion = customerDetailUpdateRequest.getE_verification_of_kyc_done_date();
            Date e_verification_of_kyc_done_date_sp = dataTypeConversion.getDateFromString("yyyy-MM-dd",e_verification_of_kyc_done_date_sp_conversion);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable e_verification_of_kyc_done_date_sp");
        }
        try {
            String pd_done_date_sp_conversion = customerDetailUpdateRequest.getPd_done_date();
            Date pd_done_date_sp = dataTypeConversion.getDateFromString("yyyy-MM-dd",pd_done_date_sp_conversion);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable pd_done_date_sp");
        }
        try {
            String search_with_registrar_of_companies_obtained_date_sp_conversion = customerDetailUpdateRequest.getSearch_with_registrar_of_companies_obtained_date();
            Date search_with_registrar_of_companies_obtained_date_sp = dataTypeConversion.getDateFromString("yyyy-MM-dd",search_with_registrar_of_companies_obtained_date_sp_conversion);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable search_with_registrar_of_companies_obtained_date_sp");
        }
        try {
            String cersai_registration_reference_number_verification_date_sp_conversion = customerDetailUpdateRequest.getCersai_registration_reference_number_verification_date();
            Date cersai_registration_reference_number_verification_date_sp = dataTypeConversion.getDateFromString("yyyy-MM-dd",cersai_registration_reference_number_verification_date_sp_conversion);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable cersai_registration_reference_number_verification_date_sp");
        }
        try {
            String cibil_report_done_date_sp_conversion = customerDetailUpdateRequest.getCibil_report_done_date();
            Date cibil_report_done_date_sp = dataTypeConversion.getDateFromString("yyyy-MM-dd",cibil_report_done_date_sp_conversion);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable cibil_report_done_date_sp");
        }
        try {
            String repayment_period_end_date_sp_conversion = customerDetailUpdateRequest.getRepayment_period_end_date();
            Date repayment_period_end_date_sp = dataTypeConversion.getDateFromString("yyyy-MM-dd",repayment_period_end_date_sp_conversion);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable repayment_period_end_date_sp");
        }
        try {
            String date_of_sanction_by_nbfc_sp_conversion = customerDetailUpdateRequest.getDate_of_sanction_by_nbfc();
            Date date_of_sanction_by_nbfc_sp = dataTypeConversion.getDateFromString("yyyy-MM-dd",date_of_sanction_by_nbfc_sp_conversion);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable date_of_sanction_by_nbfc_sp");
        }
        try {
            String date_of_documentation_by_nbfc_sp_conversion = customerDetailUpdateRequest.getDate_of_documentation_by_nbfc();
            Date date_of_documentation_by_nbfc_sp = dataTypeConversion.getDateFromString("yyyy-MM-dd",date_of_documentation_by_nbfc_sp_conversion);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable date_of_documentation_by_nbfc_sp");
        }
        try {
            Float annual_income_sp_conversion = customerDetailUpdateRequest.getAnnual_income();
            String annual_income_sp = dataTypeConversion.getStringFromFloat(annual_income_sp_conversion);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable annual_income_sp");
        }
       /* try {
            Float principal_amount_sp_conversion = customerDetailUpdateRequest.getPrincipal_amount();
            Integer principal_amount_sp  = dataTypeConversion.customerDetailUpdateRequest.getPrincipal_amount(principal_amount_sp);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable principal_amount_sp");
        }
        try {
            Float interest_rate_sp = dataTypeConverter.getIntegerFromFloat(customerDetailDataModel.getInterest_rate_sp());
            customerDetailUpdateRequest.getInterest_rate(interest_rate_sp);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable interest_rate_sp");
        }
        try {
            Float loan_emi_sp = dataTypeConverter.getIntegerFromFloat(customerDetailDataModel.getLoan_emi_sp());
            customerDetailUpdateRequest.getLoan_emi(loan_emi_sp);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable loan_emi_sp");
        }
        customerDetailUpdateRequest.getApplicant_age_at_maturity(customerDetailDataModel.getApplicant_age_at_maturity_ia());

*/

    }
}
