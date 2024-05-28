package com.sbicolending.model.createloanresponse;

import lombok.Data;

@Data
public class OriginalLoanDetailModel {

    private float loan_amount;
    private int tenure;
    private String tenure_frequency;

}
