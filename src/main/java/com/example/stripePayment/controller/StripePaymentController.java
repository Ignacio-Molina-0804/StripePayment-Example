package com.example.stripePayment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class StripePaymentController {

    @Value("${stripe.apikey}")
    String stripeApiKey;


    @RequestMapping("/")
    public String index() {
        return "Hello World" + stripeApiKey;
    }
    

}
