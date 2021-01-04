package integration.datalayer.customer;

import com.github.javafaker.Faker;
import datalayer.customer.CustomerStorage;
import datalayer.customer.CustomerStorageImpl;
import dto.Customer;
import dto.CustomerCreation;
import integration.ContainerDBForIntegrationTests;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.SQLException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("integration")
class CustomerTest extends ContainerDBForIntegrationTests {
    private CustomerStorage customerStorage;

    @BeforeAll
    public void setup() throws SQLException {
        runMigration(4);

        customerStorage = new CustomerStorageImpl(getConnectionString(),"root", getDbPassword());

        var numCustomers = customerStorage.getCustomers().size();
        if (numCustomers < 100) {
            addFakeCustomers(100 - numCustomers);
        }
    }

    private void addFakeCustomers(int numCustomers) throws SQLException {
        Faker faker = new Faker();
        for (int i = 0; i < numCustomers; i++) {
            CustomerCreation c = new CustomerCreation(faker.name().firstName(), faker.name().lastName(), new Date(),"+4512345");
            customerStorage.createCustomer(c);
        }

    }

    @Test
    public void mustSaveCustomerInDatabaseWhenCallingCreateCustomer() throws SQLException {
        // Arrange
        var firstName = "Morten";
        var lastName = "Feldt";
        var birthdate = new Date(123456789l);
        var phoneNumber = "+4512345";
        CustomerCreation c = new CustomerCreation(firstName,lastName, birthdate, phoneNumber);

        // Act
        customerStorage.createCustomer(c);
        var customers = customerStorage.getCustomers();

        // Assert
        assertTrue(
                customers.stream().anyMatch(x ->
                        x.getFirstname().equals(firstName) &&
                        x.getLastname().equals(lastName)  &&
                        x.getPhoneNumber().equals(phoneNumber)));
    }

    @Test
    public void mustSaveCustomerInDatabaseWhenCallingCreateCustomerAndGetSameCustomerById() throws SQLException {
        // Arrange
        var firstName = "Morten";
        var lastName = "Feldt";
        var birthdate = new Date(123456789l);
        var phoneNumber = "+4512345";
        CustomerCreation c = new CustomerCreation(firstName,lastName, birthdate, phoneNumber);

        // Act
        var id = customerStorage.createCustomer(c);
        var customer = customerStorage.getCustomerWithId(id);

        // Assert
        assertEquals(id, customer.getId());
        assertEquals(firstName, customer.getFirstname());
        assertEquals(lastName, customer.getLastname());
        assertEquals(phoneNumber, customer.getPhoneNumber());
    }

    @Test
    public void mustSaveCustomerInDatabaseWhenCallingCreateCustomerAndGetSameCustomerByFirstname() throws SQLException {
        // Arrange
        var firstName = "Morten1";
        var lastName = "Feldt1";
        var birthdate = new Date(123456789l);
        var phoneNumber = "+4512345";
        CustomerCreation c = new CustomerCreation(firstName,lastName, birthdate, phoneNumber);

        // Act
        var id = customerStorage.createCustomer(c);
        var customers = customerStorage.getCustomersByFirstName(firstName);

        // Assert
        assertEquals(id, customers.get(0).getId());
        assertEquals(firstName, customers.get(0).getFirstname());
        assertEquals(lastName, customers.get(0).getLastname());
        assertEquals(phoneNumber, customers.get(0).getPhoneNumber());
    }

    @Test
    public void mustSaveCustomerInDatabaseWhenCallingCreateCustomerAndGetSameCustomerByFirstnameWithCollectionOfDummyData() throws SQLException {
        // Arrange
        var firstName = "Morten";
        var lastName = "Feldt";
        var birthdate = new Date(123456789l);
        var phoneNumber = "+4512345";
        CustomerCreation c = new CustomerCreation(firstName,lastName, birthdate, phoneNumber);

        // Act
        var id = customerStorage.createCustomer(c);
        var customers = customerStorage.getCustomersByFirstName(firstName);

        // Assert
        assertTrue(
                customers.stream().anyMatch(x ->
                        x.getId() == id &&
                                x.getFirstname().equals(firstName) &&
                                x.getLastname().equals(lastName)  &&
                                x.getPhoneNumber().equals(phoneNumber)));
    }
}
