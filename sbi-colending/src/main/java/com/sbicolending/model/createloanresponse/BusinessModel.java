package com.sbicolending.model.createloanresponse;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BusinessModel {


    private String name_of_business;
    private String nature_of_business;
    private String type_of_constitution;
    private Date registration_date;
    private Date incorporation_date;
    private String industry_type;
    private String sector_type;
    private String sub_sector_type;
    private Date business_vintage;
    private String business_registered_office_address;
    private String business_registered_office_city;
    private String business_registered_office_state;
    private String business_registered_office_pincode;
    private String business_mailing_office_address;
   // private String business_mailing_office_city;
   // private String business_mailing_office_pincode;
    private String business_phone_number;
    private String business_email_id;
    private String property_ownership_flag;
    private String business_pan_number;
    private String business_rc_number;
   // private String business_udhyam_regn_number;
   // private String business_mailing_office_address1;
    private String business_mailing_office_address2;
    private String business_mailing_office_address3;
    private String enterprise_activity;
    private String customer_type;
    private String exisiting_shareholding_of_promoters;
    private String exisiting_shareholding_of_mutual_funds;
    private String exisiting_shareholding_of_financial_institutions_banks;
    private String exisiting_shareholding_of_others;
    private String exisiting_shareholding_total;
    private String proposed_shareholding_of_promoters;
    private String proposed_shareholding_of_mutual_funds;
    private String proposed_shareholding_of_financial_institutions_banks;
    private String proposed_shareholding_of_others;
    private String proposed_shareholding_total;
    private String annual_income;
    private String balance_sheet_year;
    private String ckyc_id;

}
