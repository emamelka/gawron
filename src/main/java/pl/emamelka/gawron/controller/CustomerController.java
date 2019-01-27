package pl.emamelka.gawron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.emamelka.gawron.model.Customer;
import pl.emamelka.gawron.repository.CustomerRepo;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

    @GetMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Customer> getCustomers(){
        return customerRepo.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void createCustomer(@RequestBody Customer customer){
        customerRepo.save(customer);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCustomer(@PathVariable("id") Integer id){
        customerRepo.deleteById(id);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Customer getCustomer(@PathVariable("id") Integer id){
        return customerRepo.findById(id).orElse(null);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void updateCustomer(@RequestBody Customer customer){
        customerRepo.save(customer);
    }


}
