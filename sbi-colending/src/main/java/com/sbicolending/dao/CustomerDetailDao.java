package com.sbicolending.dao;

import com.sbicolending.model.CustomerDetails;

import java.util.List;

public interface CustomerDetailDao {

    List<?> getCustomerPersonalDetails(String loanNo);

    List<?> getCustomerBussinessDetails(String loanNo);
}
