package com.example.account.service.impl;

import com.example.account.model.auto.Account;
import com.example.account.mapper.auto.AccountMapper;
import com.example.account.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.beans.Transient;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author astupidcoder
 * @since 2020-11-25
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    @Transactional(rollbackFor = {Exception.class,Error.class})
    public void transfer(int in,int out,double money) throws Exception {
        Account accountIn = accountMapper.selectById(in);
        Account accountOut = accountMapper.selectById(out);
        if(accountOut.getBalance() - money >= 0){
            accountOut.setBalance(accountOut.getBalance() - money);
        }else{
            throw new Exception();
        }
        accountIn.setBalance(accountIn.getBalance() + money);
        accountMapper.updateById(accountIn);
        accountMapper.updateById(accountOut);
    }
}
