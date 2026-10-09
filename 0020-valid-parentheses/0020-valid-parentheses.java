class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> bracketMap = Map.of('(', ')', '{', '}', '[', ']');
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            System.out.println(ch);
            if(bracketMap.containsKey(ch)){
                System.out.println("containsKey" + ch);
                stack.push(bracketMap.get(ch));
            }else{
                if (stack.isEmpty()) {
                    return false;
                }
                char cp = stack.pop();
                System.out.println("pooled : " + cp);
                if(ch != cp){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}