//main.java
//Will Denny
//IDE Project 1
//CSC 222-M1 Spring 2023
//Compute the costs of vehicles based on input such as gas, electric, etc.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Variables for our gas car
        final double WEEKS_PER_MONTH = 4.3;
        final int MONTH_IN_YEAR = 12;
        String gasCarName = new String(); //this will hold our data from the user
        double gasCarPayment;
        double gasCostPerGallon;
        double gasAvgMilesRating;
        int avgMilesDrivenWeekly;
        //Variables for EV
        String eCarName = new String();
        double eMonthlyPayment;
        double electricityPerMile;
        //this is a comment  so my project changes and i can push to git hub


        //create new scanner object
        Scanner input = new Scanner(System.in);

        //output about our program
        System.out.println("************");
        //get input from user
        System.out.println("Let's begin by getting details for the gas car.");
        System.out.println("Enter a name for your gas car (Example Toyota Camery): ");
        gasCarName = input.nextLine();

        System.out.println("Enter the monthly finance payment for your car: ");
        gasCarPayment = input.nextDouble();

        System.out.println("Enter the average miles per gallon of gas the car is rated at: ");
        gasCostPerGallon = input.nextDouble();

        System.out.println("Enter the average gas per mile the car is rated at: ");
        gasAvgMilesRating = input.nextDouble();

        //TODO: Ask the electric car questions.


        input.nextLine();

        System.out.println("************");
        System.out.println("Now, since we have the details for the gas car, let's begin getting data for the electric car!");
        System.out.println("Enter a name for your electric car (Example: Tesla X):");
        eCarName = input.nextLine();
        System.out.println("Enter a monthly finance payment for your electric car:");
        eMonthlyPayment = input.nextDouble();

        System.out.println("Enter the cost of electricity per mile:");
        electricityPerMile = input.nextDouble();

        System.out.println("************");
        System.out.println("Great, we have information about both cars. Almost done!");
        System.out.println("************");

//        System.out.println("This is what we have in our eCarName: " + eCarName);
//        System.out.println("This is what we have in our eMonthlyPayment: " + eMonthlyPayment);
//        System.out.println("This is what we have in our electricityPerMile: " + electricityPerMile);
        System.out.println("How many miles on average do you drive per week? ");
        avgMilesDrivenWeekly = input.nextInt();
        System.out.println("************");

//        System.out.println("This is what we have in our gasCarName: " + gasCarName);
//        System.out.println("This is what we have in our gasCarPayment: " + gasCarPayment);
//        System.out.println("This is what we have in our gasCostPerGallon: " + gasCostPerGallon);
//        System.out.println("This is what we have in our gasAvgMilesRating: " + gasAvgMilesRating);
//        System.out.println("This is what we have in our avgMilesDrivenWeekly: " + avgMilesDrivenWeekly);
//        //Electric car questions

        //weekly ecost
        double weeklyGasCosts = calculateWeeklyGasConsumptionCost(avgMilesDrivenWeekly, gasAvgMilesRating, gasCostPerGallon);
        //monthly gas cost
        double gasCarMonthlyGasCosts = weeklyGasCosts * WEEKS_PER_MONTH;
        //monthly cost of gas and payemnt
        double gasMonthlyTotalCosts = gasCarMonthlyGasCosts + gasCarPayment;
        //yearly cost for gas
        double gasYearlyTotalCosts = gasMonthlyTotalCosts * MONTH_IN_YEAR;

        //electric formulas
        //weekly e costs
        double weeklyECosts = calculateWeeklyElectricConsumptionCost(avgMilesDrivenWeekly, electricityPerMile);

        //Monthly e costs
        double monthlyECosts = weeklyECosts * WEEKS_PER_MONTH;

        //monthly total costs
        double eMonthlyTotalCosts = monthlyECosts + eMonthlyPayment;

        //yearly eTotalCosts
        double yearlyETotalCosts = eMonthlyTotalCosts * MONTH_IN_YEAR;
        //saving cost per month
        double savingCostsPerMonth = eMonthlyTotalCosts - gasMonthlyTotalCosts;
        //saving per year
        double savingCostsPerYear = savingCostsPerMonth * 12;

        //output results
        //I used the "printf" method to have my output in the correct format for decimal placement while using "%.3f"
        System.out.println("Results based on data you entered:");
        System.out.println("GAS CAR DATA:");
        System.out.println("Car Name: " + gasCarName);
        System.out.printf("Average Cost/Week for Gas: $%.2f%n", weeklyGasCosts);
        System.out.printf("Average Cost/Month for Payment and Gas: $%.2f (Based on average of 4.3 weeks per month)%n", gasMonthlyTotalCosts);
        System.out.printf("Average Cost/Year for Payment and Gas: $%.2f (monthly costs * 12)%n", gasYearlyTotalCosts);

        System.out.println("************");

        System.out.println("ELECTRIC CAR DATA:");
        System.out.println("Car Name: " + eCarName);
        System.out.printf("Average Cost/Week for Electricity: $%.2f%n", weeklyECosts);
        System.out.printf("Average Cost/Month for Payment and Electricity: $%.2f (Based on average of 4.3 weeks per month)%n", eMonthlyTotalCosts);
        System.out.printf("Average Cost/Year for Payment and Electricity: $%.2f (monthly costs * 12)%n", yearlyETotalCosts);

        System.out.println("************");
        System.out.println("Based on comparison, if you bought the electric car, you would save or lose the following money:");
        System.out.println("Negative means saving, positive means loss/you are paying more.");
        System.out.printf("Savings/Costs per month: $%.2f (electric monthly car costs - gas monthly car cost)%n", savingCostsPerMonth);
        System.out.printf("Savings/Costs per year: $%.2f (Savings per month * 12)%n", savingCostsPerYear);


    }


    //Adding this comment so my prject changes for gitbash

    //method to calculate weekly gas consumption costs
    public static double calculateWeeklyGasConsumptionCost(double weeklyMiles, double avgMilesRating, double gasGallonCost){

        double weeklyGallonsUsed = weeklyMiles/avgMilesRating;

        double weeklyGasCosts = weeklyGallonsUsed * gasGallonCost;

        return weeklyGasCosts;

    }//ends our calculatedWeeklyConsumptionCost

    //method for weekly electric consumption
    public static double calculateWeeklyElectricConsumptionCost(double weeklyMiles, double elecMonthlyCost){

        double weeklyElectricCost = weeklyMiles * elecMonthlyCost;

        return weeklyElectricCost;


    }//ends our calculatedWeeklyElectricConsumptionCost
//Sorry for being late on this assignment for some reason i got confused!!
}