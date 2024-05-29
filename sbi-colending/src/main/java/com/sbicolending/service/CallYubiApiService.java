package com.sbicolending.service;

import com.sbicolending.model.createloanrequest.CreateLoanRequestModel;
import com.sbicolending.model.createloanresponse.CreateLoanResponse;
import com.sbicolending.model.customerdetailsresponse.CustomerDetailResponseModel;

public interface CallYubiApiService {
     Object getCreateLoan(CreateLoanRequestModel request);
}
