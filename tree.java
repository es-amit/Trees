import java.util.*;

public class tree{
    // node declaration
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    // array to binary tree formation 
    static class BinaryTree{
        static int idx=-1;
        public static Node build_tree(int[] nodes){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newnNode= new Node(nodes[idx]);
            newnNode.left=build_tree(nodes);
            newnNode.right=build_tree(nodes);
            return newnNode;
        }

        // preorder traversal
        public static void preorder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }

        // inorder traversal
        public static void inorder(Node root){
            if(root == null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }

        //postorder traversal
        public static void postorder(Node root){
            if(root == null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }

        // Level order traversal or breadth wise traversal
        public static void levelorder(Node root){
            if(root==null){
                return;
            }
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode=q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }

                }
                else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            }

        }

        //counting the number of nodes
        public static int countNodes(Node root){
            if(root==null){
                return 0;
            }
            return 1+countNodes(root.left)+countNodes(root.right);
        }

        // sum of nodes in tree
        public static int SumofNodes(Node root){
            if(root == null){
                return 0;
            }
            return root.data+SumofNodes(root.left)+SumofNodes(root.right);
        }

        // Maximum height of tree
        public static int height(Node root){
            if(root == null){
                return 0;
            }
            int left=height(root.left);
            int right =height(root.right);
            return Math.max(left, right)+1;
        }

        //diameter of tree O(n2) approach
        public static int diameter(Node root){
            if(root==null){
                return 0;
            }
            int diameter1=diameter(root.left);
            int diameter2=diameter(root.right);
            int diameter3=height(root.left)+height(root.right)+1;
            return Math.max(diameter1, Math.max(diameter2,diameter3));
        }
        //O(n) approach for diameter
        static class Treeinfo{
            int ht;
            int diam;
            Treeinfo(int ht,int diam){
                this.ht=ht;
                this.diam=diam;
            }
        }
        public static Treeinfo diameter2(Node root){
            if(root==null){
                return new Treeinfo(0,0);
            }

            Treeinfo left= diameter2(root.left);
            Treeinfo right= diameter2(root.right);
            int myHeight=Math.max(left.ht, right.ht)+1; //calculating height

            int diam1=left.diam;
            int diam2=right.diam;
            int diam3=left.ht+right.ht+1;
            
            int mydiam=Math.max(Math.max(diam1, diam2),diam3);

            Treeinfo myinfo= new Treeinfo(myHeight, mydiam);
            return myinfo;

            

        }

        // sum of nodes at Kth level of binary  tree
        public static int sumatK(Node root,int k){
            if(root == null){
                return 0;
            }
            if(k<=0){
                return 0;
            }
            int level=0;
            int sum=0;
            Queue<Node> q=new LinkedList<>();
            level++;
            q.add(root);
            q.add(null);
            while(!q.isEmpty() && level <= k){
                Node curNode =q.remove();
                if(curNode==null){
                    level+=1;
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
    
                }
                else{
                    if(level == k){
                        sum+=curNode.data;
                    }
                    if(curNode.left!=null){
                        q.add(curNode.left);
                    }
                    if(curNode.right!=null){
                        q.add(curNode.right);
                    }
                }
            }
            return sum;
            }
        
    }
   
    

    public static void main(String[] args) {
        int[] nodes={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree t1= new BinaryTree();
        Node root=t1.build_tree(nodes);
        //System.out.println(root.data);
        // t1.preorder(root);
        // System.out.println();
        // t1.inorder(root);
        // System.out.println();
        // t1.postorder(root);
        // System.out.println();
        // t1.levelorder(root);
        //System.out.println(t1.countNodes(root));
        //System.out.println(t1.SumofNodes(root));
        //System.out.println(t1.height(root));
       // System.out.println(t1.diameter(root));
     //  System.out.println(t1.diameter2((root)).diam);
     System.out.println(t1.sumatK(root,2));
    }
}