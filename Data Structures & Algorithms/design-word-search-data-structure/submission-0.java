class WordDictionary {
    private final Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.insert(word);
    }

    public boolean search(String word) {
        return trie.search(word);
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

        boolean search(String word) {
            return search(root, word, 0);
        }

        private boolean search(TrieNode node, String word, int index) {
            if (index == word.length()) {
                return node.isWord;
            }

            char c = word.charAt(index);

            if (c != '.') {
                if (!node.has(c)) {
                    return false;
                }

                return search(node.get(c), word, index + 1);
            }
            
            for (TrieNode child: node.children) {
                if (child != null && search(child, word, index + 1)) {
                    return true;
                }
            }

            return false;
        }
    }

    private class TrieNode {
        boolean isWord;
        TrieNode[] children = new TrieNode[26];

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
