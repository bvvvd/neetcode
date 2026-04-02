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
        Map<Node, Node> map = new HashMap<>();
        Node runner = head;
        while (runner != null) {
            map.put(runner, new Node(runner.val));
            runner = runner.next;
        }

        runner = head;
        while (runner != null) {
            Node runnerCopy = map.get(runner);
            runnerCopy.next = map.get(runner.next);
            runnerCopy.random = map.get(runner.random);
            runner = runner.next;
        }

        return map.get(head);
    }
}
