package com.bank.bank_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String fullName;
    private String email;
    private String password;

    // PERSONAL INFO
    private String mobile;
    private String aadhaar;
    private String pan;
    private String address;
    private String accountType;

    // DASHBOARD DATA
    private double totalBalance;
    private int totalCards;
    private double salaryCredit;
    private double pendingMoney;
    private double savingGoals;
    private double totalBillsRemaining;

    // GETTERS & SETTERS

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAadhaar() {
        return aadhaar;
    }

    public void setAadhaar(String aadhaar) {
        this.aadhaar = aadhaar;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public int getTotalCards() {
        return totalCards;
    }

    public void setTotalCards(int totalCards) {
        this.totalCards = totalCards;
    }

    public double getSalaryCredit() {
        return salaryCredit;
    }

    public void setSalaryCredit(double salaryCredit) {
        this.salaryCredit = salaryCredit;
    }

    public double getPendingMoney() {
        return pendingMoney;
    }

    public void setPendingMoney(double pendingMoney) {
        this.pendingMoney = pendingMoney;
    }

    public double getSavingGoals() {
        return savingGoals;
    }

    public void setSavingGoals(double savingGoals) {
        this.savingGoals = savingGoals;
    }

    public double getTotalBillsRemaining() {
        return totalBillsRemaining;
    }

    public void setTotalBillsRemaining(double totalBillsRemaining) {
        this.totalBillsRemaining = totalBillsRemaining;
    }
}