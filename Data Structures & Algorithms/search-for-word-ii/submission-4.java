class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; 
    private List<String> foundWords;
    private char[][] board;

    public List<String> findWords(char[][] board, String[] words) {
        foundWords = new ArrayList<>();
        this.board = board; 
        Trie trie = new Trie();
        for (String word: words) {
            trie.insert(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (trie.root.has(board[i][j])) {
                    dfs(i, j, trie.root.get(board[i][j]));
                }
            }
        }

        return foundWords;
    }

    private void dfs(int i, int j, TrieNode node) {
        if (node.word != null) {
            foundWords.add(node.word);
            node.word = null;
        }

        char originalChar = board[i][j];
        board[i][j] = '.';
        for (int[] direction: DIRECTIONS) {
            int x = i + direction[0];
            int y = j + direction[1];

            if (x >= 0 && x < board.length && y >= 0 && y < board[x].length && board[x][y] != '.' && node.has(board[x][y])) {
                dfs(x, y, node.get(board[x][y]));
            }
        }
        board[i][j] = originalChar;
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

            node.word = word;
        }
    }

    private class TrieNode {
        private String word;
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
