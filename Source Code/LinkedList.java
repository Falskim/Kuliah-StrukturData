public class LinkedList<E> {
    
    private Node head;
    private Node tail;
    private int count;
    
    public LinkedList() {
        head = null;
        tail = null;
        count = -1;
    }
    public void add(E data){
        Node<E> node = new Node<>(data);
        Node temp = tail;
        if(head==null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        tail.prev = temp;
        count++;
    }
    public void add(E data, int index){
        if(index>count) {
            add(data);
        } else if (index==0) {
            addFirst(data);
        } else {
            Node<E> node = new Node<>(data);
            Node temp = head;
            for(int i=0;i<index;i++){
                temp = temp.next;
            }
            node.next = temp;
            node.prev = temp;
            temp.prev.next = node;
            temp.next.prev = node;
            count++;
        }
    }
    public void addFirst(E data){
        Node<E> node = new Node<>(data);
        head.prev = node;
        node.next = head;
        head = node;
        count++;
    }
    public void addLast(E data){
        add(data);
    }
    public void printAll(){
        Node temp = head;
        if(!isEmpty()){
            while(temp != null){
                System.out.print(temp.data);
                if(temp.next != null) System.out.print(", ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
    public void remove(){
        if(count==0){
            head = null;
            tail = null;
        } else {
            Node temp = tail.prev;
            tail.prev = null;
            temp.next = null;
            tail = temp;
            count--;
        }
    }
    public void remove(int index){
        Node temp = head;
        if(index>count){
            System.out.println("Error, ukuran LinkedList hanya : "+count);
        } else if (index == count){
            removeLast();
        }else {
            for(int i=0;i<index;i++){
                temp = temp.next;
            }
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        count--;
    }
    public void removeLast(){
        remove();
    }
    public void removeFirst(){
        Node temp = head.next;
        head.next.prev = null;
        head.next = null;
        head = temp;
        count--;
    }
    public String get(){
        return tail.toString();
    }
    public String get(int index){
        if(index>=count){
            return get();
        }else if(index==0){
            return getFirst();
        }else{
            Node temp = head;
            for(int i=0;i<index;i++){
                temp = temp.next;
            }
            return temp.toString();
        }
    }
    public String getLast(){
        return get();
    }
    public String getFirst(){
        return head.toString();
    }
    public void clear(){
        head.next = null;
        head.prev = null;
        head = null;
        tail.next = null;
        tail.prev = null;
        tail = null;
    }
    public boolean isEmpty(){
        return head==null && tail==null;
    }
    private class Node<E>{
        
        private E data;
        private Node next;
        private Node prev;
        
        Node(E data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
        public void setNext(Node next){
            this.next = next;
        }
        public void setPrev(Node prev){
            this.prev = prev;
        }
        public Node getNext(){
            return next;
        }
        public Node getPrev(){
            return prev;
        }
        @Override
        public String toString(){
            return data.toString();
        }
    }
}
