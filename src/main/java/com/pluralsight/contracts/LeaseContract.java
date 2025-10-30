package com.pluralsight.contracts;

import com.pluralsight.models.Vehicle;

public class LeaseContract extends Contract{
    private double expectedEndingValue,leaseFee;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicle, double expectedEndingValue, double leaseFee) {
        super(date, customerName, customerEmail, vehicle);
        this.expectedEndingValue = 0.50 * totalPrice;
        this.leaseFee = 0.07 * totalPrice;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}
