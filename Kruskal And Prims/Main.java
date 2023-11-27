
// Simple Java implementation for Kruskal's
// algorithm
import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws Exception {
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter the which algorithm to apply");
        System.out.println("(Kruskal / Prims) [press n to terminate.] ?");

        boolean flag = true;
        while (flag) {
            String algo = inp.next();
            if (algo.contains("Kruskal")) {
                Kruskal mst_kruskal = new Kruskal();
                mst_kruskal.KruskalAlgo();
                System.out.println("Do you want to continue(y/n)?");
                String resp = inp.next();
                if (resp.contains("n")) {
                    flag = false;
                } else {
                    System.out.println("Enter the which algorithm to apply");
                    System.out.println("(Kruskal / Prims) [press n to terminate.] ?");
                }
            } else if (algo.contains("Prims")) {
                Prims mst_prims = new Prims();
                mst_prims.PrimsAlgo();
                System.out.println("Do you want to continue(y/n)?");
                String resp = inp.next();
                if (resp.contains("n")) {
                    flag = false;
                } else {
                    System.out.println("Enter the which algorithm to apply");
                    System.out.println("(Kruskal / Prims) [press n to terminate.] ?");
                }
            } else if (algo.contains("n")) {
                flag = false;
            } else {
                System.out.println("Invalid Input!");
                System.out.println("Enter the which algorithm to apply");
                System.out.println("(Kruskal / Prims) [press n to terminate.] ?");
            }
        }

    }
}
