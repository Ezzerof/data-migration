package com.dataMigration.validators;

import com.dataMigration.employeePackage.EmployeeDTO;

public interface NullChecker {

    static boolean isNull(EmployeeDTO employeeDTO) {
        if (employeeDTO.getEmpId() == 0 || employeeDTO.getPrefixName() == null
                || employeeDTO.getFirstName() == null || employeeDTO.getMiddleName() == null
                || employeeDTO.getLastName() == null || employeeDTO.getGender() == null
                || employeeDTO.getEmailAddress() == null || employeeDTO.getSalary() == 0 )
        {
            return true;
        }
        return false;
    }


}
