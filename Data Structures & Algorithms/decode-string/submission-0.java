class Solution {
    private String s;
    private int index;

    public String decodeString(String s) {
        this.s = s;
        index = 0;

        return decode();
    }

    private String decode() {
        int currentNumber = 0;

        StringBuilder builder = new StringBuilder();
        while (index < s.length()) {                                    // 0
            char c = s.charAt(index);                                   // 2
            index++;                                                    // 1
            if (Character.isLetter(c)) {                                
                if (currentNumber != 0) {
                    builder.append(Integer.toString(currentNumber));
                    currentNumber = 0;
                }
                builder.append(c);
            } else if (Character.isDigit(c)) {                          // cN = 2
                currentNumber = currentNumber * 10 + c - '0';
            } else if (c == ']') {
                return builder.toString();
            } else {                                                    
                String segment = decode();
                System.out.println(segment);
                System.out.println(currentNumber);
                do {
                    builder.append(segment);
                    currentNumber--;
                } while (currentNumber > 0);
                currentNumber = 0;
            }
        }

        return builder.toString();
    }
}