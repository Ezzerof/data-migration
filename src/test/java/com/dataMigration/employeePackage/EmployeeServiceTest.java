package com.dataMigration.employeePackage;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

/**
 * GIVEN a List of Employees
 * WHEN method starts
 * THEN It should check for duplicates and invalid details
 * AND It should parse String to Employee Object
 * AND add employee to the corresponding Map
 */

public class EmployeeServiceTest {

    private EmployeeDTO employee1;
    private EmployeeDTO employee2;
    private EmployeeDTO employee3;
    private EmployeeDTO employee4;
    private static EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
    private static EmployeeRepositoryMock employeeRepositorySpy;
    private static EmployeeService employeeService;
    @BeforeAll
     static void setup() {
        employeeRepositorySpy = new EmployeeRepositoryMock();
        employeeService = new EmployeeService(employeeRepository);
    }

    @BeforeEach
    @DisplayName("Creating objects")
    void init() {
        employee1 = new EmployeeDTO(19525, "Mr.", "", "", "", Gender.MALE, "", LocalDate.now(), LocalDate.now(), 898596);
        employee2 = new EmployeeDTO(19523, "Mr.", "", "", "", Gender.MALE, "", LocalDate.now(), LocalDate.now(), 898596);
        employee3 = new EmployeeDTO(19524, "Mr.", "", "", "", Gender.MALE, "", LocalDate.now(), LocalDate.now(), 898596);
        employee4 = new EmployeeDTO(19522, "Mr.", "", "", "", Gender.MALE, "", LocalDate.now(), LocalDate.now(), 898596);
    }


    @Test
    @DisplayName("Testing Adding Employees To The Map Size Should Be 4")
    void testingAddingEmployeesToTheMapSizeShouldBe5() {

        String employee1 = "19525,Mr.,Joe,M,Dan,F,dan@gmail.com,09/09/2020,18/11/2020,59999";
        String employee2 = "19524,Mr.,Joe,M,Andrew,F,dan@gmail.com,09/09/2020,18/11/2020,59999";
        String employee3 = "19523,Mr.,Joe,M,John,F,dan@gmail.com,09/09/2020,18/11/2020,59999";
        String employee4 = "19521,Mr.,Joe,M,Emil,F,dan@gmail.com,09/09/2020,18/11/2020,59999";

        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);
        employeeService.addEmployee(employee3);
        employeeService.addEmployee(employee4);

        assertEquals(4, employeeService.getEmployeeListSize());
    }

    @Test
    @DisplayName("Testing if duplicates Id is changed")
    void testingIfDuplicatesIdIsChanged() {

        String employee1 = "19525,Mr.,Joe,M,Dan,F,dan@gmail.com,09/09/2020,18/11/2020,59999";
        String employee2 = "19525,Mr.,Joe,M,Andrew,F,dan@gmail.com,09/09/2020,18/11/2020,59999";
        String employee3 = "19525,Mr.,Joe,M,Andrew,F,dan@gmail.com,09/09/2020,18/11/2020,59999";

        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);
        employeeService.addEmployee(employee3);

        Assertions.assertNotEquals(employeeService.getCorruptedEmployee(19525), employeeService.getCorruptedEmployee(19526));
    }

    // Will run with Repo Mock!
    @Test
    @DisplayName("Should Return Corrupted Map size of 1")
    void should_ReturnCorruptedMapSizeOf1() {
        // given
        when(this.employeeService.getAllCorruptedEmployees()).thenReturn(Collections.singletonMap(19525, new EmployeeDTO(19525, "Mr.", "", "", "", Gender.MALE, "", LocalDate.now(), LocalDate.now(), 898596)));
        int expected = 1;

        // when
        int actual = employeeService.getAllCorruptedEmployees().size();

        // then
        assertEquals(expected, actual);
    }

    // Will run with Repo Mock!

    @Test
    @DisplayName("Testing Adding Corrupted Employees To The Corrupted Map Size Should Be 4")
    void testingAddingCorruptedEmployeesToTheCorruptedMapSizeShouldBe4() {
        // given
        Map<Integer, EmployeeDTO> map = Map.of(employee1.getEmpId(), employee1, employee2.getEmpId(), employee2, employee3.getEmpId(), employee3, employee4.getEmpId(), employee4);

        when(this.employeeService.getAllCorruptedEmployees()).thenReturn(map);
        int expected = 4;

        // when
        int actual = employeeService.getAllCorruptedEmployees().size();

        // then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Getting A Corrupted Employee From Repository")
    void gettingACorruptedEmployeeFromRepository() {

        employeeService.addCorruptEmployee(employee1);
        employeeService.addCorruptEmployee(employee2);
        employeeService.addCorruptEmployee(employee3);

        assertEquals(employee1, employeeRepositorySpy.getCorruptedEmployee(19525));
    }

    @Test
    @DisplayName("Getting An Employee From Repository")
    void gettingAnEmployeeFromRepository() {

        String employee1 = "19525,Mr.,Joe,M,Dan,F,dan@gmail.com,09/09/2020,18/11/2020,59999";
        String employee2 = "19523,Mr.,Joe,M,Andrew,F,dan@gmail.com,09/09/2020,18/11/2020,59999";
        String employee3 = "19524,Mr.,Joe,M,John,F,dan@gmail.com,09/09/2020,18/11/2020,59999";
        String employee4 = "19521,Mr.,Joe,M,Emil,F,dan@gmail.com,09/09/2020,18/11/2020,59999";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Employee is has same value like employee2, done because of .toString() method
        EmployeeDTO employee = new EmployeeDTO(19523, "Mr.", "Joe", "M", "Andrew", Gender.valueOf('F'), "dan@gmail.com", LocalDate.parse("09/09/2020", formatter), LocalDate.parse("18/11/2020", formatter), 59999);

        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);
        employeeService.addEmployee(employee3);
        employeeService.addEmployee(employee4);

        assertEquals(employee.toString(), employeeService.getEmployee(19523).toString());
    }

    @Test
    @DisplayName("Find Duplicate Employee")
    void findDuplicateEmployee() {

        employeeService.addCorruptEmployee(employee1);
        employeeService.addCorruptEmployee(employee1);
        employeeService.addCorruptEmployee(employee1);
        employeeService.addCorruptEmployee(employee2);

        assertEquals(employee1, employeeService.getCorruptedEmployee(employee1.getEmpId()));
    }

    @Test
    @DisplayName("Testing if we will get all employees after insertion by checking the size")
    void testingIfWeWillGetAllEmployeesAfterInsertionByCheckingTheSize() {

        String employee1 = "19525,Mr.,Joe,M,Dan,F,dan@gmail.com,09/09/2020,18/11/2020,59999";
        String employee2 = "19523,Mr.,Joe,M,Andrew,F,dan@gmail.com,09/09/2020,18/11/2020,59999";
        String employee3 = "19524,Mr.,Joe,M,John,F,dan@gmail.com,09/09/2020,18/11/2020,59999";

        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);
        employeeService.addEmployee(employee3);

        assertEquals(3,employeeService.getAllEmployees().size());
    }

    @Test
    @DisplayName("Testing if we will get all Corrupted employees after insertion by checking the size")
    void testingIfWeWillGetAllCorruptedEmployeesAfterInsertionByCheckingTheSize() {

        employeeService.addCorruptEmployee(employee1);
        employeeService.addCorruptEmployee(employee2);
        employeeService.addCorruptEmployee(employee3);
        employeeService.addCorruptEmployee(employee4);

        assertEquals(4,employeeService.getAllCorruptedEmployees().size());
    }
}
