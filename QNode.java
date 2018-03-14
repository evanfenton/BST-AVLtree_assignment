public class QNode extends Node{
    
    private QNode next, prev;
    
    public QNode(Node node){
        super(node.getStudentNum(), node.getName(),
              node.getDept(), node.getProgram(),
              node.getYear());
        super.setLeft(node.getLeft());
        super.setRight(node.getRight());
        super.setParent(node.getParent());
        next= null;
        prev= null;
    }
    
    public void setNext(QNode qn){ next= qn; }
    
    public QNode getNext(){ return next; }
    
    public void setPrev(QNode qn){ prev= qn; }
    
    public QNode getPrev(){ return prev; }
    
}

