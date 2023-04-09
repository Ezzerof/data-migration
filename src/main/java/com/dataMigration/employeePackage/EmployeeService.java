package com.dataMigration.employeePackage;

import java.util.Map;

public class EmployeeService {

    private static EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public static void addEmployee(String employees) {
        EmployeeDTO employeeDTO = EmployeeConverter.createEmployeeFromData(employees);
        employeeRepository.addEmployee(employeeDTO);
    }

    public static Map<Integer, EmployeeDTO> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public static EmployeeDTO getEmployee(int empId) {
        return employeeRepository.getEmployee(empId);
    }
    public static int getEmployeeListSize() {
        return employeeRepository.getSizeOfEmployeeList();
    }

}
