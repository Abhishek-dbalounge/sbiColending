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
        try {
            List<?> custPersonalDetail = CustomerDetailDao.getCustomerPersonalDetails(loanNo);

            if (!custPersonalDetail.isEmpty() && custPersonalDetail.size() > 0) {
                Objects obj[] = (Objects[]) custPersonalDetail.get(0);
                customerDetails.setLanSp(obj[1]+"");
            }

            List<Objects> custBussinessDetail = (List<Objects>) CustomerDetailDao.getCustomerBussinessDetails(loanNo);
            List<BusinessBlockNonIndividualApplicante> businessList = new ArrayList<>();
            for(Objects obj : custBussinessDetail) {
                BusinessBlockNonIndividualApplicante customerBussinessDetail = new BusinessBlockNonIndividualApplicante();
                customerBussinessDetail.setCustomerTypeSp(obj+"");
                customerBussinessDetail.setCustomerCategorySp(obj+"");
                businessList.add(customerBussinessDetail);
            }

            customerDetails.setBusinessBlockNonIndividualApplicante(businessList);

        } catch (Exception e) {
            System.out.println(e);
        }

        return customerDetails;
    }
}
