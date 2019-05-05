public class LinkedList {
    private Node head = null;
    public LinkedList() {}
    public LinkedList(Node head) {
        this.head = head;
    }
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
    public void add(Node newNode, int index) throws LinkedListException {
        if (index < 0) {
            throw new LinkedListException("INDEX " + index + " IS OUT OF BOUNDS");
        }
        else if (head == null) {
            if (index == 0) {
                head = newNode;
            }
            else {
                throw new LinkedListException("INDEX " + index + " IS OUT OF BOUNDS");
            }
        }
        else {
            int count = 0;
            Node trav = head;
            while ((count < index - 1) && (trav.getNext() != null)) {
                trav = trav.getNext();
                count++;
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
                throw new LinkedListException("INDEX " + index + " IS OUT OF BOUNDS");
            } 
        }
    }
    public Node remove() throws LinkedListException {
        if (head == null) {
            throw new LinkedListException("LINKED LIST IS EMPTY NO ITEMS TO REMOVE");
        }
        else if (head.getNext() == null) {
            Node removed = head;
            head = null;
            return removed;
        }
        else {
            Node trav = head;
            Node last = null;
            while (trav.getNext() != null) {
                last = trav;
                trav = trav.getNext();
            }
            last.clearNext();
            return trav;
        }
    }

    public Node remove(int index) throws LinkedListException {
        if (index < 0) {
            throw new LinkedListException("INDEX " + index + " IS OUT OF BOUNDS");
        }
        else if (head == null) {
            throw new LinkedListException("LINKED LIST IS EMPTY NO ITEMS TO REMOVE");
        }
        else if (head.getNext() == null) {
            if (index == 0) {
                Node removed = head;
                head = null;
                return removed;
            }
            else {
                throw new LinkedListException("INDEX " + index + " IS OUT OF BOUNDS");
            }
        }
        else {
            int count = 0;
            Node trav = head;
            Node last = null;
            while ((count < index) && (trav.getNext() != null)) {
                last = trav;
                trav = trav.getNext();
                count++;
            }
            if (count == index) {
                if (trav.getNext() == null) {
                    last.clearNext();
                    return trav;
                }
                else {
                    if (index == 0) {
                        Node removed = head;
                        head = head.getNext();
                        return removed;
                    }
                    else {
                        last.setNext(trav.getNext());
                        return trav;
                    }
                }
            }
            else {
                throw new LinkedListException("INDEX " + index + " IS OUT OF BOUNDS");
            }
        }
    }

    public boolean empty() {
        return head == null;
    }

    public int getSize() {
        if (head == null) {
            return 0;
        }
        else if (head.getNext() == null)  {
            return 1;
        }
        int count = 0;
        Node trav = head;
        while (trav.getNext() != null) {
            trav = trav.getNext();
            count++;
        }
        return count;
    }

    public void printList() throws LinkedListException {
        if (head == null) {
            throw new LinkedListException("LINKED LIST IS EMPTY NO ITEMS TO PRINT");
        }
        else if (head.getNext() == null){
            System.out.printf("Index: 0 | %s\n", head.getData());
        }
        else {
            int index = 0;
            Node trav = head;
            while (trav != null) {
                System.out.printf("Index: %d | %s\n", index, trav.getData());
                trav = trav.getNext();
                index++;
            }
        }
    }

    public int search(String data) throws LinkedListException {
        if (head == null) {
            throw new LinkedListException("LINKED LIST IS EMPTY NO ITEMS TO SEARCH");
        }
        Node trav = head;
        int index = 0;
        while (!trav.getData().equals(data) && trav.getNext() != null) {
            trav = trav.getNext();
            index++;
        }
        return trav.getData().equals(data) ? index : -1;
    }

}