package com.dataMigration.employeePackage;

public interface DuplicateChecker {

    static boolean isDuplicate(EmployeeDTO employeeDTO) {
        for (Integer key : EmployeeService.getAllEmployees().keySet()) {
            EmployeeDTO temployee = EmployeeService.getAllEmployees().get(key);

            if (employeeDTO.getFirstName().equals(temployee.getFirstName())
                    && employeeDTO.getLastName().equals(temployee.getLastName())
                    && employeeDTO.getEmailAddress().equals(temployee.getEmailAddress())
            ){
                return true;
            }
        }
        return false;
    }

}
