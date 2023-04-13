package com.dataMigration.employeePackage;

import java.util.HashMap;
import java.util.Map;

public class EmployeeRepositorySpy implements EmployeeRepository {

    Map<Integer, EmployeeDTO> employeesList = new HashMap<>();
    Map<Integer, EmployeeDTO> corruptedEmployeesList = new HashMap<>();


    @Override
    public void addEmployee(EmployeeDTO employee) {
        employeesList.put(employee.getEmpId(), employee);
    }

    @Override
    public void addCorruptedEmployee(EmployeeDTO employee) {
        corruptedEmployeesList.put(employee.getEmpId(), employee);
    }

    @Override
    public Map<Integer, EmployeeDTO> getAllEmployees() {
        return employeesList;
    }

    @Override
    public void removeEmployee(EmployeeDTO employee) {
        employeesList.remove(employee.getEmpId());
    }

    @Override
    public void removeCorruptedEmployee(EmployeeDTO employee) {
        corruptedEmployeesList.remove(employee.getEmpId());
    }

    @Override
    public EmployeeDTO getEmployee(int empId) {
        return employeesList.get(empId);
    }

    @Override
    public EmployeeDTO getCorruptedEmployee(int empId) {
        return corruptedEmployeesList.get(empId);
    }

    @Override
    public Map<Integer, EmployeeDTO> getAllCorruptedEmployees() {
        return corruptedEmployeesList;
    }

    @Override
    public int getSizeOfEmployeeList() {
        return employeesList.size();
    }

    @Override
    public int getSizeOfCorruptedList() {
        return corruptedEmployeesList.size();
    }

    @Override
    public EmployeeDTO searchByFirstLastNameAndEmailAddress(EmployeeDTO employeeDTO) {
        return employeeDTO;
    }

    @Override
    public EmployeeDTO searchByFirstLastNameAndEmailAddressForCorrupted(EmployeeDTO employeeDTO) {
        return employeeDTO;
    }
}
