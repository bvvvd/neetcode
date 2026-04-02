/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Node, Node> copies;
    private Set<Node> seen;

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        copies = new HashMap<>();
        seen = new HashSet<>();
        copy(node);
        seen.clear();
        deepCopy(node);

        return copies.get(node);
    }

    private void copy(Node node) {
        if (node != null && seen.add(node)) {
            copies.put(node, new Node(node.val));

            if (node.neighbors != null) {
                for (Node neighbor: node.neighbors) {
                    copy(neighbor);
                }
            }
        }
    }

    private void deepCopy(Node node) {
        if (node != null && seen.add(node)) {
            Node copy = copies.get(node);

            if (node.neighbors != null) {
                for (Node neighbor: node.neighbors) {
                    copy.neighbors.add(copies.get(neighbor));

                    deepCopy(neighbor);
                }
            }
        }
    }
}