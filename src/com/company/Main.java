package com.company;


public class Main {

    public static void main(String[] args) {
        AvlTree tree = new AvlTree();

        tree.insert(15);
        tree.insert(33);
        tree.insert(39);
        tree.insert(50);
        tree.insert(60);
        tree.insert(35);


        /*
             39
            /  \
          33   50
         /  \     \
        15  35    60

        */
        System.out.println("AVL tree : ");
        tree.preOrder(tree.root);
        tree.deleteNode( 15);
        System.out.println("");
        System.out.println("After delete :");
        tree.preOrder(tree.root);


    }
}
