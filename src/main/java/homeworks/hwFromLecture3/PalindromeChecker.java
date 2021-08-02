package homeworks.hwFromLecture3;

public class PalindromeChecker implements Palindrome {
    @Override
    public boolean isPalindrome(int x) {

        String str = String.valueOf(Math.abs(x));
        StringBuilder strReversed = new StringBuilder(str).reverse();

        return str.equals(strReversed.toString());
    }
}
