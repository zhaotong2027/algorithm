package src.simple;

public class Code0014_LongestCommonPrefix {
    public static void main(String[] args) {

        String[] strs = new String[] {"flower","flow","flight"};
//        String[] strs = new String[] {"dog","racecar","car"};
//        String[] strs = new String[] {"ab", "a"};
        System.out.println(longestCommonPrefix2(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String commP = "";
        for (int j = 0; j < strs[0].length(); j++) {
            commP = strs[0].substring(0, j + 1);
            for (int i = 0; i < strs.length; i++) {
                if (commP.length() > strs[i].length() || (!strs[i].substring(0, j + 1).equals(commP))) {
                    return commP.substring(0, j);
                }
            }
        }
        return commP;
    }

    public static String longestCommonPrefix2(String[] strs) {
        String commP = strs[0];
        for (String string : strs) {
            while (!string.startsWith(commP)){
                commP = commP.substring(0, commP.length() - 1);
            }
        }
        return commP;
    }
}
