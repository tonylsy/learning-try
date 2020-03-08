package com.mybatisMe.handler;

import com.mybatisMe.common.Result;
import com.mybatisMe.entities.Customers;
import com.mybatisMe.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HelloWorldController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/getImgCode.do")
    public void getImgCode(HttpServletResponse response) throws IOException {

        try {
            response.setContentType("image/jpeg");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Controller", "no-cache");
            response.setHeader("Set-Cookie", "name=value;HttpOnly");
            response.setDateHeader("Expire", 0);
            String context = "here's the picture's bytes";
            response.getOutputStream().write(context.getBytes());
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
    public Result getCustomer(Integer customerId) {
        Customers customers = customerService.selectCustomersById(customerId);
        if (customers == null) {
            return Result.fail("could not find the customer", null);
        }
        return Result.ok(null, customers);
    }


}
