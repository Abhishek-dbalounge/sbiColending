package com.sbicolending.model.createloanresponse;

import lombok.Data;

import java.util.Date;

@Data
public class AssetsModel {


    private String collateral_created_date;
    private String cersai_date;
    private int security_valuation;
    private String survey_or_gat_number;
    private String bound_by_north;
    private String bound_by_south;
    private String bound_by_east;
    private String bound_by_west;
    private int purchase_cost;
    private Date purchase_date;
    private String carpet_area_unit;
    private String plot_id_number;
    private String property_nature;
    private String property_locality;
    private String valuation_date;

}
