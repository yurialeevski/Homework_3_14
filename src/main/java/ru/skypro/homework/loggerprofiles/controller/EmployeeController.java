package ru.skypro.homework.loggerprofiles.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.skypro.homework.loggerprofiles.pojo.Employee;
import ru.skypro.homework.loggerprofiles.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add-employee")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @GetMapping("/get/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/update/{id}")
    public void updateEmployeeById(@PathVariable int id, @RequestBody Employee employee) {
        try {
            employeeService.updateEmployeeById(id, employee);
        } catch (Throwable throwable) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployeeById(@PathVariable int id) {
        employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/get-all-employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

    /*
    @GetMapping("/salaryHigherThan")
    public List<Employee> showSalaryHigherThan(@RequestParam("salary") Integer salary) {
        return employeeService.getHigherThanSalaryEmployees(salary);
    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addListOfEmployees(@RequestBody List<Employee> employees){
        employeeService.addListOfEmployees(employees);
    }
    @GetMapping("/salary/sum")
    public int showSumEmployeeSalary() {
        return employeeService.getSumEmployeeSalary();
    }
    @GetMapping("/salary/min")
    public int showMinEmployeeSalary() {
        return employeeService.getMinEmployeeSalary();
    }
    @GetMapping("/salary/max")
    public int showMaxEmployeeSalary() { return employeeService.getMaxEmployeeSalary();}
    @GetMapping("/high-salary")
    public List<Employee> showHighSalaryEmployees() { return employeeService.getHighSalaryEmployees();}
     */
}


