package com.dataMigration.employeePackage;

import java.util.Map;

public interface EmployeeRepository {

    void addEmployee(EmployeeDTO employee);

    void addCorruptedEmployee(EmployeeDTO employeeDTO);

    Map<Integer, EmployeeDTO> getAllEmployees();

    void removeEmployee(EmployeeDTO employee);

    void removeCorruptedEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployee(int empId);

    EmployeeDTO getCorruptedEmployee(int empId);

    Map<Integer, EmployeeDTO> getAllCorruptedEmployees();

    int getSizeOfEmployeeList();

    int getSizeOfCorruptedList();

    EmployeeDTO searchByFirstLastNameAndEmailAddress(EmployeeDTO employeeDTO);
    EmployeeDTO searchByFirstLastNameAndEmailAddressForCorrupted(EmployeeDTO employeeDTO);

}
