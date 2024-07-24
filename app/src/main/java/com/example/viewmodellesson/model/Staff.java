package com.example.viewmodellesson.model;
import androidx.annotation.NonNull;

import com.example.viewmodellesson.utils.Utils;

import java.util.Date;


public class Staff {
    private String mStaffId;
    private String mFirstName;
    private String mMidName;
    private String mLastName;
    private Date mBirthDate;
    private long salary;

    public Staff(){}

    public Staff(String StaffId, String fullName, String birthDate, long salary) {
        mStaffId = StaffId;
        setFullName(fullName);
        setBirthDate(birthDate);
        this.salary = salary;
    }

    public String getStaffId() {
        return mStaffId;
    }

    public String getFullName() {
        return mLastName + " " + mMidName + " " + mFirstName;
    }

    public Date getBirthDate() {
        return mBirthDate;
    }
    public String getBirthDateStr(Date date){
        return Utils.dateToString(date);
    }

    public long getSalary() {
        return salary;
    }

    private void setBirthDate(String birthDate) {
        mBirthDate = Utils.stringToDate(birthDate);
    }

    private void setFullName(String fullName) {
        String first = "";
        String last = "";
        StringBuilder mid = new StringBuilder();
        String[] names = fullName.split("\\s+");
        if(names.length == 1){
            last = names[0];
        } else if (names.length == 2) {
            last = names[0];
            first = names[1];
        } else if (names.length > 2) {
            last = names[0];
            first = names[names.length -1];
            for (int i = 1; i < names.length - 1; i++) {
                mid.append(names[i]).append(" ");
            }
        }
        setFirstName(first);
        setLastName(last);
        setMidName(mid.toString().trim());
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public void setMidName(String midName) {
        mMidName = midName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    @NonNull
    @Override
    public String toString() {
        return mStaffId + "-" + getFullName() + "-" + getBirthDateStr(mBirthDate)
                + "-" + salary;
    }
}
