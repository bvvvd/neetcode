class Solution {
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        int l = a.length() - 1;
        int r = b.length() - 1;

        while (l >= 0 || r >= 0) {
            int left = l >= 0 ? (a.charAt(l) == '1' ? 1 : 0) : 0;
            int right = r >= 0 ? (b.charAt(r) == '1' ? 1 : 0) : 0;

            l--;
            r--; 
            int sum = left + right + carry;
            builder.append(sum % 2);
            carry = sum / 2;
        }

        if (carry == 1) {
            builder.append(1);
        }

        return builder.reverse().toString();
    }
}