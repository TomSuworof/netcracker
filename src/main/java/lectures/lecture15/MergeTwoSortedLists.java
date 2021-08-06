package lectures.lecture15;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Node list1 = new Node(1, new Node(2, new Node(4, null)));
        Node list2 = new Node(1, new Node(3, new Node(4, null)));

        printLinked(list1); // 1 -> 2 -> 4 ->
        printLinked(list2); // 1 -> 3 -> 4 ->

        Node result = solve(list1, list2);

        printLinked(result); // 1 -> 1 -> 2 -> 3 -> 4 -> 4 ->
    }

    private static Node solve(Node a, Node b) {
        if (a == null && b == null) {
            return null;
        }
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        Node resultEmptyHead = new Node(0, null);

        Node tail = resultEmptyHead;

        while (true) {

            if (a == null) {
                tail.next = b;
                break;
            }

            if (b == null) {
                tail.next =  a;
                break;
            }

            int valA = a.value;
            int valB = b.value;

            if (valA < valB) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }

            tail = tail.next;
        }

        return resultEmptyHead.next;
    }

    private static void printLinked(Node node) {
        while (node != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println();
    }
}

class Node {
    public int value;
    public Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}