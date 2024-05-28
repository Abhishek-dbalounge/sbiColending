package com.sbicolending.controller;

import com.sbicolending.exception.SystemException;
import com.sbicolending.model.*;
import com.sbicolending.model.createloanresponse.CustomerDetailResponseModel;
import com.sbicolending.service.CustomerDetailService;
import com.sbicolending.utils.BaseLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerDetailController {

    private Logger logger = BaseLogger.getLogger(CustomerDetailController.class);
    @Autowired
    private CustomerDetailService customerDetailService;

    @GetMapping("/createLoan/{lanSp}")
    public ResponseEntity<?> createLoan(@PathVariable("lanSp") String lanSp){

        try {
        if(StringUtils.isEmpty(lanSp)){
            CommonResponseModel commonResponse = new CommonResponseModel();
            logger.info("createLoan : LenSp filed is empty");
            commonResponse.setErrorMsg("LenSp filed is empty");
            commonResponse.setErrorCode("1112");
            return new ResponseEntity<>(commonResponse,HttpStatus.OK);
        }
                CustomerDetailResponseModel customerDetailResponse = customerDetailService.getCustomerDetails(lanSp);
                if (customerDetailResponse == null) {
                    logger.info("createLoan : Invalid LenSp");
                    throw new SystemException("1113","Invalid LenSp");
                }
                return new ResponseEntity<>(customerDetailResponse, HttpStatus.OK);
            }
            catch (SystemException se){
                CommonResponseModel commonResponse = new CommonResponseModel();
                logger.error(se.toString());
                commonResponse.setErrorMsg(se.getMessage());
                commonResponse.setErrorCode(se.getRespCode());
                return new ResponseEntity<>(commonResponse,HttpStatus.OK);
            }
            catch (Exception e){
                CommonResponseModel commonResponse = new CommonResponseModel();
                logger.error(e.toString());
                commonResponse.setErrorMsg("something went worng");
                commonResponse.setErrorCode("1111");
                return new ResponseEntity<>(commonResponse,HttpStatus.OK);
            }
    }



}
