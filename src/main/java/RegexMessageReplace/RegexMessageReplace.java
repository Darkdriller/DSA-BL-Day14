package RegexMessageReplace;

/**
 * @author Dhruv
 * @project Day14
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegexMessageReplace {

    /**
     * Main program. The replacement done in Main method by using Regular Expression
     *
     * @param args
     */
    public static void main(String[] args) {
        // Example input values
        String firstName = "Dhruv";
        String fullName = "Dhruvjyoti Swain";
        String mobileNumber = "91-1234567890";
        String currentDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

        // Message template
        String message = "Hello <<name>>, We have your full name as <<full name>> in our system. "
                + "your contact number is 91-xxxxxxxxxx. Please, let us know in case of any clarification "
                + "Thank you BridgeLabz 01/01/2016.";

        // Replace placeholders with actual values using regex
        message = message.replaceAll("<<name>>", firstName);
        message = message.replaceAll("<<full name>>", fullName);
        message = message.replaceAll("91-xxxxxxxxxx", mobileNumber);
        message = message.replaceAll("\\d{2}/\\d{2}/\\d{4}", currentDate);

        // Print the modified message
        System.out.println(message);
    }
}
