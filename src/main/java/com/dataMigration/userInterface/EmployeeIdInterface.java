package com.dataMigration.userInterface;

import com.dataMigration.employeePackage.ValidationsUtil;

import java.util.Scanner;

public class EmployeeIdInterface {

    public static int getEmployeeId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPlease enter employee's ID: ");

        String empId = scanner.next();
        return ValidationsUtil.isIntCorrupted(empId);
    }

}
