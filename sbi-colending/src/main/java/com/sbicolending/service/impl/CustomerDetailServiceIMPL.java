package com.sbicolending.service.impl;

import com.sbicolending.dao.CustomerDetailDao;
import com.sbicolending.model.CustomerDetails;
import com.sbicolending.model.BusinessBlockNonIndividualApplicante;
import com.sbicolending.service.CustomerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerDetailServiceIMPL implements CustomerDetailService {

    @Autowired
    private CustomerDetailDao CustomerDetailDao;

    @Override
    public CustomerDetails getCustomerDetails(String loanNo) {

        CustomerDetails customerDetails = new CustomerDetails();
        BusinessBlockNonIndividualApplicante customerBussinessDetail = new BusinessBlockNonIndividualApplicante();
        try {
            List<?> custPersonalDetail = CustomerDetailDao.getCustomerPersonalDetails(loanNo);

            if (!custPersonalDetail.isEmpty() && custPersonalDetail.size() > 0) {
                Objects obj[] = (Objects[]) custPersonalDetail.get(0);
                customerDetails.setLanSp(obj[1]+"");
            }

            List<?> custBussinessDetail = CustomerDetailDao.getCustomerBussinessDetails(loanNo);
            if (!custBussinessDetail.isEmpty() && custBussinessDetail.size() > 0) {
                Objects obj[] = (Objects[]) custBussinessDetail.get(0);
                customerBussinessDetail.setCustomerTypeSp(obj[1]+"");
                customerBussinessDetail.setCustomerCategorySp(obj[2]+"");
            }
            List<BusinessBlockNonIndividualApplicante> businessList = new ArrayList<>();
            for(int i = 0 ; i<businessList.size() ; i++){
                BusinessBlockNonIndividualApplicante d = new BusinessBlockNonIndividualApplicante();
                Objects obj[] = (Objects[]) custBussinessDetail.get(0);
                d.setCustomerTypeSp(customerBussinessDetail.getCustomerTypeSp()+i);
                d.setCustomerCategorySp(customerBussinessDetail.getCustomerCategorySp()+i);
                businessList.add(d);
            }

            customerDetails.setBusinessBlockNonIndividualApplicante(businessList);

        } catch (Exception e) {
            System.out.println(e);
        }

        return customerDetails;
    }
}
