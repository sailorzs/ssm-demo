package com.jrminder.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.jrminder.ssm.pojo.Employee;
import com.jrminder.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author sailor
 * @create 2022-11-03 20:21
 *
 */

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(
            value = {"/employee/page/{pageNum}"},
            method = RequestMethod.GET
    )
    public String getEmployeePage(
            @PathVariable("pageNum") Integer pageNum,
            Model model
    ){
//        获取员工的分页信息
        PageInfo<Employee> page = employeeService.getEmployeePage(pageNum);
//       将分页信息共享到请求域中
        model.addAttribute("page",page);
//        跳转到employee_list.html
        return "employee_list";

    }


    @RequestMapping(
            value = {"/employee"},
            method = RequestMethod.GET
    )
    public String getAllEmployee(Model model){
        List<Employee> list = employeeService.getAllEmployee();
        model.addAttribute("list",list);
        return "employee_list";
    }

}
