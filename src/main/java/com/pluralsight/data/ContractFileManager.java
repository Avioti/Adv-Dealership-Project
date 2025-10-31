package com.pluralsight.data;

import com.pluralsight.contracts.Contract;
import com.pluralsight.contracts.LeaseContract;
import com.pluralsight.contracts.SalesContract;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class ContractFileManager {


    public void saveContract(Contract c) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/contracts.csv", true));

            if (c instanceof SalesContract sales) {
                String sale = String.format(
                        "SALE:|%s|%s|%s|%d|" +
                                "%d|%s|%s|%s|%s|%d|%.2f" +
                                "|%.2f|%.2f|%.2f|%.2f|%s|%.2f"
                        , sales.getDate(), sales.getCustomerName(), sales.getCustomerEmail(), sales.getVehicle().getVin(),
                        sales.getVehicle().getYear(), sales.getVehicle().getMake(), sales.getVehicle().getModel(), sales.getVehicle().getVehicleType(),
                        sales.getVehicle().getColor(), sales.getVehicle().getOdometer(), sales.getVehicle().getPrice(),
                        sales.getSalesTax(), sales.getRecordingFee(), sales.getProcessingFee(), sales.getTotalPrice(), sales.wantsFinance(sales.isFinanceOption()),
                        sales.getMonthlyPayment());
                writer.newLine();
                writer.write(sale);
                writer.close();
            }

            if (c instanceof LeaseContract leases) {
                String lease = String.format(
                        "SALE:|%s|%s|%s|%d|" +
                                "%d|%s|%s|%s|%s|%d|%.2f" +
                                "|%.2f|%.2f|%.2f|%.2f"
                        , leases.getDate(), leases.getCustomerName(), leases.getCustomerEmail(), leases.getVehicle().getVin(),
                        leases.getVehicle().getYear(), leases.getVehicle().getMake(), leases.getVehicle().getModel(), leases.getVehicle().getVehicleType(),
                        leases.getVehicle().getColor(), leases.getVehicle().getOdometer(), leases.getVehicle().getPrice(),
                        leases.getExpectedEndingValue(), leases.getLeaseFee(), leases.getTotalPrice(), leases.getMonthlyPayment());
                writer.newLine();
                writer.write(lease);
                writer.close();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
