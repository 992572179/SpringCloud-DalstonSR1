package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/7/21.
 */
public interface AccountDao extends JpaRepository<Account,Integer> {
}
