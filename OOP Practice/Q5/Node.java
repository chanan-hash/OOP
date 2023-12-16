package Q5;

public class Node<T> {
    T data;
    Node right, left; // right = next, left = perv

    public Node(T data, Node right, Node left){
        this.data = data;
        this.right = right;
        this.left = left;
    }

    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", right=" + right +
                ", left=" + left +
                '}';
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
}
