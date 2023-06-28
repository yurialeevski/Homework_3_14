package ru.skypro.homework.loggerprofiles.repository;

import ru.skypro.homework.loggerprofiles.pojo.Employee;

import java.io.IOException;
import java.util.List;

public interface EmployeeRepository {
    void addEmployee(Employee employee);
    Employee getById(int id);
    void updateById(int id, Employee employee);
    void deleteById(int id);
    List<Employee> getAllEmployees();

    /*int getSumSalary();
    int getMinSalary();
    int getMaxSalary();
    List<Employee> getHighSalary();
    List<Employee> getHigherThanSalary(Integer salary);
    void addListOf(List<Employee> employees);*/
}
