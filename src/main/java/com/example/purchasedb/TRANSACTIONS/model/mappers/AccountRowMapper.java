package com.example.purchasedb.TRANSACTIONS.model.mappers;

import com.example.purchasedb.TRANSACTIONS.model.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account rowObject=new Account();
        rowObject.setId(rs.getLong("id"));
        rowObject.setName(rs.getString("name"));
        rowObject.setAmount(rs.getBigDecimal("amount"));
        return rowObject;
    }
}
