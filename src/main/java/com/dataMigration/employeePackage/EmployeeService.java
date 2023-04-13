package com.dataMigration.employeePackage;

import java.util.Map;

public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(String employees) {
        EmployeeDTO employeeDTO = EmployeeConverter.createEmployeeFromData(employees);

        if (ValidationsUtil.isCorrupted(employeeDTO) || isDuplicate(employeeDTO)) {

            while (isDuplicateInCorruptedMap(employeeDTO)) {
                employeeDTO.setEmpId(employeeDTO.getEmpId() + 1);
            }
            addCorruptEmployee(employeeDTO);
        } else {
            employeeRepository.addEmployee(employeeDTO);
        }
    }

    public void addCorruptEmployee(EmployeeDTO employeeDTO) {
        employeeRepository.addCorruptedEmployee(employeeDTO);
    }

    public boolean isDuplicate(EmployeeDTO employeeDTO) {
        return employeeRepository.searchByFirstLastNameAndEmailAddress(employeeDTO) != null;
    }

    public boolean isDuplicateInCorruptedMap(EmployeeDTO employeeDTO) {
        return employeeRepository.searchByFirstLastNameAndEmailAddressForCorrupted(employeeDTO) != null;
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

    public EmployeeDTO getCorruptedEmployee(int empId){
        return employeeRepository.getCorruptedEmployee(empId);
    }

    public int getEmployeeListSize() {
        return employeeRepository.getSizeOfEmployeeList();
    }

}
