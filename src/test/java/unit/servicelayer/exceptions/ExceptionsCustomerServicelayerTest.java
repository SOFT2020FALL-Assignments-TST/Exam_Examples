package unit.servicelayer.exceptions;

import datalayer.customer.CustomerStorage;
import dto.CustomerCreation;
import exceptions.CustomerServiceException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import servicelayer.customer.CustomerService;
import servicelayer.customer.CustomerServiceImpl;

import java.sql.SQLException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ExceptionsCustomerServicelayerTest {

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
    public void mustCatchSQLExceptionWhenCreateCustomer() throws SQLException {
        // Arrange
        var firstName = "a";
        var lastName = "b";
        var birthdate = new Date(123456789l);
        var phoneNumber = "+4512345";

        // Act
        when(storageMock.createCustomer(any()))
                .thenThrow(SQLException.class);

        // Assert
        assertThrows(CustomerServiceException.class, () -> {
            customerService.createCustomer(firstName, lastName, birthdate, phoneNumber);
        });
    }

    @Test
    public void mustCatchSQLExceptionWhenGetCustomerById() throws SQLException {
        // Arrange
        var id = 1;

        // Act
        when(storageMock.getCustomerWithId(id))
                .thenThrow(SQLException.class);

        // Assert
        assertThrows(CustomerServiceException.class, () -> {
            customerService.getCustomerById(id);
        });
    }

    @Test
    public void mustCatchSQLExceptionWhenGetCustomersByFirstname() throws SQLException {
        // Arrange
        var firstName = "a";

        // Act
        when(storageMock.getCustomersByFirstName(firstName))
                .thenThrow(SQLException.class);

        // Assert
        assertThrows(CustomerServiceException.class, () -> {
            customerService.getCustomersByFirstName(firstName);
        });

    }
}
