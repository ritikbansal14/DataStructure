import java.util.Scanner;
public class Tree {
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          TreeNode rootNode = new TreeNode(5);
          rootNode.insert(4);
          rootNode.insert(3);
          rootNode.insert(2);
          rootNode.insert(6);
          rootNode.insert(7);
          rootNode.inOrderTraverse();
          sc.close();
    } 
}