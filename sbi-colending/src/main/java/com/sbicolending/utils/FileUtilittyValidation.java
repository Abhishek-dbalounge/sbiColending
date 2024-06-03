package com.sbicolending.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

@Service
public class FileUtilittyValidation {
    public boolean updateCustomerDetailsFileFormat(Row headerRow) {




        boolean matched = true;
        String errorMsg = "";

        for (int i = 0; i < 4; i++) {
            Cell cell = headerRow.getCell(i);
            errorMsg = (cell == null || cell.getCellType() == CellType.BLANK) ? "file upload error due to row no " + i + 1 + " is empty" : "";

            if (errorMsg.isEmpty() && matched == true) {

                String cellName = cell.toString();
                switch (cellName) {

                    case "primary_borrower_type":
                        matched = true;
                        break;
                    case "first_name":
                        matched = true;
                        break;
                    case "current_address":
                        matched = true;
                        break;
                    case "current_state":
                        matched = true;
                        break;
                   /* case "customer_category":
                        matched = true;
                        break;
                    case "client_customer_id":
                        matched = true;
                        break;
                    case "title":
                        matched = true;
                        break;
                    case "last_name":
                        matched = true;
                        break;
                    case "gender":
                        matched = true;
                        break;
                    case "mobile_number":
                        matched = true;
                        break;
                    case "place_of_birth":
                        matched = true;
                        break;
                    case "current_city":
                        matched = true;
                        break;
                    case "current_district":
                        matched = true;
                        break;
                    case "current_pincode":
                        matched = true;
                        break;
                    case "residence_type_current_address":
                        matched = true;
                        break;
                    case "permanent_district":
                        matched = true;
                        break;
                    case "permanent_pincode":
                        matched = true;
                        break;
                    case "residence_type_permanent_address":
                        matched = true;
                        break;
                    case "religion":
                        matched = true;
                        break;
                    case "caste":
                        matched = true;
                        break;
                    case "occupation":
                        matched = true;
                        break;
                    case "income_source":
                        matched = true;
                        break;
                    case "property_ownership_flag":
                        matched = true;
                        break;
                    case "udyam_number":
                        matched = true;
                        break;
                    case "name_of_bureau":
                        matched = true;
                        break;
                    case "bureau_score":
                        matched = true;
                        break;
                    case "product_id":
                        matched = true;
                        break;
                    case "application_id":
                        matched = true;
                        break;
                    case "category":
                        matched = true;
                        break;
                    case "sub_category":
                        matched = true;
                        break;
                    case "purpose":
                        matched = true;
                        break;
                    case "disbursement_type":
                        matched = true;
                        break;
                    case "number_of_tranches":
                        matched = true;
                        break;
                    case "tenure":
                        matched = true;
                        break;
                    case "number_of_repayments":
                        matched = true;
                        break;
                    case "psl_description":
                        matched = true;
                        break;
                    case "impacted_industry_description":
                        matched = true;
                        break;
                    case "applicant_never_in_30_plus_sma_sub_last_12m":
                        matched = true;
                        break;
                    case "tax_slab":
                        matched = true;
                        break;
                    case "psl_msme_type_of_enterprise":
                        matched = true;
                        break;
                    case "current_address_line1":
                        matched = true;
                        break;
                    case "cersai_security_int_id":
                        matched = true;
                        break;
                    case "repayment_frequency":
                        matched = true;
                        break;
                    case "father_first_name":
                        matched = true;
                        break;
                    case "father_last_name":
                        matched = true;
                        break;
                    case "total_value_of_security":
                        matched = true;
                        break;
                    case "tenure_frequency":
                        matched = true;
                        break;
                    case "marital_status":
                        matched = true;
                        break;
                    case "ckyc_id":
                        matched = true;
                        break;
                    case "date_of_birth":
                        matched = true;
                        break;
                    case "first_repayment_date":
                        matched = true;
                        break;
                    case "itr_filed_date_current_fy":
                        matched = true;
                        break;
                    case "application_date":
                        matched = true;
                        break;
                    case "fcu_done_date":
                        matched = true;
                        break;
                    case "e_verification_of_kyc_done_date":
                        matched = true;
                        break;
                    case "pd_done_date":
                        matched = true;
                        break;
                    case "search_with_registrar_of_companies_obtained_date":
                        matched = true;
                        break;
                    case "cersai_registration_reference_number_verification_date":
                        matched = true;
                        break;
                    case "cibil_report_done_date":
                        matched = true;
                        break;
                    case "repayment_period_end_date":
                        matched = true;
                        break;
                    case "date_of_sanction_by_nbfc":
                        matched = true;
                        break;
                    case "date_of_documentation_by_nbfc":
                        matched = true;
                        break;
                    case "annual_income":
                        matched = true;
                        break;
                    case "principal_amount":
                        matched = true;
                        break;
                    case "interest_rate":
                        matched = true;
                        break;
                    case "loan_emi":
                        matched = true;
                        break;
                    case "applicant_age_at_maturity":
                        matched = true;
                        break;*/

                    default:
                        matched = false;
                        break;

                }
            } else {
                matched = false;
            }
        }

        return matched;

    }
}
