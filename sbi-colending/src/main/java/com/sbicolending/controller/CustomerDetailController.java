package com.sbicolending.controller;

import com.sbicolending.model.*;
import com.sbicolending.service.CustomerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerDetailController {

    @Autowired
    private CustomerDetailService customerDetailService;

    @PostMapping("/customerDetails")
    public ResponseEntity<CustomerDetails> customerDetails(@RequestBody CustomerRequest request){

        if(StringUtils.isEmpty(request.getLoanNo())){
            CommonResponse commonResponse = new CommonResponse();
            commonResponse.setErrorMsg("Required filed is empty");
            commonResponse.setErrorCode("1111");
            return new ResponseEntity(commonResponse,HttpStatus.OK);
        }else {
            try {

                CustomerDetails customerDetail = customerDetailService.getCustomerDetails(request.getLoanNo());

                return new ResponseEntity<>(customerDetail,HttpStatus.OK);

            }catch (Exception e){
                CommonResponse commonResponse = new CommonResponse();
                System.out.println(e);
                commonResponse.setErrorMsg("something went worng");
                commonResponse.setErrorCode("1111");
                return new ResponseEntity(commonResponse,HttpStatus.OK);
            }
        }
    }



}
