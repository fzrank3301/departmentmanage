package com.wang.example.department.DAO;


import com.wang.example.department.Enitity.DepartmentEntity;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Repository
public class DepartmentDAO {

    public static Map<Integer, DepartmentEntity>  departments = null;

    static {

        departments = new HashMap<Integer, DepartmentEntity>();
        departments.put(1001,new DepartmentEntity(1001,"市场部"));
        departments.put(1002,new DepartmentEntity(1002,"教学部"));
        departments.put(1003,new DepartmentEntity(1003,"教研部"));
        departments.put(1004,new DepartmentEntity(1004,"运营部"));
        departments.put(1005,new DepartmentEntity(1005,"后勤部"));

    }



    public Collection<DepartmentEntity> getDepartments(){
        return departments.values();
    }


    public DepartmentEntity getDepartmentById(Integer id){
        return departments.get(id);
    }




}
