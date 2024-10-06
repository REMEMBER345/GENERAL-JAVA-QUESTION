package TAXES;

import java.util.Scanner;

public class Trailer extends TaxRate{
    public static final String seatingCapacity="Standard";
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
        System.out.println("VEHICLE DETAILS: TRAILER" );
        System.out.println("Mandatory to Pay The following:");
        System.out.println("StampDuty: " + StampDuty);
        System.out.println("FormFees: " + FormFees);
        System.out.println("Excise Duty: " + ExciseDuty);
    }

    public static void main(String[]args){
        Trailer trailer = new Trailer();
        Scanner obj = new Scanner(System.in);
        System.out.print("Choose between DPS and APS for number plate System:");
        obj.nextLine();
        System.out.print("Insert type of number plate System:");
        NumberPlateType = obj.next();
        trailer.Registration();
        System.out.println("The flat rate for " + NumberPlateType + " is: " + flatRate);
        obj.nextLine();
        trailer.details();
        System.out.println("Trailers have a fixed seating capacity: " + seatingCapacity);
        obj.nextLine();

       System.out.println("Enter CIF value:");
        double CIF = obj.nextDouble();

        System.out.println("Enter Gross Weight: ");
        double GrossWeight = obj.nextDouble(); // weight measured in tonnes

        double cost = 0;
        if (GrossWeight>=15000&&GrossWeight<=20000){
            cost = 0.15*CIF;
        } // pay 15% off CIF for weight between 15000 and 20000 tonnes
        else if (GrossWeight>20000) {
            cost = 0.25*CIF; //
        } else if (GrossWeight<15000) {
            cost = 0.05*CIF;
        }
        System.out.println("Gross weight costs: " + cost);
        obj.nextLine();

        System.out.println("Enter Engine capacity: ");
        int EngineCapacity = obj.nextInt();
        // for engine
        double engine = 0;
        if (EngineCapacity>2000){
            engine = 0.10*CIF; // pay 10% off CIF
        }
        if(EngineCapacity>=15000&&EngineCapacity<=20000){
            engine = 0.05*CIF; // 5% off CIF
        }
        else if (EngineCapacity<15000){
            engine = 0.025*CIF;
        }
        obj.nextLine();
        System.out.println("Engine Capacity costs: " + engine);

        System.out.println("Enter age of the vehicle(in years): ");
        int CarAge = obj.nextInt();
        obj.nextLine();
        //for car age
        double age = 0;
        if (CarAge>=10&& CarAge<=15){
            age = (0.01*CIF)+ InfrastructureLevy;
        } else if (CarAge>=5 && CarAge<=10) {
            age = (0.05*CIF)+ InfrastructureLevy;
        } else if (CarAge<5) {
            age = (0.015*CIF) + InfrastructureLevy;
        }
        System.out.println("Car Age costs: " + age);
    }
}
