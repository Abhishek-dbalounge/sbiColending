package com.sbicolending.dao.impl;

import com.sbicolending.dao.CreateLoanDao;
import com.sbicolending.model.CreateLoanDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.sbicolending.utils.DBQuery;

import java.util.List;

@Repository
public class CreateLoanDaoIMPL implements CreateLoanDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CreateLoanDataModel> getCreateLoanDataforLanSP(String lanSp) {

        List<CreateLoanDataModel> createLoanDataList = jdbcTemplate.query(DBQuery.CREATE_LOAN_DATA,new Object[] { lanSp}, new BeanPropertyRowMapper<>(CreateLoanDataModel.class));

        return createLoanDataList;
    }

}
