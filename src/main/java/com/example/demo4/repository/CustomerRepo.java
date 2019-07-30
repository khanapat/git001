package com.example.demo4.repository;

import com.example.demo4.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String>
{
    public Customer findByFirstName(String firstName);

}
