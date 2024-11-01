package D12BinarySearchTree;

import java.util.ArrayList;

public class BST {
    static class Node{
        int val;
        Node left,right;
        Node(int val){
            this.val = val;
        }
    }

    public static Node insert(Node root, int val) {
        if(root==null) {
            root = new Node(val);
                    return root;
        }

        if(root.val > val){
            root.left = insert(root.left,val);
        }else {
            root.right = insert(root.right,val);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root==null)return;
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
    }


    //-----------------------Search---------------------------------------------------------------------------------
    public static boolean search(Node root, int val){
        if(root==null)return false;
        if(root.val == val) return true;
        if(root.val>val) return search(root.left,val);
        else  return search(root.right,val);
    }

    public static Node delete(Node root,int val){
        if(root.val < val) {
            root.right = delete(root.right, val);
        } else if (root.val>val){
            root.left = delete(root.left, val);
        }
        else {
            //case-1:LeafNode
            if(root.left == null && root.right == null) return null;

            //case-2:one child
            if(root.left == null) return root.right;
            else if(root.right == null ) return root.left;

            //Case-3:both children
            Node IS = findInorderSuccessor(root.right);
            root.val = IS.val;
            root.right = delete(root.right, IS.val);
        }
        return root;

    }
    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root= root.left;
        }
        return root;
    }




    //------------------PrintINRanges--------------------------------
    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }

        // If root's data is within the range, process the left subtree, print current node, and process the right subtree.
        if (root.val >= k1 && root.val <= k2) {
            printInRange(root.left, k1, k2);   // Left subtree
            System.out.print(root.val + " "); // Print current node
            printInRange(root.right, k1, k2);  // Right subtree
        }
        // If root's data is less than k1, go right as left subtree nodes will be less than k1
        else if (root.val < k1) {
            printInRange(root.right, k1, k2); // Only check right subtree
        }
        // If root's data is greater than k2, go left as right subtree nodes will be greater than k2
        else {
            printInRange(root.left, k1, k2);  // Only check left subtree
        }
    }





//-------------------------------------printRoot2leaf-------------------------------------------------------------------
    public static void printRoot2leaf(Node root, ArrayList<Integer> path) {
        // Base case: if the current node is null, return to the previous call
        if (root == null) return;

        // Add the current node's value to the path list
        path.add(root.val);

        // If the current node is a leaf (no left or right child), print the path
        if (root.left == null && root.right == null) {
            printpath(path);
        }

        // Recursively call for the left child
        printRoot2leaf(root.left, path);

        // Recursively call for the right child
        printRoot2leaf(root.right, path);

        // Backtracking: remove the last added node from the path to explore new paths
        path.remove(path.size() - 1);
    }

    public static void printpath(ArrayList<Integer> path) {
        // Print each node in the path followed by an arrow (->), except for the last node
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) {
                System.out.print(" -> ");
            }
        }
        // Print a new line after each path to separate paths
        System.out.println();
    }





    public static void main(String[] args) {
        int val[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for(int i: val){
            root = insert(root, i);
        }
        inorder(root);
        System.out.println();

        delete(root,1);
        System.out.println();
        inorder(root);
    }
}
