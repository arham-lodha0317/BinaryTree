import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BooleanArrayTree {

    boolean[] tree;
    int levels;

    public BooleanArrayTree(boolean[] tree){

        levels = 0;

        while(Math.pow(2, levels) <= tree.length){
            levels++;
        }
        this.tree = new boolean[(int) Math.pow(2, levels)];
        for (int i = 0; i < tree.length; i++) {
            this.tree[i] = tree[i];
        }


    }

    public boolean exists(int pos){
        if(pos >= tree.length){
            return false;
        }

        return tree[pos];

    }
    public boolean getLeft(int pos){
        if((pos * 2) >= tree.length){
            return false;
        }
        return tree[pos * 2];
    }

    public boolean getRight(int pos){
        if((pos * 2 + 1) >= tree.length){
            return false;
        }

        return tree[pos * 2];
    }

    public int countLeft(int pos){
        return size(pos * 2);
    }

    public int size(int pos){
        if(!exists(pos)){
            return 0;
        }

        return 1 + size(pos * 2 + 1) + size(pos * 2);
    }

    private int countRight(int pos){
        return size(pos * 2  + 1);
    }

    public boolean isRightTree(){
        return isRightTree(1);
    }

    public boolean isRightTree(int pos){
        if(!exists(pos)){
            return true;
        }
        else if(countRight(pos) < countLeft(pos)){
            return false;
        }

        return isRightTree(pos * 2 ) && isRightTree(pos * 2  + 1 );

    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner file = new Scanner(new File("input.dat"));

        int num = Integer.parseInt(file.nextLine());

        for (int i = 1; i <= num; i++) {
            String line = file.nextLine();
            boolean[] tree = new boolean[line.length() + 1];

            for (int j = 0; j < line.length(); j++) {

                if(line.substring(j, j + 1).equals("0")){
                    tree[j + 1] = false;
                }
                else if(line.substring(j, j + 1).equals("1")){
                    tree[j + 1] = true;
                }
            }

            BooleanArrayTree booleanArrayTree = new BooleanArrayTree(tree);

            if(booleanArrayTree.isRightTree()){
                System.out.println("Tree " + i + " a is a right tree.");
            }
            else{
                System.out.println("Tree " + i + " a is a not right tree.");
            }


        }
    }


}
