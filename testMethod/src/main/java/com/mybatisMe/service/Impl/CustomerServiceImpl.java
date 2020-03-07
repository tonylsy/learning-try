package com.mybatisMe.service.Impl;

import com.mybatisMe.Dao.CustomersMapper;
import com.mybatisMe.entities.Customers;
import com.mybatisMe.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomersMapper customersMapper;

    @Override
    public Customers selectCustomersById(Integer customernumber) {
        Customers customers = customersMapper.selectByPrimaryKey(customernumber);
        return customers;
    }
}
