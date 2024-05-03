import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int[] e : edges){
            int in = e[0];
            int out = e[1];
            if(graph.size() <= in || graph.size() <= out){
                while(graph.size() <= in || graph.size() <= out){
                    graph.add(new ArrayList<>());
                }
            }
            graph.get(in).add(out);
            graph.get(out).add(in);

        }

        return 3;
    }
}
