package com.example.account.service;

import com.example.account.model.auto.Account;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author astupidcoder
 * @since 2020-11-25
 */
@Service
public interface IAccountService extends IService<Account> {
    /**
     *
     * @param in 转入账户
     * @param out 转出账户
     * @param money 金额
     */

    void transfer(int in,int out,double money) throws Exception;

}
