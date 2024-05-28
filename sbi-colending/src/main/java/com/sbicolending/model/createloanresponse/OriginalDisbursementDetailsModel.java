package com.sbicolending.model.createloanresponse;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Data
public class OriginalDisbursementDetailsModel {

    private float disbursement_amount;
    private LocalDate disbursement_date;

}
