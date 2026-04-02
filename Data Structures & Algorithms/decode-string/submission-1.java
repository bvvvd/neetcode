class Solution {
    private int index;
    private String s;

    public String decodeString(String s) {
        if (s == null) {
            return null;
        }
        this.s = s;
        this.index = 0;
        return decode();
    }

    private String decode() {
        StringBuilder builder = new StringBuilder();
        int number = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            index++;

            if (c == ']') {
                return builder.toString();
            }

            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
            } else if (c == '[') {
                String subString = decode();
                do {
                    builder.append(subString);
                    number--;
                } while (number > 0);
                number = 0;
            } else {
                builder.append(c);
            }
        }

        return builder.toString();
    }
}