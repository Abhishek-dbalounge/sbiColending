package com.sbicolending.model;

import lombok.Data;

import java.util.List;

@Data
public class CustomerDetails  {


    private String lanSp;
    private List<BusinessBlockNonIndividualApplicante> businessBlockNonIndividualApplicante;



}
