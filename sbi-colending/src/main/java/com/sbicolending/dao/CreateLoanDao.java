package com.sbicolending.dao;

import com.sbicolending.model.BusinessNonIndividualApplicanteModel;
import com.sbicolending.model.CreateLoanResponseModel;

import java.util.List;

public interface CreateLoanDao {

    List<CreateLoanResponseModel> getCreateLoanDetails(String lanSp);

    List<BusinessNonIndividualApplicanteModel> getBusinessNonIndividualApplicanteDetails(String lanSp);
}
