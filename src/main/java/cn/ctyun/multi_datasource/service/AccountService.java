package cn.ctyun.multi_datasource.service;

import cn.ctyun.multi_datasource.dao.AccountMapper;
import cn.ctyun.multi_datasource.datasource.TargetDataSource;
import cn.ctyun.multi_datasource.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @TargetDataSource(value = "test")
    public List<Account> getAccount(){
        return accountMapper.selectByExample(null);
    }
}
