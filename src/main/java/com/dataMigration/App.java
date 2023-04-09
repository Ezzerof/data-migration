package com.dataMigration;

import com.dataMigration.employeePackage.*;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            List<String> listOfEmps = EmployeeReader.getEmployees(2000);
            EmployeeRepository employeeRepository = new EmploymentRepositoryImplementation();
            EmployeeService employeeService = new EmployeeService(employeeRepository);

            for (String emp: listOfEmps) {
                employeeService.addEmployee(emp);
            }

            System.out.println(employeeService.getAllEmployees());
            System.out.println("============================================================");
            System.out.println("Corrupted list" + employeeService.getAllCorruptedEmployees());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
