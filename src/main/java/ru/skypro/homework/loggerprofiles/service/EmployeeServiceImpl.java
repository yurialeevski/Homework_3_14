package ru.skypro.homework.loggerprofiles.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.skypro.homework.loggerprofiles.pojo.Employee;
import ru.skypro.homework.loggerprofiles.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    public static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class.getName());

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void addEmployee(Employee employee) {
        logger.info("Вызван метод Добавить сотрудника: " + employee);
        employeeRepository.addEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        logger.info("Вызван метод Получить сотрудника по id = " + id);
        return employeeRepository.getById(id);
    }

    @Override
    public void updateEmployeeById(int id, Employee employee) {
        logger.info("Вызван метод Изменить сотрудника по id = " + id + " новые данные: " + employee);
            employeeRepository.updateById(id, employee);
    }

    @Override
    public void deleteEmployeeById(int id) {
        logger.info("Вызван метод Удалить сотрудника по id = " + id );
        employeeRepository.deleteById(id);
    }

    public List<Employee> getAllEmployees() {
        logger.info("Вызван метод Получить всех сотрудников");
        return employeeRepository.getAllEmployees();
    }

        /*@Override
    public int getSumEmployeeSalary() {
        return employeeRepository.getSumSalary();
    }
    @Override
    public int getMinEmployeeSalary() {
        return employeeRepository.getMinSalary();
    }
    @Override
    public int getMaxEmployeeSalary() {
        return employeeRepository.getMaxSalary();
    }
    @Override
    public List<Employee> getHighSalaryEmployees() {
        return employeeRepository.getHighSalary();
    }

    @Override
    public List<Employee> getHigherThanSalaryEmployees(Integer salary) {
        return employeeRepository.getHigherThanSalary(salary);
    }

    @Override
    public void addListOfEmployees(List<Employee> employees) {
        employeeRepository.addListOf(employees);
    }
    */
}
