package com.github.srinivaschejerla.algorithms.trees;

import java.util.Random;

public class TreeNodesCount {    

    public static int getNodesCount() {

        return Integer.MIN_VALUE;
    }

    public static TreeNode generateTree(int data, TreeNode root) {
        
        Random r = new Random();           
        TreeNode current = root;

        if(root == null) {            
            //System.out.print(data);
            return new TreeNode(data);
        }
        
        //int i = 4;
        while (current != null) {                        
            if(r.nextInt(2) == 0) {
                if(current.left == null) {
                    current.left = new TreeNode(data);
                    //System.out.format("%"+i+"d", current.left.data);
                    break;
                }                
                current = current.left;                
            } else {
                if(current.right == null) {
                    current.right = new TreeNode(data);
                    //System.out.format("%"+i+"d", current.right.data);
                    break;
                }             
                current = current.right;
            }
        }
        return root;
    }

    public static int printTree(TreeNode root, int spaces, String type) {
        if(root == null) return 0;

        TreeNode current = root;
        System.out.println(root.data);

        while(current != null) {            
            if(current.left != null) {                 
                current = current.left;
                System.out.println(current.data);                
            }
        } 
        
        return 0;
    }

    public static void main(String args[]) {
        int n = Integer.parseInt(args[0]);
        
        Random r = new Random();
        TreeNode root = null;
        
        // genate tree
        for(int i=0; i<n; i++) {
            int data = r.nextInt(n) + 1;
            root = generateTree(data,root);
        }

        // print tree nodes
        printTree(root,0,"Root");

        // get count
        // System.out.println(getNodesCount());
    }
}