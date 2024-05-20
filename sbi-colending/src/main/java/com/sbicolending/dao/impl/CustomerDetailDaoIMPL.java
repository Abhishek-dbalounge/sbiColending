package com.sbicolending.dao.impl;

import com.sbicolending.dao.CustomerDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDetailDaoIMPL implements CustomerDetailDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<?> getCustomerPersonalDetails(String loanNo) {

        List<?> custPersonalDetail = null;
        try {

            String sql = "select lan_sp\n" +
                    "from create_loan where lan_sp ='" + loanNo + "'";

            custPersonalDetail = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>());

        } catch (Exception e) {
               System.out.println(e);
        }

        return custPersonalDetail;
    }

    @Override
    public List<?> getCustomerBussinessDetails(String loanNo) {
        List<?> custBussinessDetail = null;
        try {

            String sql = "select customer_type_sp ,\n" +
                    "customer_category_sp \n" +
                    "from create_loan where lan_sp ='" + loanNo + "'";

            custBussinessDetail = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>());

        } catch (Exception e) {
            System.out.println(e);
        }

        return custBussinessDetail;
    }
}
