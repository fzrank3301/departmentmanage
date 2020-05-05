package com.wang.example.department.Enitity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.AssertTrue;
import java.util.Date;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class EmployeeEntity {


    private  Integer id;
    private  String lastName;
    private  String email;
    private  Integer gender; //0: 女 1: 男

    private DepartmentEntity department;
    private Date birth;


    public EmployeeEntity(Integer id, String lastName, String email, Integer gender, DepartmentEntity department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birth = new Date();   //默认的日期
    }
}
