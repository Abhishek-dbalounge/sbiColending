package com.sbicolending.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BusinessNonIndividualApplicanteModel {

    private String Name_of_Business;
    private String Nature_of_Business_Description;
    private String Type_of_Constitution_Description;
    private Date Registration_Date;
    private Date Incorporation_date;
    private String Industry_Type;
    // private String Sector_Type;(Not in DB)
    private String Sub_Sector_Type;
    private Date Business_Vintage_Years;
    private String Business_Mailing_Office_City;
    private String Business_Mailing_Office_Pincode;
    private String Business_Registered_Office_Address;
    private String Business_Registered_Office_Address2;
    private String Business_Registered_Office_Address3;
    private String Business_Mailing_Office_Flat;
    private String Current_District;
    private String Care_Of;
    private String Sub_District;
    private String Business_Phone_Number;
    private String Business_Email_ID;
    private String Business_PAN_Number;
    private List<String> Business_PAN_Link;
    private String Form_60_Submission_Date;
    private String Other_Income;
    private String Agricultural_Income;
    // private String Customer_GST,(NOT IN DB)
    private List<String> Business_GST_copy_Link;
    private String Business_Udhyam_regn_Number;
    private List<String> Business_Udhyam_regn_Link;
    private String Business_Mailing_Office_Address1;
    private String Business_Mailing_Office_Address2;
    private String Business_Mailing_Office_Addres3;
    private String Customer_Type1;
    private String exisiting_shareholding_of_promoters;
    private String exisiting_shareholding_of_mutual_funds;
    private String exisiting_shareholding_of_financial_institutions_banks;
    private String exisiting_shareholding_of_others;
    private String exisiting_shareholding_total;
    private String proposed_shareholding_of_prcintnrs;
    private String proposed_shareholding_of_mutual_funds;
    private String proposed_shareholding_of_financial_institutions_banks;
    private String proposed_shareholding_of_others;
    private String proposed_shareholding_total;
    private String ckyc_id;
    private String balance_sheet_year;
    private String annual_income;
    private String cin_number;
    private String coi_number;
    private String aoa_numberl;
    private String partnership_deed_number;
    private String board_resolution_number;
    private String business_rc_number;
    private List<String> aoa_link;
    private List<String> board_resoultion_link;
    private List<String> partnership_deed_link;
    private List<String> certificate_of_incorporation_link;
    private List<String> business_rc_link;



}
