package com.wang.example.department.DAO;


import com.wang.example.department.Enitity.DepartmentEntity;
import com.wang.example.department.Enitity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDAO {

    private static Map<Integer, EmployeeEntity> eployees = null;

    @Autowired
    private DepartmentDAO departmentDAO;

    static {
        eployees = new HashMap<Integer, EmployeeEntity>();

        eployees.put(1001,new EmployeeEntity(1001,"CC","2439158248@qq.com",0,new DepartmentEntity(101,"市场部")));
        eployees.put(1002,new EmployeeEntity(1002,"DD","2439158248@qq.com",0,new DepartmentEntity(101,"教学部")));
        eployees.put(1003,new EmployeeEntity(1003,"EE","2439158248@qq.com",0,new DepartmentEntity(101,"教研部")));
        eployees.put(1004,new EmployeeEntity(1004,"FF","2439158248@qq.com",0,new DepartmentEntity(101,"运营部")));
        eployees.put(1005,new EmployeeEntity(1005,"GG","2439158248@qq.com",0,new DepartmentEntity(101,"后勤部")));
    }

    //自增主键
    public static Integer initId = 1006;

    public void save(EmployeeEntity employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDAO.getDepartmentById(employee.getDepartment().getId()));

        eployees.put(employee.getId(),employee);
    }


    public Collection<EmployeeEntity> getAllEmployee()
    {
        return eployees.values();
    }


    public EmployeeEntity getEmployeeById(Integer id)
    {
        return eployees.get(id);
    }


    public void deleteById(Integer id)
    {
        eployees.remove(id);
    }





}
