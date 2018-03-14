
import java.io.*;

public class Assign3 {

    private BinarySearchTree bst;
    private Queue print_queue;

    private BinarySearchTree getBst(){ return bst; }

    private void clear(){
        bst.setRoot(null);
        print_queue.clear();
    }

    private void readInputFile(String inputfile){

        try{
            FileReader reader= new FileReader(inputfile);
            BufferedReader bufferedReader= new BufferedReader(reader);
            String std_line;
            String std_name, std_dept, std_prog;
            long std_num;
            int std_year;

            while((std_line= bufferedReader.readLine())!=null){

                std_num= Long.parseLong(std_line.substring(1,8));
                std_name= std_line.substring(8,33);
                std_dept= std_line.substring(33,37);
                std_prog= std_line.substring(37,41);
                std_year= Integer.parseInt(std_line.substring(41));

                Node std= new Node(std_num, std_name, std_dept, std_prog,
                        std_year);

                if(std_line.charAt(0)== 'D')
                    bst.delete(std);
                else
                    bst.insert(std);

            }

            bufferedReader.close();

        }catch(FileNotFoundException ex){
            System.out.println("Error: file was not found.");
        }catch(IOException ex){
            System.out.println("Error reading file");
        }

    }

    private void InOrder(Node current){

        if(current != null) {
            InOrder(current.getLeft());

            print_queue.enqueue(current);

            InOrder(current.getRight());
        }

    }

    private void printToFile(String outputfile){

        try {
            FileWriter write = new FileWriter(outputfile, false);
            PrintWriter print = new PrintWriter(write);

            while(!print_queue.isEmpty())
                print.println(print_queue.dequeue().toString());

            print.close();

        }catch(IOException e){

            System.out.println("There was a problem opening the file.");
        }

    }

    private void breadthFirst(){

        Node p= bst.getRoot();
        Queue q= new Queue();

        if(p != null){
            q.enqueue(p);

            while(!q.isEmpty()){
                p= q.dequeue();

                print_queue.enqueue(p);

                if(p.getLeft()!=null)
                    q.enqueue(p.getLeft());
                if(p.getRight()!=null)
                    q.enqueue(p.getRight());

            }
        }


    }

    private Assign3(){
        bst= new BinarySearchTree();
        print_queue= new Queue();
    }

    public static void main(String[] args) {

        Assign3 assign3= new Assign3();

        //just insertions
        assign3.readInputFile(args[0]);

        assign3.InOrder(assign3.getBst().getRoot());
        assign3.printToFile(args[1]);
        
        assign3.breadthFirst();
        assign3.printToFile(args[2]);
        
        assign3.clear();

        //insertions and deletions
        assign3.readInputFile(args[3]);

        assign3.InOrder(assign3.getBst().getRoot());
        assign3.printToFile(args[4]);

        assign3.breadthFirst();
        assign3.printToFile(args[5]);

    }
}
