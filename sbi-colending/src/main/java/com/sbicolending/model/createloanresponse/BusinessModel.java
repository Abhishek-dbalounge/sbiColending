package com.sbicolending.model.createloanresponse;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class BusinessModel {


    private String name_of_business;
    private String nature_of_business;
    private String type_of_constitution;
    private LocalDate registration_date;
    private LocalDate incorporation_date;
    private String industry_type;
    private String sector_type;
    private String sub_sector_type;
    private int business_vintage;//(int)
    private String business_registered_office_address;
    private String business_registered_office_city;
    private String business_registered_office_state;
    private int business_registered_office_pincode;//(int)
    private String business_mailing_office_address;
    private String business_mailing_office_city;
    private int business_mailing_office_pincode;//(int)
    private String business_phone_number;
    private String business_email_id;
    private String property_ownership_flag;
    private String business_pan_number;
    private String business_rc_number;
    private String business_udhyam_regn_number;
    private String business_mailing_office_address1;
    private String business_mailing_office_address2;
    private String business_mailing_office_address3;
    private String enterprise_activity;
    private String customer_type;
    private float exisiting_shareholding_of_promoters;//(float)
    private float exisiting_shareholding_of_mutual_funds;//(float)
    private float exisiting_shareholding_of_financial_institutions_banks;//(float)
    private float exisiting_shareholding_of_others;//(float)
    private float exisiting_shareholding_total;//(float)
    private float proposed_shareholding_of_promoters;//(float)
    private float proposed_shareholding_of_mutual_funds;//(float)
    private float proposed_shareholding_of_financial_institutions_banks;//(float)
    private float proposed_shareholding_of_others;//(float)
    private float proposed_shareholding_total;//(float)
    private int annual_income;//(int)
    private LocalDate balance_sheet_year;//(Date)
    private String ckyc_id;

}
