package com.dataMigration.employeePackage;

import com.dataMigration.validators.NullChecker;

import java.util.HashMap;
import java.util.Map;

public class EmploymentRepositoryImplementation implements EmployeeRepository {

    private static Map<Integer, EmployeeDTO> corruptedList = null;
    private static Map<Integer, EmployeeDTO> employmeeList = null;

    private EmploymentRepositoryImplementation() {

    }

    public static Map<Integer, EmployeeDTO> getCorruptedList() {
        if (corruptedList == null) {
            corruptedList = new HashMap<>();
        }
        return corruptedList;
    }

    public static Map<Integer, EmployeeDTO> getEmployeeList() {
        if (employmeeList == null) {
            employmeeList = new HashMap<>();
        }
        return employmeeList;
    }

    public boolean isCorrupted(EmployeeDTO employee) {
        if (NullChecker.isNull(employee) || DuplicateChecker.isDuplicate(employee))
            return true;
        else
            return false;
    }

    @Override
    public void addEmployee(EmployeeDTO employee) {
        if (isCorrupted(employee)) {
            corruptedList.put(employee.getEmpId(), employee);
        }
        employmeeList.put(employee.getEmpId(), employee);
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
        employmeeList.remove(employee.getEmpId());
    }

    public void removeCorruptedEmployee(EmployeeDTO employee) {
        corruptedList.remove(employee.getEmpId());
    }

    @Override
    public EmployeeDTO getEmployee(int empId) {
        return employmeeList.get(empId);
    }

    public EmployeeDTO getCorruptedEmployee(int emId) {
        return corruptedList.get(emId);
    }

    @Override
    public int getSizeOfEmployeeList() {
        return getEmployeeList().size();
    }

    public int getSizeOfCorruptedList() {
        return getCorruptedList().size();
    }
}




