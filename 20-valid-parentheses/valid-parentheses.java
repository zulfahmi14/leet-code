class Solution {
    private boolean isMatch(char a, char b) {
        if (a == '(' && b == ')') return true;
        if (a == '{' && b == '}') return true;
        if (a == '[' && b == ']') return true;
        return false;
    }

    private boolean openBracket(char a) {
        return a == '(' || a == '{' || a == '[';
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char[] ch = s.toCharArray();

        for(int i = 0 ; i < ch.length ; i++) {
            if (openBracket(ch[i])) {
                st.push(ch[i]);
            } else {
                if (st.isEmpty()) {
                    return false;
                }

                char top = st.pop();
                if (!isMatch(top, ch[i])) {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}