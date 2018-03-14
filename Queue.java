
public class Queue{
    
    private QNode head, tail;

    public Queue(){
        head= null;
        tail= null;
    }

    public void clear(){
        head= null;
        tail= null;
    }

    public boolean isEmpty(){

        if(head== null && tail==null)
            return true;
        else
            return false;

    }

    public void enqueue(Node node){
        QNode qnode= new QNode(node);

        if(head==null && tail==null){
            head= qnode;
            tail= qnode;
        }
        else{
            tail.setNext(qnode);
            qnode.setPrev(tail);
            tail= qnode;
        }

    }

    public Node dequeue(){

        if(head == null && tail == null){
            return null;
        }

        Node node= head;
        if(head == tail) {
            head= null;
            tail= null;
        }
        else {
            head = head.getNext();
            head.setPrev(null);
        }
        return node;
    }
    
}

