package AnagramCheck;

/**
 * @author Dhruv
 * @project Day14
 **/
import java.util.Arrays;



public class AnagramCheck {

    public static void main(String[] args) {
        String str1 = "heart";
        String str2 = "earth";

        if (isAnagram(str1, str2)) {
            System.out.println("The two strings are anagrams.");
        } else {
            System.out.println("The two strings are not anagrams.");
        }
    }

    public static boolean isAnagram(String str1, String str2) {
        str1 = str1.replaceAll("[\\W]", "").toLowerCase();
        str2 = str2.replaceAll("[\\W]", "").toLowerCase();

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }
}
