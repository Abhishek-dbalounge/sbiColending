package com.sbicolending.service;


import com.sbicolending.model.CustomerDetails;

public interface CustomerDetailService {
    CustomerDetails getCustomerDetails(String loanNo);
}
