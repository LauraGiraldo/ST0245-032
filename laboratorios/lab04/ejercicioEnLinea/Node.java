public class Node {
    public Node left;
    public Node right;
    public String data;
    public Node(String d){

        data = d;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public String getDato() {
        return data;
    }
}
