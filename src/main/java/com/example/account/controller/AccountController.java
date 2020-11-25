package com.example.account.controller;


import com.example.account.model.auto.Account;
import com.example.account.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author astupidcoder
 * @since 2020-11-25
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService iAccountService;

    @PostMapping
    public Account transfer(@RequestParam int in, @RequestParam int out, @RequestParam double money) {
        try {
            iAccountService.transfer(in,out,money);
        }catch (Exception e){
            return iAccountService.getById(out);
        }
        return iAccountService.getById(in);
    }

}
