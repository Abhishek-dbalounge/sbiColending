package com.sbicolending.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbicolending.exception.SystemException;
import com.sbicolending.model.*;
import com.sbicolending.model.customerdetailsresponse.CustomerDetailResponseModel;
import com.sbicolending.service.CustomerDetailService;
import com.sbicolending.utils.BaseLogger;
import com.sbicolending.utils.HttpClient;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerDetailController {

    private Logger logger = BaseLogger.getLogger(CustomerDetailController.class);
    @Autowired
    private CustomerDetailService customerDetailService;

    private static ObjectMapper mapper= new ObjectMapper();

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/customerDetails/{lanSp}")
    public ResponseEntity<?> customerDetails(@PathVariable("lanSp") String lanSp){

        try {
        if(StringUtils.isEmpty(lanSp)){
            CommonResponseModel commonResponse = new CommonResponseModel();
            logger.info("customerDetails : LenSp filed is empty");
            commonResponse.setErrorMsg("LenSp filed is empty");
            commonResponse.setErrorCode("1112");
            return new ResponseEntity<>(commonResponse,HttpStatus.OK);
        }
                CustomerDetailResponseModel customerDetailResponse = customerDetailService.getCustomerDetails(lanSp);
                if (customerDetailResponse == null) {
                    logger.info("customerDetails : Invalid LenSp");
                    throw new SystemException("1113","Invalid LenSp");
                }

            //==============================================
          /*  String createJobApiUrl ="https://colend-apihub-uat.go-yubi.in/colending/clients/clix/api/v2/loans";
           // String content = new String(Files.readAllBytes(Paths.get("C:\\Abhishek DBA\\test.txt")));

            Map<String, String> header = getCreateJobAPIRequestHeaders();
            String requestString = getCreateJobRequest(customerDetailResponse);
            Map<String,String> responseMap = new HashMap<>();

            responseMap = HttpClient.handlePOSTWebRequest(createJobApiUrl,requestString,header);
            String jsonResponseAccessStr = responseMap.get("requestString");
*/

          //  return null;

                //============================================
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


    private String getCreateJobRequest(CustomerDetailResponseModel createJobReq) throws Exception{

        return  mapper.writeValueAsString(createJobReq);
    }

    private  Map<String,String>getCreateJobAPIRequestHeaders(){

        Map<String,String> headers = new HashMap<>();

        headers.put("Content-Type", "application/json");
        headers.put("Product-Id","CLIX_SBI__LAP");
        headers.put("Accept","application/json");
        headers.put("Api-key","1bc2753b-9a1c-4cae-8a46-0182180de62f");

        /*byte[] pass = ("CLIX_SBI__LAP" + ":" +"1bc2753b-9a1c-4cae-8a46-0182180de62f").getBytes();
        // String auth = accessTokenApiRes.getToken_type()+""+accessTokenApiRes.getAccess_token();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization","Basic "+ Base64.encodeBase64String(pass));
        headers.put("Accept","application/json");*/

        return headers;
    }


}
