package com.sbicolending.controller;

import com.sbicolending.exception.SystemException;
import com.sbicolending.model.CommonResponseModel;
import com.sbicolending.model.createloanrequest.CreateLoanRequestModel;
import com.sbicolending.model.createloanresponse.CreateLoanResponse;
import com.sbicolending.model.customerdetailsresponse.CustomerDetailResponseModel;
import com.sbicolending.service.CallYubiApiService;
import com.sbicolending.utils.BaseLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CallYubiApiController {

    private Logger logger = BaseLogger.getLogger(CallYubiApiController.class);
    @Autowired
    private CallYubiApiService callYubiApiService;

    @PostMapping("/createLoan")
    public ResponseEntity<?> createLoan(@RequestBody CreateLoanRequestModel request){

        try {
            if(StringUtils.isEmpty(request)){
                CommonResponseModel commonResponse = new CommonResponseModel();
                logger.info("createLoan : request filed is empty");
                commonResponse.setErrorMsg("request filed is empty");
                commonResponse.setErrorCode("1112");
                return new ResponseEntity<>(commonResponse,HttpStatus.OK);
            }
            Object createLoanResponse = callYubiApiService.getCreateLoan(request);

            return new ResponseEntity<>(createLoanResponse, HttpStatus.OK);

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
