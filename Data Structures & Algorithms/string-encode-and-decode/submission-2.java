class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (String str: strs) {
            builder.append(str.length())
                .append('#')
                .append(str);
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int index = 0;
        int length = 0;

        while (index < str.length()) {
            if (str.charAt(index) == '#') {
                index++;
                decoded.add(str.substring(index, index + length));
                index = index + length;
                length = 0;
            } else {
                length = length * 10 + str.charAt(index) - '0';
                index++;
            }
        }

        return decoded;
    }
}
