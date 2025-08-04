package com.example.stripePayment.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.stripePayment.model.CustomerData;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;


@Controller
public class StripePaymentController {

    @Value("${stripe.apikey}")
    String stripeApiKey;


    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/createCustomer")
    public String createCustomer(CustomerData customerData) {
        return "create-customer";
    }

    @RequestMapping("/addCustomer")
    public String addCustomer(CustomerData customerData) throws StripeException{
        Stripe.apiKey = stripeApiKey;
        Map<String, Object> params = new HashMap<>();
        params.put("email", customerData.getEmail());
        params.put("name", customerData.getName());
        Customer customer = Customer.create(params);

        return "success";
    }
    

}
