package com.example.stripePayment.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.CustomerCollection;
import com.example.stripePayment.model.CustomerData;
import com.example.stripePayment.util.StripeUtil;

@Controller
public class StripePaymentController {

    @Value("${stripe.apikey}")
    String stripeApiKey;

	@Autowired
	StripeUtil stripeUtil;

    @RequestMapping("/home")
	public String home() {
		return "home";
	}

    @RequestMapping("/customer")
	public String customer() {
		return "customer";
	}

    @RequestMapping("/index")
    public String index(Model model) throws StripeException {

        Stripe.apiKey = stripeApiKey;

        Map<String, Object> params = new HashMap<>();
        params.put("limit", 3);

        CustomerCollection customers = Customer.list(params);
        List<CustomerData> allCustomer = new ArrayList<CustomerData>();
        for (int i = 0; i < customers.getData().size(); i++) {
            CustomerData customerData = new CustomerData();
            customerData.setCustomerId(customers.getData().get(i).getId());
            customerData.setName(customers.getData().get(i).getName());
            customerData.setEmail(customers.getData().get(i).getEmail());
            allCustomer.add(customerData);
        }


        model.addAttribute("customers", allCustomer);
        return "index";
    }

    @RequestMapping("/createCustomer")
    public String createCustomer(CustomerData customerData) {
        return "create-customer";
    }

	@RequestMapping("/addCustomer")
	public String addCustomer(CustomerData customerData) throws StripeException {
		
		Stripe.apiKey = stripeApiKey;
		Map<String, Object> params = new HashMap<>();
		params.put("name", customerData.getName());
		params.put("email", customerData.getEmail());
		Customer customer = Customer.create(params);
		
		return "success";
	}

	@RequestMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable("id") String id) throws StripeException {
		Stripe.apiKey = stripeApiKey;

		Customer customer = Customer.retrieve(id);

		Customer deletedCustomer = customer.delete();
		return "success";
	}

	@RequestMapping("/getCustomer/{id}")
	public String getCustomer(@PathVariable("id") String id, Model model) throws StripeException {
		Stripe.apiKey = stripeApiKey;
		CustomerData output =stripeUtil.getCustomer(id);
		model.addAttribute("customerData", output);
		return "update-customer";
	}
}
