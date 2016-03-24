package com.example.sti.sti_taft.db;

import java.util.Date;

/**
 * Created by STI on 1/29/2016.
 */
public class User {

    private long userId;
    private String userName;
    private String userPassword;
    private String userFirstName;
    private String userLastName;
    private String userBirthDay;
    private String userStudentNumber;
    private String userSchool;
    private double userLoad;
    private int userLoggedIn;

    public String getUserSchool() {
        return userSchool;
    }

    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserBirthDay() {
        return userBirthDay;
    }

    public void setUserBirthDay(String userBirthDay) {
        this.userBirthDay = userBirthDay;
    }

    public String getUserStudentNumber() {
        return userStudentNumber;
    }

    public void setUserStudentNumber(String userStudentNumber) {
        this.userStudentNumber = userStudentNumber;
    }

    public double getUserLoad() {
        return userLoad;
    }

    public void setUserLoad(Double userLoad) {
        this.userLoad = userLoad;
    }

    public int getUserLoggedIn() {
        return userLoggedIn;
    }

    public void setUserLoggedIn(int userLoggedIn) {
        this.userLoggedIn = userLoggedIn;
    }
}
