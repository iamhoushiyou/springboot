package com.example.springboot02config.dao;

import com.example.springboot02config.pojo.Department;
import com.example.springboot02config.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    //模拟数据库中的数据

    private static Map<Integer, Employee> employeeMap=null;

    @Autowired
    private DepartmentDao departmentMap;
    static {
        employeeMap=new HashMap<>(16);
        employeeMap.put(101,new Employee(1001,"AA","243@qq.com",1,new Department(101,"后勤部"),new Date()));
        employeeMap.put(102,new Employee(1002,"bb","2b43@qq.com",0,new Department(102,"后勤部"),new Date()));
        employeeMap.put(103,new Employee(1003,"cc","24c3@qq.com",0,new Department(103,"后勤部"),new Date()));
        employeeMap.put(104,new Employee(1004,"dd","24d3@qq.com",1,new Department(104,"后勤部"),new Date()));
        employeeMap.put(105,new Employee(1005,"ee","243e@qq.com",1,new Department(105,"后勤部"),new Date()));
    }

    private static Integer initId=1006;
    //增加员工
    public void add(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentMap.getDepartmentById(employee.getDepartment().getId()));
        employeeMap.put(employee.getId(),employee);
    }

    //查询全部员工
    public Collection<Employee> getAll(){
        return employeeMap.values();
    }

    public Employee getEmployeeById(Integer id){
        return employeeMap.get(id);
    }

    public void delete(Integer id){
        employeeMap.remove(id);
    }
}
