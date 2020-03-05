package com.mybatisMe.service;

import com.mybatisMe.entities.Customers;

public interface CustomerService {
    Customers selectCustomersById(Integer customernumber);
}
