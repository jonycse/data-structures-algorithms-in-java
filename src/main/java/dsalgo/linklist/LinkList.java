package dsalgo.linklist;


public class LinkList {

    class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }

        public boolean hasNext() {
            return this.next != null;
        }
    }

    private Node head;

    public void prepend(int value) {
        Node newHead = new Node(value);
        newHead.next = head;
        head = newHead;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;

        while (current.hasNext()) {
            current = current.next;
        }
        current.next = newNode;
    }


    public void append(int value, int index) {
        Node node = new Node(value);
        if (index == 0) {
            if (head == null) {
                head = node;
                return;
            }
            node.next = head;
            head = node;
            return;
        }
        Node current = head;
        int c = 0;
        while (current != null) {
            c++;
            if (c == index) {
                // _x_x_x_
                // _ represents position
                node.next = current.next;
                current.next = node;
                return;
            }
            current = current.next;

        }
    }

    public void deleteByValue(int value) {
        if (head == null) {
            return;
        }
        if (head.val == value) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.val == value) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void delete(int index) {

        if (head == null) {
            return;
        }
        if (index == 0) {
            if (head.hasNext()) {
                head = head.next;
                return;
            }
            head = null;
            return;
        }

        Node current = head;
        int c = 1;
        while (current.next != null) {
            if (c == index) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
            c++;
        }
    }

    public String getList() {
        return getList(head);
    }

    public String getList(Node head) {
        String r = "", sp = "";

        Node current = head;

        while (current != null) {

            r = r + sp + current.val;
            current = current.next;
            sp = " ";

        }

        return r;
    }

}

