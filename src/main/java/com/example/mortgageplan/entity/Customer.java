package com.example.mortgageplan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int years;
    private float loan;
    private float interestRate;
    private float monthlyPayment;

    protected Customer() {}

    public Customer(String name, int years, float loan, float interestRate, float monthlyPayment) {
        this.name = name;
        this.years = years;
        this.loan = loan;
        this.interestRate = interestRate;
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public String toString() {
        return String.format(
                "%s wants to borrow %s for a period of %s years and pay %.2f€ each month.", name, loan, years, monthlyPayment);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYears() {
        return years;
    }

    public float getLoan() {
        return loan;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public float getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(float monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

}
