package D11Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TreeFromArray {

    //-------------------Class Node --------------------------------
    public static class Node{
        int val;
        Node left, right;
        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    //-------------------Class BinaryTree --------------------------------
    public static class BinaryTree{
        static int i = -1;
        public static Node buildTree(int[] arr){
            i++;
            if(arr.length==i || arr[i] == -1) return null;

            Node newNode = new Node(arr[i]);
            newNode.left = buildTree(arr);
            newNode.right = buildTree(arr);
            return newNode;
        }
    }

    //-------------------Preorder --------------------------------
    public static void DLR(Node root){   //Preorder
        if(root == null) return;
        System.out.print(root.val + " ");
        DLR(root.left);
        DLR(root.right);
    }

    //-------------------Inorder --------------------------------
    public static void LDR(Node root){   //Inorder
        if(root == null) return;
        LDR(root.left);
        System.out.print(root.val + " ");
        LDR(root.right);
    }

    //-------------------Postorder --------------------------------
    public static void LRD(Node root){    //Postorder
        if(root == null) return;
        LRD(root.left);
        LRD(root.right);
        System.out.print(root.val + " ");
    }

    //-------------------Level Order --------------------------------
    public static void levelOrder(Node root){
        if(root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr== null){
                System.out.println();
                if (q.isEmpty())break;
                else q.add(null);
            }
            else{
                System.out.print (curr.val + " ");
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
    }

    //-----------------------Count--------------------
    public static int count(Node root){
        if(root==null) return 0;
        int lc = count(root.left);
        int rc = count(root.right);
        return lc + rc + 1;
    }

    //-----------------------Sum--------------------
    public static int sum(Node root){
        if(root==null) return 0;
        int lsum = sum(root.left);
        int rsum = sum(root.right);
        return lsum + rsum + root.val;
    }

    //-----------------------Height--------------------
    public static int height(Node root){
        if(root==null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh) +1;
    }

    //-----------------------Diameter O(n2)--------------------
    public static int diam2(Node root){    //O(n2)
        if(root==null) return 0;
        int ld = diam2(root.left);
        int rd = diam2(root.right);
        int rh = height(root.right);
        int lh = height(root.left);
        int selfd = lh+rh+1;
        return Math.max(selfd,Math.max(ld,rd));
    }

    //---------------------------Diameter class Info O(n)----------------------
    static class Info{
        int d;
        int h;
        public Info(int d, int h){
            this.d = d;
            this.h = h;
        }
    }
    public static Info diameter(Node root){  //O(N)
        if(root==null) return new Info(0,0);
        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);
        int diam = Math.max(Math.max(leftInfo.d , rightInfo.d) ,leftInfo.h+rightInfo.h+1);
        int height = Math.max(leftInfo.h, rightInfo.h) + 1;
        return new Info(diam, height);
    }

    //---------------------Subtree---------------------------
// Function to check if two trees are identical
    public static boolean isidentical(Node root, Node subroot) {
        // If both trees are null, they are identical
        if (root == null && subroot == null) return true;

        // If one of the trees is null, or if the values don't match, they are not identical
        if (root == null || subroot == null || root.val != subroot.val) return false;

        // Recursively check the left and right subtrees
        return isidentical(root.left, subroot.left) && isidentical(root.right, subroot.right);
    }

    // Function to check if subroot is a subtree of root
    public static boolean issub(Node root, Node subroot) {
        // If root is null, subroot can't be a subtree
        if (root == null) return false;

        // If the current node's value matches subroot's value, check if the trees are identical
        if (root.val == subroot.val && isidentical(root, subroot)) {
            return true;
        }

        // Recursively check if subroot is a subtree in the left or right subtree of root
        return issub(root.left, subroot) || issub(root.right, subroot);
    }





//    ----------------------------------TopView--------------------------------
    static class In{
        Node node;
        int hd;
        public In(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topview(Node root){
        //level order
        Queue<In> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();

        int min =0,max =0;
        q.add(new In(root,0));
        q.add(null);

        while(!q.isEmpty()){
            In curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else {
                    q.add(null);
                }
            }
            if(!map.containsKey(curr.hd)){
                map.put(curr.hd,curr.node);
            }
            if(curr.node.left != null){
                q.add(new In(curr.node.left,curr.hd-1));
                min = Math.min(min,curr.hd-1);
            }
            if(curr.node.right != null){
                q.add(new In(curr.node.right,curr.hd+1));
                max = Math.max(max,curr.hd+1);
            }

            for(int i=min;i<=max;i++){
                System.out.println(map.get(i).val + " ");

            }
            System.out.println();

        }

    }


//    ----------------------------------Klevels--------------------------------
public static void klevel(Node root, int level, int k) {
    // Base case: if the root is null, return
    if (root == null) return;

    // If the current level matches k, print the node value
    if (level == k) {
        System.out.print(root.val + " ");
        return;
    }

    // Recurse for left and right subtrees, increasing the level
    klevel(root.left, level + 1, k);
    klevel(root.right, level + 1, k);
}


//    -----------------------------Lowest Common Ancestor O(n)+Extra Space ------------------------------
// Function to find the path from root to the node 'n' and store it in the path list
public static boolean getPath(Node root, int n, ArrayList<Node> path) {
    if (root == null) return false;  // If the root is null, return false

    path.add(root);  // Add the current node to the path

    // If the current node is the target node 'n', return true
    if (root.val == n) return true;

    // Recursively check in left and right subtrees
    boolean left = getPath(root.left, n, path);
    boolean right = getPath(root.right, n, path);

    // If the target node is found in either subtree, return true
    if (left || right) return true;

    // If the target node is not found, remove the current node from the path and return false
    path.remove(path.size() - 1);
    return false;
}

    // Function to find the Lowest Common Ancestor of two nodes 'n1' and 'n2'
    public static Node LCA(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        // Find the path from root to n1 and n2
        if (!getPath(root, n1, path1) || !getPath(root, n2, path2)) {
            return null;  // If either n1 or n2 is not present in the tree, return null
        }

        // Compare the paths to find the last common node
        int i = 0;
        for ( ; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) break;
        }

        // Return the last common node in the paths (this is the LCA)
        return path1.get(i - 1);
    }



    //    -----------------------------Lowest Common Ancestor O(n) ------------------------------
    public static Node LCA2(Node root, int n1, int n2) {
        // Base case: if the root is null, return null
        if (root == null) return null;

        // If the current node is either n1 or n2, return the current node
        if (root.val == n1 || root.val == n2) {
            return  root;
        }

        // Recursively find LCA in the left and right subtrees
        Node left = LCA2(root.left, n1, n2);
        Node right = LCA2(root.right, n1, n2);

        // If both left and right are non-null, this node is the LCA
        if (left != null && right != null) return root;

        // If only one subtree returned a non-null value, return that value
        return (left != null) ? left : right;
    }



    //---------------------Mini s b/w 2 nodes------------------------
// Function to calculate the distance from root to a given node `n`
    public static int lcsDist(Node root, int n) {
        if (root == null) return -1;  // If the root is null, return -1
        if (root.val == n) return 0;  // If the current node is `n`, return 0 as distance is zero

        // Calculate distance in left and right subtrees
        int leftDist = lcsDist(root.left, n);
        int rightDist = lcsDist(root.right, n);

        // If the node is not found in both subtrees, return -1
        if (leftDist == -1 && rightDist == -1) return -1;

            // If the node is not in the left subtree, return distance from right subtree + 1
        else if (leftDist == -1) return rightDist + 1;

            // Otherwise, return distance from left subtree + 1
        else return leftDist + 1;
    }

    // Function to calculate the minimum distance between two nodes `n1` and `n2`
    public static int minDist(Node root, int n1, int n2) {
        // Find the Lowest Common Ancestor (LCA) of nodes n1 and n2
        Node lca = LCA2(root, n1, n2);

        // Calculate the distance from LCA to n1
        int dist1 = lcsDist(lca, n1);

        // Calculate the distance from LCA to n2
        int dist2 = lcsDist(lca, n2);

        // Return the sum of the two distances, which gives the minimum distance between n1 and n2
        return dist1 + dist2;
    }






    //---------------------Kth Ancestor------------------------
    public static int kAncestor(Node root, int n, int k) {
        // Base case: If the current node is null, return -1 (not found)
        if (root == null) return -1;

        // If we find the node with value 'n', return 0 (distance to itself is 0)
        if (root.val == n) return 0;

        // Recur for the left and right subtrees
        int left = kAncestor(root.left, n, k);
        int right = kAncestor(root.right, n, k);

        // If the node was not found in both left and right subtrees
        if (left == -1 && right == -1) return -1;

        // Find the max between left and right (we only expect one to be non-negative)
        int max = Math.max(left, right);

        // Check if we are exactly 'k' distance away from the node where we found 'n'
        if (max + 1 == k) {
            System.out.println("Kth Ancestor: " + root.val);  // Print the Kth ancestor
            return -1;  // Return -1 to stop further recursion after finding the Kth ancestor
        }

        // Return the distance from the current node to the node where we found 'n'
        return max + 1;
    }



    //- --------------- Sum Tree -----------------------
    public static int SumTree(Node root) {
        if (root == null) return 0;  // Base case: if root is null, return 0

        // Recursively calculate sum of left and right subtrees
        int left = SumTree(root.left);
        int right = SumTree(root.right);

        // Store the current node's value before updating it
        int data = root.val;

        // Check if root.left and root.right are not null before accessing their values
        int leftVal = (root.left != null) ? root.left.val : 0;
        int rightVal = (root.right != null) ? root.right.val : 0;

        // Update the current node's value
        root.val = leftVal + left + right + rightVal;

        // Return the updated value of the current node
        return data;  // Return the original value of the current node
    }




    //-------------------------------Main-------------------------------
    public static void main(String[] args) {
        int[] arr = {1, 2, 4,-1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(arr);
//        System.out.println("Root node data: " + root.val);
//        DLR(root);
//        System.out.println();
//        LDR(root);
//        System.out.println();
//        LRD(root);
//        System.out.println();
//        levelOrder(root);
//        System.out.println();
//        System.out.println(diam2(root));



//        Node subroot = new Node(2);
//        subroot.left = new Node(4);
//        subroot.right = new Node(7);
//        System.out.println(issub(root,subroot));


//        System.out.println(kAncestor(root,4,2));

        SumTree(root);
        DLR(root);
    }
}
