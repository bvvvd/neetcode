class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Trie trie = new Trie();
        for (String word: dictionary) {
            trie.insert(word);
        }

        int[] dp = new int[s.length() + 1];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i] = 1 + dp[i + 1];

            TrieNode node = trie.root;
            for (int j = i; j < s.length(); j++) {
                if (!node.has(s.charAt(j))) {
                    break;
                }
                node = node.get(s.charAt(j));
                if (node.isWord) {
                    dp[i] = Math.min(dp[i], dp[j + 1]);
                }
            }
        }

        return dp[0];
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
        private boolean isWord;
        private TrieNode[] children = new TrieNode[26];

        boolean has(char c) {
            return children[c - 'a'] != null;
        }

        TrieNode get(char c) {
            return children[c - 'a'];
        }

        void put(char c) {
            children[c - 'a'] = new TrieNode();
        }
    }
}