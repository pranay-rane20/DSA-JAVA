package Tree;

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
    public static void klevel(Node root,int level,int k){
        if (root == null) return;
        if(level == k){
            System.out.println(root.val + " ");
            return;
        }
        klevel(root.left, level+1, k);
        klevel(root.right, level+1, k);
    }


//    -----------------------------Lowest Common Ancestor O(n)+Extra Space ------------------------------
  public static boolean getPath(Node root, int n, ArrayList<Node> path){
        if(root == null) return true;
        path.add(root);
        if(root.val == n) return true;
        boolean left = getPath(root.left,n,path);
        boolean right = getPath(root.right,n,path);
        if(left || right) return true;
        path.remove(path.size()-1);
        return false;
  }
    public static Node LCA(Node root, int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root,n1,path1);
        getPath(root,n2,path2);

        int i=0;
        for( ;i<path1.size() && i<path2.size();i++){
            if(path1.get(i) != path2.get(i))break;
        }
        return new Node(path1.get(i-1).val);
    }


    //    -----------------------------Lowest Common Ancestor O(n) ------------------------------
    public static Node LCA2(Node root,int n1,int n2){
        if(root == null) return null;
        if(root.val == n1 || root.val == n2){
            return root;
        }
        Node left = LCA2(root.left, n1, n2);
        Node right = LCA2(root.right, n1, n2);

        //leftLCA= val rightLCA = null
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }


    //---------------------Mini s b/w 2 nodes------------------------
    public static int lcsDist(Node root,int n){
        if(root == null) return -1;
        if(root.val == n) return 0;

        int leftDist = lcsDist(root.left, n);
        int rightDist = lcsDist(root.right,n);
        if(leftDist == -1 && rightDist == -1) return -1;
        else if(leftDist==-1)return rightDist+1;
        else return leftDist+1;
    }
    public static int minDist(Node root, int n1,int n2){
        Node lca = LCA2(root,n1,n2);
        int dist1 = lcsDist(lca,n1);
        int dist2 = lcsDist(lca,n2);
        return dist1 + dist2;
    }





    //---------------------Kth Ancestor------------------------
    public static int kAncestor(Node root, int n, int k){
        if(root.val == n) return 0;
        int left = kAncestor(root.left, n, k);
        int right = kAncestor(root.right, n, k);

        if(left==-1 && right==-1) return -1;
        int max = Math.max(left,right);
        if(max +1== k) System.out.println(root.val);
        return max+1;
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
