/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/

class Solution {
    fun cloneGraph(node: Node?): Node? {
        node ?: return null
        val copies = mutableMapOf<Node, Node>()
        fun copy(n: Node?) {
            if (n != null && !copies.containsKey(n)) {
                copies[n] = Node(n.`val`)
                n.neighbors.forEach{
                    copy(it)
                }
            }
        }
        copy(node)
        
        copies.forEach{ (original, copy) ->
            copy.neighbors.addAll(original.neighbors.map { copies[it] }.toList())
        }
        return copies[node]
    }
}
