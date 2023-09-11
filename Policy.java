/**
   A program that keeps track of insurance policies.
   Yusi Wu
   CSC 251
   Fall 2023
*/
import java.lang.Math;
import java.util.Scanner;

public class Policy
{
   public static void main(String[] args)
   {
      int policyNumber = 0, // The ID number of the insurance policy.
          age = 0; // The age of the policyholder.
      String providerName = "", // The name of the insurance company.
             firstName = "", // The first name of the policyholder.
             lastName = "", // The last name of the policyholder.
             smokingStatus = ""; // Smokeing status of policy holder (smoker/non-smoker).
      double height = 0.0, // Height of the policyholder in inches.
             weight = 0.0, // Weight of the policyholder in pounds.
             BMI = 0.0,
             totalPrice = 0.0;
             
      Scanner keyboard = new Scanner(System.in);
      
      // User inputs.
      System.out.print("Please enter the Policy Number: ");
      policyNumber = keyboard.nextInt();
      
      keyboard.nextLine(); // Clears newline characters.
      
      System.out.print("Please enter the Provider Name: ");
      providerName = keyboard.nextLine();
      
      System.out.print("Please enter the Policyholder’s First Name: ");
      firstName = keyboard.nextLine();
      
      System.out.print("Please enter the Policyholder’s Last Name: ");
      lastName = keyboard.nextLine();
      
      System.out.print("Please enter the Policyholder’s Age: ");
      age = keyboard.nextInt();
      
      keyboard.nextLine(); // Clears newline characters.
      
      System.out.print("Please enter the Policyholder’s Smoking Status (smoker/non-smoker): ");
      smokingStatus = keyboard.nextLine();
      
      System.out.print("Please enter the Policyholder’s Height (in inches): ");
      height = keyboard.nextDouble();
      
      System.out.print("Please enter the Policyholder’s Weight (in pounds): ");
      weight = keyboard.nextDouble();
      
      BMI = calculateBMI(weight, height);
      
      totalPrice = calculatePolicyPrice(age, smokingStatus, BMI);
      
      System.out.println("Policy Number: " + policyNumber);
      System.out.println("Provider Name : " + providerName);
      System.out.println("Policyholder’s First Name: " + firstName);
      System.out.println("Policyholder’s Last Name: " + lastName);
      System.out.println("Policyholder’s Age: " + age);
      System.out.println("Policyholder’s Smoking Status: " + smokingStatus);
      System.out.println("Policyholder’s Height: " + height + " inches");
      System.out.println("Policyholder’s Weight: " + weight + " pounds");
      System.out.printf("Policyholder’s BMI: %,.2f\n", BMI);
      System.out.printf("Policy Price: $%,.2f\n", totalPrice);

   }
   
   /**
      Calculates BMI based on a formula.
      @param weight Weight of the user.
      @param height Height of the user.
      @return BMI Calculated BMI of the user.
   */
   public static double calculateBMI(double weight, double height)
   {
      double BMI = 0.0;
      
      BMI = (weight * 703) / (Math.pow(height, 2));
      
      return BMI;
   }
   
   /**
      Calculates the price of the policy based on the user's age, smoking status, and BMI.
      @param age User's age.
      @param smokingStatus If the user is a smoker Y/N.
      @param BMI Calculated BMI of the user.
      @return totalPrice Total price of the policy based on above factors.
   */
   public static double calculatePolicyPrice(int age, String smokingStatus, double BMI)
   {
      final double BASE_FEE = 600.0,
                   OVER_50 = 75.0,
                   SMOKER_FEE = 100.0;
      final String SMOKER = "smoker";
      final int THIRTY_FIVE = 35;
      
      double feeBMI = 0.0,
             totalPrice = 0.0;
      
      totalPrice = BASE_FEE;
      
      if (age > 50)
      {
         totalPrice += OVER_50;
      }
      
      if (smokingStatus == SMOKER)
      {
         totalPrice += SMOKER_FEE;
      }
      
      if (BMI > THIRTY_FIVE)
      {
         feeBMI = (BMI - 35) * 20;
         totalPrice += feeBMI;
      }
      
      return totalPrice;
   }
}