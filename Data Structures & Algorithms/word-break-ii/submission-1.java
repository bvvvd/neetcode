class Solution {
    private List<String> breaks;
    private Trie trie;
    private String s;

    public List<String> wordBreak(String s, List<String> wordDict) {
        trie = new Trie();
        this.s = s;
        for (String word: wordDict) {
            trie.insert(word);
        }
        breaks = new ArrayList<>();
        backtrack(0, new LinkedList<>());

        return breaks;
    }

    private void backtrack(int start, LinkedList<String> option) {
        if (start == s.length()) {
            breaks.add(String.join(" ", option));
        } else {
            TrieNode node = trie.root;
            for (int length = 0; start + length < s.length(); length++) {
                char c = s.charAt(start + length);
                if (!node.has(c)) {
                    break;
                }
                node = node.get(c);

                if (node.isWord) {
                    option.add(s.substring(start, start + length + 1));
                    backtrack(start + length + 1, option);
                    option.removeLast();
                }
            }
        }
    }

    private class Trie {
        private final TrieNode root = new TrieNode();

        void insert(String word) {
            TrieNode node = root;
            for (char c: word.toCharArray()) {
                if (!node.has(c)) {
                    node.put(c);
                }
                node = node.get(c);
            }

            node.isWord = true;
        }
    }

    private class TrieNode {
        private final TrieNode[] children = new TrieNode[26];
        private boolean isWord;

        boolean has(char c) {
            int index = c - 'a';
            return index >= 0 && index < children.length && children[c - 'a'] != null;
        }

        void put(char c) {
            children[c - 'a'] = new TrieNode();
        }

        TrieNode get(char c) {
            return children[c - 'a'];
        }
    }
}