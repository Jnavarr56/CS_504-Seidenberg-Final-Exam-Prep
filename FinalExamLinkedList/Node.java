public class Node {
    // get and set data
    // get and set next

    private String data = "";
    private Node next = null;

    public Node() {}
    public Node(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next; 
    }

    public void clearNext() {
        next = null;
    }

}