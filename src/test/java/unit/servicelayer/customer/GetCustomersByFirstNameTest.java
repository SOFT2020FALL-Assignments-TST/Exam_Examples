package unit.servicelayer.customer;

import datalayer.customer.CustomerStorage;
import dto.Customer;
import exceptions.CustomerServiceException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import servicelayer.customer.CustomerService;
import servicelayer.customer.CustomerServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GetCustomersByFirstNameTest {

    // SUT (System Under Test)
    private CustomerService customerService;

    // DOC (Depended-on Component)
    private CustomerStorage storageMock;


    @BeforeAll
    public void beforeAll(){
        storageMock = mock(CustomerStorage.class);
        customerService = new CustomerServiceImpl(storageMock);
    }

    @Test
    public void mustCallStorageWhenGetCustomersByFirstName() throws CustomerServiceException, SQLException {
        // Arrange
        var id = 1;
        var firstName = "a";
        var lastName = "b";
        var birthdate = new Date(123456789l);
        var phoneNumber = "+4512345";
        Customer c = new Customer(id, firstName, lastName, birthdate, phoneNumber);
        ArrayList<Customer> customersCollection = new ArrayList();
        customersCollection.add(c);
        customersCollection.add(c);

        // Act
        when(storageMock.getCustomersByFirstName(firstName))
                .thenReturn(customersCollection);
        Collection<Customer> customers = customerService.getCustomersByFirstName(firstName);

        // Assert
        assertEquals(customersCollection.size(), customers.size());

    }

}
