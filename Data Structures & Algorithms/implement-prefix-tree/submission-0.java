class PrefixTree {

    private final TreeNode root;

    public PrefixTree() {
         root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode node = root;
        for (char c: word.toCharArray()) {
            if (!node.hasChild(c)) {
                node.put(c);
            }
            node = node.get(c);
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TreeNode node = root;
        for (char c: word.toCharArray()) {
            if (!node.hasChild(c)) {
                return false;
            }
            node = node.get(c);
        }

        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        TreeNode node = root;
        for (char c: prefix.toCharArray()) {
            if (!node.hasChild(c)) {
                return false;
            }
            node = node.get(c);
        }

        return node != null;
    }

    private class TreeNode {
        boolean isWord;
        TreeNode[] children = new TreeNode[26];

        boolean hasChild(char c) {
            return children[c - 'a'] != null;
        }

        TreeNode get(char c) {
            return children[c - 'a'];
        }

        void put(char c) {
            children[c - 'a'] = new TreeNode();
        }
    }
}
