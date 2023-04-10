package com.dataMigration.employeePackage;

import java.util.Map;

public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(String employees) {
        EmployeeDTO employeeDTO = EmployeeConverter.createEmployeeFromData(employees);
        if (isDuplicate(employeeDTO) || ValidationsUtil.isCorrupted(employeeDTO)) {
            addCorruptEmployee(employeeDTO);
        }
        employeeRepository.addEmployee(employeeDTO);
    }

    public void addCorruptEmployee(EmployeeDTO employeeDTO) {
        employeeRepository.addCorruptedEmployee(employeeDTO);
    }

    public boolean isDuplicate(EmployeeDTO employeeDTO) {
        if (employeeRepository.searchByFirstLastNameAndEmailAddress(employeeDTO) == null) {
            return false;
        }
        return true;
    }

    public Map<Integer, EmployeeDTO> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public Map<Integer, EmployeeDTO> getAllCorruptedEmployees() {
        return employeeRepository.getAllCorruptedEmployees();
    }

    public EmployeeDTO getEmployee(int empId) {
        return employeeRepository.getEmployee(empId);
    }

    public int getEmployeeListSize() {
        return employeeRepository.getSizeOfEmployeeList();
    }

}
