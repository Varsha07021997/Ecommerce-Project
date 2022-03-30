package com.Ecommerce.controller;

import com.Ecommerce.entities.Address;
import com.Ecommerce.handler.ResponseHandler;
import com.Ecommerce.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class response {

    @Autowired
    AddressRepository repository;
    @GetMapping("/address")
    public ResponseEntity<Object> address()
    {
        try{
            Address address=new Address();
            address.setCity("Lucknow");
            address.setState("UP");
            address.setCountry("India");
            address.setAddressLine("Flat number 12,Woods Apartments");
            address.setZipCode(226001);
            address.setLabel("Home");
            Object save=repository.save(address);

            return ResponseHandler.generateResponse("Data added Successfully !!!!", HttpStatus.OK,save);
        }
        catch (Exception e)
        {
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }
}
