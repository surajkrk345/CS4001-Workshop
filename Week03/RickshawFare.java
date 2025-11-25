import java.util.Scanner;
import java.text.DecimalFormat;

public class RickshawFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        final double BASE_FARE = 25.0;       
        final double PER_KM = 15.0;          
        final double PER_MIN = 2.0;          
        final double LOCAL_DISCOUNT_RATE = 0.10; 
        final double NIGHT_SURCHARGE_RATE = 0.20; 
        final double LONG_DISTANCE_THRESHOLD = 10.0; 
        
        System.out.print("Enter distance (km): ");
        double distance = sc.nextDouble();

        System.out.print("Enter time (minutes): ");
        double minutes = sc.nextDouble();
        sc.nextLine(); 

        System.out.print("Is the customer a local? (yes/no): ");
        String localAnswer = sc.nextLine().trim().toLowerCase();
        boolean isLocal = localAnswer.equals("yes") ? true : false; 

        System.out.print("Is this travel during night? (yes/no): ");
        String nightAnswer = sc.nextLine().trim().toLowerCase();
        boolean isNight = nightAnswer.equals("yes") ? true : false; 

        double fare = BASE_FARE + (PER_KM * distance) + (PER_MIN * minutes);

        double discount = 0.0;
        discount = (isLocal && distance >= LONG_DISTANCE_THRESHOLD) ? (fare * LOCAL_DISCOUNT_RATE) : 0.0;

        double fareAfterDiscount = fare - discount;
        double nightSurcharge = isNight ? (fareAfterDiscount * NIGHT_SURCHARGE_RATE) : 0.0;

        double finalFare = fareAfterDiscount + nightSurcharge;

        System.out.println();
        System.out.println("----- Fare Summary -----");
        System.out.println("Base fare: Rs. " + df.format(BASE_FARE));
        System.out.println("Distance charge (" + distance + " km): Rs. " + df.format(PER_KM * distance));
        System.out.println("Time charge (" + minutes + " min): Rs. " + df.format(PER_MIN * minutes));
        System.out.println("Subtotal: Rs. " + df.format(fare));
        System.out.println("Local discount: Rs. " + df.format(discount));
        System.out.println("Night surcharge: Rs. " + df.format(nightSurcharge));
        System.out.println("------------------------");
        System.out.println("Final fare: Rs. " + df.format(finalFare));
        System.out.println("------------------------");

        sc.close();
    }
}
