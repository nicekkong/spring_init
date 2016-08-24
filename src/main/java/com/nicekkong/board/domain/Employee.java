/******************************************************
 * Project Name :  spring_board
 * File Name : .java
 * Author : nicekkong@gmail.com
 * Create Date : 2016. 8. 24. 오전 7:37
 * Description : 
 ******************************************************/

package com.nicekkong.board.domain;

public class Employee {

    private String name;
    private int age;
    private int empNo;
    private String dept;
    private String sex;

    public String getSex() {
        return sex;
    }

    public Employee setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Employee setAge(int age) {
        this.age = age;
        return this;
    }

    public int getEmpNo() {
        return empNo;
    }

    public Employee setEmpNo(int empNo) {
        this.empNo = empNo;
        return this;
    }

    public String getDept() {
        return dept;
    }

    public Employee setDept(String dept) {
        this.dept = dept;
        return this;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", empNo=" + empNo +
                ", dept='" + dept + '\'' +
                '}';
    }
}
