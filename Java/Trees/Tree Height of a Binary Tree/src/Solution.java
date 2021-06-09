import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    /*
    class Node 
        int data;
        Node left;
        Node right;
    */
    public static int height(Node root) {
        // Write your code here.
        int height = 0;
        int l = 0;
        int r = 0;

        if(root.left != null) {
            l = height(root.left, 1);
        }

        if(root.right != null) {
            r = height(root.right, 1);
        }

        if(l > r)
            height = l;
        else
            height = r;

        return height;
    }

    public static int height(Node root, int currHeight) {
        int height = 0;
        int l = currHeight;
        int r = currHeight;

        if(root.left != null) {
            l = height(root.left, currHeight + 1);
        }

        if(root.right != null) {
            r = height(root.right, currHeight + 1);
        }

        if(l > r)
            height = l;
        else
            height = r;

        return height;
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(System.getProperty("user.dir") + "\\src\\" + "case_02.txt"));
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}