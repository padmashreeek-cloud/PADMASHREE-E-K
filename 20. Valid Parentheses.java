class Solution {
    public boolean isValid(String s) {
        // Optimization: Odd length strings can never be valid
        if (s.length() % 2 != 0) {
            return false;
        }

        // Use a character array as a fast stack pointer
        char[] stack = new char[s.length()];
        int head = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // When encountering an open bracket, expect its closing counterpart
            if (c == '(') {
                stack[head++] = ')';
            } else if (c == '{') {
                stack[head++] = '}';
            } else if (c == '[') {
                stack[head++] = ']';
            } else {
                // If it's a closing bracket, it must match the expected one
                if (head == 0 || stack[--head] != c) {
                    return false;
                }
            }
        }
        return head==0;
    }
}
