class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadend = new HashSet<>();
        for (String d: deadends) {
            deadend.add(d);
        }

        if (deadend.contains("0000")) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        queue.add("0000");
        seen.add("0000");
        int modifications = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String code = queue.poll();
                if (code.equals(target)) {
                    return modifications;
                }
                List<String> children = modify(code);
                for (String child: children) {
                    if (!seen.contains(child) && !deadend.contains(child)) {
                        queue.add(child);
                        seen.add(child);
                    }
                }
            }
            modifications++;
        }

        return -1;
    }

    private List<String> modify(String code) {
        char[] chars = code.toCharArray();
        List<String> modifications = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char original = chars[i];
            
            chars[i] = original == '9' ? '0' : (char) (original + 1);
            modifications.add(new String(chars));
            
            chars[i] = original == '0' ? '9' : (char) (original - 1);
            modifications.add(new String(chars));
            
            chars[i] = original;
        }
        return modifications;
    }
}