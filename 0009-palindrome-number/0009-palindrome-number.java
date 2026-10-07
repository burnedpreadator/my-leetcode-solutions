class Solution {
    public boolean isPalindrome(int x) {
        int num = x;
        int reverseNum = 0;

        while(num>0){
            int remainder = num%10;
            reverseNum = (reverseNum*10)+remainder;
            num /= 10;
        }

        if (x == reverseNum){
            return true;
        }

        return false;
    }
}