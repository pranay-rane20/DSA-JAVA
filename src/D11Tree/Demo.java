package D11Tree;

import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class Demo{
    static Scanner sc;
    static {
        sc = new Scanner(System.in);
    }

    private static TreeNode buildTree(){
        System.out.println("enter val");
        int val = sc.nextInt();
        if(val  == -1) return null;
        TreeNode root = new TreeNode(val);
        System.out.println("enter left for " + val);
        root.left = buildTree();
        System.out.println("enter right for " + val);
        root.right = buildTree();
        return root;
    }

    public static void DLR(TreeNode root){
        if(root == null) return;
        System.out.println(root.val);
        DLR(root.left);
        DLR(root.right);
    }


    public static void main(String[] args) {
        TreeNode root = buildTree();
        System.out.println("Inorder traversal:");
        DLR(root);
    }
}