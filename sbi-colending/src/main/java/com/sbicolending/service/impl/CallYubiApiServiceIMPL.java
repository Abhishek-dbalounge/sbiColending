package com.sbicolending.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbicolending.exception.SystemException;
import com.sbicolending.model.createloanrequest.CreateLoanRequestModel;
import com.sbicolending.model.createloanresponse.CreateLoanResponse;
import com.sbicolending.service.CallYubiApiService;
import com.sbicolending.utils.HttpClient;
import com.sbicolending.utils.NoResponseException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CallYubiApiServiceIMPL implements CallYubiApiService {

    private static ObjectMapper mapper= new ObjectMapper();
    @Override
    public Object getCreateLoan(CreateLoanRequestModel request) {

       try {

           String createLoanApiUrl ="https://colend-apihub-uat.go-yubi.in/colending/clients/clix/api/v2/loans";

           Map<String, String> header = getCreateLoanAPIRequestHeaders();
           String requestString = getCreateLoanRequest(request);
           Map<String,String> responseMap = new HashMap<>();

           responseMap = HttpClient.handlePOSTWebRequest(createLoanApiUrl,requestString,header);
           String responseCode = responseMap.get("responseCode");
           String responseString = responseMap.get("responseString");

           if (StringUtils.isBlank(responseString)) {
               throw new SystemException("1115","Api no any response");
           }

           return mapper.readValue(responseString,Object.class);
       }
       catch (NoResponseException npe) {
           throw new SystemException(npe.getErrorCode(),npe.getErrorMsg());
       }
       catch (Exception e){
           throw new SystemException("1111","something went worng");
       }
    }

    private String getCreateLoanRequest(CreateLoanRequestModel createJobReq) throws Exception{

        return  mapper.writeValueAsString(createJobReq);
    }

    private  Map<String,String>getCreateLoanAPIRequestHeaders(){

        Map<String,String> headers = new HashMap<>();

        headers.put("Content-Type", "application/json");
        headers.put("Product-Id","CLIX_SBI__LAP");
        headers.put("Accept","application/json");
        headers.put("Api-key","1bc2753b-9a1c-4cae-8a46-0182180de62f");

        return headers;
    }





    //===========================================================
    @Override
    public Object getLoanDetails(String loanId) {
        try {

            String createJobApiUrl ="https://colend-apihub-uat.go-yubi.in/colending/clients/clix/api/v2/loans/"+loanId;

            Map<String, String> header = getLoanDetailsAPIRequestHeaders();
            Map<String,String> responseMap = new HashMap<>();

            responseMap = HttpClient.handleGETWebRequest(createJobApiUrl,header);
            String responseCode = responseMap.get("responseCode");
            String responseString = responseMap.get("responseString");

            if (StringUtils.isBlank(responseString)) {
                throw new SystemException("1115","Api no any response");
            }

            return mapper.readValue(responseString,Object.class);
        }
        catch (NoResponseException npe) {
            throw new SystemException(npe.getErrorCode(),npe.getErrorMsg());
        }
        catch (Exception e){
            throw new SystemException("1111","something went worng");
        }
    }

    private  Map<String,String>getLoanDetailsAPIRequestHeaders(){

        Map<String,String> headers = new HashMap<>();

        headers.put("Content-Type", "application/json");
        headers.put("Product-Id","CLIX_SBI__LAP");
        headers.put("Accept","application/json");
        headers.put("Api-key","1bc2753b-9a1c-4cae-8a46-0182180de62f");

        return headers;
    }

}
