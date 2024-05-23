package com.sbicolending.controller;

import com.sbicolending.model.CommonResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class UpdateLoanController {

    @PutMapping("/updateLoan")
    public ResponseEntity<String> updateLoan(){

        CommonResponseModel commonResponse = new CommonResponseModel();

        System.out.println("Hello you are in Update Api");
        return null;
    }
}
