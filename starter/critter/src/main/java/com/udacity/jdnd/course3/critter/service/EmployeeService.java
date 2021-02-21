package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.entity.Employee;
import com.udacity.jdnd.course3.critter.model.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.model.EmployeeSkill;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import com.udacity.jdnd.course3.critter.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.*;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;
    ScheduleRepository scheduleRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findById(long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        return employee.get();
    }

    public List<Employee> findAvailableEmployees(EmployeeRequestDTO employeeDTO) {
        List<Employee> employees = employeeRepository.findAllByDaysAvailable(employeeDTO.getDate().getDayOfWeek());
        List<Employee> availableEmployees = new ArrayList<>();
        for (Employee employee : employees){
            if(employee.getSkills().containsAll(employeeDTO.getSkills())){
                availableEmployees.add(employee);
            }
        }
        return availableEmployees;
    }
}
