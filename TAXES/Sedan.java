package TAXES;

import java.util.Scanner;

public class Sedan extends TaxRate{
    public static double CIF;
    public static final double InfrastructureLevy = 150000;
    public static final String seatingCapacity="Standard";
    public void details(){
        System.out.println("The vehicle is a: Sedan");
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
    public static void main(String[]args){
        Sedan sedan = new Sedan();
        Scanner obj = new Scanner(System.in);
        sedan.details();
        System.out.println("Enter CIF Value: shs");
        double CIF = obj.nextDouble(); // set CIF Value from keyboard
        obj.nextLine();
        System.out.println("Importer required to pay the following Taxes for Sedan:");
        double ImportDuty = sedan.ImportDuty();
        System.out.println("Import Duty is: " + ImportDuty);

        double VAT =sedan.ValueAddedTax();
        System.out.println("VAT is: " + VAT);

        double WHT = sedan.WithholdingTax();
        System.out.println("Withholding Tax is: " + WHT);
        obj.nextLine();
        System.out.println("Sedans have a fixed seating capacity: " + seatingCapacity);
        obj.nextLine();

        System.out.println("Enter Gross Weight: ");
        double GrossWeight = obj.nextDouble(); // weight measured in tonnes

        System.out.println("Enter Engine capacity: ");
        int EngineCapacity = obj.nextInt();

        System.out.println("Enter age of the vehicle(in years): ");
        int CarAge = obj.nextInt();
        obj.nextLine();

        double cost = 0;
        if (GrossWeight>=1500 && GrossWeight<=2000){
            cost = 0.10*CIF;
        } // pay 5% off CIF for weight between 1500 and 2000 tonnes
        else if (GrossWeight>2000) {
            cost = 0.15*CIF; // 10% off for weight greater than 2000
        } else if (GrossWeight<1500) {
            cost = 0.02*CIF; //2% off CIF for weight less than 1500
        }

// for engine
        double engine = 0;
        if (EngineCapacity>2000){
            engine = 0.10*CIF; // pay 5% off CIF
        }
        if (EngineCapacity<=2000&& EngineCapacity>=1500){
            engine = 0.05*CIF; // 2.5% off CIF
        }
        else if (EngineCapacity<1500)
            engine = 0.025*CIF;

        //for car age
        double age = 0;
        if (CarAge<=15&&CarAge>=10){
            age = (0.01*CIF)+ InfrastructureLevy;
        } else if (CarAge>=5 && CarAge<=10) {
            age = (0.05*CIF)+ InfrastructureLevy;
        } else if (CarAge<5) {
            age = (0.015*CIF) + InfrastructureLevy;
        }
        obj.nextLine();
        System.out.println("Gross weight costs: " + cost);
        obj.nextLine();
        System.out.println("Engine Capacity costs: " + engine);
        obj.nextLine();
        System.out.println("Car Age costs: " + age);
    }
}
