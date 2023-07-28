public class WelcomeMessage {
    public static void main(String[] args) {
        String studentName = "Khaled";  // replace with the actual student name

        LocalDateTime currentTime = LocalDateTime.now();
        LocalTime noon = LocalTime.of(12, 0);
        LocalTime currentLocalTime = currentTime.toLocalTime();

        String greeting;

        if (currentLocalTime.isBefore(noon)) {
            greeting = "Good morning, " + studentName + ", Welcome to COMP367";
        } else {
            greeting = "Good afternoon, " + studentName + ", Welcome to COMP367";
        }

        System.out.println(greeting);
    }
}