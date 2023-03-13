package com.example.crud_operation.controllers;


import com.example.crud_operation.entities.Address;
import com.example.crud_operation.entities.Employee;
import com.example.crud_operation.repositories.AddressRepo;
import com.example.crud_operation.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private AddressRepo addressRepo;

    @GetMapping("/")
    public String addEmployee() {
        return "add_employee";
    }

    @PostMapping("/")
    public String addEmployee(@ModelAttribute("employee") Employee employee, @ModelAttribute("address")Address address, Model model) {

        employee.setAddress(address);
        address.setEmployee(employee);
        this.employeeRepo.save(employee);

        model.addAttribute("msg", "Employee added");
        return "add_employee";
    }

    @GetMapping("/view_employee")
    public String viewEmployee(Model model) {

        Iterable<Employee> employees = this.employeeRepo.findAll();
        System.out.println(employees);
        model.addAttribute("employees", employees);
        return "view_employee";
    }

    @GetMapping("/edit_employee/{id}")
    public String editEmployee(@PathVariable Integer id, Model model) throws Exception {

        Employee employee = this.employeeRepo.findById(id).orElseThrow(() -> new Exception("User not found"));
        System.out.println("employee : "+employee);
        model.addAttribute("employee", employee);
        return "edit_employee";
    }


    @PostMapping("/edit_employee")
    public String editEmployee(@ModelAttribute("employee") Employee employee,@ModelAttribute("address")Address address, Model model) throws Exception {
        employee.setAddress(address);
        this.employeeRepo.save(employee);
        Iterable<Employee> employees = this.employeeRepo.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("msg", "Employee updated successfully");
        return "view_employee";
    }

    @GetMapping("/delete_employee/{id}")
    public String deleteEmployee(@PathVariable Integer id, Model model) throws Exception {

        Employee employee = this.employeeRepo.findById(id).orElseThrow(() -> new Exception("User not found"));
        this.employeeRepo.delete(employee);
        Iterable<Employee> employees = this.employeeRepo.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("msg", "Employee deleted successfully");
        return "view_employee";
    }
}
