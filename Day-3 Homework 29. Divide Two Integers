class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow case: -2147483648 / -1 = 2147483647
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        // True if signs are different, false if they are the same
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert both numbers to negative to prevent overflow issues with Integer.MIN_VALUE
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int result = 0;

        // Shift divisor left until it exceeds dividend, then subtract
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            int multiple = 1;

            // Double the divisor using bitwise left shift until it's larger than the remaining dividend
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            // Remove the largest chunk possible and add the multiple to the result
            absDividend -= tempDivisor;
            result += multiple;
        }

        // Apply the sign to the final quotient
        return isNegative ? -result : result;
    }
}
