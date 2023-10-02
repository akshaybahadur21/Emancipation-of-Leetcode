class Solution {
    public boolean winnerOfGame(String colors) {
        int a = 0, b = 0;
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < colors.length(); i++){
            char curr = colors.charAt(i);
            if(s.isEmpty()){
                s.push(curr);
                continue;
            }
            if(i < colors.length() - 1){
                char prev = s.peek();
                char next = colors.charAt(i + 1);
                if(prev == curr && curr == next){
                    if(prev == 'A')a++;
                    else b++;
                }
                else s.push(curr);
            }
        }
        return a > b;
    }
}
