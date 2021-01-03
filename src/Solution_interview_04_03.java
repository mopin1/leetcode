class Solution_interview_04_03 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode[] listOfDepth(TreeNode tree) {
        if (null != tree) {
            int depth = getDepth(tree);
            ListNode[] res = new ListNode[depth];
            dfs(tree, 0, res);
            return res;
        }
        return new ListNode[0];
    }

    private int getDepth(TreeNode tree) {
        if (tree == null) return 0;
        return Math.max(getDepth(tree.left), getDepth(tree.right)) + 1;
    }

    public void dfs(TreeNode tree, int depth, ListNode[] res) {
        if (tree != null) {
            ListNode node = new ListNode(tree.val);
            if (res[depth] == null) {
                res[depth] = node;
            } else {
                node.next = res[depth];
                res[depth] = node;
            }
            dfs(tree.right, depth + 1, res);
            dfs(tree.left, depth + 1, res);
        }
    }
}