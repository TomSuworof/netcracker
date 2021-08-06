package lectures.lecture15;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(solve(new String[]{"flower", "flow", "flight"})); // "fl"
        System.out.println(solve(new String[]{"dog", "racecar", "car"})); // ""
    }

    private static String solve(String[] strings) {
        StringBuilder strB = new StringBuilder();

        for (int i = 0; i < strings[0].length(); i++) {
            boolean allHave = true;
            try {
                char c = strings[0].charAt(i);
                for (String str : strings) {
                    if (str.toCharArray()[i] != c) {
                        allHave = false;
                        break;
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                return strB.toString();
            }
            if (allHave) {
                strB.append(strings[0].charAt(i));
            }
        }

        return strB.toString();
    }
}
