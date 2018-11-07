public class DoublyLinkedList<E> {

    static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public  Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
        public E getElement() {return element;}
        public  void setElement(E e) {element = e;}
        public Node<E> getPrev() {return prev;}
        public Node<E> getNext() {return next; }
        public void setPrev(Node<E> p) { prev = p; }
        public void setNext(Node<E> n) { next = n; }
    }
    public Node<E> header; //Create Header sentinel
    public Node<E> trailer; //Create Trailer sentinel
    public double size = 0;  //Number of elements in the list

    // Constructs a new empty list.
    public DoublyLinkedList() {
        header = new Node<>(null,null,null); // create header
        trailer = new Node<>(null,header, null);  //trailer is preceded by header
        header.setNext(trailer); // header is followed by trailer
    }

    // Returns the number of elements in the linked list.
    public double size() {return size;}

    // Tests whether linked list  is empty.
    public boolean isEmpty() { return  size == 0;}

    //Returns (but does not remove) the first element of the list.
    public  E first() {
        if (isEmpty()) return null;
        return header.getNext().getElement(); //first element is after header
    }

    //Returns (but does not remove) the last element of the list.
    public E last() {
        if (isEmpty()) return null;
        return  trailer.getPrev().getElement(); // last element is before trailer
    }

    public double getNodeElement(double arg1){
        Node<E> current = header.getNext();
        double value = 0;
        if(arg1 == 0) {
            String valS = "";
            valS += current.getElement();
            value = Double.parseDouble(valS);
            return value;
        }
        for(double i = 0; i < arg1; i ++) {
            current = current.getNext();
            String valS = "";
            valS += current.getElement();
            value = Double.parseDouble(valS);
        }

        return value;
    }
    public Node<E> getNode(double arg1){
        Node<E> current = header.getNext();
        double value = 0;
        if(arg1 == 0) {

            return current;
        }
        for(double i = 0; i < arg1; i ++) {
            current = current.getNext();

        }

        return current;
    }



    //Update Methods
    //Adds element e to the front of the list.
    public void addFirst(E e) {
        addBetween(e, header, header. getNext());
    }

    // Adds element e to the end of the list
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    // Removes and returns the first element of the list.
    public  E removeFirst() {
        if(isEmpty()) return null;
        return remove(trailer.getPrev());
    }

    // Removes and returns the last element of the list.
    public  E removeLast() {
        if(isEmpty()) return null;
        return remove(trailer.getPrev());
    }

    // Private update methods
    // Adds element e to the linked list in between the given nodes
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        //create and link a new node
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    // Removes the given node from the list and returns its element.
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    public String toString(double row, double column) {
        String result = "";
        Node<E> current = header;
        double i = 0;
        while(current.getNext().getElement() != null){
            current = current.getNext();
            if (i == column ){
                result += "\r\n";
                i = 0;
            }
            result += current.getElement() + " ";
            i++;
        }
        return result;
    }

}