package com.sbicolending.service.impl;

import com.sbicolending.dao.CreateLoanDao;
import com.sbicolending.model.CommonResponseModel;
import com.sbicolending.model.CreateLoanResponseModel;
import com.sbicolending.model.BusinessNonIndividualApplicanteModel;
import com.sbicolending.service.CreateLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateLoanServiceIMPL implements CreateLoanService {

    @Autowired
    private CreateLoanDao CustomerDetailDao;

    @Override
    public CreateLoanResponseModel getCreateLoanDetails(String lanSp) {

        CreateLoanResponseModel createLoanResponse = new CreateLoanResponseModel();
        try {

            //======CreateLoanResponseBlock(Main Bloack)----
            List<CreateLoanResponseModel> createLoanResponseList = CustomerDetailDao.getCreateLoanDetails(lanSp);
            CreateLoanResponseModel createLoanResponseModel = new CreateLoanResponseModel();
            if(!createLoanResponseList.isEmpty() && createLoanResponseList.size() > 0) {

                createLoanResponseModel = createLoanResponseList.get(0);
                List<String> bureau_report_link_SP = new ArrayList<>();
                bureau_report_link_SP.add("http:bureau_report_link_SP_1");
                bureau_report_link_SP.add("http:bureau_report_link_SP_2");
                createLoanResponse.setBureau_report_link_SP(bureau_report_link_SP);

                List<String> loan_details_link_SP = new ArrayList<>();
                loan_details_link_SP.add("http:loan_details_link_SP_1");
                loan_details_link_SP.add("http:loan_details_link_SP_2");
                createLoanResponse.setBureau_report_link_SP(loan_details_link_SP);

                createLoanResponseModel.setBureau_report_link_SP(bureau_report_link_SP);
                createLoanResponseModel.setLoan_details_link_SP(loan_details_link_SP);
                createLoanResponse = createLoanResponseModel;
            }


            //BusinessNonIndividualApplicanteModel Block
            List<BusinessNonIndividualApplicanteModel> businessNonIndividualApplicanteList = CustomerDetailDao.getBusinessNonIndividualApplicanteDetails(lanSp);
            BusinessNonIndividualApplicanteModel businessNonIndividualApplicanteModel = new BusinessNonIndividualApplicanteModel();
            if(!businessNonIndividualApplicanteList.isEmpty() && businessNonIndividualApplicanteList.size() > 0) {

                businessNonIndividualApplicanteModel = businessNonIndividualApplicanteList.get(0);
                List<String> Business_PAN_Link = new ArrayList<>();
                Business_PAN_Link.add("http:Business_PAN_Link_1");
                Business_PAN_Link.add("http:Business_PAN_Link_2");

                List<String> Business_GST_copy_Link = new ArrayList<>();
                Business_GST_copy_Link.add("http:Business_GST_copy_Link_1");
                Business_GST_copy_Link.add("http:Business_GST_copy_Link_2");

                List<String> Business_Udhyam_regn_Link = new ArrayList<>();
                Business_Udhyam_regn_Link.add("http:Business_Udhyam_regn_Link_1");
                Business_Udhyam_regn_Link.add("http:Business_Udhyam_regn_Link_2");

                List<String> aoa_link = new ArrayList<>();
                aoa_link.add("http:aoa_link_1");
                aoa_link.add("http:aoa_link_1");

                List<String> board_resoultion_link = new ArrayList<>();
                board_resoultion_link.add("http:board_resoultion_link_1");
                board_resoultion_link.add("http:board_resoultion_link_2");

                List<String> partnership_deed_link = new ArrayList<>();
                partnership_deed_link.add("partnership_deed_link");
                partnership_deed_link.add("partnership_deed_link");

                List<String> certificate_of_incorporation_link = new ArrayList<>();
                certificate_of_incorporation_link.add("certificate_of_incorporation_link_1");
                certificate_of_incorporation_link.add("certificate_of_incorporation_link_2");

                List<String> business_rc_link = new ArrayList<>();
                business_rc_link.add("business_rc_link_1");
                business_rc_link.add("business_rc_link_2");

                businessNonIndividualApplicanteModel.setBusiness_PAN_Link(Business_PAN_Link);
                businessNonIndividualApplicanteModel.setBusiness_GST_copy_Link(Business_GST_copy_Link);
                businessNonIndividualApplicanteModel.setBusiness_Udhyam_regn_Link(Business_Udhyam_regn_Link);
                businessNonIndividualApplicanteModel.setAoa_link(aoa_link);
                businessNonIndividualApplicanteModel.setBoard_resoultion_link(board_resoultion_link);
                businessNonIndividualApplicanteModel.setPartnership_deed_link(partnership_deed_link);
                businessNonIndividualApplicanteModel.setCertificate_of_incorporation_link(certificate_of_incorporation_link);
                businessNonIndividualApplicanteModel.setBusiness_rc_link(business_rc_link);
                createLoanResponse.setBusinessBlockNonIndividualApplicante(businessNonIndividualApplicanteModel);
            }


        } catch (Exception e) {
            CommonResponseModel commonResponse = new CommonResponseModel();
            System.out.println(e);
            commonResponse.setErrorMsg("something went worng");
            commonResponse.setErrorCode("1111");
        }

        return createLoanResponse;
    }
}
