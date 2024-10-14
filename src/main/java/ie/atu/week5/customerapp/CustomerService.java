package ie.atu.week5.customerapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public List<Customer> getCustomerById(String id){
        customerRepository.findById(id);
        return customerRepository.findAll();
    }

    public void create(Customer customer){
        customerRepository.save(customer);
    }


    public List<Customer> delete(String id){
        customerRepository.deleteById(id);
        return customerRepository.findAll();
    }
}
