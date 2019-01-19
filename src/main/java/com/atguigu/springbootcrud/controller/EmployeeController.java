package com.atguigu.springbootcrud.controller;

import com.atguigu.springbootcrud.dao.DepartmentDao;
import com.atguigu.springbootcrud.dao.EmployeeDao;
import com.atguigu.springbootcrud.entities.Department;
import com.atguigu.springbootcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    //获取员工列表
    @GetMapping("/emps")
    public String getEmps(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        //放入域中
        model.addAttribute("emps", employees);
        // thymeleaf默认就会拼串
        // classpath:/templates/xxxx.html
        return "emp/list";
    }

    //来到员工添加页面, 需要查询部门信息填充在选项中
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    //添加员工
    @PostMapping("/emp")
    public String saveEmp(Employee employee) {
        //springMVC会自动将表单的数据封装到employee中，前提表单中的name和employee属性对应

        //保存employee
        employeeDao.save(employee);

        //之后重定向到列表页面
        return "redirect:/emps";
    }


    //来到修改页面，查出员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {

        //根据id获取员工信息
        Employee employee = employeeDao.get(id);
        //将员工信息放入域中
        model.addAttribute("emp", employee);

        //查询部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);

        //来到修改页面(add页面是一个修改、添加功能合一的页面)
        return "emp/add";
    }

    //员工修改，需要提供员工id
    @PutMapping("/emp")
    public String updateEmp(Employee employee) {

        employeeDao.save(employee);

        //返回列表页面
        return "redirect:/emps";
    }

    //删除员工
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id) {

        //根据id删除员工
        employeeDao.delete(id);

        return "redirect:/emps";
    }
}
