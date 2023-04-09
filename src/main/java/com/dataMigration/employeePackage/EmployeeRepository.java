package com.dataMigration.employeePackage;

import java.util.Map;

public interface EmployeeRepository {

    void addEmployee(EmployeeDTO employee);
    Map<Integer, EmployeeDTO> getAllEmployees();

    void removeEmployee(EmployeeDTO employee);

    EmployeeDTO getEmployee(int empId);

    int getSizeOfEmployeeList();

}
