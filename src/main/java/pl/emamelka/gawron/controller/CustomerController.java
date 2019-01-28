package pl.emamelka.gawron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.emamelka.gawron.exceptions.ValidationException;
import pl.emamelka.gawron.model.Customer;
import pl.emamelka.gawron.model.CustomerDto;
import pl.emamelka.gawron.model.ExceptionMessage;
import pl.emamelka.gawron.repository.CustomerRepo;
import pl.emamelka.gawron.validator.CustomerValidator;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CustomerValidator customerValidator;

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EntityNotFoundException.class)
    public ExceptionMessage entityNotFoundException(){
        return new ExceptionMessage("User not found.");
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public ExceptionMessage validationNotPassedException(ValidationException ex){
        return new ExceptionMessage(ex.getMessage());
    }

    @GetMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Customer> getCustomers(){
        return customerRepo.findAll();
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void createCustomer(@RequestBody CustomerDto customerDto){
        customerValidator.validateCustomer(customerDto);
        Customer customer = new Customer(customerDto);
        customerRepo.save(customer);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CustomerDto getCustomer(@PathVariable("id") Integer id){
        Customer customer = customerRepo.getOne(id);
        CustomerDto customerDto = new CustomerDto(customer);
        return customerDto;
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void updateCustomer(@PathVariable("id") Integer id, @RequestBody CustomerDto customerDto){
        Customer customer = customerRepo.getOne(id);
        customer.update(customerDto);
        customerRepo.save(customer);
    }

}
