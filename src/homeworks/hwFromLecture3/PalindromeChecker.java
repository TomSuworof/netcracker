package homeworks.hwFromLecture3;

public class PalindromeChecker implements Palindrome {
    @Override
    public boolean isPalindrome(int x) {
        x = Math.abs(x);

        String str = String.valueOf(x);
        StringBuilder strReversed = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            strReversed.append(str.charAt(str.length() - i - 1));
        }

        return str.equals(strReversed.toString());
    }
}
