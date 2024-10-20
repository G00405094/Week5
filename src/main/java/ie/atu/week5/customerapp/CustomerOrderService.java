package ie.atu.week5.customerapp;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CustomerOrderService {
    private final CustomerService customerService;

    private final OrderService orderService;

    public CustomerOrderService(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    public void createCustomerWithOrders(CustomerOrderRequest customerOrderRequest){
        customerService.createCustomer(customerOrderRequest.getCustomer());
        String customerId = customerOrderRequest.getCustomer().getId();

        for(Order order : orderService.getAllOrders()) {
            order.setCustomerId(customerId);
            orderService.createOrder(order);
        }
    }
}


