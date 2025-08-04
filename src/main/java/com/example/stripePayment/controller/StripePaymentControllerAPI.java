package com.example.stripePayment.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stripePayment.model.CustomerData;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;

@RestController
@RequestMapping("/api")
public class StripePaymentControllerAPI {

    @Value("${stripe.apikey}")
    String stripeApiKey;

    @RequestMapping("/createCustomer")
    public CustomerData index(@RequestBody CustomerData data) throws StripeException {
        Stripe.apiKey = stripeApiKey;
        Map<String, Object> params = new HashMap<>();
        params.put("email", data.getEmail());
        params.put("name", data.getName());
        Customer customer = Customer.create(params);
        data.setCustomerId(customer.getId());
        return data;
    }

    
}
