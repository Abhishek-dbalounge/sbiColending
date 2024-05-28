package com.sbicolending.model.createloanresponse;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class AssetsModel {


    private float sanction_ltv;
    private LocalDate collateral_created_date;//(Date)
    private LocalDate cersai_date;//(Date)
    private float security_valuation;//(flot)
    private String survey_or_gat_number;
    private String bound_by_north;
    private String bound_by_south;
    private String bound_by_east;
    private String bound_by_west;
    private int purchase_cost;//(int)
    private LocalDate purchase_date;//(Date)
    private String carpet_area_unit;
    private String plot_id_number;
    private String property_nature;
    private String property_locality;
    private LocalDate valuation_date;//(Date)

}
