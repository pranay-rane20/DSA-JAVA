package Tree;

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
    public static boolean isidentical(Node root,Node subroot){
        if(root == null && subroot == null) return true;
        else if(root == null || subroot == null || root.val!=subroot.val) return false;

        if(!isidentical(root.left,subroot.left)) return false;
        if (!isidentical(root.right,subroot.right)) return false;
        return true;
    }

    public static boolean issub(Node root, Node subroot){
        if (root == null) return false;
        if(root.val == subroot.val){
            if(isidentical(root,subroot)) return true;
        }
        boolean left = issub(root.left, subroot);
        boolean right = issub(root.right, subroot);
        return left || right;
    }


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


    //-------------------------------Main-------------------------------
    public static void main(String[] args) {
        int[] arr = {1, 2, 4,-1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(arr);
        System.out.println("Root node data: " + root.val);
        DLR(root);
        System.out.println();
        LDR(root);
        System.out.println();
        LRD(root);
        System.out.println();
        levelOrder(root);
        System.out.println();
        System.out.println(diam2(root));



        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(7);

        System.out.println(issub(root,subroot));
    }
}
