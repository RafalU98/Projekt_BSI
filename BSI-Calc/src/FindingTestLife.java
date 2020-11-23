/*
    Author: Marcin Rozkwitalski

    Exercise 4.1 based on Example 2.1
    Design a test to demonstrate 100,000 miles life at 95% reliability and 60% confidence.
    The available sample size is 6.(Assume b=2)

    Ans: Test life 179,000 miles.
 */
import java.util.Scanner;

public class FindingTestLife {
    private double findTimeLife(double miles, double reliability, double confidence, double samples, double weibull){
        if( confidence > 0.99 ) { confidence = confidence / 100; }
        if( reliability > 0.99 ) { reliability = reliability / 100; }
        double a = ( 1 / (float) samples * ( Math.log10( 1 / ( 1 - confidence ))));
        double b = Math.log10( 1 / (1 - (1 - reliability)));
        double c = Math.pow( (a / b), (1 / weibull) );
        return miles * c;
    }

    public void main() {
        int menu;
        double miles, reliability, confidence, samples, weibull, result;

        System.out.println("4. Finding Test Life with given miles of life, reliability and confidence");
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("\nEnter miles: ");
            miles = Double.parseDouble(input.nextLine());
            if(miles < 0){
                throw new IllegalArgumentException("Value out ot range.");
            }
            System.out.println("\nEnter reliability: ");
            reliability = Double.parseDouble(input.nextLine());
            if(reliability > 100.0 || reliability < 0.01){
                throw new IllegalArgumentException("Value out ot range.");
            }
            System.out.println("\nEnter confidence: ");
            confidence = Double.parseDouble(input.nextLine());
            if(confidence > 100.0 || confidence < 0.01){
                throw new IllegalArgumentException("Value out ot range.");
            }
            System.out.println("\nEnter samples: ");
            samples = Double.parseDouble(input.nextLine());
            if(samples < 1.0){
                throw new IllegalArgumentException("Value out ot range.");
            }
            System.out.println("\nEnter weibull: ");
            weibull = Double.parseDouble(input.nextLine());
            if(weibull < 1.0){
                throw new IllegalArgumentException("Value out ot range.");
            }
            result = findTimeLife(miles, reliability, confidence, samples, weibull);
            System.out.println("Test Life for all samples with no failures would be " + String.format("%.0f", result) + " miles.");
            System.out.println("\nDo you want to go back to the Main Menu? (Enter 1)");
            menu = input.nextInt();
            if(menu == 1) Main.TaskOptions();
        } catch (NumberFormatException exception){
            System.out.println("Wrong data type, enter number.");
        }
    }
}
