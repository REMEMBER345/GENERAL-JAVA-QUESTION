package TAXES;

import java.util.Scanner;

public class SUV extends TaxRate{
    public static String NumberPlateType;
    public void details(){
        System.out.println("VEHICLE DETAILS: SUV" );
        System.out.println("Mandatory to Pay The following:");
        System.out.println("StampDuty: " + StampDuty);
        System.out.println("FormFees: " + FormFees);
        System.out.println("Excise Duty: " + ExciseDuty);
    }
    public double ImportDuty(){
        return 0.25*CIF;
    }
    public double ValueAddedTax(){
        return 0.18*CIF;
    }
    public double WithholdingTax(){
        return 0.06*CIF;
    }
    public void Registration() {

        if (NumberPlateType.equals("APS")) {
            flatRate = 300000;
        } else if (NumberPlateType.equals("DPS")) {
            flatRate = 700000;
        } else {
            flatRate = 0;
        }
    }
    public static void main(String[]args){
        SUV suv = new SUV();
        Scanner obj = new Scanner(System.in);
        suv.details();
        System.out.println("Enter CIF: ");
        double CIF =obj.nextDouble();

        double ImportDuty = suv.ImportDuty();
        System.out.println("Import Duty is: " + ImportDuty);

        double VAT = suv.ValueAddedTax();
        System.out.println("VAT is: " + VAT);

        double WHT = suv.WithholdingTax();
        System.out.println("Withholding Tax is: " + WHT);
        obj.nextLine();

        System.out.print("Insert type of number plate System:");
        NumberPlateType = obj.next();
        suv.Registration();
        System.out.println("The flat rate for " + NumberPlateType + " is: " + flatRate);
        obj.nextLine();


        System.out.println("Enter Seating capacity: ");
        int SeatingCapacity = obj.nextInt();
        obj.nextLine();

        // for calculating cost of extra seat
        double CostForExtraSeat = 0;
        if (SeatingCapacity>5){
            CostForExtraSeat =(SeatingCapacity-5)*350000;
        }
        System.out.println("Extra Seat cost: " + CostForExtraSeat);
        obj.nextLine();

        System.out.println("Enter Gross Weight: ");
        double GrossWeight = obj.nextDouble(); // weight measured in tonnes

        double cost = 0;
        if (GrossWeight>5000){
            cost = 0.15*CIF;
        } // pay 5% off CIF for weight between 1500 and 2000 tonnes
        else if (GrossWeight<5000) {
            cost = 0.00000; //
        }
        System.out.println("Gross weight costs: " + cost);
        obj.nextLine();

        System.out.println("Enter age of the vehicle(in years): ");
        int CarAge = obj.nextInt();
        obj.nextLine();
        double age = 0;
        if (CarAge>=1&& CarAge<=5){
            age = (0.01*CIF)+ InfrastructureLevy;
        } else if (CarAge>=5 && CarAge<=10) {
            age = (0.15*CIF)+ InfrastructureLevy;
        } else if (CarAge>10) {
            age = (0.25*CIF) + InfrastructureLevy;
        }
        System.out.println("Car Age costs: " + age);
    }
}
