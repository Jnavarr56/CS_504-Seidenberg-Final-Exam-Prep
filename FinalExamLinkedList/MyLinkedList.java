public class MyLinkedList {
    // add(Node newNode), add(Node newNode, int index) [x]
    // remove(), remove(int index) []
    // search(String data)
    // empty()
    // getSize()
    // printList()
    // LinkedList(), LinkedList(Node head)
    private Node head = null;

    public MyLinkedList() {}
    
    public void add(Node newNode) {
        if (head == null) {
            head = newNode;
        }
        else {
            Node trav = head;
            while (trav.getNext() != null) {
                trav = trav.getNext();
            }
            trav.setNext(newNode);
        }
    }

    public void add(Node newNode, int index) throws MyLinkedListException {
        if (index < 0) {
            throw new MyLinkedListException("Index " + index + " is out of bounds.");
        }
        else if (head == null) {
            if (index == 0) {
                head = newNode;
            }
            else {
                throw new MyLinkedListException("Index " + index + " is out of bounds.");
            }
        }
        else {
            Node trav = head;
            int count = 0;
            while ((count < index - 1) && (trav.getNext() != null)) {
                trav = trav.getNext();
            }
            if (count == index - 1) {
                if (trav.getNext() == null) {
                    trav.setNext(newNode);
                }
                else {
                    newNode.setNext(trav.getNext());
                    trav.setNext(newNode);
                }
            }
            else {
                throw new MyLinkedListException("Index " + index + " is out of bounds.");
            }
        }
    }

    public Node remove() throws MyLinkedListException {
        if (head == null) {
            throw new MyLinkedListException("List empty, nothing to remove.");
        }
        else {
            Node trav = head;
            while (trav.getNext() != null) {
                trav = trav.getNext();
            }
            Node removed = trav;
            trav.clearNext();
            return removed;
        }
    }

    public Node remove(int index) throws MyLinkedListException {
        if (head == null) {
            throw new MyLinkedListException("Index " + index + " is out of bounds.");
        }
        else if (index == 0) {
            if (head.getNext() == null) {
                Node removed = head;
                head = null;
                return removed;
            }
            else {
                Node removed = head;
                head = head.getNext();
                return removed;
            }
        }
        else {
            Node trav = head;
            Node prev = null;
            int indexCount = 0;
            while((indexCount < index) && (trav.getNext() != null)) {
                prev = trav;
                trav = trav.getNext();
                indexCount++;
            }
            if (indexCount == index) {
                Node removed = trav;
                if (trav.getNext() == null) {
                    prev.clearNext();
                    return removed;
                }
                else {
                    prev.setNext(trav.getNext());
                    return removed;
                }
            }
            else {
                throw new MyLinkedListException("Index " + index + " is out of bounds.");
            }
        }
    }

    public int search(String data) throws MyLinkedListException {
        if (head == null) {
            throw new MyLinkedListException("List is empty nothing to search.");
        }
        else {
            Node trav = head;
            int indexCount = 0;
            while (trav.getNext() != null) {
                if (trav.getData().equals(data)) {
                    return indexCount;
                }
                trav = trav.getNext();
                indexCount++;
            }
            return trav.getData().equals(data) ? indexCount : -1;
        }
    }

    public boolean empty() {
        return head == null;
    }

    public int getSize() {
        if (head == null) {
            return 0;
        }
        else {
            Node trav = head;
            int indexCount = 0;
            while (trav.getNext() != null) {
                trav = trav.getNext();
                indexCount++;
            }
            return indexCount + 1;
        }
    }

    public void printList() throws MyLinkedListException {
        if (head == null) {
            throw new MyLinkedListException("List is empty nothing to search.");
        }
        else {
            Node trav = head;
            int indexCount = 0;
            while (trav.getNext() != null) {
                System.out.printf("Index: %s | %s\n", indexCount, trav.getData());
                trav = trav.getNext();
                indexCount++;
            }
            System.out.printf("Index: %s | %s\n", indexCount, trav.getData());
        }
    }

}