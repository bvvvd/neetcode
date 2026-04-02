class Solution {

    public String encode(List<String> strs) {
        if (strs == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        for (String str: strs) {
            if (str == null) {
                builder.append('@');
            } else {
                builder.append(str.length())
                    .append('#')
                    .append(str);
            }
        }

        return builder.toString();
    }

    // "5#hello5#world"
    public List<String> decode(String str) {
        List<String> decodedStrings = new ArrayList<>();
        if (str == null) {
            return decodedStrings;
        }

        int index = 0;
        int currentNumber = 0;
        while (index < str.length()) {
            char currentChar = str.charAt(index);

            if (currentChar == '@') {
                decodedStrings.add(null);
            } else if (currentChar == '#') {
                index++;
                decodedStrings.add(str.substring(index, index + currentNumber));
                index = index + currentNumber - 1;
                currentNumber = 0;
            } else {
                currentNumber = currentNumber * 10 + currentChar - '0';
            }
            index++;
        }

        return decodedStrings;
    }
}
