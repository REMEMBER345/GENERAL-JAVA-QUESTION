package TAXES;
import java.util.Scanner;

public class Ambulance extends TaxRate{
    public static double CIF; //CIF
    public static int CarAge;// age of the car derived from the year of the manufacturer
    public static String CarType;
    //for Ambulance
    public void AmbulanceInfo(){
        if (CarType.equals("Ambulance")){
            System.out.println("The Ambulance is exempted from paying Import Duty, Value Added Tax and withholding tax.");
            System.out.println("It is mandatory for the importer to pay Stamp Duty, Form Fees and Excise Duty");
            System.out.println("Stamp duty: shs " + StampDuty);
            System.out.println("Form fees: shs " + FormFees);
            System.out.println("Excise duty: shs " + ExciseDuty);
            //the ambulance is required to have digital plate
            System.out.println("Mandatory Plate System:  DPS");
            if (CarAge>10){
                double InfrastructureLevy = 0.15*CIF;
                System.out.println("The Infrastructure Levy  for Ambulance older than ten Years is: shs " +InfrastructureLevy);
            }
            else {
                double FlatAmount = 150000;
                System.out.println("The IL for newer ambulances less than 10 years: shs " +FlatAmount);
            }
        }
    }
    public static void main(String[]args){
        Ambulance car  = new Ambulance();
        Scanner obj = new Scanner(System.in);

        System.out.println("CIF: shs ");
        CIF = obj.nextDouble();
        obj.nextLine();

        System.out.println("Ambulance Import Details");
        System.out.println("Vehicle Type: ");
        CarType = obj.next();
        car.AmbulanceInfo();
    }
}
