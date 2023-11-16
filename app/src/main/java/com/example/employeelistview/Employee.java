package com.example.employeelistview;

public class Employee {
    String name;
    int salary;
    int age;
    String jobtitle;
    public Employee(String name, int salary, int age, String jobtitle) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.jobtitle = jobtitle;
    }
//#region getset
    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }
    public String getJobtitle()
    {
        return  jobtitle;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setJobtitle(String jobtitle) {
        this.name = jobtitle;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //endregion

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
