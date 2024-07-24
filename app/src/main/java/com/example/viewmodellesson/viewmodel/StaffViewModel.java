package com.example.viewmodellesson.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.viewmodellesson.model.Staff;

import java.util.ArrayList;
import java.util.List;

public class StaffViewModel extends ViewModel {
    private List<Staff> mStaffList; // used to set live data
    private MutableLiveData<List<Staff>> staffLiveData;

    public LiveData<List<Staff>> getStaffs(){
        if(mStaffList == null){
            mStaffList = new ArrayList<>();
            staffLiveData = new MutableLiveData<>();
            staffLiveData.setValue(mStaffList);
        }
        return staffLiveData;
    }

    public void addStaff(String id, String fullName, String birthDate, long salary){
        // some exception if attr is empty or null
        Staff staff = new Staff(id,fullName,birthDate,salary);
        mStaffList.add(staff);
        staffLiveData.setValue(mStaffList);
    }
}
