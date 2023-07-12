package com.dataMigration.employeePackage;

import java.util.HashMap;
import java.util.Map;

public class EmploymentRepositoryImplementation implements EmployeeRepository {

    private static Map<Integer, EmployeeDTO> corruptedEmpMap = null;
    private static Map<Integer, EmployeeDTO> cleanEmpMap = null;

    public EmploymentRepositoryImplementation() {
        corruptedEmpMap = new HashMap<>();
        cleanEmpMap = new HashMap<>();
    }

    @Override
    public EmployeeDTO searchByFirstLastNameAndEmailAddress(EmployeeDTO employeeDTO) {
        for (Integer key : EmploymentRepositoryImplementation.cleanEmpMap.keySet()) {
            EmployeeDTO temployee = EmploymentRepositoryImplementation.cleanEmpMap.get(key);

            if (employeeDTO.getEmpId() == temployee.getEmpId()
                    || (employeeDTO.getFirstName().equals(temployee.getFirstName())
                    && employeeDTO.getLastName().equals(temployee.getLastName())
                    && employeeDTO.getEmailAddress().equals(temployee.getEmailAddress()))
            ) {
                return employeeDTO;
            }
        }
        return null;
    }

    public EmployeeDTO searchByFirstLastNameAndEmailAddressForCorrupted(EmployeeDTO employeeDTO) {
        for (Integer key : EmploymentRepositoryImplementation.corruptedEmpMap.keySet()) {
            EmployeeDTO temployee = EmploymentRepositoryImplementation.corruptedEmpMap.get(key);

            if (employeeDTO.getEmpId() == temployee.getEmpId()
                    || (employeeDTO.getFirstName().equals(temployee.getFirstName())
                    && employeeDTO.getLastName().equals(temployee.getLastName())
                    && employeeDTO.getEmailAddress().equals(temployee.getEmailAddress()))
            ) {
                return employeeDTO;
            }
        }
        return null;
    }

    @Override
    public void addEmployee(EmployeeDTO employee) {
        cleanEmpMap.put(employee.getEmpId(), employee);
    }

    @Override
    public void addCorruptedEmployee(EmployeeDTO employee) {
        corruptedEmpMap.put(employee.getEmpId(), employee);
    }

    @Override
    public Map<Integer, EmployeeDTO> getAllEmployees() {
        return cleanEmpMap;
    }

    public Map<Integer, EmployeeDTO> getAllCorruptedEmployees() {
        return corruptedEmpMap;
    }

    @Override
    public void removeEmployee(EmployeeDTO employee) {
        cleanEmpMap.remove(employee.getEmpId());
    }

    @Override
    public void removeCorruptedEmployee(EmployeeDTO employee) {
        corruptedEmpMap.remove(employee.getEmpId());
    }

    @Override
    public EmployeeDTO getEmployee(int empId) {
        return cleanEmpMap.get(empId);
    }
    @Override
    public EmployeeDTO getCorruptedEmployee(int emId) {
        return corruptedEmpMap.get(emId);
    }

    @Override
    public int getSizeOfEmployeeList() {
        return cleanEmpMap.size();
    }

    @Override
    public int getSizeOfCorruptedList() {
        return corruptedEmpMap.size();
    }
}




