package com.example.account.service.impl;

import com.example.account.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceImplTest {

    @Autowired
    private IAccountService iAccountService;

    @Test
    public void transfer() {
        double money = 1000;
        try {
            iAccountService.transfer(1,2,money);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    @Test
    public void transfer2() {
        double money = 3000;
        try {
            iAccountService.transfer(2,1,money);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}