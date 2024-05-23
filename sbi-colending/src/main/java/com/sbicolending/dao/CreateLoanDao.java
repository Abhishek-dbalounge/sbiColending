package com.sbicolending.dao;

import com.sbicolending.model.CreateLoanDataModel;

import java.util.List;

public interface CreateLoanDao {
    List<CreateLoanDataModel> getCreateLoanDataforLanSP(String lanSp);
}
