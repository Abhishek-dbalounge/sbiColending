package com.sbicolending.controller;

import com.sbicolending.model.*;
import com.sbicolending.service.CreateLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CreateLoanController {

    @Autowired
    private CreateLoanService createLoanService;

    @PostMapping("/createLoan")
    public ResponseEntity<CreateLoanResponseModel> createLoan(@RequestBody CreateLoanRequestModel request){

        if(StringUtils.isEmpty(request.getLanSp())){
            CommonResponseModel commonResponse = new CommonResponseModel();
            commonResponse.setErrorMsg("LenSp filed is empty");
            commonResponse.setErrorCode("1111");
            return new ResponseEntity(commonResponse,HttpStatus.OK);
        }else {
            try {

                CreateLoanResponseModel createLoanResponse = createLoanService.getCreateLoanDetails(request.getLanSp());
                    return new ResponseEntity<>(createLoanResponse, HttpStatus.OK);
            }catch (Exception e){
                CommonResponseModel commonResponse = new CommonResponseModel();
                System.out.println(e);
                commonResponse.setErrorMsg("something went worng");
                commonResponse.setErrorCode("1111");
                return new ResponseEntity(commonResponse,HttpStatus.OK);
            }
        }
    }



}
