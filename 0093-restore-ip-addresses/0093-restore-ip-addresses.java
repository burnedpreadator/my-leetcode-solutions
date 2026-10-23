class Solution {
    private List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0, new ArrayList<>());
        return result;
    }

    private void backtracking(String s, int start, List<String> curr_path){
        if(curr_path.size() == 4){
            if(start  == s.length()){
                result.add(String.join(".", curr_path));
            }
            return;
        }

        for(int i=1; i<4; i++){
            if(start + i > s.length()){
                break;
            }

            String segment = s.substring(start, start+i);

            if(segment.length()>1 && segment.charAt(0) == '0'){
                break;
            }

            if(Integer.parseInt(segment)>255){
                continue;
            }

            curr_path.add(segment);

            backtracking(s, start+i, curr_path);

            curr_path.remove(curr_path.size() - 1);
        }

    }
}