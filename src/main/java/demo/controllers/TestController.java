/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.controllers;

import demo.model.Customer;
import demo.model.repositiories.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author waldekd
 */
@RestController
@EnableAutoConfiguration
public class TestController {

    @Autowired
    CustomerRepository repository;

    @RequestMapping(value = "/test")
    @ResponseBody
    String test() {
        return "Hello from controller";
    }

    @RequestMapping(value = "/customers/names/{name}")
    List<Customer> getCustomersByName(@PathVariable String name) {
        return repository.findByName(name);
    }

    @RequestMapping(value = "/customers/all")
    List<Customer> getAll() {
        Iterable<Customer> it = repository.findAll();
        if (it != null) {
            return IteratorUtils.toList(it.iterator());
        } else {
            return new ArrayList<>();
        }
    }
    
    @RequestMapping(value = "/customers/add/{name}/{surname}")
    void addCustomer(@PathVariable("name")String name, @PathVariable("surname") String surname){
        Customer n = new Customer();
        n.setName(name);
        n.setAddressline1("address");
        n.setEmail("dackow@gmail.com");
        n.setCity("ddd");
        repository.save(n);
    }

    @RequestMapping(value = "/customers/states/{state}")
    List<Customer> getCustomersByState(@PathVariable("state") String state1) {
        return repository.findByState(state1);
    }
}
