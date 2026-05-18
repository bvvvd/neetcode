class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word: wordDict) {
            trie.insert(word);
        }

        return wordBreak(s, 0, trie, new HashMap<>());
    }

    private boolean wordBreak(String s, int index, Trie trie, Map<Integer, Boolean> cache) {
        if (index >= s.length()) {
            return true;
        }
        if (cache.containsKey(index)) {
            return cache.get(index);
        }

        TrieNode node = trie.root;
        boolean canBreak = false;
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if (node.has(c)) {
                node = node.get(c);
            } else {
                break;
            }
            if (node.isWord && wordBreak(s, i + 1, trie, cache)) {
                canBreak = true;
                break;
            }
        }

        cache.put(index, canBreak);
        return canBreak;
    }

    private class Trie {
        private final TrieNode root;

        Trie() {
            root = new TrieNode();
        }

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
        boolean isWord;
        private final TrieNode[] children = new TrieNode[26];

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
