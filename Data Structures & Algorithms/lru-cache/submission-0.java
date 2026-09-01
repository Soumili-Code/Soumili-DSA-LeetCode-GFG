class Node{
     int val;
     int key;
     Node next;
     Node prev;
     Node(int key, int val){
        this.key = key;
        this.val = val;
        next = null;
        prev = null;
     }
   }
   class LRUCache {
    Map<Integer,Node> mp;
    Node head,tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        mp = new HashMap<>();
        head = new Node(-1, -1); 
        tail = new Node(-1, -1);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!mp.containsKey(key))
            return -1;
        Node node=mp.get(key);
        deleteNode(node);
        insertNodeAfterHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node=null;
        if(mp.containsKey(key)){
            node=mp.get(key);
            node.val=value;
            deleteNode(node);
        }
        else{
            if(mp.size()>=capacity){
                Node end = tail.prev;
                mp.remove(end.key);
                deleteNode(end);
            }
            node = new Node(key, value);
            mp.put(key, node);
        }
        insertNodeAfterHead(node); 
    }
    private void insertNodeAfterHead(Node node){
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
    }
    private void deleteNode(Node node){
         Node prevNode = node.prev;
         Node nextNode = node.next;
         prevNode.next = nextNode;
         nextNode.prev = prevNode;
    }
   }