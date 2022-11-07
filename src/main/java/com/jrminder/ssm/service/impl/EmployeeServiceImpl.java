package com.jrminder.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jrminder.ssm.mapper.EmployeeMapper;
import com.jrminder.ssm.pojo.Employee;
import com.jrminder.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sailor
 * @create 2022-11-03 20:56
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public PageInfo<Employee> getEmployeePage(Integer pageNum) {
//        开启分页功能
        PageHelper.startPage(pageNum,5);
//        查询所有的员工信息
        List<Employee> allEmployee = employeeMapper.getAllEmployee();
//        获取分页相关数据
        PageInfo<Employee> employeePageInfo = new PageInfo<>(allEmployee, 5);
        return employeePageInfo;

    }
}
