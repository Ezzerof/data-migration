package com.dataMigration.employeePackage;

import java.util.Map;

public class EmployeeService {

    private static EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(String employees) {
        EmployeeDTO employeeDTO = EmployeeConverter.createEmployeeFromData(employees);
        employeeRepository.addEmployee(employeeDTO);
    }

    public boolean isDuplicate(EmployeeDTO employeeDTO) {
        for (Integer key : EmploymentRepositoryImplementation.getEmployeeList().keySet()) {
            EmployeeDTO temployee = EmploymentRepositoryImplementation.getEmployeeList().get(key);

            if (employeeDTO.getFirstName().equals(temployee.getFirstName())
                    && employeeDTO.getLastName().equals(temployee.getLastName())
                    && employeeDTO.getEmailAddress().equals(temployee.getEmailAddress())
            ){
                return true;
            }
        }
        return false;
    }

    public boolean isCorrupted(EmployeeDTO employee) {

        if (employee.getEmpId() == 0 || employee.getPrefixName() == null
                || employee.getFirstName() == null || employee.getMiddleName() == null
                || employee.getLastName() == null || employee.getGender() == null
                || employee.getEmailAddress() == null || employee.getSalary() == 0) {
            return true;
        }

        return false;
    }

    public Map<Integer, EmployeeDTO> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public EmployeeDTO getEmployee(int empId) {
        return employeeRepository.getEmployee(empId);
    }

    public int getEmployeeListSize() {
        return employeeRepository.getSizeOfEmployeeList();
    }

}
