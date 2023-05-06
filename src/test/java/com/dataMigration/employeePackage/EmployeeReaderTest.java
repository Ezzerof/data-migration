package com.dataMigration.employeePackage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeReaderTest {

    /**
     * GIVEN .csv file with employees details
     * WHEN method starts
     * THEN it asks user to provide needed number of employees to retrieve
     * AND it parses all employees into a List of Strings
     */

    @Test
    @DisplayName("Test 10 Parsed Employees Into A String List")
    void test10ParsedEmployeesIntoAStringList() {
        List<String> employeesList;
        try {
            employeesList = EmployeeReader.getEmployees(10);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertEquals(10, employeesList.size());
    }

    @Test
    @DisplayName("Testing Invalid Input Number Of Employees Should Get An Error Message")
    void testingInvalidInputNumberOfEmployeesShouldGetAnErrorMessage() {

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> EmployeeReader.getEmployees(0));
        assertEquals("Argument Employees number must be between 1 and 10000", exception.getMessage());
    }

    @Test
    @DisplayName("Testing Invalid Input of Employees should get an exception")
    void testingInvalidInputOfEmployeesShouldGetAnException() {

        assertThrows(IllegalArgumentException.class, () -> {
            int numEmployees = 0;
            EmployeeReader.getEmployees(numEmployees);
        });

    }

}
