package Lab4.pack3_ArrayLinkedList;

public class MyLinkedList_651328 {
    public class Node {
        int data;
        Node next;
        public Node(int d) {
            data = d;
        }
    }
    Node head = null;

    public int size(){
        int count = 0;
        Node p = head;
        while(p!=null) {
            count++;
            p = p.next;
        }
        return count;
    }

    public void add(int [] d){
        for(int i = d.length - 1; i >= 0; i--){
            add(d[i]);
        }
    }

    public void insert(int [] d){
        for(int i = 0; i < d.length; i++){
            insert(d[i]);
        }
    }

    public void q1_rotate_clockwise(int k){
        if (k <= 0 || k >= size()) return;
        Node p = head;
        for(int i = 0; i < k - 1; i++){
            p = p.next;
        }
        Node q = p.next;
        p.next = null;
        Node r = q;
        while(r.next != null){
            r = r.next;
        }
        r.next = head;
        head = q;
    }

    public void q2_reverse(){
        Node p = head;
        Node q = null;
        Node r = null;
        while(p != null){
            r = q;
            q = p;
            p = p.next;
            q.next = r;
        }
        head = q;
    }

    public void q3_remove_dup(){
        Node p = head;
        while(p != null){
            Node q = p;
            while(q.next != null){
                if(q.next.data == p.data){
                    q.next = q.next.next;
                }else{
                    q = q.next;
                }
            }
            p = p.next;
        }
    }

    public void q4_increment_digits(){
        Node p = head;
        Node q = null;
        while(p != null){
            if(p.data != 9){
                q = p;
            }
            p = p.next;
        }
        if(q == null){
            q = new Node(0);
            q.next = head;
            head = q;
        }
        q.data++;
        p = q.next;
        while(p != null){
            p.data = 0;
            p = p.next;
        }
    }

    public boolean q5_isPalindrome(){
        Node p = head;
        Node q = head;
        while(q != null && q.next != null){
            p = p.next;
            q = q.next.next;
        }
        if(q != null){
            p = p.next;
        }
        Node r = null;
        while(p != null){
            Node t = r;
            r = p;
            p = p.next;
            r.next = t;
        }
        p = head;
        while(r != null){
            if(r.data != p.data){
                return false;
            }
            r = r.next;
            p = p.next;
        }
        return true;
    }

    public void add(int d){
        Node p = new Node(d);
        p.next = head;
        head = p;
    }

    public void insert(int d){
        Node p = new Node(d);
        if(head == null){
            head = p;
            return;
        }
        Node q = head;
        Node r = null;
        while(q != null && q.data < d){
            r = q;
            q = q.next;
        }
        if(r == null){
            p.next = head;
            head = p;
        }else{
            r.next = p;
            p.next = q;
        }
    }

    public void delete(int d) {
        Node t = new Node(0);
        t.next = head;
        Node p = t;
        while( (p.next!=null) && (p.next.data!=d) ) {
            p = p.next;
        }
        if(p.next!=null) {
            p.next = p.next.next;
        }
        head = t.next;
    }

    public int find(int d){
        Node p = head;
        int index = 0;
        while(p != null){
            if(p.data == d){
                return index;
            }
            index++;
            p = p.next;
        }
        return -1;
    }

    public void append(int d) {
        Node p = new Node(d);
        if(head==null) {
            head = p;
            return;
        }
        Node q = head;
        while(q.next!=null) {
            q = q.next;
        }
        q.next = p;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("head ");
        Node p = head;
        while(p!=null) {
            sb.append("--> [");
            sb.append(p.data);
            sb.append("] ");
            p = p.next;
        }
        sb.append("-> null");
        return new String(sb);
    }
}