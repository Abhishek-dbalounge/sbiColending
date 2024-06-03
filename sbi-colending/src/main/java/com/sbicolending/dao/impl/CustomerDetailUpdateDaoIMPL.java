package com.sbicolending.dao.impl;

import com.sbicolending.dao.CustomerDetailUpdateDao;
import com.sbicolending.exception.SystemException;
import com.sbicolending.model.CommonResponseModel;
import com.sbicolending.model.updatecustomerdetailsrequest.CustomerDetailUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDetailUpdateDaoIMPL implements CustomerDetailUpdateDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public boolean updateCustomerDetails(CustomerDetailUpdateModel customerDetailUpdateData, String lanSp) {

        boolean status=false;
        try {

            String primary_borrower_type =customerDetailUpdateData.getPrimary_borrower_type();
            String first_name=customerDetailUpdateData.getFirst_name();
            String current_address=customerDetailUpdateData.getCurrent_address();
            String current_state=customerDetailUpdateData.getCurrent_state();
            Integer number_of_tranches= customerDetailUpdateData.getNumber_of_tranches();

            String sql = "UPDATE public.create_loan SET \n" +
                    "customer_type_sp = '"+primary_borrower_type+"' ,\n"+
                    "first_name_ia ='"+first_name+"' ,\n"+
                    "current_address_ia ='"+current_address+"' ,\n"+
                    "State_ia='"+current_state+"', \n"+
                    "number_of_tranches_sp='"+number_of_tranches+"' \n" +
                    "WHERE lan_sp ='"+lanSp+"' \n";

            int i = jdbcTemplate.update(sql);
            if (i>0){
                status = true;
            }


        }catch (Exception e){
            throw new SystemException("1111",e.getMessage());
        }

        return status;
    }
}
