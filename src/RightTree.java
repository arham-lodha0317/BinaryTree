import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RightTree {

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
