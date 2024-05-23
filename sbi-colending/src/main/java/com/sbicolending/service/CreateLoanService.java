package com.sbicolending.service;


import com.sbicolending.model.createloanresponse.CreateLoanResponseModel;

public interface CreateLoanService {
    CreateLoanResponseModel getCreateLoanDetails(String lanSp);
}
