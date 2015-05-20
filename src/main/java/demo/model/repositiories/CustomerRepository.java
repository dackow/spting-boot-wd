/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.model.repositiories;

import demo.model.Customer;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Waldemar Dacko <waldekd@softsystem.pl>
 */
public interface CustomerRepository extends CrudRepository<Customer, Long>{
    List<Customer> findByName(String name);    
    List<Customer> findByState(String state);
  
}
