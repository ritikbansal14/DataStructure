public class TreeNode{
    int data;
    TreeNode leftNode;
    TreeNode rightNode;

    TreeNode(int data) {
        this.data = data;
    }

    public void insert(int data) {
        if (this.data < data) {
            if (rightNode == null) {
                rightNode = new TreeNode(data);
            } else {
                rightNode.insert(data);
            }
        } else {
            if (leftNode == null) {
                leftNode = new TreeNode(data);
            } else {
                leftNode.insert(data);
            }
        }
    }

    public boolean find(int data) {
        if (this.data == data) {
            return true;
        } else if (this.data < data && rightNode != null) {
            return rightNode.find(data);
        } else if (this.data >= data && leftNode != null) {
            return leftNode.find(data);
        }
        return false;
    }

    public void inOrderTraverse() {
        if (leftNode != null) {
            leftNode.inOrderTraverse();
        }
        System.out.print(this.data + " ");
        if (rightNode != null) {
            rightNode.inOrderTraverse();
        }
    }

}
