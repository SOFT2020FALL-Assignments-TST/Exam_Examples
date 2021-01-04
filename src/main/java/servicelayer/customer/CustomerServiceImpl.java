package servicelayer.customer;

import datalayer.customer.CustomerStorage;
import dto.Customer;
import dto.CustomerCreation;
import exceptions.CustomerServiceException;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

public class CustomerServiceImpl implements CustomerService {

    private CustomerStorage customerStorage;

    public CustomerServiceImpl(CustomerStorage customerStorage) {
        this.customerStorage = customerStorage;
    }

    @Override
    public int createCustomer(String firstName, String lastName, Date birthdate, String phoneNumber) throws CustomerServiceException {
        try {
            return customerStorage.createCustomer(new CustomerCreation(firstName, lastName, birthdate, phoneNumber));
        } catch (SQLException ex) {
            throw new CustomerServiceException();
        }
    }

    @Override
    public Customer getCustomerById(int id) throws CustomerServiceException {
        try {
            return customerStorage.getCustomerWithId(id);
        } catch (SQLException ex) {
            throw new CustomerServiceException();
        }
    }

    @Override
    public Collection<Customer> getCustomersByFirstName(String firstName) throws CustomerServiceException {
        try {
            return customerStorage.getCustomersByFirstName(firstName);
        } catch (SQLException ex) {
            throw new CustomerServiceException();
        }
    }
}
