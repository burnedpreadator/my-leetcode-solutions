class Solution {
    public int myAtoi(String s) {
        if (s==null) return 0;

        int sign = 1;
        int result = 0;
        int i = 0;
        int n = s.length();
        boolean isNegative = false;
        while(i < n && s.charAt(i) == ' '){
            i++;
        }
        if (i==n) return 0;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        
        while(i < n){
            char c = s.charAt(i);
            if(c<'0' || c>'9'){
                break;
            }
            int digit = c - '0';
            
            // Check for 32-bit signed integer overflow
            if (result > Integer.MAX_VALUE / 10 || 
               (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = (result*10)+digit;
            i++;
        }
        return result*sign;
    }
}