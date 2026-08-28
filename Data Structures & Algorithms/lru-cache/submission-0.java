class Node{
    int val;
    int key;

    Node prev;
    Node next;

    Node(int key, int val){
        this.key=key;
        this.val=val;
    }
}

class LRUCache {

    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int cap;

    public LRUCache(int capacity) {
        map=new HashMap<>();
        cap=capacity;

        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;

    }

    public void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;

        node.prev=null;
        node.next=null;
    }

    public void insertAtTail(Node node){
        tail.prev.next=node;
        node.prev=tail.prev;
        node.next=tail;
        tail.prev=node;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        insertAtTail(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.val=value;
            remove(node);
            insertAtTail(node);
            return;
        }

        if (map.size()==cap){
            Node lru=head.next;
            remove(lru);
            map.remove(lru.key);
        }

        Node node1=new Node(key,value);
        map.put(key,node1);
        insertAtTail(node1);
    }
}
