package com.example.employeelistview;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.preference.PreferenceManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;


import java.util.List;

public class EmployeeAdapter extends ArrayAdapter {
    public  EmployeeAdapter(Context context, List<Employee> employees){
        super(context,0,employees);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertview, @NonNull ViewGroup parent){
        View view = convertview;
        if( view == null)
        {
            view = LayoutInflater.from(getContext()).inflate(R.layout.listitem_employee, parent, false);
        }

        Employee employee = (Employee) getItem(position);
        TextView tvName = view.findViewById(R.id.tv_name);
        tvName.setText("Name: "+employee.getName() +"\nAge:" + employee.getAge() +
                        "\nSalary: " + employee.getSalary() +"\nJob Title: " +employee.getJobtitle());
        return view;
    }
}
