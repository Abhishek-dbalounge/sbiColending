package com.sbicolending.service;


import com.sbicolending.model.createloanresponse.CustomerDetailResponseModel;

public interface CustomerDetailService {
    CustomerDetailResponseModel getCustomerDetails(String lanSp);
}
