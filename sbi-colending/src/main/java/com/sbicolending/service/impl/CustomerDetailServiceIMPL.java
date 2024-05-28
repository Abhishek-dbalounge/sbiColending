package com.sbicolending.service.impl;

import com.sbicolending.dao.CustomerDetailDao;
import com.sbicolending.exception.SystemException;
import com.sbicolending.model.CustomerDetailDataModel;
import com.sbicolending.model.createloanresponse.*;
import com.sbicolending.service.CustomerDetailService;
import com.sbicolending.utils.BaseLogger;
import com.sbicolending.utils.DataTypeConverter;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerDetailServiceIMPL implements CustomerDetailService {

    private Logger logger = BaseLogger.getLogger(CustomerDetailServiceIMPL.class);

    @Autowired
    private CustomerDetailDao customerDetailDao;
    @Autowired
    private DataTypeConverter dataTypeConverter;

    @Override
    public CustomerDetailResponseModel getCustomerDetails(String lanSp) {

        CustomerDetailResponseModel  customerDetailResponse = null;
        try {

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
                Integer current_pincode_ia = dataTypeConverter.stringtoIntConverter(customerDetailDataModel.getCurrent_pincode_ia());
                customerDetailResponse.setCurrent_pincode(current_pincode_ia);
                customerDetailResponse.setResidence_type_current_address(customerDetailDataModel.getResidence_permanent_address_ic());
                customerDetailResponse.setPermanent_district(customerDetailDataModel.getPermanent_district_ia());
                Integer permanent_pincode_ia = dataTypeConverter.stringtoIntConverter(customerDetailDataModel.getPermanent_pincode_ia());
                customerDetailResponse.setPermanent_pincode(permanent_pincode_ia);
                customerDetailResponse.setResidence_type_permanent_address(customerDetailDataModel.getResidence_permanent_address_ic());
                customerDetailResponse.setReligion(customerDetailDataModel.getReligion_ia());
                customerDetailResponse.setCaste(customerDetailDataModel.getCaste_ia());
                customerDetailResponse.setOccupation(customerDetailDataModel.getOccupation_ic());
                customerDetailResponse.setIncome_source("Cash");
                customerDetailResponse.setProperty_ownership_flag("Y");
                customerDetailResponse.setUdyam_number(customerDetailDataModel.getBusiness_udhyam_regn_number_nia());
                customerDetailResponse.setName_of_bureau(customerDetailDataModel.getName_of_bureau_sp());
                Integer bureau_score_sp = dataTypeConverter.stringtoIntConverter(customerDetailDataModel.getBureau_score_sp());
                customerDetailResponse.setBureau_score(bureau_score_sp);
                List<String> bureau_report_link_SP = getBureauReportLinkSP();
                customerDetailResponse.setBureau_report_link(bureau_report_link_SP);
                customerDetailResponse.setProduct_id("CONSUMER_001");
                customerDetailResponse.setApplication_id("LOAN00001");
                customerDetailResponse.setCategory("unsecured");
                customerDetailResponse.setSub_category("fresh");
                customerDetailResponse.setPurpose(customerDetailDataModel.getPurpose_sp());
                customerDetailResponse.setDisbursement_type("single");
                customerDetailResponse.setNumber_of_tranches(2);
                customerDetailResponse.setTenure(customerDetailDataModel.getTenure_sp());
                customerDetailResponse.setNumber_of_repayments(customerDetailDataModel.getNumber_of_repayments_sp());
                customerDetailResponse.setPsl_description("psl_description_72");
                customerDetailResponse.setImpacted_industry_description("impacted_industry_description_26");
                customerDetailResponse.setApplicant_never_in_30_plus_sma_sub_last_12m("applicant_never_in_30_plus_sma_sub_last_12m_89");
                customerDetailResponse.setTax_slab(customerDetailDataModel.getTax_slab_sp());
                customerDetailResponse.setPsl_msme_type_of_enterprise(customerDetailDataModel.getPsl_msme_type_of_enterprise_sp());
                customerDetailResponse.setCurrent_address_line1(customerDetailDataModel.getCurrent_address_ia());
                customerDetailResponse.setCersai_security_int_id(customerDetailDataModel.getCersai_security_int_id_ac());
                customerDetailResponse.setRepayment_frequency(customerDetailDataModel.getRepayment_frequency_sp());
                customerDetailResponse.setFather_first_name(customerDetailDataModel.getFather_first_name_ia());
                customerDetailResponse.setFather_last_name(customerDetailDataModel.getFather_last_name_ia());
                String total_value_of_security_sp = dataTypeConverter.FloattoStringConverter(customerDetailDataModel.getTotal_value_of_security_sp());
                customerDetailResponse.setTotal_value_of_security(total_value_of_security_sp);
                customerDetailResponse.setTenure_frequency("bullet");
                customerDetailResponse.setMarital_status(customerDetailDataModel.getMarital_status_ia());
                customerDetailResponse.setCkyc_id(customerDetailDataModel.getCkyc_id_ia());
                customerDetailResponse.setDate_of_birth(customerDetailDataModel.getDate_of_birth_ia());
                customerDetailResponse.setFirst_repayment_date(customerDetailDataModel.getFirst_repayment_date_sp());
                LocalDate itr_filed_date_current_fy = dataTypeConverter.stringtoDateConverter("2012-12-12");
                customerDetailResponse.setItr_filed_date_current_fy(itr_filed_date_current_fy);
                LocalDate application_date_sp = dataTypeConverter.stringtoDateConverter(customerDetailDataModel.getApplication_date_sp());
                customerDetailResponse.setApplication_date(application_date_sp);
                LocalDate fcu_done_date_sp = dataTypeConverter.stringtoDateConverter(customerDetailDataModel.getFcu_done_date_sp());
                customerDetailResponse.setFcu_done_date(fcu_done_date_sp);
                LocalDate e_verification_of_kyc_done_date_sp = dataTypeConverter.stringtoDateConverter(customerDetailDataModel.getE_verification_of_kyc_done_date_sp());
                customerDetailResponse.setE_verification_of_kyc_done_date(e_verification_of_kyc_done_date_sp);
                LocalDate pd_done_date_sp = dataTypeConverter.stringtoDateConverter(customerDetailDataModel.getPd_done_date_sp());
                customerDetailResponse.setPd_done_date(pd_done_date_sp);
                LocalDate search_with_registrar_of_companies_obtained_date_sp = dataTypeConverter.stringtoDateConverter(customerDetailDataModel.getSearch_with_registrar_of_companies_obtained_date_sp());
                customerDetailResponse.setSearch_with_registrar_of_companies_obtained_date(search_with_registrar_of_companies_obtained_date_sp);
                LocalDate cersai_registration_reference_number_verification_date_sp = dataTypeConverter.stringtoDateConverter(customerDetailDataModel.getCersai_registration_reference_number_verification_date_sp());
                customerDetailResponse.setCersai_registration_reference_number_verification_date(cersai_registration_reference_number_verification_date_sp);
                LocalDate cibil_report_done_date_sp = dataTypeConverter.stringtoDateConverter(customerDetailDataModel.getCibil_report_done_date_sp());
                customerDetailResponse.setCibil_report_done_date(cibil_report_done_date_sp);
                LocalDate repayment_period_end_date_sp = dataTypeConverter.stringtoDateConverter(customerDetailDataModel.getRepayment_period_end_date_sp());
                customerDetailResponse.setRepayment_period_end_date(repayment_period_end_date_sp);
                LocalDate date_of_sanction_by_nbfc_sp = dataTypeConverter.stringtoDateConverter(customerDetailDataModel.getDate_of_sanction_by_nbfc_sp());
                customerDetailResponse.setDate_of_sanction_by_nbfc(date_of_sanction_by_nbfc_sp);
                LocalDate date_of_documentation_by_nbfc_sp = dataTypeConverter.stringtoDateConverter(customerDetailDataModel.getDate_of_documentation_by_nbfc_sp());
                customerDetailResponse.setDate_of_documentation_by_nbfc(date_of_documentation_by_nbfc_sp);
                customerDetailResponse.setAnnual_income(100.0f);
                Float principal_amount_sp = dataTypeConverter.integertoFloatConverter(customerDetailDataModel.getPrincipal_amount_sp());
                customerDetailResponse.setPrincipal_amount(principal_amount_sp);
                Float interest_rate_sp = dataTypeConverter.integertoFloatConverter(customerDetailDataModel.getInterest_rate_sp());
                customerDetailResponse.setInterest_rate(interest_rate_sp);
                Float loan_emi_sp = dataTypeConverter.integertoFloatConverter(customerDetailDataModel.getLoan_emi_sp());
                customerDetailResponse.setLoan_emi(loan_emi_sp);
                customerDetailResponse.setApplicant_age_at_maturity(customerDetailDataModel.getApplicant_age_at_maturity_ia());


                BusinessModel businessModel = getBusinessModelData(customerDetailDataModel);
                customerDetailResponse.setBusiness(businessModel);
                GuarantorsModel guarantorsModel = getGuarantorsModelData(customerDetailDataModel);
                customerDetailResponse.setGuarantors(guarantorsModel);
                CoApplicantsModel coApplicantsModel = getCoApplicantsModelData(customerDetailDataModel);
                customerDetailResponse.setCoApplicants(coApplicantsModel);
                BankStatementModel bankStatementModel = getBankStatementModelData(customerDetailDataModel);
                customerDetailResponse.setBankStatement(bankStatementModel);
                FinancialDataModel financialDataModel = getFinancialDataModelData(customerDetailDataModel);
                customerDetailResponse.setFinancialData(financialDataModel);
                TranchesModel tranchesModel = getTranchesModelData(customerDetailDataModel);
                customerDetailResponse.setTranchesModel(tranchesModel);
                LinkedLoanInfosModel linkedLoanInfosModel = getLinkedLoanInfosModelData(coApplicantsModel);
                customerDetailResponse.setLinkedLoanInfosModel(linkedLoanInfosModel);
                BusinessCoApplicantsModel businessCoApplicantsModel = getBusinessCoApplicantsModelData(customerDetailDataModel);
                customerDetailResponse.setBusinessCoApplicants(businessCoApplicantsModel);
                BusinessGuarantorsModel BusinessGuarantorsModel = getBusinessGuarantorsModelData(customerDetailDataModel);
                customerDetailResponse.setBusinessGuarantorsModel(BusinessGuarantorsModel);
                RelatedPartiesModel relatedPartiesModel = getRelatedPartiesModelData(customerDetailDataModel);
                customerDetailResponse.setRelatedPartiesModel(relatedPartiesModel);
                OriginalLoanDetailModel originalLoanDetailModel = getOriginalLoanDetailModelData(customerDetailDataModel);
                customerDetailResponse.setOriginalLoanDetailModel(originalLoanDetailModel);
                OriginalDisbursementDetailsModel originalDisbursementDetailsModel = getOriginalDisbursementDetailsModelData(customerDetailDataModel);
                customerDetailResponse.setOriginalDisbursementDetails(originalDisbursementDetailsModel);
                AssetsModel AssetsModel = getAssetsModelData(customerDetailDataModel);
                customerDetailResponse.setAssets(AssetsModel);
                PropertyReviewDocumentsModel propertyReviewDocumentsModel = getPropertyReviewDocumentsModelData(customerDetailDataModel);
                customerDetailResponse.setPropertyReviewDocumentsModel(propertyReviewDocumentsModel);
            }

        } catch (Exception e) {
            logger.error("getCreateLoanDetails : " + e.toString());
            throw new SystemException("1111", "something went worng");
        }
        return customerDetailResponse;
    }


    private BusinessModel getBusinessModelData(CustomerDetailDataModel createLoanDataModel) throws ParseException {

        BusinessModel businessModel = new BusinessModel();


        businessModel.setName_of_business(createLoanDataModel.getName_of_business_nia());
        businessModel.setNature_of_business(createLoanDataModel.getNature_of_business_nia());
        businessModel.setType_of_constitution(createLoanDataModel.getType_of_constitution_nia());
        LocalDate registration_date_nia = dataTypeConverter.stringtoDateConverter(createLoanDataModel.getRegistration_date_nia());
        businessModel.setRegistration_date(registration_date_nia);
        LocalDate incorporation_date_nia = dataTypeConverter.stringtoDateConverter(createLoanDataModel.getIncorporation_date_nia());
        businessModel.setIncorporation_date(incorporation_date_nia);
        businessModel.setIndustry_type(createLoanDataModel.getIndustry_type_nia());
        businessModel.setSector_type(createLoanDataModel.getSector_type_nic());
        businessModel.setSub_sector_type(createLoanDataModel.getSub_sector_type_nia());
        Integer business_vintage_nia = dataTypeConverter.doubletoIntConverter(createLoanDataModel.getBusiness_vintage_nia());
        businessModel.setBusiness_vintage(business_vintage_nia);
        businessModel.setBusiness_registered_office_address(createLoanDataModel.getBusiness_registered_office_address_nia());
        businessModel.setBusiness_registered_office_city(createLoanDataModel.getBusiness_mailing_office_city_nia());
        businessModel.setBusiness_registered_office_state("Tamil Nadu");
        Integer business_registered_office_pincode = dataTypeConverter.stringtoIntConverter(createLoanDataModel.getBusiness_mailing_office_pincode_nia());
        businessModel.setBusiness_registered_office_pincode(business_registered_office_pincode);
        businessModel.setBusiness_mailing_office_address(createLoanDataModel.getBusiness_mailing_office_address1_nia());
        businessModel.setBusiness_mailing_office_city(createLoanDataModel.getBusiness_mailing_office_city_nia());
        Integer business_mailing_office_pincode_nia = dataTypeConverter.stringtoIntConverter(createLoanDataModel.getBusiness_mailing_office_pincode_nia());
        businessModel.setBusiness_registered_office_pincode(business_mailing_office_pincode_nia);
        businessModel.setBusiness_phone_number(createLoanDataModel.getBusiness_phone_number_nia());
        businessModel.setBusiness_email_id(createLoanDataModel.getBusiness_email_id_nia());
        businessModel.setProperty_ownership_flag(createLoanDataModel.getProperty_ownership_flag_nic());
        businessModel.setBusiness_pan_number(createLoanDataModel.getBusiness_pan_number_nia());
        businessModel.setBusiness_rc_number(createLoanDataModel.getBusiness_rc_number_nia());
        businessModel.setBusiness_udhyam_regn_number(createLoanDataModel.getBusiness_udhyam_regn_number_nia());
        businessModel.setBusiness_mailing_office_address1(createLoanDataModel.getBusiness_mailing_office_address1_nia());
        businessModel.setBusiness_mailing_office_address2(createLoanDataModel.getBusiness_mailing_office_address2_nia());
        businessModel.setBusiness_mailing_office_address3(createLoanDataModel.getBusiness_mailing_office_address3_nia());
        businessModel.setEnterprise_activity("enterprise_activity_11");
        businessModel.setCustomer_type(createLoanDataModel.getCustomer_type_sp());
        Float exisiting_shareholding_of_promoters_nia = dataTypeConverter.stringtoFloatConverter(createLoanDataModel.getExisiting_shareholding_of_promoters_nia());
        businessModel.setExisiting_shareholding_of_promoters(exisiting_shareholding_of_promoters_nia);
        Float exisiting_shareholding_of_mutual_funds_nia = dataTypeConverter.stringtoFloatConverter(createLoanDataModel.getExisiting_shareholding_of_mutual_funds_nia());
        businessModel.setExisiting_shareholding_of_mutual_funds(exisiting_shareholding_of_mutual_funds_nia);
        Float exisiting_shareholding_of_financial_institutions_banks_nia = dataTypeConverter.stringtoFloatConverter(createLoanDataModel.getExisiting_shareholding_of_financial_institutions_banks_nia());
        businessModel.setExisiting_shareholding_of_financial_institutions_banks(exisiting_shareholding_of_financial_institutions_banks_nia);
        Float exisiting_shareholding_of_others_nia = dataTypeConverter.stringtoFloatConverter(createLoanDataModel.getExisiting_shareholding_of_others_nia());
        businessModel.setExisiting_shareholding_of_others(exisiting_shareholding_of_others_nia);
        Float exisiting_shareholding_total_nia = dataTypeConverter.stringtoFloatConverter(createLoanDataModel.getExisiting_shareholding_total_nia());
        businessModel.setExisiting_shareholding_total(exisiting_shareholding_total_nia);
        Float proposed_shareholding_of_promoters_nia = dataTypeConverter.stringtoFloatConverter(createLoanDataModel.getProposed_shareholding_of_promoters_nia());
        businessModel.setProposed_shareholding_of_promoters(proposed_shareholding_of_promoters_nia);
        Float proposed_shareholding_of_mutual_funds_nia = dataTypeConverter.stringtoFloatConverter(createLoanDataModel.getProposed_shareholding_of_mutual_funds_nia());
        businessModel.setProposed_shareholding_of_mutual_funds(proposed_shareholding_of_mutual_funds_nia);
        Float proposed_shareholding_of_financial_institutions_banks_nia = dataTypeConverter.stringtoFloatConverter(createLoanDataModel.getProposed_shareholding_of_financial_institutions_banks_nia());
        businessModel.setProposed_shareholding_of_financial_institutions_banks(proposed_shareholding_of_financial_institutions_banks_nia);
        Float proposed_shareholding_of_others_nia = dataTypeConverter.stringtoFloatConverter(createLoanDataModel.getProposed_shareholding_of_others_nia());
        businessModel.setProposed_shareholding_of_others(proposed_shareholding_of_others_nia);
        Float proposed_shareholding_total_nia = dataTypeConverter.stringtoFloatConverter(createLoanDataModel.getProposed_shareholding_total_nia());
        businessModel.setProposed_shareholding_total(proposed_shareholding_total_nia);
        Integer annual_income = dataTypeConverter.stringtoIntConverter(createLoanDataModel.getAnnual_income_nia());
        businessModel.setAnnual_income(annual_income);
        LocalDate balance_sheet_year_nia = dataTypeConverter.stringtoDateConverter(createLoanDataModel.getBalance_sheet_year_nia());
        businessModel.setBalance_sheet_year(balance_sheet_year_nia);
        businessModel.setCkyc_id(createLoanDataModel.getCkyc_id_ni());


        return businessModel;
    }

    private GuarantorsModel getGuarantorsModelData(CustomerDetailDataModel createLoanDataModel) throws ParseException {

        GuarantorsModel guarantorsModel = new GuarantorsModel();

        LocalDate date_of_birth_ig = dataTypeConverter.stringtoDateConverter(createLoanDataModel.getDate_of_birth_ig());
        guarantorsModel.setDate_of_birth(date_of_birth_ig);
        guarantorsModel.setGender(createLoanDataModel.getGender_ig());
        guarantorsModel.setCurrent_address(createLoanDataModel.getCurrent_address_ig());
        guarantorsModel.setCurrent_district(createLoanDataModel.getCurrent_district_ig());
        guarantorsModel.setCurrent_city(createLoanDataModel.getCity_ig());
        guarantorsModel.setCurrent_state(createLoanDataModel.getState_ig());
        Integer current_pincode_ig = dataTypeConverter.stringtoIntConverter(createLoanDataModel.getCurrent_pincode_ig());
        guarantorsModel.setCurrent_pincode(current_pincode_ig);
        guarantorsModel.setPermanent_district(createLoanDataModel.getPermanent_district_ig());
        Integer permanent_pincode_ig = dataTypeConverter.stringtoIntConverter(createLoanDataModel.getPermanent_pincode_ig());
        guarantorsModel.setPermanent_pincode(permanent_pincode_ig);
        Integer mobile_number_ig = dataTypeConverter.stringtoIntConverter(createLoanDataModel.getMobile_number_ig());
        guarantorsModel.setMobile_number(mobile_number_ig);
        guarantorsModel.setMarital_status(createLoanDataModel.getMarital_status_ig());
        guarantorsModel.setReligion(createLoanDataModel.getReligion_ig());
        Integer bureau_score_ig = dataTypeConverter.stringtoIntConverter(createLoanDataModel.getBureau_score_ig());
        guarantorsModel.setBureau_score(bureau_score_ig);
        Integer age_at_maturity_ig = dataTypeConverter.stringtoIntConverter(createLoanDataModel.getAge_at_maturity_ig());
        guarantorsModel.setAge_at_maturity(age_at_maturity_ig);
        guarantorsModel.setEmployment_details_designation(createLoanDataModel.getEmployment_details_designation_sp());
        guarantorsModel.setCaste("caste_12");
        guarantorsModel.setFather_first_name(createLoanDataModel.getFather_first_name_ig());
        guarantorsModel.setFather_last_name(createLoanDataModel.getFather_last_name_ig());
        guarantorsModel.setOccupation(createLoanDataModel.getOccupation_ig());
        guarantorsModel.setPlace_of_birth(createLoanDataModel.getPlace_of_birth_ig());
        guarantorsModel.setTitle(createLoanDataModel.getTitle_ig());
        guarantorsModel.setIncome_source("Borrowed funds");
        guarantorsModel.setCurrent_address_line1(createLoanDataModel.getCurrent_address_line1_ig());
        guarantorsModel.setEducation(createLoanDataModel.getEducation_ig());
        Float other_than_agricultural_income_ig = dataTypeConverter.stringtoFloatConverter(createLoanDataModel.getOther_than_agricultural_income_ig());
        guarantorsModel.setOther_than_agricultural_income(other_than_agricultural_income_ig);
        guarantorsModel.setTotal_net_worth(100.0f);
        guarantorsModel.setCustomer_type(createLoanDataModel.getCustomer_type_ig());
        guarantorsModel.setCkyc_id(createLoanDataModel.getCkyc_id_ig());
        guarantorsModel.setAnnual_income(createLoanDataModel.getAnnual_income_ig());

        return guarantorsModel;
    }


    private CoApplicantsModel getCoApplicantsModelData(CustomerDetailDataModel createLoanDataModel) throws ParseException {

        CoApplicantsModel coApplicantsModel = new CoApplicantsModel();


        coApplicantsModel.setRelationship_with_applicant(createLoanDataModel.getRelationship_with_applicant_addcolumn());
        coApplicantsModel.setFirst_name(createLoanDataModel.getFather_first_name_ic());
        coApplicantsModel.setLast_name(createLoanDataModel.getLast_name_ia());
        coApplicantsModel.setGender(createLoanDataModel.getGender_ic());
        coApplicantsModel.setOccupation(createLoanDataModel.getOccupation_ic());
        LocalDate date_of_birth_ic = dataTypeConverter.stringtoDateConverter(createLoanDataModel.getDate_of_birth_ic());
        coApplicantsModel.setDate_of_birth(date_of_birth_ic);
        Integer mobile_number_ic = dataTypeConverter.stringtoIntConverter(createLoanDataModel.getMobile_number_ic());
        coApplicantsModel.setMobile_number(mobile_number_ic);
        coApplicantsModel.setCurrent_address(createLoanDataModel.getCurrent_address_ic());
        coApplicantsModel.setCurrent_city(createLoanDataModel.getCity_ic());
        coApplicantsModel.setCurrent_district(createLoanDataModel.getCurrent_district_ic());
        coApplicantsModel.setCurrent_state(createLoanDataModel.getState_ic());
        Integer current_pincode_ic = dataTypeConverter.stringtoIntConverter(createLoanDataModel.getCurrent_pincode_ic());
        coApplicantsModel.setCurrent_pincode(current_pincode_ic);
        coApplicantsModel.setPermanent_district(createLoanDataModel.getPermanent_district_ic());
        Integer permanent_pincode_ic = dataTypeConverter.stringtoIntConverter(createLoanDataModel.getPermanent_pincode_ic());
        coApplicantsModel.setPermanent_pincode(permanent_pincode_ic);
        coApplicantsModel.setMarital_status(createLoanDataModel.getMarital_status_ic());
        coApplicantsModel.setReligion(createLoanDataModel.getReligion_ic());
        Float annual_income_ic = dataTypeConverter.stringtoFloatConverter(createLoanDataModel.getAnnual_income_ic());
        coApplicantsModel.setAnnual_income(annual_income_ic);
        Integer bureau_score_ic = dataTypeConverter.stringtoIntConverter(createLoanDataModel.getBureau_score_ic());
        coApplicantsModel.setBureau_score(bureau_score_ic);
        Integer age_at_maturity_ic = dataTypeConverter.stringtoIntConverter(createLoanDataModel.getAge_at_maturity_ic());
        coApplicantsModel.setAge_at_maturity(age_at_maturity_ic);
        coApplicantsModel.setEmployment_details_designation(createLoanDataModel.getEmployment_details_designation_sp());
        coApplicantsModel.setCaste(createLoanDataModel.getCaste_ic());
        coApplicantsModel.setFather_first_name(createLoanDataModel.getFirst_name_ic());
        coApplicantsModel.setFather_last_name(createLoanDataModel.getFather_last_name_ic());
        coApplicantsModel.setPlace_of_birth(createLoanDataModel.getPlace_of_birth_ic());
        coApplicantsModel.setTitle(createLoanDataModel.getTitle_ic());
        coApplicantsModel.setIncome_source("Own fund");
        coApplicantsModel.setCurrent_address_line1(createLoanDataModel.getCurrent_address_ic());
        coApplicantsModel.setTotal_net_worth(100.0f);
        coApplicantsModel.setCustomer_type(createLoanDataModel.getCustomer_type_ic());
        coApplicantsModel.setCkyc_id("ckyc_id_69");

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

        Float annual_business_turnover_sp = dataTypeConverter.stringtoFloatConverter(createLoanDataModel.getAnnual_business_turnover_sp());
        financialDataModel.setAnnual_business_turnover(annual_business_turnover_sp);
        return financialDataModel;
    }

    private TranchesModel getTranchesModelData(CustomerDetailDataModel createLoanDataModel) {

        TranchesModel tranchesModel = new TranchesModel();
        tranchesModel.setTranche_number(1);
        tranchesModel.setPrincipal_amount(10000);

        return tranchesModel;

    }

    private LinkedLoanInfosModel getLinkedLoanInfosModelData(CoApplicantsModel coApplicantsModel) {

        LinkedLoanInfosModel linkedLoanInfosModel = new LinkedLoanInfosModel();
        linkedLoanInfosModel.setLinked_loan_id("CA_123");
        linkedLoanInfosModel.setForeclosure("true");

        return linkedLoanInfosModel;

    }

    private BusinessCoApplicantsModel getBusinessCoApplicantsModelData(CustomerDetailDataModel createLoanDataModel) throws ParseException {

        BusinessCoApplicantsModel businessCoApplicantsModel = new BusinessCoApplicantsModel();


        businessCoApplicantsModel.setName_of_business(createLoanDataModel.getName_of_business_nic());
        businessCoApplicantsModel.setNature_of_business(createLoanDataModel.getNature_of_business_nic());
        businessCoApplicantsModel.setType_of_constitution(createLoanDataModel.getType_of_constitution_nic());
        LocalDate registration_date_nic = dataTypeConverter.stringtoDateConverter(createLoanDataModel.getRegistration_date_nic());
        businessCoApplicantsModel.setRegistration_date(registration_date_nic);
        LocalDate incorporation_date_nic = dataTypeConverter.stringtoDateConverter(createLoanDataModel.getIncorporation_date_nic());
        businessCoApplicantsModel.setIncorporation_date(incorporation_date_nic);
        businessCoApplicantsModel.setIndustry_type(createLoanDataModel.getIndustry_type_nic());
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
        Integer business_mailing_office_pincode_nic = dataTypeConverter.stringtoIntConverter(createLoanDataModel.getBusiness_mailing_office_pincode_nic());
        businessCoApplicantsModel.setBusiness_mailing_office_pincode(business_mailing_office_pincode_nic);
        businessCoApplicantsModel.setBusiness_phone_number(createLoanDataModel.getName_of_business_nic());
        businessCoApplicantsModel.setBusiness_pan_number(createLoanDataModel.getBusiness_pan_number_nic());
        businessCoApplicantsModel.setBusiness_pan_link(createLoanDataModel.getBusiness_pan_link_nic());
        businessCoApplicantsModel.setBusiness_rc_number(createLoanDataModel.getBusiness_rc_number_nic());
        businessCoApplicantsModel.setBusiness_rc_link(createLoanDataModel.getBusiness_rc_link_nic());
        Float annual_business_turnover_sp = dataTypeConverter.stringtoFloatConverter(createLoanDataModel.getAnnual_business_turnover_sp());
        businessCoApplicantsModel.setAnnual_business_turnover(annual_business_turnover_sp);
        businessCoApplicantsModel.setCkyc_id(createLoanDataModel.getCkyc_id_nic());

        return businessCoApplicantsModel;
    }


    private BusinessGuarantorsModel getBusinessGuarantorsModelData(CustomerDetailDataModel createLoanDataModel) {

        BusinessGuarantorsModel businessGuarantorsModel = new BusinessGuarantorsModel();


        businessGuarantorsModel.setName_of_business("Credavenue");
        businessGuarantorsModel.setNature_of_business("Agri Machinery; Hospitality; Textiles, Electronics, Heavy Machinery etc.");
        businessGuarantorsModel.setType_of_constitution("Private limited");
        businessGuarantorsModel.setRegistration_date(LocalDate.parse("2012-12-12"));
        businessGuarantorsModel.setIncorporation_date(LocalDate.parse("2012-12-12"));
        businessGuarantorsModel.setIndustry_type("Services");
        businessGuarantorsModel.setSector_type("Financial Services");
        businessGuarantorsModel.setSub_sector_type("Banking");
        businessGuarantorsModel.setBusiness_vintage(31);
        businessGuarantorsModel.setBusiness_registered_office_address("221B, Baker Street, Chennai");
        businessGuarantorsModel.setBusiness_registered_office_city("Chennai");
        businessGuarantorsModel.setBusiness_registered_office_state("Tamil Nadu");
        businessGuarantorsModel.setBusiness_registered_office_pincode(63);
        businessGuarantorsModel.setBusiness_mailing_office_address("221B, Baker Street, Chennai");
        businessGuarantorsModel.setBusiness_mailing_office_address1("35 nagar");
        businessGuarantorsModel.setBusiness_mailing_office_address2("samta colony");
        businessGuarantorsModel.setBusiness_mailing_office_address3("main road");
        businessGuarantorsModel.setBusiness_mailing_office_city("Chennai");
        businessGuarantorsModel.setBusiness_mailing_office_pincode(86);//(//int)
        businessGuarantorsModel.setBusiness_phone_number("");
        businessGuarantorsModel.setBusiness_pan_number("BMMPG9018G");
        businessGuarantorsModel.setBusiness_pan_link("business_pan_link_37");
        businessGuarantorsModel.setBusiness_rc_number("U72200MH2009PLC123456");
        businessGuarantorsModel.setBusiness_rc_link("https://cdn.pixabay.com/photo/2017/06/22/20/22/green-2432374_1280.jpg");
        businessGuarantorsModel.setAnnual_business_turnover(100.0f);//(float)
        businessGuarantorsModel.setCkyc_id("123456789876548");

        return businessGuarantorsModel;
    }

    private RelatedPartiesModel getRelatedPartiesModelData(CustomerDetailDataModel createLoanDataModel) {

        RelatedPartiesModel relatedPartiesModel = new RelatedPartiesModel();


        relatedPartiesModel.setConnected_with("guarantor");
        relatedPartiesModel.setConnection_name("connection_name_46");
        relatedPartiesModel.setRp_type("individual");
        relatedPartiesModel.setName("name_14");
        relatedPartiesModel.setShare_holding("share_holding_59");
        relatedPartiesModel.setDesignation("designation_19");
        relatedPartiesModel.setProposed_share_holding("100%");

        return relatedPartiesModel;

    }

    private OriginalLoanDetailModel getOriginalLoanDetailModelData(CustomerDetailDataModel createLoanDataModel) {

        OriginalLoanDetailModel originalLoanDetailModel = new OriginalLoanDetailModel();


        originalLoanDetailModel.setLoan_amount(100.0f);
        originalLoanDetailModel.setTenure(13);
        originalLoanDetailModel.setTenure_frequency(createLoanDataModel.getRepayment_frequency_sp());

        return originalLoanDetailModel;
    }


    private OriginalDisbursementDetailsModel getOriginalDisbursementDetailsModelData(CustomerDetailDataModel createLoanDataModel) throws ParseException {

        OriginalDisbursementDetailsModel originalDisbursementDetailsModel = new OriginalDisbursementDetailsModel();

        Float disbursement_amount_sp = dataTypeConverter.stringtoFloatConverter(createLoanDataModel.getDisbursement_amount_sp());
        originalDisbursementDetailsModel.setDisbursement_amount(disbursement_amount_sp);
        LocalDate disbursement_date_sp = dataTypeConverter.stringtoDateConverter(createLoanDataModel.getDisbursement_date_sp());
        originalDisbursementDetailsModel.setDisbursement_date(disbursement_date_sp);

        return originalDisbursementDetailsModel;
    }

    private AssetsModel getAssetsModelData(CustomerDetailDataModel createLoanDataModel) throws ParseException {

        AssetsModel assetsModel = new AssetsModel();

        assetsModel.setSanction_ltv(100.0f);
        LocalDate collateral_created_date_ac = dataTypeConverter.stringtoDateConverter(createLoanDataModel.getCollateral_created_date_ac());
        assetsModel.setCollateral_created_date(collateral_created_date_ac);
        LocalDate cersai_date_ac = dataTypeConverter.stringtoDateConverter(createLoanDataModel.getCersai_date_ac());
        assetsModel.setCersai_date(cersai_date_ac);
        Float Security_valuation_ac = dataTypeConverter.stringtoFloatConverter(createLoanDataModel.getSecurity_valuation_ac());
        assetsModel.setSecurity_valuation(Security_valuation_ac);
        assetsModel.setSurvey_or_gat_number(createLoanDataModel.getSurvey_or_gat_number_ac());
        assetsModel.setBound_by_north(createLoanDataModel.getBound_by_north_ac());
        assetsModel.setBound_by_south(createLoanDataModel.getBound_by_south_ac());
        assetsModel.setBound_by_east(createLoanDataModel.getBound_by_east_ac());
        assetsModel.setBound_by_west(createLoanDataModel.getBound_by_west_ac());
        Integer purchase_cost_ac = dataTypeConverter.stringtoIntConverter(createLoanDataModel.getPurchase_cost_ac());
        assetsModel.setPurchase_cost(purchase_cost_ac);
        LocalDate purchase_date_ac = dataTypeConverter.stringtoDateConverter(createLoanDataModel.getPurchase_date_ac());
        assetsModel.setPurchase_date(purchase_date_ac);
        assetsModel.setCarpet_area_unit(createLoanDataModel.getCarpet_area_unit_ac());
        assetsModel.setPlot_id_number(createLoanDataModel.getPlot_id_number_ac());
        assetsModel.setProperty_nature(createLoanDataModel.getProperty_nature_ac());
        assetsModel.setProperty_locality(createLoanDataModel.getProperty_locality_ac());
        LocalDate valuation_date_ac = dataTypeConverter.stringtoDateConverter(createLoanDataModel.getValuation_date_ac());
        assetsModel.setValuation_date(valuation_date_ac);

        return assetsModel;
    }


    private PropertyReviewDocumentsModel getPropertyReviewDocumentsModelData(CustomerDetailDataModel createLoanDataModel) {

        PropertyReviewDocumentsModel propertyReviewDocumentsModel = new PropertyReviewDocumentsModel();

        List<String> field_verification_report_link = getField_verification_report_link();
        propertyReviewDocumentsModel.setField_verification_report_link(field_verification_report_link);
        List<String> cersai_check_report_link = getCersai_check_report_link();
        propertyReviewDocumentsModel.setCersai_check_report_link(cersai_check_report_link);
        List<String> entire_set_of_property_documents_link = getEntire_set_of_property_documents_link();
        propertyReviewDocumentsModel.setEntire_set_of_property_documents_link(entire_set_of_property_documents_link);


        return propertyReviewDocumentsModel;
    }


    private List<String> getBureauReportLinkSP() {

        List<String> bureauReportLinkSP = new ArrayList<>();
        bureauReportLinkSP.add("https://cdn.pixabay.com/photo/2017/06/22/20/22/green-2432374_1280.jpg");
        bureauReportLinkSP.add("https://cdn.pixabay.com/photo/2017/06/22/20/22/green-2432374_1280.jpg");
        return bureauReportLinkSP;
    }


    private List<String> getField_verification_report_link() {

        List<String> field_verification_report_link = new ArrayList<>();
        field_verification_report_link.add("https://cdn.pixabay.com/photo/2017/06/22/20/22/green-2432374_1280.jpg");
        field_verification_report_link.add("https://cdn.pixabay.com/photo/2017/06/22/20/22/green-2432374_1280.jpg");
        return field_verification_report_link;
    }

    private List<String> getEntire_set_of_property_documents_link() {

        List<String> cersai_check_report_link = new ArrayList<>();
        cersai_check_report_link.add("https://cdn.pixabay.com/photo/2017/06/22/20/22/green-2432374_1280.jpg");
        cersai_check_report_link.add("https://cdn.pixabay.com/photo/2017/06/22/20/22/green-2432374_1280.jpg");
        return cersai_check_report_link;

    }

    private List<String> getCersai_check_report_link() {

        List<String> entire_set_of_property_documents_link = new ArrayList<>();
        entire_set_of_property_documents_link.add("https://cdn.pixabay.com/photo/2017/06/22/20/22/green-2432374_1280.jpg");
        entire_set_of_property_documents_link.add("https://cdn.pixabay.com/photo/2017/06/22/20/22/green-2432374_1280.jpg");
        return entire_set_of_property_documents_link;

    }


}