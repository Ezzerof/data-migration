package com.dataMigration.database;

import com.dataMigration.employeePackage.EmployeeDTO;

import java.util.List;

public class EmployeeDAO implements DAO<EmployeeDTO> {

    private static final String insertNewEmployee = "INSERT INTO employees (emp_id, name_prefix, first_name, middle_name, last_name, gender, email_address, birth_date, start_date, salary) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String selectAllEmployees = "SELECT * FROM employees";
    private static final String deleteEmployee = "DELETE FROM employees WHERE id=?";
    private static final String selectAEmployee = "SELECT * FROM employees WHERE id=?";
    private static final String updateEmployee = "UPDATE employees SET name_prefix =?, first_name=?, middle_name=?, last_name=?, gender=?, email_address=?, birth_date=?, start_date=?, salary=? WHERE id=?";

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void updated(EmployeeDTO update) {

    }

    @Override
    public int insert(EmployeeDTO newRow) {
        return 0;
    }

    @Override
    public EmployeeDTO findById(int id) {
        return null;
    }

    @Override
    public List<EmployeeDTO> findAll() {
        return null;
    }
}
