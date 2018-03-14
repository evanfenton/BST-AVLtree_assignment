
public class Node implements Comparable{
    
    private Node parent, left, right;
    private long student_num;
    private String last_name, dept, program;
    private int year;
    
    public Node(long stn, String ln, String dp,
         String p, int y){
        student_num= stn;
        last_name= ln;
        dept= dp;
        program= p;
        year= y;
        parent= null;
        left= null;
        right= null;
    }
    
    public void setParent(Node p){ parent= p; }
    
    public void setLeft(Node l){ left= l; }
    
    public void setRight(Node r){ right= r; }
    
    public Node getParent(){ return parent; }
    
    public Node getLeft(){ return left; }
    
    public Node getRight(){ return right; }
    
    public long getStudentNum(){ return student_num; }
    
    public String getName(){ return last_name; }
    
    public String getDept(){ return dept; }
    
    public String getProgram(){ return program; }
    
    public int getYear(){ return year; }

    @Override
    public String toString() {
        return "\nStudent number: " + student_num + "\nLast Name: " +
                last_name + "\nDepartment: " + dept + "\nProgram: " +
                program + "\nYear: " + year;
    }
    
    @Override
    public int compareTo(Object n){
        Node node= (Node)n;
        return last_name.compareTo(node.getName());
    }
    
}














