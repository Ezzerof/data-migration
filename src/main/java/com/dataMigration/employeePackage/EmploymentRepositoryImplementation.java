package com.dataMigration.employeePackage;

import java.util.HashMap;
import java.util.Map;

public class EmploymentRepositoryImplementation implements EmployeeRepository {

    private static Map<Integer, EmployeeDTO> corruptedList = null;
    private static Map<Integer, EmployeeDTO> employeesList = null;

    public EmploymentRepositoryImplementation() {
        corruptedList = new HashMap<>();
        employeesList = new HashMap<>();
    }

    public static Map<Integer, EmployeeDTO> getCorruptedList() {
        return corruptedList;
    }

    public static Map<Integer, EmployeeDTO> getEmployeeList() {

        return employeesList;
    }

    @Override
    public EmployeeDTO searchByFirstLastNameAndEmailAddress(EmployeeDTO employeeDTO) {
        for (Integer key : EmploymentRepositoryImplementation.getEmployeeList().keySet()) {
            EmployeeDTO temployee = EmploymentRepositoryImplementation.getEmployeeList().get(key);

            if (employeeDTO.getFirstName().equals(temployee.getFirstName())
                    && employeeDTO.getLastName().equals(temployee.getLastName())
                    && employeeDTO.getEmailAddress().equals(temployee.getEmailAddress())
            ){
                return employeeDTO;
            }
        }

        return null;
    }

    @Override
    public void addEmployee(EmployeeDTO employee) {
        employeesList.put(employee.getEmpId(), employee);
    }
    @Override
    public void addCorruptedEmployee(EmployeeDTO employee) {
        corruptedList.put(employee.getEmpId(), employee);
    }
    @Override
    public Map<Integer, EmployeeDTO> getAllEmployees() {
        return getEmployeeList();
    }

    public Map<Integer, EmployeeDTO> getAllCorruptedEmployees() {
        return getCorruptedList();
    }

    @Override
    public void removeEmployee(EmployeeDTO employee) {
        employeesList.remove(employee.getEmpId());
    }
    @Override
    public void removeCorruptedEmployee(EmployeeDTO employee) {
        corruptedList.remove(employee.getEmpId());
    }

    @Override
    public EmployeeDTO getEmployee(int empId) {
        return employeesList.get(empId);
    }
    @Override
    public EmployeeDTO getCorruptedEmployee(int emId) {
        return corruptedList.get(emId);
    }

    @Override
    public int getSizeOfEmployeeList() {
        return getEmployeeList().size();
    }
    @Override
    public int getSizeOfCorruptedList() {
        return getCorruptedList().size();
    }
}




