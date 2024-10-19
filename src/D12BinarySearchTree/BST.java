package D12BinarySearchTree;

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


    //-----------------------Search-------------------------
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
