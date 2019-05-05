import java.util.*;
public class Main {
    public static void main(String args[]) {
        LinkedList myLinkedList = new LinkedList();
        String input = "";
        String[] inputComponents;
        while (!input.equals("-1")) {
            System.out.print("Enter Command: ");
            input = (new Scanner(System.in)).nextLine();
            inputComponents = input.split(" ");
            if (inputComponents.length == 1) {
                if (input.equals("printList")) {
                    try {
                        myLinkedList.printList();
                    }
                    catch (LinkedListException e){
                        System.out.println(e);
                    }
                }
                else if (input.equals("getSize")) {
                    System.out.println(myLinkedList.getSize());
                }
                else if (input.equals("empty")) {
                    System.out.println(myLinkedList.empty());
                }
                else if (input.equals("remove")) {
                    try {
                        System.out.printf("Removed: %s\n" , myLinkedList.remove().getData());
                    }
                    catch (LinkedListException e){
                        System.out.println(e);
                    }
                }
                else {
                    System.out.println("COMMAND NOT RECOGNIZED");
                }
            }
            else if (inputComponents.length == 2) {
                if (inputComponents[0].equals("add")) {
                    myLinkedList.add(new Node(inputComponents[1]));
                }
                else if (inputComponents[0].equals("remove")) {
                    try {
                        System.out.println(myLinkedList.remove(Integer.parseInt(inputComponents[1])).getData());
                    }
                    catch (LinkedListException e){
                        System.out.println(e);
                    }
                }
                else if (inputComponents[0].equals("search")) {
                    try {
                        System.out.println(myLinkedList.search(inputComponents[1]));
                    }
                    catch (LinkedListException e) {
                        System.out.println(e);
                    }
                }
                else {
                    System.out.println("COMMAND NOT RECOGNIZED");
                }
            }
            else if (inputComponents.length == 3) {
                if (inputComponents[0].equals("add")) {
                    try {
                        myLinkedList.add(new Node(inputComponents[1]), Integer.parseInt(inputComponents[2]));
                    }
                    catch (LinkedListException e){
                        System.out.println(e);
                    }
                }
                else {
                    System.out.println("COMMAND NOT RECOGNIZED");
                }
            }
            else {
                System.out.println("COMMAND NOT RECOGNIZED");
            }
        }
        System.out.println("BYE!");
    }
}