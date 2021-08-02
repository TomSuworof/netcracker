package homeworks.hwFromLecture3;

public class Main {
    public static void main(String[] args) {
        Palindrome palindrome = new PalindromeChecker();

        int x = 121;
        System.out.println("\nInput: " + x);
        System.out.println("Output: " + palindrome.isPalindrome(x));

        x = 10;
        System.out.println("\nInput: " + x);
        System.out.println("Output: " + palindrome.isPalindrome(x));
    }
}
