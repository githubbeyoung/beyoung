package com.enjoy.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @description :学生类
 * @param :
 * @author :liqy
 * @version :1.0.0.1
 * @data :2019-11-06 21:11
 */
public class Student implements Serializable {

    private Integer id;
    private String name;
    private Date birthday;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                '}';
    }
}
