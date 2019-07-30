package com.example.demo4.service;

import com.example.demo4.controller.CustomerController;
import com.example.demo4.entity.Customer;
import com.example.demo4.model.CustomerRequest;
import com.example.demo4.model.CustomerResponse;
import com.example.demo4.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public CustomerResponse servicePost(CustomerRequest request) {
        Optional<Customer> customerOpt = customerRepo.findById(request.getiD());
        if (customerOpt.isPresent() == true) {
            return new CustomerResponse(request.getiD(), "ID already exist", "Post Error", 0, 0);
        } else {
            Customer item = new Customer();
            item.setiD(request.getiD());
            item.setFirstName(request.getFirstName());
            item.setLastName(request.getLastName());
            item.setDayReg(request.getDayReg());
            item.setMonthReg(request.getMonthReg());
            customerRepo.save(item);
            CustomerResponse customerResponsePostService = new CustomerResponse((item.getiD()),
                    item.getFirstName(), item.getLastName(), item.getDayReg(), item.getMonthReg());

            return customerResponsePostService;
        }
    }


    public CustomerResponse serviceGetID(String iD)
    {
        Optional<Customer> customerOpt2 = customerRepo.findById(iD);
        if (customerOpt2.isPresent() != true)
        {
            return new CustomerResponse(iD,"ID doesn't exist","Get Error",0,0);
        } else {
            Customer data = customerRepo.findById(iD).get();
            CustomerResponse customerResponseGetID = new CustomerResponse(data.getiD(),data.getFirstName()
            ,data.getLastName(),data.getDayReg(),data.getMonthReg());

            return customerResponseGetID;
        }
    }


    public List<CustomerResponse> serviceGetAll()
    {
        List<Customer> list = customerRepo.findAll();
        List<CustomerResponse> listGetAll = new ArrayList<CustomerResponse>();

        for (Customer a : list)
        {
            CustomerResponse customerResponseGetAll = new CustomerResponse(a.getiD(),a.getFirstName()
            ,a.getLastName(),a.getDayReg(),a.getMonthReg());
            listGetAll.add(customerResponseGetAll);
        }
        return listGetAll;
    }


    public CustomerResponse serviceGetName(String firstName)
    {
        Optional<Customer> customerOpt3 = Optional.ofNullable(customerRepo.findByFirstName(firstName));
        if (!customerOpt3.isPresent())
        {
            return new CustomerResponse("This First Name doesn't exist",firstName,"Get Error",0,0);
        }
        Customer data = customerRepo.findByFirstName(firstName);
        CustomerResponse customerResponseGetName = new CustomerResponse(data.getiD(),data.getFirstName()
        ,data.getLastName(),data.getDayReg(),data.getMonthReg());

        return customerResponseGetName;
    }


    public CustomerResponse serviceUpdate(CustomerRequest request)
    {
        Optional<Customer> customerOpt4 = customerRepo.findById(request.getiD());
        if (!customerOpt4.isPresent())
        {
            return new CustomerResponse(request.getiD(),"This ID doesn't exist","Update Error",0,0);
        } else {
            Customer item2 = new Customer();
            item2.setiD(request.getiD());
            item2.setFirstName(request.getFirstName());
            item2.setLastName(request.getLastName());
            item2.setDayReg(request.getDayReg());
            item2.setMonthReg(request.getMonthReg());
            customerRepo.save(item2);

            CustomerResponse customerResponseUpdate = new CustomerResponse(item2.getiD(),item2.getFirstName()
            ,item2.getLastName(),item2.getDayReg(),item2.getMonthReg());

            return customerResponseUpdate;
        }
    }


    public void serviceDeleteAll()
    {
        customerRepo.deleteAll();
    }


    public List<CustomerResponse> serviceDeleteID(String iD)
    {
        Optional<Customer> customerOpt2 = customerRepo.findById(iD);
        if (customerOpt2.isPresent() != true)
        {
            List<Customer> list = customerRepo.findAll();
            List<CustomerResponse> listID = new ArrayList<CustomerResponse>();
            for (Customer a : list)
            {
                CustomerResponse customerResponseDeleteID = new CustomerResponse(a.getiD(),a.getFirstName()
                        ,a.getLastName(),a.getDayReg(),a.getMonthReg());
                listID.add(customerResponseDeleteID);
            }
            return listID;
        } else {
            customerRepo.deleteById(iD);
            List<Customer> list = customerRepo.findAll();
            List<CustomerResponse> listDeleteID = new ArrayList<CustomerResponse>();

            for (Customer a : list)
            {
                CustomerResponse customerResponseDeleteID = new CustomerResponse(a.getiD(), a.getFirstName()
                        , a.getLastName(), a.getDayReg(), a.getMonthReg());
                listDeleteID.add(customerResponseDeleteID);
            }
            return listDeleteID;
        }
    }



}
