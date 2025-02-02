import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FeedbackProcessor processor = new SimpleFeedbackProcessor();
        MusicTherapy therapy = new MusicTherapy(UUID.randomUUID().toString(), processor);

        System.out.println("Welcome to the Migraine Music Therapy Program!");

        int feelingRating = getInput(scanner, "Enter your feeling rating (1-5): ");
        int headacheRating = getInput(scanner, "Enter your headache severity (1-5): ");
        int smellSensitivity = getInput(scanner, "Enter your smell sensitivity (1-5): ");
        int lightSensitivity = getInput(scanner, "Enter your light sensitivity (1-5): ");

        scanner.nextLine(); // Consume leftover newline
        System.out.print("Do you prefer hot or cool temperature? ");
        String temperaturePreference = scanner.nextLine();

        System.out.print("Enter your favorite music genre: ");
        String genre = scanner.nextLine();

        System.out.print("Enter your favorite track: ");
        String favoriteTrack = scanner.nextLine();

        System.out.print("What mood do you prefer in music? ");
        String mood = scanner.nextLine();

        System.out.print("What is your preferred instrument? ");
        String preferredInstrument = scanner.nextLine();

        MusicPreference musicPreference = new MusicPreference(genre, favoriteTrack, mood, preferredInstrument);
        Feedback feedback = new Feedback(UUID.randomUUID().toString(), feelingRating, headacheRating, smellSensitivity, lightSensitivity, temperaturePreference, musicPreference);
        therapy.addFeedback(feedback);

        therapy.summarizeFeedback();
        scanner.close();
    }

    private static int getInput(Scanner scanner, String prompt) {
        int value;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number (1-5): ");
                scanner.next();
            }
            value = scanner.nextInt();
        } while (value < 1 || value > 5);
        return value;
    }
}