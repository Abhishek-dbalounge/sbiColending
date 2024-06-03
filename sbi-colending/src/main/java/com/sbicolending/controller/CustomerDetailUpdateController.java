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

@RestController
@RequestMapping("/customer")
public class CustomerDetailUpdateController {

    private Logger logger = BaseLogger.getLogger(CustomerDetailUpdateController.class);

    @Autowired
    private CustomerDetailUpdateService customerDetailUpdateService;


    @PutMapping("/updateCustomerDetails/{lanSp}")
    public ResponseEntity<?> customerDetailsUpdate(@PathVariable("lanSp") String lanSp, @RequestBody CustomerDetailUpdateModel customerDetailUpdateRequest){

        try {
            if(StringUtils.isEmpty(lanSp)){
                CommonResponseModel commonResponse = new CommonResponseModel();
                logger.info("updateCustomerDetails : LenSp filed is empty");
                commonResponse.setErrorMsg("LenSp filed is empty");
                commonResponse.setErrorCode("1112");
                return new ResponseEntity<>(commonResponse, HttpStatus.OK);
            }

            customerDetailUpdateService.updateCustomerDetails(customerDetailUpdateRequest);
          /*  CustomerDetailResponseModel customerDetailResponse = customerDetailService.getCustomerDetails(lanSp);
            if (customerDetailResponse == null) {
                logger.info("updateCustomerDetails : Invalid LenSp");
                throw new SystemException("1113","Invalid LenSp");
            }
            return new ResponseEntity<>(customerDetailResponse, HttpStatus.OK);*/
            return null;


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
