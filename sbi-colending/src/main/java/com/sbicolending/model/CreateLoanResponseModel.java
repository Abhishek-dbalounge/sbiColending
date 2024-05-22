package com.sbicolending.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Indexed;

import java.util.Date;
import java.util.List;

@Data
public class CreateLoanResponseModel {

    private String Customer_Type;
    private String Customer_Category;
    private String Client_Customer_ID;
    private String residential_status1;
   // tdcaac.Residence_Type_Current_Address as residence_type_current_address_AAC  (----CHECk-----)
    private String Permanent_Pincode;
  //  private String residence_permanent_address_IC (----CHECk-----)
    private String Residence_Type_Current_Address;
    private String Name_of_Bureau;
    private String Bureau_Score;
    private List<String> bureau_report_link_SP;
   // private String bureau_report_link_SP (-----CHECK-----)
    private String Purpose;
    private float Principal_Amount;
    private float interest_rate;
    private String Interest_Type;
    private int Tenure;
    private String Repayment_Frequency;
    private int Number_of_Repayments;
    private Date First_Repayment_Date;
    private float First_EMI;
    private String PSL_MSME_Type_of_Enterprise;
    private Date Application_Date;
    private String e_Verification_of_KYC_Done_Date;
    private String PD_Done_Date;
    private String FCU_Done_Date;
    private String Search_with_Registrar_of_Companies_Obtained_Date;
    private String Cersai_Registration_Reference_Number_Verification_Date;
    private String Cibil_Report_Done_Date;
    private Date Repayment_Period_End_Date;
    private String Date_of_Sanction_by_NBFC;
    private String Date_of_Documentation_by_NBFC;
    private String Total_Value_of_Security;
    private String ROC_Search_Report_Date;
    private String TAX_Slab;
    private List<String> loan_details_link_SP;
   // tdsp.Loan_Details_Link as loan_details_link_SP (----CHECK----)
    private String Employment_Details_Designation;
    private BusinessNonIndividualApplicanteModel businessBlockNonIndividualApplicante;

}
