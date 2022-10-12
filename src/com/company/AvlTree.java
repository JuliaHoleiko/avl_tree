package com.company;

public class AvlTree {
    Node root;

    int getHeight(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    int max(int a, int b){
        if(a>b)
            return a;
        return b;
    }
    int getBalance(Node node){
        if(node == null){
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    Node rightRotate(Node y){
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = max(getHeight(y.left), getHeight(y.right)) +1;
        x.height = max(getHeight(x.left), getHeight(x.right)) +1;
        return x;


    }
    Node leftRotate(Node x){
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        y.height = max(getHeight(y.left), getHeight(y.right)) +1;
        x.height = max(getHeight(x.left), getHeight(x.right)) +1;
        return y;


    }

    Node minNode(Node node){
        Node current = node;
        while(current.left != null){
            current = current.left;
        }
        return current;
    }
    Node deleteNode (Node root, int key){
        if (root == null)
            return root;
        if(key < root.key)
            root.left = deleteNode(root.left, key);
        else if(key > root.key)
            root.right = deleteNode(root.right, key);

        else{
            if ((root.right==null) || (root.left == null)){
                Node temp = null;
                if(temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;
                if(temp == null){
                    temp = root;
                    root = null;

                }
                else
                    root = temp;
            }
            else {
                //smallest in the right subtree
                Node temp = minNode(root.right);

                // Copy the inorder successor's data to this node
                root.key = temp.key;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.key);
            }
        }


        if (root == null)
            return root;
        //edit height
        root.height = max(getHeight(root.left), getHeight(root.right)) + 1;

        int balance = getBalance(root);

        // Left Left
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right
        if (balance > 1 && getBalance(root.left) < 0)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left
        if (balance < -1 && getBalance(root.right) > 0)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }
    Node insert(Node node, int key){
        if(node == null){
            return(new Node(key));
        }
        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;

        node.height = 1 + max(getHeight(node.left),
                getHeight(node.right));


        int balance = getBalance(node);


        //  Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }


        return node;
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    void insert(int key){
        root = insert(root, key);
    }
    void deleteNode(int key){root = deleteNode(root, key);}



}









