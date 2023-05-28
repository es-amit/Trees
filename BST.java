import java.util.*;
public class BST {
    //Node declaration of Binary Search Tree
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    // Inserting node in BST
    public static Node insert(Node root,int val){
        if(root == null){
            root= new Node(val);
            return root;
        }
        if(root.data > val){
            root.left= insert(root.left, val);
        }
        else{
            root.right = insert(root.right, val);
        }
        return root;

    }

    // Preorder Traversal
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        preorder(root.left);
        System.out.print(root.data+" ");
        preorder(root.right);
    }

    // searching in BST
    public static boolean search(Node root,int k){
        if(root == null){
            return false;
        }
        if(root.data==k){
            return true;
        }
        if(root.data >k){
            return search(root.left, k);
        }
        else{
            return search(root.right, k);
        }
    }

    //Deleting nodes in BST (Most important question)
    public static Node delete(Node root,int val){
        if(root.data > val){
            root.left = delete(root.left, val);
        }
        else if(root.data < val){
            root.right = delete(root.right, val);
        }
        else{
            //case 1
            if(root.left == null && root.right == null){
                return null;
            }
            // case 2
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            //case 3
            Node IS= inorderSuccessor(root.right);
            root.data=IS.data;
            root.right =delete(root.right, IS.data);
        }
        return root;
    }
    public static Node inorderSuccessor(Node root){
        while(root.left != null){
            root= root.left;
        }
        return root;
    }

    // Print node of BST between x and y (x and y are also included)
    public static void printinRange(Node root,int x,int y){
        if(root == null){
            return;
        }
        if(root.data >=x && root.data <= y){
            printinRange(root.left, x, y);
            System.out.print(root.data+" ");
            printinRange(root.right, x, y);
        }
        else if(root.data >=y){
            printinRange(root.left, x, y);
        }
        else if(root.data <=x){
            printinRange(root.right, x, y);
        }
    }

    // Printing all the paths from root node to leaf node
    public static void printPath(List<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+ "->");
        }
        System.out.println();
    }
    public static void printroot2leaf(Node root,List<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }
        else{
            printroot2leaf(root.left, path);
            printroot2leaf(root.right, path);
            path.remove(path.size()-1);
        }
    }

    
    public static void main(String[] args) {
        int[] val={8,5,3,1,4,6,10,11,14};
        Node root = null;
        for(int i=0;i<val.length;i++){
            root = insert(root, val[i]);
        }
        //preorder(root);
        //System.out.println(search(root, 10));
        //delete(root, 5);
        //preorder(root);
        //printinRange(root, 6, 10);
        List<Integer> path = new ArrayList<>();
        printroot2leaf(root,path );
    }
}
