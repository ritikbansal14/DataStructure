package Tree;
import java.util.Scanner;

public class Tree {
    public static boolean check(TreeNode root, int k) {
        if (root == null) {
            return false;
        } else {
            if (root.leftNode == null && root.rightNode == null) {
                return (root.data == k);
            } else if (root.leftNode != null && root.rightNode != null) {
                return check(root.leftNode, k - root.data) || check(root.rightNode, k - root.data);
            } else if (root.leftNode == null) {
                return check(root.rightNode, k - root.data);
            } else {
                return check(root.leftNode, k - root.data);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode rootNode = new TreeNode(5);
        rootNode.insert(3);
        rootNode.insert(1);
        rootNode.insert(4);
        rootNode.insert(8);
        rootNode.insert(7);
        rootNode.insert(6);
        rootNode.insert(9);
        rootNode.inOrderTraverse();
        System.out.println(check(rootNode, 11));
        sc.close();
    }
}