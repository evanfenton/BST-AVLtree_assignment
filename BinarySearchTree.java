
public class BinarySearchTree{

    private Node root;
    
    private Node findSmallest(Node current){
        
        Node smallest= current;
        
        while(smallest.getLeft() != null){
            
            smallest= smallest.getLeft();
        }
        
        return smallest;
    }
    
    private Node search(Node current, Node key){
        
        while(current != null){
            
            if(key.compareTo(current) == 0) {
                return current;
            }
            else if(key.compareTo(current) > 0) {
                current = current.getRight();
            }
            else {
                current = current.getLeft();
            }
        }
        return null;
    }

    public BinarySearchTree(){
        root= null;
    }

    public Node getRoot(){ return root; }

    public void setRoot(Node r){
        root= r;
    }

    public void insert(Node node){

        Node current = root, parent= null;

        while(current != null){

            parent= current;

            if( node.compareTo(current) > 0 )
                current= current.getRight();
            else
                current= current.getLeft();
        }

        if(root == null) {
            root = node;
        }
        else if( node.compareTo(parent) > 0 ) {
            parent.setRight(node);
            node.setParent(parent);
        }
        else {
            parent.setLeft(node);
            node.setParent(parent);
        }
    }

    public void delete(Node key_to_delete){

        Node to_delete= search(root, key_to_delete);

        if(to_delete == null) {
            System.err.println("Error: Could not delete the record. " +
                    "The following record does not exist:\n"+key_to_delete.toString());
        }

        else if(to_delete.getLeft()== null &&
                to_delete.getRight()== null){

            if(to_delete.compareTo(to_delete.getParent()) > 0)
                to_delete.getParent().setRight(null);
            else
                to_delete.getParent().setLeft(null);
        }

        else if(to_delete.getLeft()== null &&
                to_delete.getRight()!= null){

            if(to_delete == root){
                root= root.getRight();
                root.setParent(null);
            }
            else if(to_delete.compareTo(to_delete.getParent()) > 0) {
                to_delete.getParent().setRight(to_delete.getRight());
                to_delete.getRight().setParent(to_delete.getParent());
            }
            else {
                to_delete.getParent().setLeft(to_delete.getRight());
                to_delete.getRight().setParent(to_delete.getParent());
            }

        }

        else if(to_delete.getLeft()!= null &&
                to_delete.getRight()== null) {

            if(to_delete == root){
                root= root.getLeft();
                root.setParent(null);
            }
            else if(to_delete.compareTo(to_delete.getParent()) > 0) {
                to_delete.getParent().setRight(to_delete.getLeft());
                to_delete.getLeft().setParent(to_delete.getParent());
            }
            else {
                to_delete.getParent().setLeft(to_delete.getLeft());
                to_delete.getLeft().setParent(to_delete.getParent());
            }
        }

        else{

            Node sub= findSmallest(to_delete.getRight());
            delete(sub);

            sub.setLeft(to_delete.getLeft());
            sub.setRight(to_delete.getRight());

            if(to_delete==root){
                root= sub;
            }
            else if(to_delete.compareTo(to_delete.getParent()) > 0) {
                to_delete.getParent().setRight(sub);
                sub.setParent(to_delete.getParent());
            }
            else {
                to_delete.getParent().setLeft(sub);
                sub.setParent(to_delete.getParent());
            }
        }

    }

}
