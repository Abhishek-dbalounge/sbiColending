package com.sbicolending.model.customerdetailsresponse;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BusinessCoApplicantsModel {

    private String name_of_business;
    private String nature_of_business;
    private String type_of_constitution;
    private String registration_date;//(Date)
    private String incorporation_date;//(Date)
    private String industry_type;
    private String sector_type;
    private String sub_sector_type;
    private String business_vintage;
    private String business_registered_office_address;
    private String business_registered_office_city;
    private String business_registered_office_state;
    private String business_registered_office_pincode;
    private String business_mailing_office_address;
    private String business_mailing_office_address1;
    private String business_mailing_office_address2;
    private String business_mailing_office_address3;
    private String business_mailing_office_city;
    private int business_mailing_office_pincode;//(//int)
    private List<Long> business_phone_number;
    private String business_pan_number;
    private String business_pan_link;
    private String business_rc_number;
    private String business_rc_link;
    private float annual_business_turnover;//(float)
    private String ckyc_id;


}
