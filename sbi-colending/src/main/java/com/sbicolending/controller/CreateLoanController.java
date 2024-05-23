package com.sbicolending.controller;

import com.sbicolending.exception.SystemException;
import com.sbicolending.model.*;
import com.sbicolending.model.createloanresponse.CreateLoanResponseModel;
import com.sbicolending.service.CreateLoanService;
import com.sbicolending.utils.BaseLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CreateLoanController {

    private Logger logger = BaseLogger.getLogger(CreateLoanController.class);
    @Autowired
    private CreateLoanService createLoanService;

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
                CreateLoanResponseModel createLoanResponse = createLoanService.getCreateLoanDetails(lanSp);
                if (createLoanResponse == null) {
                    logger.info("createLoan : Invalid LenSp");
                    throw new SystemException("1113","Invalid LenSp");
                }
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
