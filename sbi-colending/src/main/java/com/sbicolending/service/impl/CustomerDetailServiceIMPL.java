package com.sbicolending.service.impl;

import com.sbicolending.dao.CustomerDetailDao;
import com.sbicolending.exception.SystemException;
import com.sbicolending.model.CustomerDetailDataModel;
import com.sbicolending.model.customerdetailsresponse.*;
import com.sbicolending.service.CustomerDetailService;
import com.sbicolending.utils.BaseLogger;
import com.sbicolending.utils.DataTypeConversion;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerDetailServiceIMPL implements CustomerDetailService {

    private Logger logger = BaseLogger.getLogger(CustomerDetailServiceIMPL.class);

    @Autowired
    private CustomerDetailDao customerDetailDao;
    @Autowired
    private DataTypeConversion dataTypeConversion;

    @Override
    public CustomerDetailResponseModel getCustomerDetails(String lanSp) {

        CustomerDetailResponseModel  customerDetailResponse = null;

            CustomerDetailDataModel customerDetailDataModel = new CustomerDetailDataModel();
            List<CustomerDetailDataModel> customerDetailDataModelList = customerDetailDao.getCustomerDetailsforLanSP(lanSp);

            if (!customerDetailDataModelList.isEmpty() && customerDetailDataModelList.size() > 0) {
                customerDetailDataModel = customerDetailDataModelList.get(0);

                customerDetailResponse = new CustomerDetailResponseModel();

                customerDetailResponse.setPrimary_borrower_type(customerDetailDataModel.getCustomer_type_sp());
                customerDetailResponse.setFirst_name(customerDetailDataModel.getFirst_name_ia());
                customerDetailResponse.setCurrent_address(customerDetailDataModel.getCurrent_address_ia());
                customerDetailResponse.setCurrent_state(customerDetailDataModel.getState_ia());
                customerDetailResponse.setCustomer_category(customerDetailDataModel.getCustomer_category_sp());
                customerDetailResponse.setClient_customer_id(customerDetailDataModel.getClient_customer_id_sp());
                customerDetailResponse.setTitle(customerDetailDataModel.getTitle_ia());
                customerDetailResponse.setLast_name(customerDetailDataModel.getLast_name_ia());
                customerDetailResponse.setGender(customerDetailDataModel.getGender_ia());
                customerDetailResponse.setMobile_number(customerDetailDataModel.getMobile_number_ia());
                customerDetailResponse.setPlace_of_birth(customerDetailDataModel.getPlace_of_birth_ia());
                customerDetailResponse.setCurrent_city(customerDetailDataModel.getCity_ia());
                customerDetailResponse.setCurrent_district(customerDetailDataModel.getCurrent_district_ia());
                try {
                    Integer current_pincode_ia = dataTypeConversion.getStringFromInt(customerDetailDataModel.getCurrent_pincode_ia());
                    customerDetailResponse.setCurrent_pincode(current_pincode_ia);
                }catch (Exception e){
                    throw new SystemException("1110","Unparseable current_pincode_ia");
                }
                customerDetailResponse.setResidence_type_current_address(customerDetailDataModel.getResidence_permanent_address_ic());
                customerDetailResponse.setPermanent_district(customerDetailDataModel.getPermanent_district_ia());
                try {
                    Integer permanent_pincode_ia = dataTypeConversion.getStringFromInt(customerDetailDataModel.getPermanent_pincode_ia());
                    customerDetailResponse.setPermanent_pincode(permanent_pincode_ia);
                }catch (Exception e){
                    throw new SystemException("1110","Unparseable permanent_pincode_ia");
                }
                customerDetailResponse.setResidence_type_permanent_address(customerDetailDataModel.getResidence_permanent_address_ic());
                customerDetailResponse.setReligion(customerDetailDataModel.getReligion_ia());
                customerDetailResponse.setCaste(customerDetailDataModel.getCaste_ia());
                customerDetailResponse.setOccupation(customerDetailDataModel.getOccupation_ic());
                customerDetailResponse.setIncome_source(customerDetailDataModel.getIncome_source_sp());
                customerDetailResponse.setProperty_ownership_flag(customerDetailDataModel.getProperty_ownership_flag_sp());
                customerDetailResponse.setUdyam_number(customerDetailDataModel.getBusiness_udhyam_regn_number_nia());
                customerDetailResponse.setName_of_bureau(customerDetailDataModel.getName_of_bureau_sp());
                try {
                    Integer bureau_score_sp = dataTypeConversion.getStringFromInt(customerDetailDataModel.getBureau_score_sp());
                    customerDetailResponse.setBureau_score(bureau_score_sp);
                }catch (Exception e){
                    throw new SystemException("1110","Unparseable bureau_score_sp");
                }
                List<String> bureau_report_link_SP = getBureauReportLinkSP();
                customerDetailResponse.setBureau_report_link(bureau_report_link_SP);
                customerDetailResponse.setProduct_id(customerDetailDataModel.getProduct_id_sp());
                customerDetailResponse.setApplication_id(customerDetailDataModel.getApplication_id_sp());
                customerDetailResponse.setCategory(customerDetailDataModel.getCategory_sp());
                customerDetailResponse.setSub_category(customerDetailDataModel.getSub_category_sp());
                customerDetailResponse.setPurpose(customerDetailDataModel.getPurpose_sp());
                customerDetailResponse.setDisbursement_type(customerDetailDataModel.getDisbursement_type_sp());
                customerDetailResponse.setNumber_of_tranches(customerDetailDataModel.getNumber_of_tranches_sp());
                customerDetailResponse.setTenure(customerDetailDataModel.getTenure_sp());
                customerDetailResponse.setNumber_of_repayments(customerDetailDataModel.getNumber_of_repayments_sp());
                customerDetailResponse.setPsl_description(customerDetailDataModel.getPsl_description_sp());
                customerDetailResponse.setImpacted_industry_description(customerDetailDataModel.getImpacted_industry_description_sp());
                customerDetailResponse.setApplicant_never_in_30_plus_sma_sub_last_12m(customerDetailDataModel.getApplicant_never_in_30_plus_sma_sub_last_12m_sp());
                customerDetailResponse.setTax_slab(customerDetailDataModel.getTax_slab_sp());
                customerDetailResponse.setPsl_msme_type_of_enterprise(customerDetailDataModel.getPsl_msme_type_of_enterprise_sp());
                customerDetailResponse.setCurrent_address_line1(customerDetailDataModel.getCurrent_address_ia());
                customerDetailResponse.setCersai_security_int_id(customerDetailDataModel.getCersai_security_int_id_ac());
                customerDetailResponse.setRepayment_frequency(customerDetailDataModel.getRepayment_frequency_sp());
                customerDetailResponse.setFather_first_name(customerDetailDataModel.getFather_first_name_ia());
                customerDetailResponse.setFather_last_name(customerDetailDataModel.getFather_last_name_ia());
                customerDetailResponse.setTotal_value_of_security(customerDetailDataModel.getTotal_value_of_security_sp());
                customerDetailResponse.setTenure_frequency(customerDetailDataModel.getTenure_frequency_sp());
                customerDetailResponse.setMarital_status(customerDetailDataModel.getMarital_status_ia());
                customerDetailResponse.setCkyc_id(customerDetailDataModel.getCkyc_id_ia());
                try {
                    String date_of_birth_ia = dataTypeConversion.getStringFromDate("yyyy-MM-dd",customerDetailDataModel.getDate_of_birth_ia());
                    customerDetailResponse.setDate_of_birth(date_of_birth_ia);
                }catch (Exception e){
                     throw new SystemException("1110","Unparseable date_of_birth_ia");
                }try {
                    String first_repayment_date_sp = dataTypeConversion.getStringFromDate("yyyy-MM-dd",customerDetailDataModel.getFirst_repayment_date_sp());
                    customerDetailResponse.setFirst_repayment_date(first_repayment_date_sp);
                }catch (Exception e){
                    throw new SystemException("1110","Unparseable first_repayment_date_sp");
                }
                try {
                    String itr_filed_date_current_fy = dataTypeConversion.getStringFromDate("yyyy-MM-dd",customerDetailDataModel.getItr_filed_date_current_fy_sp());
                    customerDetailResponse.setItr_filed_date_current_fy(itr_filed_date_current_fy);
                }catch (Exception e) {
                    throw new SystemException("1110","Unparseable itr_filed_date_current_fy");
                }
                try {
                    String application_date_sp = dataTypeConversion.getStringFromDate("yyyy-MM-dd",customerDetailDataModel.getApplication_date_sp());
                    customerDetailResponse.setApplication_date(application_date_sp);
                }catch (Exception e){
                    throw new SystemException("1110","Unparseable application_date_sp");
                }
                try {
                    String fcu_done_date_sp = dataTypeConversion.getStringFromDate("yyyy-MM-dd",customerDetailDataModel.getFcu_done_date_sp());
                    customerDetailResponse.setFcu_done_date(fcu_done_date_sp);
                }catch (Exception e){
                    throw new SystemException("1110","Unparseable fcu_done_date_sp");
                }try {
                    String e_verification_of_kyc_done_date_sp = dataTypeConversion.getStringFromDate("yyyy-MM-dd",customerDetailDataModel.getE_verification_of_kyc_done_date_sp());
                    customerDetailResponse.setE_verification_of_kyc_done_date(e_verification_of_kyc_done_date_sp);
                }catch (Exception e){
                    throw new SystemException("1110","Unparseable e_verification_of_kyc_done_date_sp");
                }
                try {
                    String pd_done_date_sp = dataTypeConversion.getStringFromDate("yyyy-MM-dd",customerDetailDataModel.getPd_done_date_sp());
                    customerDetailResponse.setPd_done_date(pd_done_date_sp);
                }catch (Exception e){
                    throw new SystemException("1110","Unparseable pd_done_date_sp");
                }
                try {
                    String search_with_registrar_of_companies_obtained_date_sp = dataTypeConversion.getStringFromDate("yyyy-MM-dd",customerDetailDataModel.getSearch_with_registrar_of_companies_obtained_date_sp());
                    customerDetailResponse.setSearch_with_registrar_of_companies_obtained_date(search_with_registrar_of_companies_obtained_date_sp);
                }catch (Exception e){
                    throw new SystemException("1110","Unparseable search_with_registrar_of_companies_obtained_date_sp");
                }
                try {
                    String cersai_registration_reference_number_verification_date_sp = dataTypeConversion.getStringFromDate("yyyy-MM-dd",customerDetailDataModel.getCersai_registration_reference_number_verification_date_sp());
                    customerDetailResponse.setCersai_registration_reference_number_verification_date(cersai_registration_reference_number_verification_date_sp);
                }catch (Exception e){
                    throw new SystemException("1110","Unparseable cersai_registration_reference_number_verification_date_sp");
                }
                try {
                    String cibil_report_done_date_sp = dataTypeConversion.getStringFromDate("yyyy-MM-dd",customerDetailDataModel.getCibil_report_done_date_sp());
                    customerDetailResponse.setCibil_report_done_date(cibil_report_done_date_sp);
                }catch (Exception e){
                    throw new SystemException("1110","Unparseable cibil_report_done_date_sp");
                }
                try {
                    String repayment_period_end_date_sp = dataTypeConversion.getStringFromDate("yyyy-MM-dd",customerDetailDataModel.getRepayment_period_end_date_sp());
                    customerDetailResponse.setRepayment_period_end_date(repayment_period_end_date_sp);
                }catch (Exception e){
                    throw new SystemException("1110","Unparseable repayment_period_end_date_sp");
                }
                try {
                    String date_of_sanction_by_nbfc_sp = dataTypeConversion.getStringFromDate("yyyy-MM-dd",customerDetailDataModel.getDate_of_sanction_by_nbfc_sp());
                    customerDetailResponse.setDate_of_sanction_by_nbfc(date_of_sanction_by_nbfc_sp);
                }catch (Exception e){
                    throw new SystemException("1110","Unparseable date_of_sanction_by_nbfc_sp");
                }
                try {
                    String date_of_documentation_by_nbfc_sp = dataTypeConversion.getStringFromDate("yyyy-MM-dd",customerDetailDataModel.getDate_of_documentation_by_nbfc_sp());
                    customerDetailResponse.setDate_of_documentation_by_nbfc(date_of_documentation_by_nbfc_sp);
                }catch (Exception e){
                    throw new SystemException("1110","Unparseable date_of_documentation_by_nbfc_sp");
                }
                try {
                    Float annual_income_sp = dataTypeConversion.getStringFromFloat(customerDetailDataModel.getAnnual_income_sp());
                    customerDetailResponse.setAnnual_income(annual_income_sp);
                }catch (Exception e){
                    throw new SystemException("1110","Unparseable annual_income_sp");
                }
                try {
                   Float principal_amount_sp = dataTypeConversion.getIntegerFromFloat(customerDetailDataModel.getPrincipal_amount_sp());
                   customerDetailResponse.setPrincipal_amount(principal_amount_sp);
                }catch (Exception e){
                   throw new SystemException("1110","Unparseable principal_amount_sp");
                }
                try {
                    Float interest_rate_sp = dataTypeConversion.getIntegerFromFloat(customerDetailDataModel.getInterest_rate_sp());
                    customerDetailResponse.setInterest_rate(interest_rate_sp);
                }catch (Exception e){
                    throw new SystemException("1110","Unparseable interest_rate_sp");
                }
                try {
                    Float loan_emi_sp = dataTypeConversion.getIntegerFromFloat(customerDetailDataModel.getLoan_emi_sp());
                    customerDetailResponse.setLoan_emi(loan_emi_sp);
                }catch (Exception e){
                    throw new SystemException("1110","Unparseable loan_emi_sp");
                }
                customerDetailResponse.setApplicant_age_at_maturity(customerDetailDataModel.getApplicant_age_at_maturity_ia());



                //==================Set Data in Object====================================
                BusinessModel businessModel = getBusinessModelData(customerDetailDataModel);
                customerDetailResponse.setBusiness(businessModel);
                List<GuarantorsModel> guarantorsModel = getGuarantorsModelData(customerDetailDataModel);
                customerDetailResponse.setGuarantors(guarantorsModel);
                CoApplicantsModel coApplicantsModel = getCoApplicantsModelData(customerDetailDataModel);
                customerDetailResponse.setCoApplicants(coApplicantsModel);
                BankStatementModel bankStatementModel = getBankStatementModelData(customerDetailDataModel);
                customerDetailResponse.setBankStatement(bankStatementModel);
                FinancialDataModel financialDataModel = getFinancialDataModelData(customerDetailDataModel);
                customerDetailResponse.setFinancialData(financialDataModel);
                List<TranchesModel> tranchesModel = getTranchesModelData(customerDetailDataModel);
                customerDetailResponse.setTranchesModel(tranchesModel);
                LinkedLoanInfosModel linkedLoanInfosModel = getLinkedLoanInfosModelData(customerDetailDataModel);
                customerDetailResponse.setLinkedLoanInfosModel(linkedLoanInfosModel);
                BusinessCoApplicantsModel businessCoApplicantsModel = getBusinessCoApplicantsModelData(customerDetailDataModel);
                customerDetailResponse.setBusinessCoApplicants(businessCoApplicantsModel);
                RelatedPartiesModel relatedPartiesModel = getRelatedPartiesModelData(customerDetailDataModel);
                customerDetailResponse.setRelatedPartiesModel(relatedPartiesModel);
                OriginalLoanDetailModel originalLoanDetailModel = getOriginalLoanDetailModelData(customerDetailDataModel);
                customerDetailResponse.setOriginal_loan_detail(originalLoanDetailModel);
                List<OriginalDisbursementDetailsModel> originalDisbursementDetailsModel = getOriginalDisbursementDetailsModelData(customerDetailDataModel);
                customerDetailResponse.setOriginal_disbursement_details(originalDisbursementDetailsModel);
                List<AssetsModel> AssetsModel = getAssetsModelData(customerDetailDataModel);
                customerDetailResponse.setAssets(AssetsModel);
                PropertyReviewDocumentsModel propertyReviewDocumentsModel = getPropertyReviewDocumentsModelData(customerDetailDataModel);
                customerDetailResponse.setPropertyReviewDocumentsModel(propertyReviewDocumentsModel);
            }

        return customerDetailResponse;
    }


    private BusinessModel getBusinessModelData(CustomerDetailDataModel createLoanDataModel) {

        BusinessModel businessModel = new BusinessModel();


        businessModel.setName_of_business(createLoanDataModel.getName_of_business_nia());
        businessModel.setNature_of_business(createLoanDataModel.getNature_of_business_nia());
        businessModel.setType_of_constitution(createLoanDataModel.getType_of_constitution_nia());
        try {
            String registration_date_nia = dataTypeConversion.getStringFromDate("yyyy-MM-dd",createLoanDataModel.getRegistration_date_nia());
            businessModel.setRegistration_date(registration_date_nia);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable registration_date_nia");
        }
        try {
            String incorporation_date_nia = dataTypeConversion.getStringFromDate("yyyy-MM-dd",createLoanDataModel.getIncorporation_date_nia());
            businessModel.setIncorporation_date(incorporation_date_nia);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable incorporation_date_nia");
        }
        businessModel.setIndustry_type(createLoanDataModel.getIndustry_type_nia());
        businessModel.setSector_type(createLoanDataModel.getSector_type_nic());
        businessModel.setSub_sector_type(createLoanDataModel.getSub_sector_type_nia());
        try {
            Integer business_vintage_nia = dataTypeConversion.getDoubletoFromInt(createLoanDataModel.getBusiness_vintage_nia());
            businessModel.setBusiness_vintage(business_vintage_nia);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable business_vintage_nia");
        }
        businessModel.setBusiness_registered_office_address(createLoanDataModel.getBusiness_registered_office_address_nia());
        businessModel.setBusiness_registered_office_city(createLoanDataModel.getBusiness_mailing_office_city_nia());
        businessModel.setBusiness_registered_office_state(createLoanDataModel.getBusiness_registered_office_state_nia());
        try {
            Integer business_registered_office_pincode_nia = dataTypeConversion.getStringFromInt(createLoanDataModel.getBusiness_mailing_office_pincode_nia());
            businessModel.setBusiness_registered_office_pincode(business_registered_office_pincode_nia);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable business_registered_office_pincode_nia");
        }
        businessModel.setBusiness_mailing_office_address(createLoanDataModel.getBusiness_mailing_office_address1_nia());
        businessModel.setBusiness_mailing_office_city(createLoanDataModel.getBusiness_mailing_office_city_nia());
        try {
            Integer business_mailing_office_pincode_nia = dataTypeConversion.getStringFromInt(createLoanDataModel.getBusiness_mailing_office_pincode_nia());
            businessModel.setBusiness_mailing_office_pincode(business_mailing_office_pincode_nia);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable business_mailing_office_pincode_nia");
        }
       /* try {
            List<Long> business_phone_number_nia = new ArrayList<>();
            Long business_phone_number_nia_converter = dataTypeConverter.getStringFromLong(createLoanDataModel.getBusiness_phone_number_nia());
            business_phone_number_nia.add(business_phone_number_nia_converter);
            businessModel.setBusiness_phone_number(business_phone_number_nia);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable business_phone_number_nia");
        }*/
        List<Long> business_phone_number_nia = getBusinessPhoneNumberNia();
        businessModel.setBusiness_phone_number(business_phone_number_nia);

        List<String> business_email_id_nia = new ArrayList<>();
        business_email_id_nia.add(createLoanDataModel.getBusiness_email_id_nia());
        businessModel.setBusiness_email_id(business_email_id_nia);
        businessModel.setProperty_ownership_flag(createLoanDataModel.getProperty_ownership_flag_nic());
        businessModel.setBusiness_pan_number(createLoanDataModel.getBusiness_pan_number_nia());
        businessModel.setBusiness_rc_number(createLoanDataModel.getBusiness_rc_number_nia());
        businessModel.setBusiness_udhyam_regn_number(createLoanDataModel.getBusiness_udhyam_regn_number_nia());
        businessModel.setBusiness_mailing_office_address1(createLoanDataModel.getBusiness_mailing_office_address1_nia());
        businessModel.setBusiness_mailing_office_address2(createLoanDataModel.getBusiness_mailing_office_address2_nia());
        businessModel.setBusiness_mailing_office_address3(createLoanDataModel.getBusiness_mailing_office_address3_nia());
        businessModel.setEnterprise_activity(createLoanDataModel.getEnterprise_activity_nia());
        businessModel.setCustomer_type(createLoanDataModel.getCustomer_type_sp());
        try {
            Float exisiting_shareholding_of_promoters_nia = dataTypeConversion.getStringFromFloat(createLoanDataModel.getExisiting_shareholding_of_promoters_nia());
            businessModel.setExisiting_shareholding_of_promoters(exisiting_shareholding_of_promoters_nia);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable exisiting_shareholding_of_promoters_nia");
        }
        try {
            Float exisiting_shareholding_of_mutual_funds_nia = dataTypeConversion.getStringFromFloat(createLoanDataModel.getExisiting_shareholding_of_mutual_funds_nia());
            businessModel.setExisiting_shareholding_of_mutual_funds(exisiting_shareholding_of_mutual_funds_nia);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable exisiting_shareholding_of_mutual_funds_nia");
        }
        try {
            Float exisiting_shareholding_of_financial_institutions_banks_nia = dataTypeConversion.getStringFromFloat(createLoanDataModel.getExisiting_shareholding_of_financial_institutions_banks_nia());
            businessModel.setExisiting_shareholding_of_financial_institutions_banks(exisiting_shareholding_of_financial_institutions_banks_nia);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable exisiting_shareholding_of_financial_institutions_banks_nia");
        }
        try {
            Float exisiting_shareholding_of_others_nia = dataTypeConversion.getStringFromFloat(createLoanDataModel.getExisiting_shareholding_of_others_nia());
            businessModel.setExisiting_shareholding_of_others(exisiting_shareholding_of_others_nia);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable exisiting_shareholding_of_others_nia");
        }
        try {
            Float exisiting_shareholding_total_nia = dataTypeConversion.getStringFromFloat(createLoanDataModel.getExisiting_shareholding_total_nia());
            businessModel.setExisiting_shareholding_total(exisiting_shareholding_total_nia);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable exisiting_shareholding_total_nia");
        }
        try {
            Float proposed_shareholding_of_promoters_nia = dataTypeConversion.getStringFromFloat(createLoanDataModel.getProposed_shareholding_of_promoters_nia());
            businessModel.setProposed_shareholding_of_promoters(proposed_shareholding_of_promoters_nia);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable proposed_shareholding_of_promoters_nia");
        }
        try {
            Float proposed_shareholding_of_mutual_funds_nia = dataTypeConversion.getStringFromFloat(createLoanDataModel.getProposed_shareholding_of_mutual_funds_nia());
            businessModel.setProposed_shareholding_of_mutual_funds(proposed_shareholding_of_mutual_funds_nia);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable proposed_shareholding_of_mutual_funds_nia");
        }
        try {
            Float proposed_shareholding_of_financial_institutions_banks_nia = dataTypeConversion.getStringFromFloat(createLoanDataModel.getProposed_shareholding_of_financial_institutions_banks_nia());
            businessModel.setProposed_shareholding_of_financial_institutions_banks(proposed_shareholding_of_financial_institutions_banks_nia);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable proposed_shareholding_of_financial_institutions_banks_nia");
        }
        try {
            Float proposed_shareholding_of_others_nia = dataTypeConversion.getStringFromFloat(createLoanDataModel.getProposed_shareholding_of_others_nia());
            businessModel.setProposed_shareholding_of_others(proposed_shareholding_of_others_nia);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable proposed_shareholding_of_others_nia");
        }
        try {
            Float proposed_shareholding_total_nia = dataTypeConversion.getStringFromFloat(createLoanDataModel.getProposed_shareholding_total_nia());
            businessModel.setProposed_shareholding_total(proposed_shareholding_total_nia);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable proposed_shareholding_total_nia");
        }
        try {
            Integer annual_income_nia = dataTypeConversion.getStringFromInt(createLoanDataModel.getAnnual_income_nia());
            businessModel.setAnnual_income(annual_income_nia);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable annual_income_nia");
        }
        try {
            String balance_sheet_year_nia = dataTypeConversion.getStringFromDate("yyyy-MM-dd",createLoanDataModel.getBalance_sheet_year_nia());
            businessModel.setBalance_sheet_year(balance_sheet_year_nia);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable balance_sheet_year_nia");
        }
        businessModel.setCkyc_id(createLoanDataModel.getCkyc_id_nia());


        return businessModel;
    }


    private List<GuarantorsModel> getGuarantorsModelData(CustomerDetailDataModel createLoanDataModel) {

        GuarantorsModel guarantorsModel = new GuarantorsModel();
        GuarantorsModel guarantorsModel1 = new GuarantorsModel();
        GuarantorsModel guarantorsModel2 = new GuarantorsModel();
        List<GuarantorsModel> guarantorsModelList = new ArrayList<>();


        try {
            String date_of_birth_ig = dataTypeConversion.getStringFromDate("yyyy-MM-dd",createLoanDataModel.getDate_of_birth_ig());
            guarantorsModel.setDate_of_birth(date_of_birth_ig);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable date_of_birth_ig");
        }
        guarantorsModel.setGender(createLoanDataModel.getGender_ig());
        guarantorsModel.setCurrent_address(createLoanDataModel.getCurrent_address_ig());
        guarantorsModel.setCurrent_district(createLoanDataModel.getCurrent_district_ig());
        guarantorsModel.setCurrent_city(createLoanDataModel.getCity_ig());
        guarantorsModel.setCurrent_state(createLoanDataModel.getState_ig());
        try {
            Integer current_pincode_ig = dataTypeConversion.getStringFromInt(createLoanDataModel.getCurrent_pincode_ig());
            guarantorsModel.setCurrent_pincode(current_pincode_ig);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable current_pincode_ig");
        }
        guarantorsModel.setPermanent_district(createLoanDataModel.getPermanent_district_ig());
        try {
            Integer permanent_pincode_ig = dataTypeConversion.getStringFromInt(createLoanDataModel.getPermanent_pincode_ig());
            guarantorsModel.setPermanent_pincode(permanent_pincode_ig);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable permanent_pincode_ig");
        }
       try {
            Long mobile_number_ig = dataTypeConversion.getStringFromLong(createLoanDataModel.getMobile_number_ig());
            guarantorsModel.setMobile_number(mobile_number_ig);
        }catch (Exception e){
           throw new SystemException("1110","Unparseable mobile_number_ig");
        }
        guarantorsModel.setMarital_status(createLoanDataModel.getMarital_status_ig());
        guarantorsModel.setReligion(createLoanDataModel.getReligion_ig());
        try {
            Integer bureau_score_ig = dataTypeConversion.getStringFromInt(createLoanDataModel.getBureau_score_ig());
            guarantorsModel.setBureau_score(bureau_score_ig);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable bureau_score_ig");
        }
        try {
            Integer age_at_maturity_ig = dataTypeConversion.getStringFromInt(createLoanDataModel.getAge_at_maturity_ig());
            guarantorsModel.setAge_at_maturity(age_at_maturity_ig);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable age_at_maturity_ig");
        }
        guarantorsModel.setEmployment_details_designation(createLoanDataModel.getEmployment_details_designation_sp());
        guarantorsModel.setCaste(createLoanDataModel.getCaste_ig());
        guarantorsModel.setFather_first_name(createLoanDataModel.getFather_first_name_ig());
        guarantorsModel.setFather_last_name(createLoanDataModel.getFather_last_name_ig());
        guarantorsModel.setOccupation(createLoanDataModel.getOccupation_ig());
        guarantorsModel.setPlace_of_birth(createLoanDataModel.getPlace_of_birth_ig());
        guarantorsModel.setTitle(createLoanDataModel.getTitle_ig());
        guarantorsModel.setIncome_source(createLoanDataModel.getIncome_source_ig());
        guarantorsModel.setCurrent_address_line1(createLoanDataModel.getCurrent_address_line1_ig());
        guarantorsModel.setEducation(createLoanDataModel.getEducation_ig());
        try {
            Float other_than_agricultural_income_ig = dataTypeConversion.getStringFromFloat(createLoanDataModel.getOther_than_agricultural_income_ig());
            guarantorsModel.setOther_than_agricultural_income(other_than_agricultural_income_ig);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable other_than_agricultural_income_ig");
        }
        try {
            Float total_net_worth_ig = dataTypeConversion.getStringFromFloat(createLoanDataModel.getTotal_net_worth_ig());
            guarantorsModel.setTotal_net_worth(total_net_worth_ig);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable total_net_worth_ig");
        }
        guarantorsModel.setCustomer_type(createLoanDataModel.getCustomer_type_ig());
        guarantorsModel.setCkyc_id(createLoanDataModel.getCkyc_id_ig());
        guarantorsModel.setAnnual_income(createLoanDataModel.getAnnual_income_ig());
        guarantorsModelList.add(guarantorsModel);


        //===================================

        try {
            String date_of_birth_ig = dataTypeConversion.getStringFromDate("yyyy-MM-dd",createLoanDataModel.getDate_of_birth_ig());
            guarantorsModel1.setDate_of_birth(date_of_birth_ig);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable date_of_birth_ig");
        }
        guarantorsModel1.setGender(createLoanDataModel.getGender_ig());
        guarantorsModel1.setCurrent_address(createLoanDataModel.getCurrent_address_ig());
        guarantorsModel1.setCurrent_district(createLoanDataModel.getCurrent_district_ig());
        guarantorsModel1.setCurrent_city(createLoanDataModel.getCity_ig());
        guarantorsModel1.setCurrent_state(createLoanDataModel.getState_ig());
        try {
            Integer current_pincode_ig = dataTypeConversion.getStringFromInt(createLoanDataModel.getCurrent_pincode_ig());
            guarantorsModel1.setCurrent_pincode(current_pincode_ig);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable current_pincode_ig");
        }
        guarantorsModel1.setPermanent_district(createLoanDataModel.getPermanent_district_ig());
        try {
            Integer permanent_pincode_ig = dataTypeConversion.getStringFromInt(createLoanDataModel.getPermanent_pincode_ig());
            guarantorsModel1.setPermanent_pincode(permanent_pincode_ig);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable permanent_pincode_ig");
        }
        try {
            Long mobile_number_ig = dataTypeConversion.getStringFromLong(createLoanDataModel.getMobile_number_ig());
            guarantorsModel1.setMobile_number(mobile_number_ig);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable mobile_number_ig");
        }
        guarantorsModel1.setMarital_status(createLoanDataModel.getMarital_status_ig());
        guarantorsModel1.setReligion(createLoanDataModel.getReligion_ig());
        try {
            Integer bureau_score_ig = dataTypeConversion.getStringFromInt(createLoanDataModel.getBureau_score_ig());
            guarantorsModel1.setBureau_score(bureau_score_ig);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable bureau_score_ig");
        }
        try {
            Integer age_at_maturity_ig = dataTypeConversion.getStringFromInt(createLoanDataModel.getAge_at_maturity_ig());
            guarantorsModel1.setAge_at_maturity(age_at_maturity_ig);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable age_at_maturity_ig");
        }
        guarantorsModel1.setEmployment_details_designation(createLoanDataModel.getEmployment_details_designation_sp());
        guarantorsModel1.setCaste(createLoanDataModel.getCaste_ig());
        guarantorsModel1.setFather_first_name(createLoanDataModel.getFather_first_name_ig());
        guarantorsModel1.setFather_last_name(createLoanDataModel.getFather_last_name_ig());
        guarantorsModel1.setOccupation(createLoanDataModel.getOccupation_ig());
        guarantorsModel1.setPlace_of_birth(createLoanDataModel.getPlace_of_birth_ig());
        guarantorsModel1.setTitle(createLoanDataModel.getTitle_ig());
        guarantorsModel1.setIncome_source(createLoanDataModel.getIncome_source_ig());
        guarantorsModel1.setCurrent_address_line1(createLoanDataModel.getCurrent_address_line1_ig());
        guarantorsModel1.setEducation(createLoanDataModel.getEducation_ig());
        try {
            Float other_than_agricultural_income_ig = dataTypeConversion.getStringFromFloat(createLoanDataModel.getOther_than_agricultural_income_ig());
            guarantorsModel1.setOther_than_agricultural_income(other_than_agricultural_income_ig);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable other_than_agricultural_income_ig");
        }
        try {
            Float total_net_worth_ig = dataTypeConversion.getStringFromFloat(createLoanDataModel.getTotal_net_worth_ig());
            guarantorsModel1.setTotal_net_worth(total_net_worth_ig);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable total_net_worth_ig");
        }
        guarantorsModel1.setCustomer_type(createLoanDataModel.getCustomer_type_ig());
        guarantorsModel1.setCkyc_id(createLoanDataModel.getCkyc_id_ig());
        guarantorsModel1.setAnnual_income(createLoanDataModel.getAnnual_income_ig());
        guarantorsModelList.add(guarantorsModel1);





        guarantorsModel2.setGender(null);
        guarantorsModel2.setCurrent_address(null);
        guarantorsModel2.setCurrent_district(null);
        guarantorsModel2.setCurrent_city(null);
        guarantorsModel2.setCurrent_state(null);
        guarantorsModel2.setEmployment_details_designation(null);
        guarantorsModel2.setCaste(null);
        guarantorsModel2.setFather_first_name(null);
        guarantorsModel2.setFather_last_name(null);
        guarantorsModel2.setOccupation(null);
        guarantorsModel2.setPlace_of_birth(null);
        guarantorsModel2.setTitle(null);
        guarantorsModel2.setIncome_source(null);
        guarantorsModel2.setCurrent_address_line1(null);
        guarantorsModel2.setEducation(null);

        guarantorsModel2.setCustomer_type(null);
        guarantorsModel2.setCkyc_id(null);
        guarantorsModel2.setAnnual_income(null);
        guarantorsModelList.add(guarantorsModel2);


        //===============================================
        return guarantorsModelList;
    }


    private CoApplicantsModel getCoApplicantsModelData(CustomerDetailDataModel createLoanDataModel)  {

        CoApplicantsModel coApplicantsModel = new CoApplicantsModel();


        coApplicantsModel.setRelationship_with_applicant(createLoanDataModel.getRelationship_with_applicant_ic());
        coApplicantsModel.setFirst_name(createLoanDataModel.getFather_first_name_ic());
        coApplicantsModel.setLast_name(createLoanDataModel.getLast_name_ia());
        coApplicantsModel.setGender(createLoanDataModel.getGender_ic());
        coApplicantsModel.setOccupation(createLoanDataModel.getOccupation_ic());
        coApplicantsModel.setDate_of_birth(createLoanDataModel.getDate_of_birth_ic());
        try {
            Long mobile_number_ic = dataTypeConversion.getStringFromLong(createLoanDataModel.getMobile_number_ic());
            coApplicantsModel.setMobile_number(mobile_number_ic);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable mobile_number_ic");
        }

        coApplicantsModel.setCurrent_address(createLoanDataModel.getCurrent_address_ic());
        coApplicantsModel.setCurrent_city(createLoanDataModel.getCity_ic());
        coApplicantsModel.setCurrent_district(createLoanDataModel.getCurrent_district_ic());
        coApplicantsModel.setCurrent_state(createLoanDataModel.getState_ic());
        try {
            Integer current_pincode_ic = dataTypeConversion.getStringFromInt(createLoanDataModel.getCurrent_pincode_ic());
            coApplicantsModel.setCurrent_pincode(current_pincode_ic);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable current_pincode_ic");
        }
        coApplicantsModel.setPermanent_district(createLoanDataModel.getPermanent_district_ic());
        try {
            Integer permanent_pincode_ic = dataTypeConversion.getStringFromInt(createLoanDataModel.getPermanent_pincode_ic());
            coApplicantsModel.setPermanent_pincode(permanent_pincode_ic);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable permanent_pincode_ic");
        }
        coApplicantsModel.setMarital_status(createLoanDataModel.getMarital_status_ic());
        coApplicantsModel.setReligion(createLoanDataModel.getReligion_ic());
        coApplicantsModel.setEducation(createLoanDataModel.getEducation_ic());
        try {
            Float annual_income_ic = dataTypeConversion.getStringFromFloat(createLoanDataModel.getAnnual_income_ic());
            coApplicantsModel.setAnnual_income(annual_income_ic);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable annual_income_ic");
        }
        try {
            Integer bureau_score_ic = dataTypeConversion.getStringFromInt(createLoanDataModel.getBureau_score_ic());
            coApplicantsModel.setBureau_score(bureau_score_ic);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable bureau_score_ic");
        }
        try {
            Integer age_at_maturity_ic = dataTypeConversion.getStringFromInt(createLoanDataModel.getAge_at_maturity_ic());
            coApplicantsModel.setAge_at_maturity(age_at_maturity_ic);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable age_at_maturity_ic");
        }
        coApplicantsModel.setEmployment_details_designation(createLoanDataModel.getEmployment_details_designation_sp());
        coApplicantsModel.setCaste(createLoanDataModel.getCaste_ic());
        coApplicantsModel.setFather_first_name(createLoanDataModel.getFirst_name_ic());
        coApplicantsModel.setFather_last_name(createLoanDataModel.getFather_last_name_ic());
        coApplicantsModel.setPlace_of_birth(createLoanDataModel.getPlace_of_birth_ic());
        coApplicantsModel.setTitle(createLoanDataModel.getTitle_ic());
        coApplicantsModel.setIncome_source(createLoanDataModel.getIncome_source_ic());
        coApplicantsModel.setCurrent_address_line1(createLoanDataModel.getCurrent_address_ic());
        try {
            Float total_net_worth_ic = dataTypeConversion.getStringFromFloat(createLoanDataModel.getTotal_net_worth_ic());
            coApplicantsModel.setTotal_net_worth(total_net_worth_ic);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable total_net_worth_ic");
        }
        coApplicantsModel.setCustomer_type(createLoanDataModel.getCustomer_type_ic());
        coApplicantsModel.setCkyc_id(createLoanDataModel.getCkyc_id_ic());

        return coApplicantsModel;
    }


    private BankStatementModel getBankStatementModelData(CustomerDetailDataModel createLoanDataModel) {

        BankStatementModel bankStatementModel = new BankStatementModel();

        bankStatementModel.setSma_account(createLoanDataModel.getSma_account_sp());
        bankStatementModel.setBusiness_transactions(createLoanDataModel.getBusiness_transactions_sp());

        return bankStatementModel;
    }


    private FinancialDataModel getFinancialDataModelData(CustomerDetailDataModel createLoanDataModel) {

        FinancialDataModel financialDataModel = new FinancialDataModel();

        Float annual_business_turnover_sp = dataTypeConversion.getStringFromFloat(createLoanDataModel.getAnnual_business_turnover_sp());
        financialDataModel.setAnnual_business_turnover(annual_business_turnover_sp);
        return financialDataModel;
    }

    private List<TranchesModel> getTranchesModelData(CustomerDetailDataModel createLoanDataModel) {

        TranchesModel tranchesModel = new TranchesModel();
        List<TranchesModel> tranchesModelList = new ArrayList<>();

        tranchesModel.setTranche_number(createLoanDataModel.getTranche_number());
        tranchesModel.setPrincipal_amount(createLoanDataModel.getPrincipal_amount());
        tranchesModelList.add(tranchesModel);

        return tranchesModelList;

    }

    private LinkedLoanInfosModel getLinkedLoanInfosModelData(CustomerDetailDataModel customerDetailDataModel) {

        LinkedLoanInfosModel linkedLoanInfosModel = new LinkedLoanInfosModel();
        linkedLoanInfosModel.setLinked_loan_id(customerDetailDataModel.getLinked_loan_id());
        linkedLoanInfosModel.setForeclosure(customerDetailDataModel.getForeclosure());

        return linkedLoanInfosModel;

    }

    private BusinessCoApplicantsModel getBusinessCoApplicantsModelData(CustomerDetailDataModel createLoanDataModel) {

        BusinessCoApplicantsModel businessCoApplicantsModel = new BusinessCoApplicantsModel();


        businessCoApplicantsModel.setName_of_business(createLoanDataModel.getName_of_business_nic());
        businessCoApplicantsModel.setNature_of_business(createLoanDataModel.getNature_of_business_nic());
        businessCoApplicantsModel.setType_of_constitution(createLoanDataModel.getType_of_constitution_nic());
        try {
            String registration_date_nic = dataTypeConversion.getStringFromDate("yyyy-MM-dd",createLoanDataModel.getRegistration_date_nic());
            businessCoApplicantsModel.setRegistration_date(registration_date_nic);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable registration_date_nic");
        }
        try {
            String incorporation_date_nic = dataTypeConversion.getStringFromDate("yyyy-MM-dd",createLoanDataModel.getIncorporation_date_nic());
            businessCoApplicantsModel.setIncorporation_date(incorporation_date_nic);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable incorporation_date_nic");
        }
        businessCoApplicantsModel.setIndustry_type(createLoanDataModel.getIndustry_type_nic());
        businessCoApplicantsModel.setSector_type(createLoanDataModel.getSector_type_nic());
        businessCoApplicantsModel.setSub_sector_type(createLoanDataModel.getSub_sector_type_nic());
        businessCoApplicantsModel.setBusiness_vintage(createLoanDataModel.getBusiness_vintage_nic());
        businessCoApplicantsModel.setBusiness_registered_office_address(createLoanDataModel.getBusiness_registered_office_address_nic());
        businessCoApplicantsModel.setBusiness_registered_office_city(createLoanDataModel.getBusiness_mailing_office_city_nic());
        businessCoApplicantsModel.setBusiness_registered_office_state(createLoanDataModel.getBusiness_registered_office_address_nic());
        businessCoApplicantsModel.setBusiness_registered_office_pincode(createLoanDataModel.getBusiness_mailing_office_pincode_nic());
        businessCoApplicantsModel.setBusiness_mailing_office_address(createLoanDataModel.getBusiness_registered_office_address_nic());
        businessCoApplicantsModel.setBusiness_mailing_office_address1(createLoanDataModel.getBusiness_mailing_office_address1_nic());
        businessCoApplicantsModel.setBusiness_mailing_office_address2(createLoanDataModel.getBusiness_mailing_office_address2_nic());
        businessCoApplicantsModel.setBusiness_mailing_office_address3(createLoanDataModel.getBusiness_mailing_office_address3_nic());
        businessCoApplicantsModel.setBusiness_mailing_office_city(createLoanDataModel.getBusiness_mailing_office_city_nic());
        try {
            Integer business_mailing_office_pincode_nic = dataTypeConversion.getStringFromInt(createLoanDataModel.getBusiness_mailing_office_pincode_nic());
            businessCoApplicantsModel.setBusiness_mailing_office_pincode(business_mailing_office_pincode_nic);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable business_mailing_office_pincode_nic");
        }
        try {
            Long business_phone_number_nic = dataTypeConversion.getStringFromLong(createLoanDataModel.getBusiness_phone_number_nic());
            businessCoApplicantsModel.setBusiness_phone_number(business_phone_number_nic);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable business_phone_number_nic");
        }
        businessCoApplicantsModel.setBusiness_pan_number(createLoanDataModel.getBusiness_pan_number_nic());
        businessCoApplicantsModel.setBusiness_pan_link(createLoanDataModel.getBusiness_pan_link_nic());
        businessCoApplicantsModel.setBusiness_rc_number(createLoanDataModel.getBusiness_rc_number_nic());
        businessCoApplicantsModel.setBusiness_rc_link(createLoanDataModel.getBusiness_rc_link_nic());
        try {
            Float annual_business_turnover_sp = dataTypeConversion.getStringFromFloat(createLoanDataModel.getAnnual_business_turnover_sp());
            businessCoApplicantsModel.setAnnual_business_turnover(annual_business_turnover_sp);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable annual_business_turnover_sp");
        }
        businessCoApplicantsModel.setCkyc_id(createLoanDataModel.getCkyc_id_nic());

        return businessCoApplicantsModel;
    }


    private RelatedPartiesModel getRelatedPartiesModelData(CustomerDetailDataModel createLoanDataModel) {

        RelatedPartiesModel relatedPartiesModel = new RelatedPartiesModel();


        relatedPartiesModel.setConnected_with(createLoanDataModel.getConnected_with_rp());
        relatedPartiesModel.setConnection_name(createLoanDataModel.getConnection_name_rp());
        relatedPartiesModel.setRp_type(createLoanDataModel.getRp_type_rp());
        relatedPartiesModel.setName(createLoanDataModel.getName_rp());
        relatedPartiesModel.setShare_holding(createLoanDataModel.getShare_holding_rp());
        relatedPartiesModel.setDesignation(createLoanDataModel.getDesignation_rp());
        relatedPartiesModel.setProposed_share_holding(createLoanDataModel.getProposed_share_holding_rp());

        return relatedPartiesModel;

    }

    private OriginalLoanDetailModel getOriginalLoanDetailModelData(CustomerDetailDataModel createLoanDataModel) {

        OriginalLoanDetailModel originalLoanDetailModel = new OriginalLoanDetailModel();

        originalLoanDetailModel.setLoan_amount(createLoanDataModel.getLoan_amount());
        originalLoanDetailModel.setTenure(createLoanDataModel.getTenure());
        originalLoanDetailModel.setTenure_frequency(createLoanDataModel.getTenure_frequency_sp());

        return originalLoanDetailModel;
    }


    private List<OriginalDisbursementDetailsModel> getOriginalDisbursementDetailsModelData(CustomerDetailDataModel createLoanDataModel) {

        OriginalDisbursementDetailsModel originalDisbursementDetailsModel = new OriginalDisbursementDetailsModel();
        List<OriginalDisbursementDetailsModel> originalDisbursementDetailsModelList = new ArrayList<>();

        try {
            Float disbursement_amount_sp = dataTypeConversion.getStringFromFloat(createLoanDataModel.getDisbursement_amount_sp());
            originalDisbursementDetailsModel.setDisbursement_amount(disbursement_amount_sp);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable disbursement_amount_sp");
        }
        try {
            String disbursement_date_sp = dataTypeConversion.getStringFromDate("yyyy-MM-dd",createLoanDataModel.getDisbursement_date_sp());
            originalDisbursementDetailsModel.setDisbursement_date(disbursement_date_sp);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable disbursement_date_sp");
        }
        originalDisbursementDetailsModelList.add(originalDisbursementDetailsModel);

        return originalDisbursementDetailsModelList;
    }


    private List<AssetsModel> getAssetsModelData(CustomerDetailDataModel createLoanDataModel) {

        AssetsModel assetsModel = new AssetsModel();
        List<AssetsModel> assetsModelList = new ArrayList<>();

        assetsModel.setSanction_ltv(createLoanDataModel.getSanction_ltv_ac());
        try {
              String collateral_created_date_ac = dataTypeConversion.getStringFromDate("yyyy-MM-dd",createLoanDataModel.getCollateral_created_date_ac());
              assetsModel.setCollateral_created_date(collateral_created_date_ac);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable collateral_created_date_ac");
        }
        try {
            String cersai_date_ac = dataTypeConversion.getStringFromDate("yyyy-MM-dd",createLoanDataModel.getCersai_date_ac());
            assetsModel.setCersai_date(cersai_date_ac);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable cersai_date_ac");
        }
        try {
            Float Security_valuation_ac = dataTypeConversion.getStringFromFloat(createLoanDataModel.getSecurity_valuation_ac());
            assetsModel.setSecurity_valuation(Security_valuation_ac);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable Security_valuation_ac");
        }
        assetsModel.setSurvey_or_gat_number(createLoanDataModel.getSurvey_or_gat_number_ac());
        assetsModel.setBound_by_north(createLoanDataModel.getBound_by_north_ac());
        assetsModel.setBound_by_south(createLoanDataModel.getBound_by_south_ac());
        assetsModel.setBound_by_east(createLoanDataModel.getBound_by_east_ac());
        assetsModel.setBound_by_west(createLoanDataModel.getBound_by_west_ac());
        try {
            Integer purchase_cost_ac = dataTypeConversion.getStringFromInt(createLoanDataModel.getPurchase_cost_ac());
            assetsModel.setPurchase_cost(purchase_cost_ac);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable purchase_cost_ac");
        }
        try {
            String purchase_date_ac = dataTypeConversion.getStringFromDate("yyyy-MM-dd",createLoanDataModel.getPurchase_date_ac());
            assetsModel.setPurchase_date(purchase_date_ac);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable purchase_date_ac");
        }
        assetsModel.setCarpet_area_unit(createLoanDataModel.getCarpet_area_unit_ac());
        assetsModel.setPlot_id_number(createLoanDataModel.getPlot_id_number_ac());
        assetsModel.setProperty_nature(createLoanDataModel.getProperty_nature_ac());
        assetsModel.setProperty_locality(createLoanDataModel.getProperty_locality_ac());
        try {
            String valuation_date_ac = dataTypeConversion.getStringFromDate("yyyy-MM-dd",createLoanDataModel.getValuation_date_ac());
            assetsModel.setValuation_date(valuation_date_ac);
        }catch (Exception e){
            throw new SystemException("1110","Unparseable valuation_date_ac");
        }
        assetsModelList.add(assetsModel);

        return assetsModelList;
    }


    private PropertyReviewDocumentsModel getPropertyReviewDocumentsModelData(CustomerDetailDataModel createLoanDataModel) {

        PropertyReviewDocumentsModel propertyReviewDocumentsModel = new PropertyReviewDocumentsModel();

        List<String> field_verification_report_link = new ArrayList<>();
        field_verification_report_link.add(createLoanDataModel.getField_verification_report_link());
        propertyReviewDocumentsModel.setField_verification_report_link(field_verification_report_link);

        List<String> cersai_check_report_link = new ArrayList<>();
        cersai_check_report_link.add(createLoanDataModel.getCersai_check_report_link());
        propertyReviewDocumentsModel.setCersai_check_report_link(cersai_check_report_link);

        List<String> entire_set_of_property_documents_link = new ArrayList<>();
        entire_set_of_property_documents_link.add(createLoanDataModel.getEntire_set_of_property_documents_link());
        propertyReviewDocumentsModel.setEntire_set_of_property_documents_link(entire_set_of_property_documents_link);


        return propertyReviewDocumentsModel;
    }


    private List<String> getBureauReportLinkSP() {

        List<String> bureauReportLinkSP = new ArrayList<>();
        bureauReportLinkSP.add("https://cdn.pixabay.com/photo/2017/06/22/20/22/green-2432374_1280.jpg");
        bureauReportLinkSP.add("https://cdn.pixabay.com/photo/2017/06/22/20/22/green-2432374_1280.jpg");
        return bureauReportLinkSP;
    }

    private List<Long> getBusinessPhoneNumberNia() {

        List<Long> businessPhoneNumberNia = new ArrayList<>();
        businessPhoneNumberNia.add(9876543210L);
        businessPhoneNumberNia.add(9876543210L);
        return businessPhoneNumberNia;
    }


}