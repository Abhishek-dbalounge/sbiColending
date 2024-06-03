package com.sbicolending.service;

import com.sbicolending.model.CommonResponseModel;
import com.sbicolending.model.updatecustomerdetailsrequest.CustomerDetailUpdateModel;
import org.springframework.web.multipart.MultipartFile;

public interface CustomerDetailUpdateService {
    CommonResponseModel updateCustomerDetails(String lanSp , MultipartFile file);
}
