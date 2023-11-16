package com.example.employeelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
//hanad
public class MainActivity extends AppCompatActivity {
    EditText nameInput;
    EditText ageInput;
    EditText salaryInput;
    EditText jobtitleInput;
    Button registerBtn;
    Button showEmployeesBtn;
    DataManager dataManager = new DataManager();
    SharedPreferences prefs ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences("com.example.employeelistview.prefs", MODE_PRIVATE);
        nameInput = findViewById(R.id.editText_Name);
        salaryInput = findViewById(R.id.editText_salary);
        ageInput = findViewById(R.id.editText_age);
        jobtitleInput = findViewById(R.id.editText_jobtitle);
        registerBtn = findViewById(R.id.button_register);
        showEmployeesBtn = findViewById(R.id.button_show_employees);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString();
                if (ageInput.getText().toString().matches("[0-9]+")
                        && salaryInput.getText().toString().matches("[0-9]+")
                        && !jobtitleInput.toString().isEmpty()
                        && !nameInput.toString().isEmpty()) {
                    int salary = Integer.parseInt(salaryInput.getText().toString());
                    int age = Integer.parseInt(ageInput.getText().toString());
                    String job = jobtitleInput.getText().toString();
                    Employee employee = dataManager.createEmployee(name, salary, age ,  job);
                    Toast.makeText(MainActivity.this, "Added Employee:" + name, Toast.LENGTH_SHORT).show();

                    SharedPreferences.Editor prefsEditor = prefs.edit();
                    Gson gson = new Gson();
                    String json = gson.toJson(employee);
                    prefsEditor.putString(employee.getName(), json);
                    prefsEditor.commit();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        showEmployeesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EmployeesActivity.class);
                startActivity(intent);
            }
        });

    }
}