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
    public Node cloneGraph(Node node) {
        return copy(node, new HashMap<>());
    }

    private Node copy(Node node, Map<Node, Node> copies) {
        if (node == null) {
            return null;
        }

        if (copies.containsKey(node)) {
            return copies.get(node);
        }

        Node copy = new Node(node.val);
        copies.put(node, copy);
        for (Node neighbor: node.neighbors) {
            copy.neighbors.add(copy(neighbor, copies));
        }
        return copy;
    }
}