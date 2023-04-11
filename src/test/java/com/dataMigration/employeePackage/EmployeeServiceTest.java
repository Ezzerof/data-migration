package com.dataMigration.employeePackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

/**
 * GIVEN a List of Employees
 * WHEN method starts
 * THEN It should check for duplicates and invalid details
 * AND It should parse String to Employee Object
 * AND add employee to the corresponding Map
 */

public class EmployeeServiceTest {

    @Test
    @DisplayName("TestingAddingEmployeesToTheMapSizeShouldBe4")
    void testingAddingEmployeesToTheMapSizeShouldBe5() {

        EmployeeRepositorySpy employeeRepositorySpy = new EmployeeRepositorySpy();
        EmployeeService employeeService = new EmployeeService(employeeRepositorySpy);

        EmployeeDTO employeeDTO = new EmployeeDTO(19525, "Mr.", "", "", "", Gender.MALE, "", LocalDate.now(), LocalDate.now(), 898596);
        EmployeeDTO employeeDTO2 = new EmployeeDTO(19523, "Mr.", "", "", "", Gender.MALE, "", LocalDate.now(), LocalDate.now(), 898596);
        EmployeeDTO employeeDTO3 = new EmployeeDTO(19524, "Mr.", "", "", "", Gender.MALE, "", LocalDate.now(), LocalDate.now(), 898596);
        EmployeeDTO employeeDTO4 = new EmployeeDTO(19522, "Mr.", "", "", "", Gender.MALE, "", LocalDate.now(), LocalDate.now(), 898596);


        employeeRepositorySpy.addEmployee(employeeDTO);
        employeeRepositorySpy.addEmployee(employeeDTO2);
        employeeRepositorySpy.addEmployee(employeeDTO3);
        employeeRepositorySpy.addEmployee(employeeDTO4);


        Assertions.assertEquals(4, employeeRepositorySpy.getSizeOfEmployeeList());
    }

    @Test
    @DisplayName("TestingAddingCorruptedEmployeesToTheCorruptedMapSizeShouldBe4")
    void testingAddingCorruptedEmployeesToTheCorruptedMapSizeShouldBe4() {
        EmployeeRepositorySpy employeeRepositorySpy = new EmployeeRepositorySpy();
        EmployeeService employeeService = new EmployeeService(employeeRepositorySpy);

        EmployeeDTO employeeDTO = new EmployeeDTO(19525, "Mr.", "", "", "", Gender.MALE, "", LocalDate.now(), LocalDate.now(), 898596);
        EmployeeDTO employeeDTO2 = new EmployeeDTO(19523, "Mr.", "", "", "", Gender.MALE, "", LocalDate.now(), LocalDate.now(), 898596);
        EmployeeDTO employeeDTO3 = new EmployeeDTO(19524, "Mr.", "", "", "", Gender.MALE, "", LocalDate.now(), LocalDate.now(), 898596);
        EmployeeDTO employeeDTO4 = new EmployeeDTO(19522, "Mr.", "", "", "", Gender.MALE, "", LocalDate.now(), LocalDate.now(), 898596);

        employeeService.addCorruptEmployee(employeeDTO);
        employeeService.addCorruptEmployee(employeeDTO2);
        employeeService.addCorruptEmployee(employeeDTO3);
        employeeService.addCorruptEmployee(employeeDTO4);


        Assertions.assertEquals(4, employeeRepositorySpy.getSizeOfCorruptedList());
    }

    @Test
    @DisplayName("GettingAnEmployeeFromRepository")
    void gettingAnEmployeeFromRepository() {
        EmployeeRepositorySpy employeeRepositorySpy = new EmployeeRepositorySpy();
        EmployeeService employeeService = new EmployeeService(employeeRepositorySpy);

        EmployeeDTO employeeDTO = new EmployeeDTO(19525, "Mr.", "", "", "", Gender.MALE, "", LocalDate.now(), LocalDate.now(), 898596);
        EmployeeDTO employeeDTO2 = new EmployeeDTO(19523, "Mr.", "", "", "", Gender.MALE, "", LocalDate.now(), LocalDate.now(), 898596);
        EmployeeDTO employeeDTO3 = new EmployeeDTO(19524, "Mr.", "", "", "", Gender.MALE, "", LocalDate.now(), LocalDate.now(), 898596);

        employeeService.addCorruptEmployee(employeeDTO);
        employeeService.addCorruptEmployee(employeeDTO2);
        employeeService.addCorruptEmployee(employeeDTO3);

        Assertions.assertEquals(employeeDTO,employeeRepositorySpy.getCorruptedEmployee(19525));
    }

    @Test
    @DisplayName("FindDuplicateEmployee")
    void findDuplicateEmployee() {
        EmployeeRepositorySpy employeeRepositorySpy = new EmployeeRepositorySpy();
        EmployeeService employeeService = new EmployeeService(employeeRepositorySpy);

        EmployeeDTO employeeDTO = new EmployeeDTO(19525, "Mr.", "Dan", "", "Flow", Gender.MALE, "serafina.bumgarner@exxonmobil.com", LocalDate.now(), LocalDate.now(), 898596);
        EmployeeDTO employeeDTO2 = new EmployeeDTO(19523, "Mr.", "Dan", "", "Flow", Gender.MALE, "serafina.bumgarner@exxonmobil.com", LocalDate.now(), LocalDate.now(), 898596);

        employeeService.addCorruptEmployee(employeeDTO);
        employeeService.addCorruptEmployee(employeeDTO2);

        Assertions.assertEquals(employeeDTO, employeeRepositorySpy.searchByFirstLastNameAndEmailAddress(employeeDTO));
    }

}
