package com.sbicolending.service.impl;

import com.sbicolending.dao.CustomerDetailUpdateDao;
import com.sbicolending.exception.SystemException;
import com.sbicolending.model.CommonResponseModel;
import com.sbicolending.model.updatecustomerdetailsrequest.CustomerDetailUpdateModel;
import com.sbicolending.service.CustomerDetailUpdateService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerDetailUpdateServiceIMPL  implements CustomerDetailUpdateService {


    @Autowired
    private CustomerDetailUpdateDao customerDetailUpdateDao;


    @Override
    public CommonResponseModel updateCustomerDetailsData(String lanSp, MultipartFile multipartFile, List<String> header) throws SystemException {


        CommonResponseModel commonResponseModel = new CommonResponseModel();
        InputStream inputStream;
        boolean checkheader = false;

        try {

            inputStream = new ByteArrayInputStream(multipartFile.getBytes());
            @SuppressWarnings("resource")
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            int rowNum = sheet.getPhysicalNumberOfRows();

            for (int i = 0; i < 1; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < header.size(); j++) {
                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                    if (cell.getCellType() == CellType.BLANK) {
                        throw new SystemException("1111","Cell is empty");

                    } else {
                        if (cell.getStringCellValue().equals(header.get(j).toString())) {
                            checkheader = true;
                        } else {
                            checkheader = false;
                            throw new SystemException("1111","Used Header Name " + header.get(j).toString() + " at index"+j);
                        }
                    }
                }
            }

            if (checkheader) {
                commonResponseModel = validExcelCustomerDetailsUpload(sheet, header, lanSp);
                return commonResponseModel;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SystemException se) {
            se.printStackTrace();
            throw se;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SystemException(e.getMessage());
        }
        return commonResponseModel;
    }


    private CommonResponseModel validExcelCustomerDetailsUpload(Sheet sheet, List<String> header,String lanSp) {

        CommonResponseModel commonResponseModel = new CommonResponseModel();
        CustomerDetailUpdateModel customerDetailUpdateData = new CustomerDetailUpdateModel();
        List<CustomerDetailUpdateModel> customerDetailUpdateDataList = new ArrayList<>();

        try {

            String primary_borrower_type = null;
            String first_name = null;
            String current_address = null;
            String current_state = null;
            int number_of_tranches = 0;


            int rownum = sheet.getPhysicalNumberOfRows();
            if (rownum == 1) {
                throw new SystemException("1111","empty excel file");
            }


            for (int i = 1; i < rownum; i++) {

                CustomerDetailUpdateModel customerDetailUpdate = new CustomerDetailUpdateModel();

                Row row = sheet.getRow(i);

                if (row == null) {
                    throw new SystemException("1111","Empty Cell Please Check the file Row Number " + i);

                }

                    for (int j = 0; j < header.size(); j++) {
                        Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                     try {
                        switch (cell.getCellType()) {

                            case ERROR:
                                throw new SystemException("1111","Error Cell Please Check the file.");


                            case BLANK:

                                if (j == 0)
                                    throw new SystemException("1111","Empty Cell primary_borrower_type Please Check the file Column Number " + j);

                                else if (j == 1)
                                    throw new SystemException("1111","Empty Cell first_name Please Check the file Column Number " + j);

                                else if (j == 2)
                                    throw new SystemException("1111","Empty Cell current_address Please Check the file Column Number " + j);

                                else if (j == 3)
                                    throw new SystemException("1111","Empty Cell current_state Please Check the file Column Number " + j);

                                else if (j == 4)
                                    throw new SystemException("1111","Empty Cell number_of_tranches Please Check the file Column Number " + j);

                                break;

                            case NUMERIC:

                                if (j == 0)
                                    primary_borrower_type = NumberToTextConverter.toText(cell.getNumericCellValue());

                                else if (j == 1)
                                    first_name = NumberToTextConverter.toText(cell.getNumericCellValue());

                                else if (j == 2)
                                    current_address = NumberToTextConverter.toText(cell.getNumericCellValue());

                                else if (j == 3)
                                    current_state = NumberToTextConverter.toText(cell.getNumericCellValue());

                                else if (j == 4)
                                    number_of_tranches = (int) cell.getNumericCellValue();

                                break;

                            case STRING:

                                if (j == 0) {
                                    primary_borrower_type = cell.getStringCellValue();
                                } else if (j == 1) {
                                    first_name = cell.getStringCellValue();
                                } else if (j == 2) {
                                    current_address = cell.getStringCellValue();
                                } else if (j == 3) {
                                    current_state = cell.getStringCellValue();
                                } else if (j == 4)
                                    number_of_tranches = Integer.parseInt(cell.getStringCellValue());

                                break;

                            default:
                                break;

                        }
                     } catch (NumberFormatException e) {
                            throw new SystemException("1111","Invalid Record(Unparseable) of Column Name " + header.get(j).toString()+ " at index"+j);
                     }
                    }

                try {

                    customerDetailUpdate.setPrimary_borrower_type(primary_borrower_type);
                    customerDetailUpdate.setFirst_name(first_name);
                    customerDetailUpdate.setCurrent_address(current_address);
                    customerDetailUpdate.setCurrent_state(current_state);
                    customerDetailUpdate.setNumber_of_tranches(number_of_tranches);
                    customerDetailUpdateDataList.add(customerDetailUpdate);
                    customerDetailUpdateData = customerDetailUpdateDataList.get(0);

                    boolean updateStatus = customerDetailUpdateDao.updateCustomerDetails(customerDetailUpdateData, lanSp);
                    if(updateStatus == true) {
                        commonResponseModel.setErrorCode("0000");
                        commonResponseModel.setErrorMsg("file update successfully ");
                    }else {
                        commonResponseModel.setErrorCode("1111");
                        commonResponseModel.setErrorMsg("file not update successfully ");
                    }

                } catch (Exception e) {
                    throw new SystemException("1111",e.getMessage());
                }
            }

            return commonResponseModel;
        } catch (Exception e) {
            throw new SystemException("1111",e.getMessage());
        }

    }





    }