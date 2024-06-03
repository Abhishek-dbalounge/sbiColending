package com.sbicolending.controller;

import com.sbicolending.exception.SystemException;
import com.sbicolending.model.CommonResponseModel;
import com.sbicolending.model.updatecustomerdetailsrequest.CustomerDetailUpdateModel;
import com.sbicolending.service.CustomerDetailUpdateService;
import com.sbicolending.utils.BaseLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/customer")
public class CustomerDetailUpdateController {

    private Logger logger = BaseLogger.getLogger(CustomerDetailUpdateController.class);

    @Autowired
    private CustomerDetailUpdateService customerDetailUpdateService;

    @PostMapping("/updateCustomerDetails")
    public ResponseEntity<?> customerDetails(@PathVariable("lanSp") String lanSp, @RequestParam("file") MultipartFile file){

        try {
            if(StringUtils.isEmpty(file)){
                CommonResponseModel commonResponse = new CommonResponseModel();
                logger.info("updateCustomerDetails : file is empty");
                commonResponse.setErrorMsg("file is empty");
                commonResponse.setErrorCode("1112");
                return new ResponseEntity<>(commonResponse, HttpStatus.OK);
            }

            CommonResponseModel commonResponseModel =  customerDetailUpdateService.updateCustomerDetails(lanSp,file);

            return new ResponseEntity<>(commonResponseModel, HttpStatus.OK);

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
