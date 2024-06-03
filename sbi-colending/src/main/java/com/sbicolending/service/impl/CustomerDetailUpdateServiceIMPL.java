package com.sbicolending.service.impl;

import com.sbicolending.model.CommonResponseModel;
import com.sbicolending.model.updatecustomerdetailsrequest.CustomerDetailUpdateModel;
import com.sbicolending.service.CustomerDetailUpdateService;
import com.sbicolending.utils.FileUtilittyValidation;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Iterator;

@Service
public class CustomerDetailUpdateServiceIMPL  implements CustomerDetailUpdateService {

    @Autowired
    private FileUtilittyValidation fileUtilittyValidation;
    @Override
    public CommonResponseModel updateCustomerDetails(String lanSp, MultipartFile file) {

        String errorMsg = "";
        CommonResponseModel commonResponse = new CommonResponseModel();
        int count = 0;

        try {
            InputStream inputStream = file.getInputStream();
            ZipSecureFile.setMinInflateRatio(0);
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Row headerRow = rowIterator.next();
            boolean fileFormat = true;
            fileFormat = fileUtilittyValidation.updateCustomerDetailsFileFormat(headerRow);
            System.out.println("true/false :- " + fileFormat);
            if (fileFormat) {

                while (rowIterator.hasNext()) {

                    count++;
                    Row row = rowIterator.next();

                    CustomerDetailUpdateModel customerDetailUpdateModel = new CustomerDetailUpdateModel();

                    for (int i = 0; i < 4; i++) {

                        Cell cell = row.getCell(i);
                        errorMsg = (cell == null || cell.getCellType() == CellType.BLANK) ? "file upload error due to row no " + (row.getRowNum() + 1) + " is empty" : "";
                        if (errorMsg.isEmpty()) {
                            switch (i) {

                                case 0:
                                    customerDetailUpdateModel.setPrimary_borrower_type(row.getCell(0).toString());
                                    break;
                                case 1:
                                    customerDetailUpdateModel.setFirst_name(row.getCell(1).toString());
                                    break;
                                case 2:
                                    customerDetailUpdateModel.setCurrent_address(row.getCell(2).toString());
                                    break;
                                case 3:
                                    customerDetailUpdateModel.setCurrent_state(row.getCell(3).toString());
                                    break;

                            }
                        }

                        if (!errorMsg.isEmpty()) break;
                    }
                    if (!errorMsg.isEmpty()) break;
                }
            } else {
                System.out.println("file format is not matched");
                errorMsg = "file format is not matching or technical issue.";
            }
        } catch (Exception e) {
            System.out.println(e);
            errorMsg = "file is empty or technical issue :";

        }
        return commonResponse;
    }
}
