package com.example.employeelistview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.google.gson.Gson;

import java.util.ArrayList;


public class EmployeesActivity extends AppCompatActivity {
ListView listView;
SharedPreferences prefs;
Button deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees);
        listView = findViewById(R.id.lv_employees);
        deleteBtn = findViewById(R.id.btn_deleteemployees);

        prefs = getSharedPreferences("com.example.employeelistview.prefs", MODE_PRIVATE);
        java.util.Map<String, ?> allPrefs = prefs.getAll();
        for (String key : allPrefs.keySet()) {
            Gson gson = new Gson();
            String json = prefs.getString(key, "");
            Employee obj = gson.fromJson(json, Employee.class);
            DataManager.Employees.add(obj);
        }
       EmployeeAdapter adapter = new EmployeeAdapter(this, DataManager.Employees);
        listView.setAdapter(adapter);

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = prefs.edit();
               editor.clear();
               editor.apply();
                setAddapter();
//                finish();
            }
        });
    }

    private void setAddapter()
    {
        prefs = getSharedPreferences("com.example.employeelistview.prefs", MODE_PRIVATE);
        java.util.Map<String, ?> allPrefs = prefs.getAll();
        DataManager.Employees.clear();
        for (String key : allPrefs.keySet()) {
            Gson gson = new Gson();
            String json = prefs.getString(key, "");
            Employee obj = gson.fromJson(json, Employee.class);
            DataManager.Employees.add(obj);
        }
        EmployeeAdapter adapter = new EmployeeAdapter(this, DataManager.Employees);
        listView.setAdapter(adapter);
    }
}