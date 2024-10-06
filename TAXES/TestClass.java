package TAXES;

import java.util.Scanner;

public class TestClass extends TaxRate{
    public static String vehicleType;
    public static final int parkingFee = 15000;
    public void Registration() {
        if (NumberPlateType.equals("APS")) {
            flatRate = 300000;
        } else if (NumberPlateType.equals("DPS")) {
            flatRate = 700000;
        } else {
            flatRate = 0;
        }

    }
    public void details(){
        System.out.println("VEHICLE TAX DETAILS" );
        System.out.println("Mandatory to Pay The following:");
        System.out.println("StampDuty: " + StampDuty);
        System.out.println("FormFees: " + FormFees);
        System.out.println("Excise Duty: " + ExciseDuty);
    }
    public static void main(String[]args){

        TestClass test = new TestClass();
        Scanner obj = new Scanner(System.in);
        System.out.print("Choose between DPS and APS for number plate System");
        obj.nextLine();
        System.out.print("Insert type of number plate System:");
        NumberPlateType = obj.next();
        test.Registration();
        System.out.println("The flat rate for " + NumberPlateType + " is: " + flatRate);

        System.out.println("Insert vehicle category: ");
         vehicleType =obj.next();
         if (!vehicleType.equals("Ambulance")
         && !vehicleType.equals("Estate")
                 &&!vehicleType.equals("Sedan")
                 &&! vehicleType.equals("SUV")
                 &&!vehicleType.equals("Trailer")
         ){
             System.out.println("Required to pay the following standard taxes:");
             System.out.println("Insert CIF value:");
             CIF = obj.nextDouble();
             System.out.println("Importer should pay the following standard taxes:");
             double ImportDuty = test.calculateImportDuty();
             System.out.println("The import duty is: " + ImportDuty);

             double ValueAddedTax = test.calculateValueAddedTax();
             System.out.println("The VAT is: " + ValueAddedTax);

             double WithholdingTax = test.calculateWithholdingTax();
             System.out.println("The Withholding tax is: " + WithholdingTax);
             System.out.println("The infrastructure Levy Tax is: "+ InfrastructureLevy);
             obj.nextLine();
             test.details();
             obj.nextLine();
         }
         else {
             System.out.println("Exempt taxes");
         }
         System.out.println("Insert period(in days) of storage at the bond:");
         int days = obj.nextInt();
         obj.nextLine();
         int totalPeriod =days*parkingFee;
         System.out.println("Total amount payable considering period of storage:shs "+ totalPeriod);
         double totalTaxes = StampDuty+FormFees+ExciseDuty;
         double ImportDuty = test.calculateImportDuty();
         double ValueAddedTax = test.calculateValueAddedTax();
         double WithholdingTax = test.calculateWithholdingTax();
         totalTaxes+= ImportDuty+ValueAddedTax+WithholdingTax+InfrastructureLevy;
         System.out.println("Total mandatory taxes are: "+ totalTaxes);
         obj.nextLine();
         System.out.println("Insert mode of transport: ");
         String modeOfTransport = obj.next();
         System.out.println("Insert CIF:shs");
         double CIF = obj.nextDouble();
         double roadTolls=0;
         double borderFees =0.015*CIF;
         if(modeOfTransport.equalsIgnoreCase("carrier")){
             roadTolls = 0.005*CIF;
         } else if (modeOfTransport.equalsIgnoreCase("driven")) {
             roadTolls=borderFees;
         }
         else {
             System.out.println("Invalid:N/A");
         }
         System.out.println("Road toll is:shs " +roadTolls);
    }
}
