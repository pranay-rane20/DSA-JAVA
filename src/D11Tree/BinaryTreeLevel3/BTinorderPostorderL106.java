package D11Tree.BinaryTreeLevel3;

import java.util.HashMap;

public class BTinorderPostorderL106 {
    int post = 0;
    public void set(int l){
        post = l;
    }
    private TreeNode helper(int left, int right, int []postorder, HashMap<Integer, Integer> map){
        if(post <= -1)return null;
        if(left > right)return null;
        TreeNode root = new TreeNode(postorder[post]);
        int in = map.get(postorder[post--]);
        root.right = helper(in+1, right, postorder, map);
        root.left = helper(left, in-1, postorder, map);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        set(postorder.length-1);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)map.put(inorder[i], i);
        return helper(0, postorder.length-1, postorder, map);
    }
}
