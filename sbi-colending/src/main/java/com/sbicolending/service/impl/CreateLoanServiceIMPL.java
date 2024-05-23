package com.sbicolending.service.impl;

import com.sbicolending.dao.CreateLoanDao;
import com.sbicolending.exception.SystemException;
import com.sbicolending.model.CreateLoanDataModel;
import com.sbicolending.model.createloanresponse.CoApplicantsModel;
import com.sbicolending.model.createloanresponse.CreateLoanResponseModel;
import com.sbicolending.model.createloanresponse.BusinessModel;
import com.sbicolending.model.createloanresponse.GuarantorsModel;
import com.sbicolending.service.CreateLoanService;
import com.sbicolending.utils.BaseLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateLoanServiceIMPL implements CreateLoanService {

    private Logger logger = BaseLogger.getLogger(CreateLoanServiceIMPL.class);

    @Autowired
    private CreateLoanDao createLoanDao;

    @Override
    public CreateLoanResponseModel getCreateLoanDetails(String lanSp) {

        CreateLoanResponseModel createLoanResponse = null;
        try {

            CreateLoanDataModel createLoanDataModel = new CreateLoanDataModel();
            List<CreateLoanDataModel> createLoanDataModelList = createLoanDao.getCreateLoanDataforLanSP(lanSp);

            if(!createLoanDataModelList.isEmpty() && createLoanDataModelList.size() > 0) {
                createLoanDataModel = createLoanDataModelList.get(0);

                createLoanResponse = new CreateLoanResponseModel();

                createLoanResponse.setPrimary_borrower_type(createLoanDataModel.getCustomer_type_sp());
                createLoanResponse.setFirst_name(createLoanDataModel.getFirst_name_ia());
                createLoanResponse.setCurrent_address(createLoanDataModel.getCurrent_address_ia());
                createLoanResponse.setCurrent_state(createLoanDataModel.getState_ia());
                createLoanResponse.setCustomer_category(createLoanDataModel.getCategory_addcolum());
                createLoanResponse.setClient_customer_id(createLoanDataModel.getClient_customer_id_sp());
                createLoanResponse.setTitle(createLoanDataModel.getTitle_ia());
                createLoanResponse.setLast_name(createLoanDataModel.getLast_name_ia());
                createLoanResponse.setGender(createLoanDataModel.getGender_ia());
                createLoanResponse.setMobile_number(createLoanDataModel.getMobile_number_ia());
                createLoanResponse.setPlace_of_birth(createLoanDataModel.getPlace_of_birth_ia());
                createLoanResponse.setCurrent_city(createLoanDataModel.getCity_ia());
                createLoanResponse.setCurrent_district(createLoanDataModel.getCurrent_district_ia());
                createLoanResponse.setCurrent_pincode(createLoanDataModel.getCurrent_pincode_ia());
                createLoanResponse.setResidence_type_current_address(createLoanDataModel.getResidence_permanent_address_ic());
                createLoanResponse.setPermanent_district(createLoanDataModel.getPermanent_district_ia());
                createLoanResponse.setPermanent_pincode(createLoanDataModel.getPermanent_pincode_ia());
                createLoanResponse.setResidence_type_permanent_address(createLoanDataModel.getResidence_permanent_address_ic());
                createLoanResponse.setReligion(createLoanDataModel.getReligion_ia());
                createLoanResponse.setCaste(createLoanDataModel.getCaste_ia());
                createLoanResponse.setOccupation(createLoanDataModel.getOccupation_ic());
                createLoanResponse.setIncome_source(createLoanDataModel.getIncome_source_addcolum());
                createLoanResponse.setProperty_ownership_flag(createLoanDataModel.getProperty_ownership_flag_addcolum());
                createLoanResponse.setUdyam_number(createLoanDataModel.getBusiness_udhyam_regn_number_nia());
                createLoanResponse.setName_of_bureau(createLoanDataModel.getName_of_bureau_sp());
                createLoanResponse.setBureau_score(createLoanDataModel.getBureau_score_sp());
                List<String> bureau_report_link_SP = getBureauReportLinkSP();
                createLoanResponse.setBureau_report_link(bureau_report_link_SP);
                createLoanResponse.setProduct_id(createLoanDataModel.getProduct_id_addcolum());
                createLoanResponse.setApplication_id(createLoanDataModel.getApplication_id_addcolum());
                createLoanResponse.setCategory(createLoanDataModel.getCategory_addcolum());
                createLoanResponse.setSub_category(createLoanDataModel.getSub_category_addcolum());
                createLoanResponse.setPurpose(createLoanDataModel.getPurpose_sp());
                createLoanResponse.setDisbursement_type(createLoanDataModel.getDisbursement_type_addcolum());
                createLoanResponse.setNumber_of_tranches(createLoanDataModel.getNumber_of_tranches_addcolum());
                createLoanResponse.setTenure(createLoanDataModel.getTenure_sp());
                createLoanResponse.setNumber_of_repayments(createLoanDataModel.getNumber_of_repayments_sp());
                createLoanResponse.setPsl_description(createLoanDataModel.getPsl_description_addcolum());
                createLoanResponse.setImpacted_industry_description(createLoanDataModel.getImpacted_industry_description_addcolum());
                createLoanResponse.setApplicant_never_in_30_plus_sma_sub_last_12m(createLoanDataModel.getApplicant_never_in_30_plus_sma_sub_last_12m_addcolum());
                createLoanResponse.setTax_slab(createLoanDataModel.getTax_slab_sp());
                createLoanResponse.setPsl_msme_type_of_enterprise(createLoanDataModel.getPsl_msme_type_of_enterprise_sp());
                createLoanResponse.setCersai_security_int_id(createLoanDataModel.getCersai_security_int_id_ac());
                createLoanResponse.setRepayment_frequency(createLoanDataModel.getRepayment_frequency_sp());
                createLoanResponse.setFather_first_name(createLoanDataModel.getFather_first_name_ia());
                createLoanResponse.setFather_last_name(createLoanDataModel.getFather_last_name_ia());
                createLoanResponse.setTotal_value_of_security(createLoanDataModel.getTotal_value_of_security_sp());
                createLoanResponse.setTenure_frequency(createLoanDataModel.getTenure_frequency_addcolum());
                createLoanResponse.setMarital_status(createLoanDataModel.getMarital_status_ia());
                createLoanResponse.setCkyc_id(createLoanDataModel.getCkyc_id_ia());
                createLoanResponse.setDate_of_birth(createLoanDataModel.getDate_of_birth_ia());
                createLoanResponse.setFirst_repayment_date(createLoanDataModel.getFirst_repayment_date_sp());
                createLoanResponse.setItr_filed_date_current_fy(createLoanDataModel.getItr_filed_date_current_fy_addcolumn());
                createLoanResponse.setApplication_date(createLoanDataModel.getApplication_date_sp());
                createLoanResponse.setFcu_done_date(createLoanDataModel.getFcu_done_date_sp());
                createLoanResponse.setE_verification_of_kyc_done_date(createLoanDataModel.getE_verification_of_kyc_done_date_sp());
                createLoanResponse.setPd_done_date(createLoanDataModel.getPd_done_date_sp());
                createLoanResponse.setSearch_with_registrar_of_companies_obtained_date(createLoanDataModel.getSearch_with_registrar_of_companies_obtained_date_sp());
                createLoanResponse.setCersai_registration_reference_number_verification_date(createLoanDataModel.getCersai_registration_reference_number_verification_date_sp());
                createLoanResponse.setCibil_report_done_date(createLoanDataModel.getCibil_report_done_date_sp());
                createLoanResponse.setRepayment_period_end_date(createLoanDataModel.getRepayment_period_end_date_sp());
                createLoanResponse.setDate_of_sanction_by_nbfc(createLoanDataModel.getDate_of_sanction_by_nbfc_sp());
                createLoanResponse.setDate_of_documentation_by_nbfc(createLoanDataModel.getDate_of_documentation_by_nbfc_sp());
                createLoanResponse.setAnnual_income(createLoanDataModel.getAnnual_income_sp_addcolumn());
                createLoanResponse.setPrincipal_amount(createLoanDataModel.getPrincipal_amount_sp());
                createLoanResponse.setInterest_rate(createLoanDataModel.getInterest_rate_sp());
                createLoanResponse.setLoan_emi(createLoanDataModel.getLoan_emi_sp());
                createLoanResponse.setApplicant_age_at_maturity(createLoanDataModel.getApplicant_age_at_maturity_ia());

                BusinessModel businessModel = getBusinessModelData(createLoanDataModel);
                createLoanResponse.setBusiness(businessModel);
                GuarantorsModel guarantorsModel = getGuarantorsModelData(createLoanDataModel);
                createLoanResponse.setGuarantors(guarantorsModel);
                CoApplicantsModel coApplicantsModel = getCoApplicantsModelData(createLoanDataModel);
                createLoanResponse.setCoApplicantsModel(coApplicantsModel);
            }
        } catch (Exception e) {
            logger.error("getCreateLoanDetails : "+e.toString());
            throw new SystemException("1111","something went worng");
        }
        return createLoanResponse;
    }


    private BusinessModel getBusinessModelData(CreateLoanDataModel createLoanDataModel) {

        BusinessModel businessModel = new BusinessModel();


        businessModel.setName_of_business(createLoanDataModel.getName_of_business_nia());
        businessModel.setNature_of_business(createLoanDataModel.getNature_of_business_nia());
        businessModel.setType_of_constitution(createLoanDataModel.getType_of_constitution_nia());
        businessModel.setRegistration_date(createLoanDataModel.getRegistration_date_nia());
        businessModel.setIncorporation_date(createLoanDataModel.getIncorporation_date_nia());
        businessModel.setIndustry_type(createLoanDataModel.getIndustry_type_nia());
        businessModel.setSector_type(createLoanDataModel.getSector_type_nic());
        businessModel.setSub_sector_type(createLoanDataModel.getSub_sector_type_nia());
        businessModel.setBusiness_vintage(createLoanDataModel.getBusiness_vintage_nia());
        businessModel.setBusiness_registered_office_address(createLoanDataModel.getBusiness_registered_office_address_nia());
        businessModel.setBusiness_registered_office_city(createLoanDataModel.getBusiness_mailing_office_city_nia());
        businessModel.setBusiness_registered_office_state(createLoanDataModel.getBusiness_registered_office_state_addcolumn());
        businessModel.setBusiness_registered_office_pincode(createLoanDataModel.getBusiness_mailing_office_pincode_nia());
        businessModel.setBusiness_mailing_office_address(createLoanDataModel.getBusiness_mailing_office_address1_nia());
        businessModel.setBusiness_phone_number(createLoanDataModel.getBusiness_phone_number_nia());
        businessModel.setBusiness_email_id(createLoanDataModel.getBusiness_email_id_nia());
        businessModel.setProperty_ownership_flag(createLoanDataModel.getProperty_ownership_flag_nic());
        businessModel.setBusiness_pan_number(createLoanDataModel.getBusiness_pan_number_nia());
        businessModel.setBusiness_rc_number(createLoanDataModel.getBusiness_rc_number_nia());
        businessModel.setBusiness_mailing_office_address2(createLoanDataModel.getBusiness_mailing_office_address2_nia());
        businessModel.setBusiness_mailing_office_address3(createLoanDataModel.getBusiness_mailing_office_address3_nia());
        businessModel.setEnterprise_activity(createLoanDataModel.getEnterprise_activity_addcolumn());
        businessModel.setCustomer_type(createLoanDataModel.getCustomer_type_sp());
        businessModel.setExisiting_shareholding_of_promoters(createLoanDataModel.getExisiting_shareholding_of_promoters_nia());
        businessModel.setExisiting_shareholding_of_mutual_funds(createLoanDataModel.getExisiting_shareholding_of_mutual_funds_nia());
        businessModel.setExisiting_shareholding_of_financial_institutions_banks(createLoanDataModel.getExisiting_shareholding_of_financial_institutions_banks_nia());
        businessModel.setExisiting_shareholding_of_others(createLoanDataModel.getExisiting_shareholding_of_others_nia());
        businessModel.setExisiting_shareholding_total(createLoanDataModel.getExisiting_shareholding_total_nia());
        businessModel.setProposed_shareholding_of_promoters(createLoanDataModel.getProposed_shareholding_of_promoters_nia());
        businessModel.setProposed_shareholding_of_mutual_funds(createLoanDataModel.getProposed_shareholding_of_mutual_funds_nia());
        businessModel.setProposed_shareholding_of_financial_institutions_banks(createLoanDataModel.getProposed_shareholding_of_financial_institutions_banks_nia());
        businessModel.setProposed_shareholding_of_others(createLoanDataModel.getProposed_shareholding_of_others_nia());
        businessModel.setProposed_shareholding_total(createLoanDataModel.getProposed_shareholding_total_nia());
        businessModel.setAnnual_income(createLoanDataModel.getAnnual_income_sp_addcolumn());
        businessModel.setBalance_sheet_year(createLoanDataModel.getBalance_sheet_year_nia());
        businessModel.setCkyc_id(createLoanDataModel.getCkyc_id_ni());


        return businessModel;
    }

    private GuarantorsModel getGuarantorsModelData(CreateLoanDataModel createLoanDataModel) {

        GuarantorsModel guarantorsModel = new GuarantorsModel();

        guarantorsModel.setDate_of_birth(createLoanDataModel.getDate_of_birth_ig());
        guarantorsModel.setGender(createLoanDataModel.getGender_ig());
        guarantorsModel.setCurrent_address(createLoanDataModel.getCurrent_address_ig());
        guarantorsModel.setCurrent_district(createLoanDataModel.getCurrent_district_ig());
        guarantorsModel.setCurrent_city(createLoanDataModel.getCity_ig());
        guarantorsModel.setCurrent_state(createLoanDataModel.getState_ig());
        guarantorsModel.setCurrent_pincode(createLoanDataModel.getPermanent_pincode_ig());
        guarantorsModel.setPermanent_district(createLoanDataModel.getPermanent_district_ig());
        guarantorsModel.setPermanent_pincode(createLoanDataModel.getPermanent_pincode_ig());
        guarantorsModel.setMobile_number(createLoanDataModel.getMobile_number_ig());
        guarantorsModel.setMarital_status(createLoanDataModel.getMarital_status_ig());
        guarantorsModel.setReligion(createLoanDataModel.getReligion_ig());
        guarantorsModel.setBureau_score(createLoanDataModel.getBureau_score_ig());
        guarantorsModel.setAge_at_maturity(createLoanDataModel.getAge_at_maturity_ig());
        guarantorsModel.setEmployment_details_designation(createLoanDataModel.getEmployment_details_designation_sp());
        guarantorsModel.setCaste(createLoanDataModel.getCaste_addcolumn());
        guarantorsModel.setFather_first_name(createLoanDataModel.getFather_first_name_ig());
        guarantorsModel.setFather_last_name(createLoanDataModel.getFather_last_name_ig());
        guarantorsModel.setOccupation(createLoanDataModel.getOccupation_ig());
        guarantorsModel.setPlace_of_birth(createLoanDataModel.getPlace_of_birth_ig());
        guarantorsModel.setTitle(createLoanDataModel.getTitle_ig());
        guarantorsModel.setIncome_source(createLoanDataModel.getIncome_source_addcolumn());
        guarantorsModel.setCurrent_address_line1(createLoanDataModel.getCurrent_address_line1_ig());
        guarantorsModel.setEducation(createLoanDataModel.getEducation_ig());
        guarantorsModel.setOther_than_agricultural_income(createLoanDataModel.getOther_than_agricultural_income_ig());
        guarantorsModel.setTotal_net_worth(createLoanDataModel.getTotal_net_worth_addcolumn());
        guarantorsModel.setCustomer_type(createLoanDataModel.getCustomer_type_ig());
        guarantorsModel.setCkyc_id(createLoanDataModel.getCkyc_id_ig());
        guarantorsModel.setAnnual_income(createLoanDataModel.getAnnual_income_ig());

        return guarantorsModel;
    }


    private CoApplicantsModel getCoApplicantsModelData(CreateLoanDataModel createLoanDataModel) {

        CoApplicantsModel coApplicantsModel = new CoApplicantsModel();


        coApplicantsModel.setRelationship_with_applicant(createLoanDataModel.getRelationship_with_applicant_addcolumn());
        coApplicantsModel.setFirst_name(createLoanDataModel.getFather_first_name_ic());
        coApplicantsModel.setLast_name(createLoanDataModel.getLast_name_ia());
        coApplicantsModel.setGender(createLoanDataModel.getGender_ic());
        coApplicantsModel.setDate_of_birth(createLoanDataModel.getDate_of_birth_ic());
        coApplicantsModel.setMobile_number(createLoanDataModel.getMobile_number_ic());
        coApplicantsModel.setCurrent_address(createLoanDataModel.getCurrent_address_ic());
        coApplicantsModel.setCurrent_city(createLoanDataModel.getCity_ic());
        coApplicantsModel.setCurrent_district(createLoanDataModel.getCurrent_district_ic());
        coApplicantsModel.setCurrent_state(createLoanDataModel.getState_ic());
        coApplicantsModel.setCurrent_pincode(createLoanDataModel.getCurrent_pincode_ic());
        coApplicantsModel.setPermanent_district(createLoanDataModel.getPermanent_district_ic());
        coApplicantsModel.setPermanent_pincode(createLoanDataModel.getPermanent_pincode_ic());
        coApplicantsModel.setMarital_status(createLoanDataModel.getMarital_status_ic());
        coApplicantsModel.setReligion(createLoanDataModel.getReligion_ic());
        coApplicantsModel.setEducation(createLoanDataModel.getEducation_ic());
        coApplicantsModel.setAnnual_income(createLoanDataModel.getAnnual_income_ic());
        coApplicantsModel.setBureau_score(createLoanDataModel.getBureau_score_ic());
        coApplicantsModel.setAge_at_maturity(createLoanDataModel.getAge_at_maturity_ic());
        coApplicantsModel.setCaste(createLoanDataModel.getCaste_ic());
        coApplicantsModel.setFather_first_name(createLoanDataModel.getFirst_name_ic());
        coApplicantsModel.setFather_last_name(createLoanDataModel.getFather_last_name_ic());
        coApplicantsModel.setPlace_of_birth(createLoanDataModel.getPlace_of_birth_ic());
        coApplicantsModel.setTitle(createLoanDataModel.getTitle_ic());
        coApplicantsModel.setCustomer_type(createLoanDataModel.getCustomer_type_ic());
        coApplicantsModel.setCkyc_id(createLoanDataModel.getCkyc_id_addcolumn());

        return coApplicantsModel;
    }

    private List<String> getBureauReportLinkSP() {

        List<String> bureauReportLinkSP = new ArrayList<>();
        bureauReportLinkSP.add("http:bureau_report_link_SP1");
        bureauReportLinkSP.add("http:bureau_report_link_SP2");
        return bureauReportLinkSP;
    }
}
