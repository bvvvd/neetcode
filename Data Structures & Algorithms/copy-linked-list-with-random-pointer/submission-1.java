/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> copies = new HashMap<>();
        for (Node runner = head; runner != null; runner = runner.next) {
            copies.put(runner, new Node(runner.val));
        }

        for (Node runner = head; runner != null; runner = runner.next) {
            Node copy = copies.get(runner);
            copy.next = copies.get(runner.next);
            copy.random = copies.get(runner.random);
        }
        return copies.get(head);
    }
}
