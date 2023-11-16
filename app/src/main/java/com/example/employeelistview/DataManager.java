package com.example.employeelistview;

import android.content.SharedPreferences;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import android.content.SharedPreferences;

public class DataManager {
    public static ArrayList Employees = new ArrayList<>();

    public Employee createEmployee(String name , int salary , int age, String jobtitle)
    {
        Employee employee = new Employee(name, salary , age, jobtitle);
//       Employees.add(employee);

        return employee;
    }
    public static void removeEmployee(Employee employee)
    {
        Employees.remove(employee);
    }
}
