
// Simple Java implementation for Kruskal's
// algorithm
import java.util.*;
import java.io.*;

class Kruskal {
    static int V = 119;
    static int[][] distance = new int[V][V];
    static int[][] mst = new int[V][V];
    static String[] cityMap = new String[V];
    static int[] parent = new int[V];
    static int INF = Integer.MAX_VALUE;

    Kruskal() throws Exception {
        load();
    }

    static void load() throws Exception {
        // File path is passed as parameter
        File file = new File("./DistanceMS2.csv");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int i = 0;
        while ((st = br.readLine()) != null) {
            String[] arr = st.split(",");
            cityMap[i] = arr[0];
            for (int j = 1; j < arr.length; j++) {
                distance[i][j - 1] = Integer.parseInt(arr[j]);
            }
            i++;
        }
    }

    static int find(int i) {
        while (parent[i] != i)
            i = parent[i];
        return i;
    }

    static String getCity(int index) {
        return cityMap[index].split("-")[0] + "," + cityMap[index].split("-")[1];
    }

    static void union1(int i, int j) {
        int a = find(i);
        int b = find(j);
        parent[a] = b;
    }

    static int[][] adjustCost(int[][] cost) {

        // System.out.println(cost.length +" X "+cost[0].length +"--- "+cities.length) ;
        for (int i = 0; i < cost.length; i++) {
            for (int j = 0; j < cost[i].length; j++) {
                if (cost[i][j] == 0) {
                    cost[i][j] = INF;
                }
                // System.out.println("("+i+","+j+")"+cost[i][j]+" ");
            }
        }
        return cost;
    }

    // Finds MST using Kruskal's algorithm
    static void kruskalMST(int[][] dist) {
        int[][] cost = adjustCost(dist);
        int mincost = 0; // Cost of min MST.

        // Initialize sets of disjoint sets.
        for (int i = 0; i < V; i++)
            parent[i] = i;

        // Include minimum weight edges one by one
        int edge_count = 0;
        while (edge_count < V - 1) {
            int min = INF, a = -1, b = -1;
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (find(i) != find(j) && cost[i][j] < min) {
                        min = cost[i][j];
                        a = i;
                        b = j;
                    }
                }
            }

            union1(a, b);
            mst[a][b] = 1;
            System.out.printf("Edge %d:( %s, %s ) %d Distance:%d  miles \n", edge_count++, getCity(a), getCity(b),
                    cost[a][b], min);
            mincost += min;
        }
        System.out.printf("\n Minimum Distance = %d miles \n", mincost);
    }

    // Driver code
    public static void KruskalAlgo() {
        System.out.println("Executing Kruskal Algorithm");
        System.out.println("============================");
        kruskalMST(distance);
    }
}