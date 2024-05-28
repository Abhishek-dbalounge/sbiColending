package com.sbicolending.model.createloanresponse;


import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class GuarantorsModel {

    private LocalDate date_of_birth;//(Date)
    private String gender;
    private String current_address;
    private String current_district;
    private String current_city;
    private String current_state;
    private int current_pincode;//(int)
    private String permanent_district;
    private int permanent_pincode;//(int)
    private int mobile_number;//(int)
    private String marital_status;
    private String religion;
    private int bureau_score;//(int)
    private int age_at_maturity;//(int)
    private String employment_details_designation;
    private String caste;
    private String father_first_name;
    private String father_last_name;
    private String occupation;
    private String place_of_birth;
    private String title;
    private String income_source;
    private String current_address_line1;
    private String education;
    private float other_than_agricultural_income;//(float)
    private float total_net_worth;//(float)
    private String customer_type;
    private String ckyc_id;
    private String annual_income;

}
