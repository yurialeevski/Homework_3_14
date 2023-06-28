package ru.skypro.homework.loggerprofiles.service;


import ru.skypro.homework.loggerprofiles.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);
    Employee getEmployeeById(int id);
    void updateEmployeeById(int id, Employee employee);
    void deleteEmployeeById(int id);
    List<Employee> getAllEmployees();

    //int getSumEmployeeSalary();
    //int getMinEmployeeSalary();
    //int getMaxEmployeeSalary();
    //List<Employee> getHighSalaryEmployees();
    //List<Employee> getHigherThanSalaryEmployees(Integer salary);
    //void addListOfEmployees(List<Employee> employees);
}

