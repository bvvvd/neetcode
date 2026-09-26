class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null) return false
        if (isSameTree(root, subRoot)) return true
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }

    fun isSameTree(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) return true
        if ((left == null) != (right == null)) return false
        return left?.`val` == right?.`val` &&
            isSameTree(left?.left, right?.left) &&
            isSameTree(left?.right, right?.right)
    }
}