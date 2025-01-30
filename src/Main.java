import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a feedback processor
        FeedbackProcessor processor = new SimpleFeedbackProcessor();

        // Create a MusicTherapy session using the processor
        MusicTherapy therapy = new MusicTherapy(processor);

        System.out.println("Welcome to the Migraine Music Therapy Program!");

        // Collect feedback from the user
        System.out.print("Enter your feeling rating (1-5): ");
        int feelingRating = scanner.nextInt();

        System.out.print("Enter your headache severity (1-5): ");
        int headacheRating = scanner.nextInt();

        System.out.print("Enter your smell sensitivity (1-5): ");
        int smellSensitivity = scanner.nextInt();

        System.out.print("Enter your light sensitivity (1-5): ");
        int lightSensitivity = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Do you prefer hot or cool temperature? ");
        String temperaturePreference = scanner.nextLine();

        // Add feedback to the therapy session
        Feedback feedback = new Feedback(feelingRating, headacheRating, smellSensitivity, lightSensitivity, temperaturePreference);
        therapy.addFeedback(feedback);

        // Display feedback summary
        therapy.summarizeFeedback();

        scanner.close();
    }
}
