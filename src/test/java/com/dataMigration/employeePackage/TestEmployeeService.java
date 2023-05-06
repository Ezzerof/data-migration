package com.dataMigration.employeePackage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * GIVEN a List of Employees
 * WHEN method starts
 * THEN It should check for duplicates and invalid details
 * AND It should parse String to Employee Object
 * AND add employee to the corresponding Map
 */

@ExtendWith(MockitoExtension.class)
public class TestEmployeeService {
    @InjectMocks
    private static EmployeeService employeeService;
    @Mock
    private static EmployeeRepository employeeRepositoryMock;

    @Nested
    @DisplayName("Test add employees")
    class AddEmployees {
        @Test
        @DisplayName("Should add 2 employees when call addEmployee method")
        void should_Add2Employees_When_CallAddEmployeeMethod() {
            // given
            String employee1 = "19525,Mr.,Joe,M,Dan,F,dan@gmail.com,09/09/2020,18/11/2020,59999";
            String employee2 = "19526,Mr.,Andrew,M,Flower,F,dan@gmail.com,09/09/2021,18/11/2021,59999";
            doNothing().when(employeeRepositoryMock).addEmployee(any(EmployeeDTO.class));

            //when
            employeeService.addEmployee(employee1);
            employeeService.addEmployee(employee2);

            //then
            verify(employeeRepositoryMock, times(2)).addEmployee(any(EmployeeDTO.class));
        }

        @Test
        @DisplayName("Should add 2 corrupted employee when call add Corrupted Employee method")
        void should_Add2CorruptedEmployee_When_CallAddCorruptedEmployeeMethod() {
            //given
            EmployeeDTO corruptedEmployee = new EmployeeDTO(19525, "Mr.", "", "", "", Gender.MALE, "", LocalDate.now(), LocalDate.now(), 898596);
            doNothing().when(employeeRepositoryMock).addCorruptedEmployee(any(EmployeeDTO.class));

            //when
            employeeService.addCorruptEmployee(corruptedEmployee);

            //then
            verify(employeeRepositoryMock, times(1)).addCorruptedEmployee(any(EmployeeDTO.class));
        }

        @Test
        @DisplayName("should return 1 when get corrupted employees")
        void should_Return1_When_GetCorruptedEmployees() {
            // given
            when(employeeService.getAllCorruptedEmployees()).thenReturn(Collections.singletonMap(19525, new EmployeeDTO(19525, "Mr.", "", "", "", Gender.MALE, "", LocalDate.now(), LocalDate.now(), 898596)));
            int expected = 1;

            // when
            int actual = employeeService.getAllCorruptedEmployees().size();

            // then
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Should return 4 when get employees")
        void should_Return4_When_GetEmployees() {
            // given
            EmployeeDTO corruptedEmployee = new EmployeeDTO(19525, "Mr.", "", "", "", Gender.MALE, "", LocalDate.now(), LocalDate.now(), 898596);
            EmployeeDTO corruptedEmployee2 = new EmployeeDTO(19526, "Mrs.", "", "", "", Gender.MALE, "", LocalDate.now(), LocalDate.now(), 898596);
            EmployeeDTO corruptedEmployee3 = new EmployeeDTO(19527, "Mr.", "", "", "", Gender.MALE, "", LocalDate.now(), LocalDate.now(), 898596);
            EmployeeDTO corruptedEmployee4 = new EmployeeDTO(19528, "Mrs.", "", "", "", Gender.MALE, "", LocalDate.now(), LocalDate.now(), 898596);
            Map<Integer, EmployeeDTO> map = Map.of(corruptedEmployee.getEmpId(), corruptedEmployee, corruptedEmployee2.getEmpId(), corruptedEmployee2, corruptedEmployee3.getEmpId(), corruptedEmployee3, corruptedEmployee4.getEmpId(), corruptedEmployee4);

            when(employeeService.getAllCorruptedEmployees()).thenReturn(map);
            int expected = 4;

            // when
            int actual = employeeService.getAllCorruptedEmployees().size();

            // then
            assertEquals(expected, actual);
        }
    }

}
