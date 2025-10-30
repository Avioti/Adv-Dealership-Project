package com.pluralsight.contracts;

import com.pluralsight.models.Vehicle;

public class LeaseContract extends Contract{
    private double expectedEndingValue,leaseFee;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicle) {
        super(date, customerName, customerEmail, vehicle);


    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    @Override
    public double getTotalPrice() {
        this.leaseFee = 0.07 * totalPrice;
        this.expectedEndingValue = 0.50 * totalPrice;
        totalPrice = expectedEndingValue + leaseFee;
        return totalPrice;

    }

    @Override
    public double getMonthlyPayment() {

        double monthlyRate = 0;

        int months = 0;
        totalPrice = getTotalPrice();
            months = 36;


        monthlyRate = 0.04 / 12;

        monthlyPayment = totalPrice * (monthlyRate * Math.pow(1 + monthlyRate, months))
                / (Math.pow(1 + monthlyRate, months) - 1);


        return monthlyPayment;
    }
}
