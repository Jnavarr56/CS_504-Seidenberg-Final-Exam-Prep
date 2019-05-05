public class Node {
    private String data = "";
    private Node next = null;
    private Node prev = null;
    public Node() {}
    public Node(String data) {
        this.data = data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getData() {
        return data;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public Node getNext() {
        return next;
    }
    public void clearNext() {
        next = null;
    }
}