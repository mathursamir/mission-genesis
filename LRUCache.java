import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Dnode {
        int key;
        int value;
        Dnode previous;
        Dnode next;
    }

    private void addtoHead(Dnode node){
        node.previous=head;
        node.next=head.next;
        head.next.previous=node;
        head.next=node;
    }

    private void remove (Dnode node){

        node.previous.next=node.next;
        node.next.previous=node.previous;

    }

    private void movetoHead (Dnode node){
        remove(node);
        addtoHead(node);
    }

    Dnode head = new Dnode();
    Dnode tail = new Dnode();

    private int capacity ;
    private int size ;

    private Map<Integer,Dnode> cache =new HashMap<Integer,Dnode>();


    public LRUCache(int capacity) {
        this.size=0;
        tail.previous=head;
        head.next=tail;
this.capacity=capacity;

    }

    public int get(int key) {
        Dnode node = cache.get(key);
        if (node == null) return -1;

        movetoHead(node);


        return node.value;
    }

    public void put(int key, int value) {
        Dnode node = cache.get(key);

        if (node==null){
            Dnode newNode=new Dnode();
            newNode.key=key;
            newNode.value=value;
            addtoHead(newNode);
            cache.put(key,newNode);
            size++;


            if (size>capacity){
                Dnode lastNode = tail.previous;
                remove(lastNode);
                cache.remove(lastNode.key);
                --size;
            }
        }else {
            node.value=value;
            movetoHead(node);

        }



    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */