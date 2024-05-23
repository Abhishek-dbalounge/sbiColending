package com.sbicolending.model.createloanresponse;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BusinessCoApplicantsModel {

    private String name_of_business;
    private String nature_of_business;
    private String type_of_constitution;
    private Date registration_date;
    private Date incorporation_date;
    private String industry_type;
   // private String sector_type;
    private String sub_sector_type;
    private float business_vintage;
    private String business_registered_office_address;
    private String business_registered_office_city;
    private String business_registered_office_state;
    private String business_registered_office_pincode;
    //private String business_mailing_office_address;
    private String business_mailing_office_address1;
    private String business_mailing_office_address2;
    private String business_mailing_office_address3;
   // private String business_mailing_office_city;
   // private String business_mailing_office_pincode;
    private String business_phone_number;
    private String business_pan_number;
    private List<String> business_pan_link;
    private String business_rc_number;
    private List<String> business_rc_link;
    //private String annual_business_turnover;
    private String ckyc_id;

}
