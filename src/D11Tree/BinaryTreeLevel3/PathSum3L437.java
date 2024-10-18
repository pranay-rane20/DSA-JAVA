package D11Tree.BinaryTreeLevel3;

public class PathSum3L437 {
    int ans = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        solve(root, targetSum, 0);

        pathSum(root.left, targetSum);

        pathSum(root.right, targetSum);
        return ans;
    }

    private void solve(TreeNode root, int targetSum, long sum) {
        if (root == null)
            return;
        if (sum + root.val == targetSum)
            ans++;

        solve(root.left, targetSum, sum + root.val);
        solve(root.right, targetSum, sum + root.val);
    }
}



 class TreeNode {
      int val;
      TreeNode left;
    TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
        this.right = right;
    }
 }
