package com.sbicolending.model.createloanresponse;

import lombok.Data;

@Data
public class CoApplicantsModel {

    private String relationship_with_applicant;
    private String first_name;
    private String last_name;
    private String gender;
    //private String occupation;
    private String date_of_birth;
    private String mobile_number;
    private String current_address;
    private String current_city;
    private String current_district;
    private String current_state;
    private String current_pincode;
    private String permanent_district;
    private String permanent_pincode;
    private String marital_status;
    private String religion;
    private String education;
    private float annual_income;
    private int bureau_score;
    private String age_at_maturity;
   // private String employment_details_designation;
    private String caste;
    private String father_first_name;
    private String father_last_name;
    private String place_of_birth;
    private String title;
   // private String income_source;
   // private String current_address_line1;
   // private String total_net_worth;
    private String customer_type;
    private String ckyc_id;

}
