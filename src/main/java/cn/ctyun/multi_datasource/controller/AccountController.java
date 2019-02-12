package cn.ctyun.multi_datasource.controller;

import cn.ctyun.multi_datasource.entity.Account;
import cn.ctyun.multi_datasource.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/account/index")
    public List<Account> getAccount(){
        return  accountService.getAccount();
    }
}
