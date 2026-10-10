class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int maxLength = 1;

        for (int i = 0; i < s.length(); i++) {
            
            int left1 = i;
            int right1 = i;

            while (left1 >= 0 && right1 < s.length()
                    && s.charAt(left1) == s.charAt(right1)) {
                if (right1 - left1 + 1 > maxLength) {
                    start = left1;
                    maxLength = right1 - left1 + 1;
                }
                left1--;
                right1++;
            }

            
            int left2 = i;
            int right2 = i + 1;

            while (left2 >= 0 && right2 < s.length()
                    && s.charAt(left2) == s.charAt(right2)) {
                if (right2 - left2 + 1 > maxLength) {
                    start = left2;
                    maxLength = right2 - left2 + 1;
                }
                left2--;
                right2++;
            }
        }

        return s.substring(start, start + maxLength);
    }
}

        
    