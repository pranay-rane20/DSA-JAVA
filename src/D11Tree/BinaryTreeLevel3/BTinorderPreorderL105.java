package D11Tree.BinaryTreeLevel3;

import java.util.HashMap;

public class BTinorderPreorderL105 {
    int pre=0;
    HashMap<Integer, Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++) map.put(inorder[i], i);
        return build(0, preorder.length-1, preorder);
    }
    private TreeNode build(int left, int right, int[] preorder){
        if(pre>=preorder.length) return null;
        if(left>right) return null;
        TreeNode root=new TreeNode(preorder[pre]);
        int in=map.get(preorder[pre++]);
        root.left=build(left, in-1, preorder);
        root.right=build(in+1, right, preorder);
        return root;
    }
}



