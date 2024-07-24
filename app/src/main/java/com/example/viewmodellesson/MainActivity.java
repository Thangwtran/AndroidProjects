package com.example.viewmodellesson;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.viewmodellesson.model.Staff;
import com.example.viewmodellesson.viewmodel.StaffViewModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mEditId;
    private EditText mEditName;
    private EditText mEditBirthDate;
    private EditText mEditSalary;
    private Button btnAddStaff;
    private TextView textResult;
    private StaffViewModel mViewModel; // save the data
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
        addObserver();
    }

    @SuppressLint("SetTextI18n")
    private void addObserver() {
        mViewModel = new ViewModelProvider(this).get(StaffViewModel.class);
        mViewModel.getStaffs().observe(this,staffs ->{
            if(staffs.isEmpty()){
                textResult.setText("No Data");
            }else{
                StringBuilder stringBuilder = new StringBuilder();
                for (Staff staff: staffs) {
                    stringBuilder.append(staff.toString()).append("\n");
                }
                textResult.setText(stringBuilder.toString());
            }
        });
    }

    private void initViews() {
        textResult = findViewById(R.id.text_result);
        mEditId = findViewById(R.id.edit_id);
        mEditName = findViewById(R.id.edit_name);
        mEditBirthDate = findViewById(R.id.edit_birthdate);
        mEditSalary = findViewById(R.id.edit_salary);
        btnAddStaff = findViewById(R.id.btn_add_staff);
        btnAddStaff.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String id = mEditId.getText().toString().trim();
        String fullName = mEditName.getText().toString().trim();
        String birthDate = mEditBirthDate.getText().toString().trim();
        String salaryStr = mEditSalary.getText().toString().trim();
        long salary = Long.parseLong(salaryStr);
        mViewModel.addStaff(id,fullName,birthDate,salary);

    }
}