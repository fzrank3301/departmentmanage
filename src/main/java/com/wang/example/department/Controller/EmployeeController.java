package com.wang.example.department.Controller;


import com.wang.example.department.DAO.DepartmentDAO;
import com.wang.example.department.DAO.EmployeeDAO;
import com.wang.example.department.Enitity.DepartmentEntity;
import com.wang.example.department.Enitity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDAO employeeDAO;

    @Autowired
    DepartmentDAO departmentDAO;

    @RequestMapping({"/emps","/list.html"})
    public String list(Model model)
    {
        Collection<EmployeeEntity> allEmployee = employeeDAO.getAllEmployee();
        model.addAttribute("emps",allEmployee);
        return "list";
    }


    @GetMapping("/emp/add")
    public String toAddPage(Model model)
    {
        Collection<DepartmentEntity> departments = departmentDAO.getDepartments();
        model.addAttribute("departments",departments);
        return "add";
    }


    @PostMapping("/emp/add")
    public String addEmp(EmployeeEntity employeeEntity)
    {
        employeeDAO.save(employeeEntity);
        return "redirect:/list.html";
    }


    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable(name = "id")Integer id,Model model)
    {
        Collection<DepartmentEntity> departments = departmentDAO.getDepartments();
        EmployeeEntity employee = employeeDAO.getEmployeeById(id);
        model.addAttribute("employee",employee);
        model.addAttribute("departments",departments);
        return "update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(EmployeeEntity employeeEntity)
    {
        employeeDAO.save(employeeEntity);
        return "redirect:/list.html";
    }


    @GetMapping("/delemp/{id}")
    public String delemp(@PathVariable(name = "id")Integer id)
    {
        employeeDAO.deleteById(id);
        return "redirect:/list.html";
    }


}
