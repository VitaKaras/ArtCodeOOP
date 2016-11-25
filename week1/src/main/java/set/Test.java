package main.java.set;

/**
 * Created by Vita on 20.11.2016.
 */
public class Test {
    public static void main(String[] args) {
        MyBinarySearchTree tree = new MyBinarySearchTree();
        tree.add(25);
        tree.add(24);
        tree.add(19);
        tree.add(18);
        tree.add(35);
        tree.add(34);
        tree.add(16);
        tree.add(11);
        tree.add(45);
        tree.add(20);
        tree.add(17);
        tree.add(15);
        tree.add(14);
        tree.add(13);

        //25, 24, 19, 18, 35, 34, 16, 11, 45, 20, 17, 15, 14, 13
        tree.showTree();
        tree.remove(19);
        System.out.println();
        tree.showTree();

        MyBinarySearchTree tree1 = new MyBinarySearchTree();

        tree1.add(45);
        tree1.add(40);
        tree1.add(38);
        tree1.add(89);
        tree1.add(67);
        tree1.add(41);
        //45, 40, 38, 89, 67, 41

//        tree.add();
//        tree.add();
//        tree.add();
//        tree.add();
//        tree.add();
//        tree.add();
//        tree.add();
//        tree.add();
//        tree.add();
//        tree.add();
//        tree.add();
//        tree.add();
//        tree.add();

        System.out.println();
        tree1.showTree();
    }
}
