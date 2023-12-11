package NumberFinder;

/**
 * @author Dhruv
 * @project Day14
 */
import java.util.Scanner;

public class NumberFinder {

    /**
     * Main class cals findNumber function based on the N value given in arguments
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Assuming N is provided as a command-line argument
        int N = Integer.parseInt(args[0]);
        System.out.println("Think of a number between 0 and " + (N - 1));

        int answer = findNumber(0, N - 1, scanner);
        System.out.println("Your number is: " + answer);
        scanner.close();
    }

    /**
     * Uses Binary Search to triangulate a number chosen by user by repeatedly asking at midpoint
     *
     * @param low
     * @param high
     * @param scanner
     * @return
     */
    private static int findNumber(int low, int high, Scanner scanner) {
        if (low == high) {
            return low;
        }

        int mid = low + (high - low) / 2;
        System.out.println("Is your number less than or equal to " + mid + "? (yes/no)");

        String response = scanner.next();
        if (response.equalsIgnoreCase("yes")) {
            return findNumber(low, mid, scanner);
        } else {
            return findNumber(mid + 1, high, scanner);
        }
    }
}
