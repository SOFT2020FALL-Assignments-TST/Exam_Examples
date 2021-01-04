package unit.datalayer.exceptions;

import datalayer.customer.CustomerStorage;
import dto.CustomerCreation;
import exceptions.CustomerServiceException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import servicelayer.customer.CustomerServiceImpl;

import java.sql.SQLException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ExceptionsCustomerDatalayerTest {

    private CustomerStorage storageMock;

    @BeforeAll
    public void beforeAll(){
        storageMock = mock(CustomerStorage.class);
    }

    @Test
    public void mustCatchSQLExceptionWhenCreateCustomer() throws SQLException {
        // Arrange
        var firstName = "Morten";
        var lastName = "Feldt";
        var birthdate = new Date(123456789l);
        var phoneNumber = "+4512345";
        CustomerCreation c = new CustomerCreation(firstName,lastName, birthdate, phoneNumber);

        // Act
        when(storageMock.createCustomer(c))
                .thenThrow(SQLException.class);

        // Assert
        assertThrows(SQLException.class, () -> {
            storageMock.createCustomer(c);
        });
    }

    @Test
    public void mustCatchSQLExceptionWhenGetCustomerWithId() throws SQLException {
        // Arrange
        var id = 1;

        // Act
        when(storageMock.getCustomerWithId(id))
                .thenThrow(SQLException.class);

        // Assert
        assertThrows(SQLException.class, () -> {
            storageMock.getCustomerWithId(id);
        });
    }

    @Test
    public void mustCatchSQLExceptionWhenGetCustomersByFirstname() throws SQLException {
        // Arrange
        var firstName = "Morten";

        // Act
        when(storageMock.getCustomersByFirstName(firstName))
                .thenThrow(SQLException.class);

        // Assert
        assertThrows(SQLException.class, () -> {
            storageMock.getCustomersByFirstName(firstName);
        });
    }

    @Test
    public void mustCatchSQLExceptionWhenGetCustomers() throws SQLException {
        // Arrange
        // Act
        when(storageMock.getCustomers())
                .thenThrow(SQLException.class);

        // Assert
        assertThrows(SQLException.class, () -> {
            storageMock.getCustomers();
        });
    }
}
