package com.jrminder.ssm.service;

import com.github.pagehelper.PageInfo;
import com.jrminder.ssm.pojo.Employee;

import java.util.List;

/**
 * @author sailor
 * @create 2022-11-03 20:55
 */
public interface EmployeeService {
    List<Employee> getAllEmployee();

    PageInfo<Employee> getEmployeePage(Integer pageNum);
}
