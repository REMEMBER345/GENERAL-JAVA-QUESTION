package TAXES;
import java.util.Scanner;// scanner to capture the CIF value
public class TaxRate {
    // attributes for tax calculation
    public static final double InfrastructureLevy = 150000; // flat amount IF
    public static double StampDuty = 35000; //flat amount SD
    public static double FormFees = 20000; // flat amount FF
    public static double ExciseDuty = 200000; //flat amount ED
    public static String NumberPlateType;
    public static double flatRate;
    public static double CIF;
    public void calculateRegistration() {

        if (NumberPlateType.equals("APS")) {
            flatRate = 300000;
        } else if (NumberPlateType.equals("DPS")) {
            flatRate = 700000;
        } else {
            flatRate = 0;
        }
    }
//methods to calculate the taxes
    public double calculateImportDuty(){
        return 0.25*CIF;
    }
    public double calculateValueAddedTax(){
        return 0.18*CIF;
    }
    public double calculateWithholdingTax(){
        return 0.06*CIF;
    }

    public static void main(String[] args) {
        TaxRate tax = new TaxRate();
        Scanner obj = new Scanner(System.in);

        System.out.print("Insert type of number plate System:");
        NumberPlateType = obj.next();
        tax.calculateRegistration();
        System.out.println("The flat rate for " + NumberPlateType + " is: " + flatRate);
        obj.nextLine();

        System.out.println("Insert CIF value:");
        CIF = obj.nextDouble();
        double ImportDuty = tax.calculateImportDuty();
        System.out.println("The import duty is: " + ImportDuty);

        double ValueAddedTax = tax.calculateValueAddedTax();
        System.out.println("The VAT is: " + ValueAddedTax);

        double WithholdingTax = tax.calculateWithholdingTax();
        System.out.println("The Withholding tax is: " + WithholdingTax);
        }
    }



