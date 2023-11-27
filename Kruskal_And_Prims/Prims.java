// A simple Java implementation to find minimum
// spanning tree for adjacency representation.
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

class Prims
{
    static int V = 119;
    static int[][] distance = new int[V][V];
    static String []  cityMap = new String[V];
    static int INT_MAX = Integer.MAX_VALUE;

    public static String getCity(int index){
        return cityMap[index];
    }
    public static void load() throws Exception{
        // File path is passed as parameter
        File file = new File("./DistanceMS2.csv");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int i =0;
        while ((st = br.readLine()) != null){
            String [] arr = st.split(",");
            cityMap[i] = arr[0];
            for(int j =1;j<arr.length;j++){
                distance[i][j-1] = Integer.parseInt(arr[j])==0?INT_MAX:Integer.parseInt(arr[j]);
            }
            i++;
        }
    }
    static boolean isValidEdge(int u, int v,
                               boolean[] inMST)
    {
        if (u == v)
            return false;
        if (inMST[u] == false && inMST[v] == false)
            return false;
        else if (inMST[u] == true && inMST[v] == true)
            return false;
        return true;
    }

    static void primMST(int cost[][])
    {
        boolean []inMST = new boolean[V];

        // Include first vertex in MST
        inMST[0] = true;

        // Keep adding edges while number of included
        // edges does not become V-1.
        int edge_count = 0, mincost = 0;
        while (edge_count < V - 1)
        {

            // Find minimum weight valid edge.
            int min = INT_MAX, a = -1, b = -1;
            for (int i = 0; i < V; i++)
            {
                for (int j = 0; j < V; j++)
                {
                    if (cost[i][j] < min)
                    {
                        if (isValidEdge(i, j, inMST))
                        {
                            min = cost[i][j];
                            a = i;
                            b = j;
                        }
                    }
                }
            }

            if (a != -1 && b != -1)
            {
                System.out.printf("Edge %d:(%s, %s) cost: %d \n",
                        edge_count++, getCity(a), getCity(b), min);
                mincost = mincost + min;
                inMST[b] = inMST[a] = true;
            }
        }
        System.out.printf("\n Minimum Distance  = %d \n  miles∂", mincost);
    }

    // Driver Code
    public static void PrimsAlgo() throws Exception {
        load();
        // Print the solution
        primMST(distance);
    }
}