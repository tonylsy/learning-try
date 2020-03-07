package com.mybatisMe.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatisMe.entities.Customers;
import com.mybatisMe.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloworldController {
    @Autowired
    CustomerService customerService;

    private Logger logger = LogManager.getLogger(HelloworldController.class);

    @RequestMapping("/getImgCode.do")
    public void getImgCode(HttpServletRequest req, HttpServletResponse response) throws IOException {

        try {
            response.setContentType("image/jpeg");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Controller", "no-cache");
            response.setHeader("Set-Cookie", "name=value;HttpOnly");
            response.setDateHeader("Expire", 0);
            response.getOutputStream().write(null);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            response.getOutputStream().flush();
            response.getOutputStream().close();
        }

    }

    @RequestMapping("/getCustomer.do")
    @ResponseBody
    public Customers getCustomer(Integer customerId) {
        Customers customers = customerService.selectCustomersById(customerId);
        if(customers == null){
            logger.error("the customerId is not find!");
        }
        return customers;
    }


}
