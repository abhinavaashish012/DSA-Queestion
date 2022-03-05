import java.util.*;
import java.io.*;

public class AVL
{
    Node root;

    public AVL()
    {
        this.root=null;
    }

    public int getHeight(Node n) {
      if(n==null)
        return 0;
      return n.height;
    }

    public Node insertNode(Node node, Node newNode)
    {
        if(node==null)
            return newNode;

        if(newNode.val<node.val)
          node.left=insertNode(node.left,newNode);
        else if(newNode.val>node.val)
          node.right=insertNode(node.right,newNode);
        else
          return node;

        node.height = 1 + Math.max(getHeight(node.left),getHeight(node.right));

        int balance = getHeight(node.left) - getHeight(node.right);
        // System.out.println("Balance = " + balance);

        //RR case
        if(balance > 1 && newNode.val < node.left.val)
          return rightRotate(node);

          //LL case
        if (balance < -1 && newNode.val > node.right.val)
          return leftRotate(node);

          // Left Right Case
          if (balance > 1 && newNode.val > node.left.val)//<
          {
              node.left = leftRotate(node.left);
              return rightRotate(node);
          }

          // Right Left Case
          if (balance < -1 && newNode.val < node.right.val)//>
          {
              node.right = rightRotate(node.right);
              return leftRotate(node);
          }
          return node;
    }

    public Node leftRotate(Node node)
    {
      Node temp = node.right;
      node.right= temp.left;
      temp.left=node;
      node.height=Math.max(getHeight(node.left),getHeight(node.right))+1;
      temp.height=Math.max(getHeight(temp.left),getHeight(temp.right))+1;
      return temp;
    }


    public Node rightRotate(Node node)
    {
      Node temp = node.left;
      node.left= temp.right;
      temp.right=node;
      node.height=Math.max(getHeight(node.left),getHeight(node.right))+1;
      temp.height=Math.max(getHeight(temp.left),getHeight(temp.right))+1;
      return temp;
    }



    public static void main(String[] args) {
        AVL avl = new AVL();
        avl.root=avl.insertNode(avl.root,new Node(5));
        avl.root=avl.insertNode(avl.root,new Node(10));
        avl.root=avl.insertNode(avl.root,new Node(25));

        System.out.println("The level order traversal is as follows :");
        avl.levelOrder(avl.root);
    }

    public void levelOrder(Node node)
    {
      if(node==null)
        return;

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while(q.isEmpty()==false)
        {
          Node temp = q.peek();
          System.out.print(temp.val+ " ");
          q.remove();
          if(temp.left!=null)
            q.add(temp.left);
          if(temp.right!=null)
            q.add(temp.right);
        }
    }

}


class Node {
    int val;
    int height;
    Node left, right;

    public Node(int x) {
        this.val = x;
        this.height = 1;
        this.left = null;
        this.right = null;
    }

    public int getHeight(Node n) {
        return n.height;
    }
}
