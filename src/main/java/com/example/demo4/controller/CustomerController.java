package com.example.demo4.controller;

import com.example.demo4.entity.Customer;
import com.example.demo4.model.CustomerResponse;
import com.example.demo4.model.CustomerRequest;
import com.example.demo4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


@RestController
public class CustomerController
{
    @Autowired
    private CustomerService customerService;

    @PostMapping("trust")
    public CustomerResponse post(@RequestBody CustomerRequest request)
    {
        CustomerResponse customerResponsePost = customerService.servicePost(request);

        return customerResponsePost;
    }

    @GetMapping("trust/{iD}")
    public CustomerResponse getID(@PathVariable String iD)
    {
        CustomerResponse customerResponseGetID = customerService.serviceGetID(iD);

        return customerResponseGetID;
    }

    @GetMapping("trust")
    public List<CustomerResponse> getAll()
    {
        List<CustomerResponse> customerResponseGetAll = customerService.serviceGetAll();

        return customerResponseGetAll;
    }

    @GetMapping("trust2")
    public CustomerResponse getName(@RequestParam (value = "firstName", defaultValue = "-") String firstName)
    {
        CustomerResponse customerResponseGetName = customerService.serviceGetName(firstName);

        return customerResponseGetName;
    }

    @PutMapping("trust")
    public CustomerResponse update(@RequestBody CustomerRequest request)
    {
        CustomerResponse customerResponseUpdate = customerService.serviceUpdate(request);

        return customerResponseUpdate;
    }

    @DeleteMapping("trust")
    public CustomerResponse deleteAll()
    {
        customerService.serviceDeleteAll();

        return new CustomerResponse("Success","Deleted All Data","-",0,0);
    }

    @DeleteMapping("trust/{iD}")
    public List<CustomerResponse> deleteID(@PathVariable String iD)
    {
        List<CustomerResponse> customerResponseDeleteID = customerService.serviceDeleteID(iD);

        return customerResponseDeleteID;
    }

}


