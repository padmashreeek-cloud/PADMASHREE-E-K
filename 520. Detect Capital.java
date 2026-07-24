class Solution {
    public boolean detectCapitalUse(String word) {
        int length = word.length();
        int upperCount = 0;
        for (int i = 0; i < length; i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                upperCount++;
            }
        }

        if (upperCount == length || upperCount == 0) {
            return true;
        }

        return upperCount == 1 && Character.isUpperCase(word.charAt(0));
    }
}
