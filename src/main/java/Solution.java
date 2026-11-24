class Solution {
    public int maxLength(int[] nums) {
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            int gcd = nums[i];
            int lcm = nums[i];
            int prod = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                prod *= nums[j];
                gcd = gcd(gcd, nums[j]);
                lcm = lcm(lcm, nums[j]);
                if (prod == gcd * lcm) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;

        }
        return a;
    }

    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}