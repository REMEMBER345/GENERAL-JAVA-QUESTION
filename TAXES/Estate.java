package TAXES;

import java.util.Scanner;

public class Estate extends TaxRate{
    public static final double InfrastructureLevy = 150000; // flat amount IF
    public static double CIF;
    public void EstateInfo() {

        System.out.println("Mandatory to Pay The following:");
        System.out.println("StampDuty: " + StampDuty);
        System.out.println("FormFees: " + FormFees);
        System.out.println("Excise Duty: " + ExciseDuty);

        System.out.println("Required to Pay The following: " + "Import Duty, " + " VAT," + " WHT," +  " IL");
        }
        public double determineImportDuty(){
        return 0.25*CIF;
        }
        public double determineWithholdingTax() {
        return 0.18*CIF;
    }
        public double determineValueAddedTax() {
        return 0.06*CIF;
    }
        public void choosePlateSystem(){

            if (NumberPlateType.equals("APS")) {
                flatRate = 300000;
            } else if (NumberPlateType.equals("DPS")) {
                flatRate = 700000;
            } else {
                flatRate = 0;
            }
        }
    public static void main(String[]args) {
        Estate car = new Estate();
        Scanner obj = new Scanner(System.in);

        System.out.println("Vehicle Details: ");

        car.EstateInfo();
        obj.nextLine();

        System.out.println("The importer can choose between APS and DPS for number plate System");
        System.out.print("Insert type of number plate System:");
        NumberPlateType = obj.next();
        car.choosePlateSystem();
        System.out.println("The flat rate for " + NumberPlateType + " is: " + flatRate);
        obj.nextLine();

        System.out.println("Enter CIF: ");
        double CIF =obj.nextDouble();

        double ImportDuty = car.determineImportDuty();
        System.out.println("Import Duty is: " + ImportDuty);

        double VAT = car.determineValueAddedTax();
        System.out.println("VAT is: " + VAT);

        double WHT = car.determineWithholdingTax();
        System.out.println("Withholding Tax is: " + WHT);
        obj.nextLine();

        System.out.println("Enter Seating capacity: ");
        int SeatingCapacity = obj.nextInt();
         obj.nextLine();

        System.out.println("Enter Gross Weight: ");
        double GrossWeight = obj.nextDouble(); // weight measured in tonnes

        System.out.println("Enter Engine capacity: ");
        int EngineCapacity = obj.nextInt();

        System.out.println("Enter age of the vehicle(in years): ");
        int CarAge = obj.nextInt();
        obj.nextLine();

        // for calculating cost of extra seat
        double CostForExtraSeat = 0;
        if (SeatingCapacity>5){
            CostForExtraSeat =(SeatingCapacity-5)*25000;
        }

        //for calculating gross weight
        double cost = 0;
        if (GrossWeight>=1500 && GrossWeight<=2000){
            cost = 0.05*CIF;
        } // pay 5% off CIF for weight between 1500 and 2000 tonnes
        else if (GrossWeight>2000) {
            cost = 0.10*CIF; // 10% off for weight greater than 2000
        } else if (GrossWeight<1500) {
            cost = 0.02*CIF; //2% off CIF for weight less than 1500
        }

       // for engine
        double engine = 0;
       if (EngineCapacity>1800){
           engine = 0.05*CIF; // pay 5% off CIF
       }
       else {
           engine = 0.025*CIF; // 2.5% off CIF
       }
       //for car age
        double age = 0;
       if (CarAge>=1&& CarAge<=5){
           age = (0.01*CIF)+ InfrastructureLevy;
       } else if (CarAge>=5 && CarAge<=10) {
           age = (0.05*CIF)+ InfrastructureLevy;
       } else if (CarAge>10) {
           age = (0.15*CIF) + InfrastructureLevy;
       }
        System.out.println("Extra Seat cost: " + CostForExtraSeat);
        obj.nextLine();
        System.out.println("Gross weight costs: " + cost);
        obj.nextLine();
        System.out.println("Engine Capacity costs: " + engine);
        obj.nextLine();
        System.out.println("Car Age costs: " + age);
    }
}
