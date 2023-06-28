package ru.skypro.homework.loggerprofiles.repository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;
import ru.skypro.homework.loggerprofiles.pojo.Employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    public static final Logger logger = LoggerFactory.getLogger(EmployeeRepositoryImpl.class.getName());
    // Коллекция для имитации данных
    public static List<Employee> employeeList = List.of(
            new Employee(0,"Катя", 90_000),
            new Employee(1,"Дима", 102_000),
            new Employee(2,"Олег", 80_000),
            new Employee(3,"Вика", 165_000));

    @Override
    public void addEmployee(Employee employee) {
        List<Employee> e = new ArrayList<>(employeeList);
        e.add(employee);
        setEmployeeList(e);
    }

    @Override
    public Employee getById(int id) throws IllegalArgumentException {
        for (int i=0; i<employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                logger.debug("В метод Получить по id передан существующий id: " + id);
                return employeeList.get(i);
            }
        }
        logger.error("Введен несуществующий id: " + id);
        return null;
    }
    @Override
    public void updateById(int id, Employee employee) {
        for(int i=0; i<employeeList.size(); i++){
            if(employeeList.get(i).getId() == id){
                logger.debug("Передан существующий id: " + id);
                employeeList.get(id).setName(employee.getName());
                employeeList.get(id).setSalary(employee.getSalary());
                return;
            }
        }
        logger.error("Введен несуществующий id: " + id);
    }

    @Override
    public void deleteById(int id) {
        List<Employee> arrayList = new ArrayList<>(employeeList);
        for(int i=0; i<arrayList.size(); i++){
            if(arrayList.get(i).getId() == id) {
                logger.debug("Передан существующий id: " + id);
                arrayList.remove(i);
                setEmployeeList(arrayList);
                return;
            }
        }
            logger.error("Введен несуществующий id: " + id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

/*
    @Override
    public int getSumSalary() {
        int sum = 0;
        for(Employee employee: employeeList) {
            sum = sum + employee.getSalary();
        }
        return sum;
    }

    @Override
    public int getMinSalary() {
        int min = employeeList.get(0).getSalary();
        for(int i = 1; i < employeeList.size(); i++) {
            if(employeeList.get(i).getSalary() < min) {
                min = employeeList.get(i).getSalary();
            }
        }
        return min;
    }

    @Override
    public int getMaxSalary() {
        int max = employeeList.get(0).getSalary();
        for(int i = 1; i < employeeList.size(); i++) {
            if(employeeList.get(i).getSalary() > max) {
                max = employeeList.get(i).getSalary();
            }
        }
        return max;
    }

    @Override
    public List<Employee> getHighSalary() {
        int sum = getSumSalary();
        int average = sum / employeeList.size();
        List<Employee> empl = new ArrayList<>();
        for(Employee employee: employeeList) {
            if(employee.getSalary() > average) {
                empl.add(employee);
            }
        }
        return empl;
    }

    @Override
    public List<Employee> getHigherThanSalary(Integer salary) {
        List<Employee> emplList = new ArrayList<>();
        for(Employee employee: employeeList) {
            if (employee.getSalary() > salary) {
                emplList.add(employee);
            }
        }
        return emplList;
    }

    @Override
    public void addListOf(List<Employee> employees) {
        List<Employee> arrayList = new ArrayList<>(employeeList);
        arrayList.addAll(employees);
        setEmployeeList(arrayList);
    }
*/
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "EmployeeRepositoryImpl{" +
                "employeeList=" + employeeList +
                '}';
    }
}

