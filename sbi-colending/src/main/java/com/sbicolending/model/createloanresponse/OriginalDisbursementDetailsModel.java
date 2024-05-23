package com.sbicolending.model.createloanresponse;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class OriginalDisbursementDetailsModel {

    private int disbursement_amount;
    private Date disbursement_date;

}
