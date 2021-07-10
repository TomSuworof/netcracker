package homeworks.hwFromLecture3;

import org.junit.Assert;
import org.junit.Test;

public class PalindromeTest {

    @Test
    public void getCorrectAnswerFor121() {
        int x = 121;
        Palindrome palindrome = new PalindromeChecker();

        Assert.assertTrue(palindrome.isPalindrome(x));
    }

    @Test
    public void getCorrectAnswerForMinus121() {
        int x = -121;
        Palindrome palindrome = new PalindromeChecker();

        Assert.assertTrue(palindrome.isPalindrome(x));
    }

    @Test
    public void getCorrectAnswerFor10() {
        int x = 10;
        Palindrome palindrome = new PalindromeChecker();

        Assert.assertFalse(palindrome.isPalindrome(x));
    }

    @Test
    public void getCorrectAnswerForMinus10() {
        int x = -10;
        Palindrome palindrome = new PalindromeChecker();

        Assert.assertFalse(palindrome.isPalindrome(x));
    }

    @Test
    public void getCorrectAnswerFor0() {
        int x = 0;
        Palindrome palindrome = new PalindromeChecker();

        Assert.assertTrue(palindrome.isPalindrome(x));
    }

    @Test
    public void getCorrectAnswerForMinus0() {
        int x = -0;
        Palindrome palindrome = new PalindromeChecker();

        Assert.assertTrue(palindrome.isPalindrome(x));
    }
}