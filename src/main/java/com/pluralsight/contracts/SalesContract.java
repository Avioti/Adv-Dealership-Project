package com.pluralsight.contracts;

import com.pluralsight.models.Vehicle;

public class SalesContract extends Contract{
    private double salesTax,processingFee;
    private double recordingFee = 100;
    private boolean financeOption;


    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicle, double salesTax, double processingFee, boolean financeOption) {
        super(date, customerName, customerEmail, vehicle);
        this.salesTax = 0.05;
        this.processingFee = 295;
        this.recordingFee = 100;
        this.financeOption = financeOption;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public boolean wantsFinance() {
        return financeOption;
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
