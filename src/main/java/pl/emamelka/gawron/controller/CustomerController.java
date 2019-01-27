package pl.emamelka.gawron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
