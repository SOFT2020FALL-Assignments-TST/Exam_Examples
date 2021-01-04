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
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GetCustomerByIdTest {

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
    public void mustCallStorageWhenGetCustomerById() throws CustomerServiceException, SQLException {
        // Arrange
        var id = 1;
        var firstName = "a";
        var lastName = "b";
        var birthdate = new Date(123456789l);
        var phoneNumber = "+4512345";

        // Act
        when(storageMock.getCustomerWithId(1))
                .thenReturn(new Customer(id, firstName, lastName, birthdate, phoneNumber));
        Customer c = customerService.getCustomerById(id);

        // Assert
        assertEquals(c.getFirstname(), firstName);
        assertEquals(c.getLastname(), lastName);
        assertEquals(c.getBirthDate(), birthdate);
        assertEquals(c.getPhoneNumber(), phoneNumber);
    }

}
