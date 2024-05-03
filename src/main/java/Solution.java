import java.util.*;

public class Solution {
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int[] e : edges) {
            int in = e[0];
            int out = e[1];
            if (graph.size() <= in || graph.size() <= out) {
                while (graph.size() <= in || graph.size() <= out) {
                    graph.add(new ArrayList<>());
                }
            }
            graph.get(in).add(out);
            graph.get(out).add(in);

        }
        Map<Long, Integer> guessesIndex = new HashMap<>();
        for (int i = 0; i < guesses.length; i++) {
            int[] g = guesses[i];
            guessesIndex.put(g[0] * (long) 1e6 + (long) g[1], i);
        }
        boolean[] rightGuesses0 = new boolean[guesses.length];
        int[] result = new int[graph.size()];

        dfs0(0, -1, graph, rightGuesses0, guessesIndex, result);
        //System.out.println(Arrays.toString(rightGuesses0));

        int[] answer = new int[1];
        answer[0] = 0;
        dfs(0, -1, graph, rightGuesses0, guessesIndex, result, answer, k);
        //System.out.println(Arrays.toString(result));
        return answer[0];
    }

    void dfs(int node, int parent, List<List<Integer>> graph, boolean[] rightGuesses0,
             Map<Long, Integer> guessesIndex, int[] result, int[] answer, int k) {
        if (parent != -1) {
            result[node] = result[parent];
        }

        if (guessesIndex.containsKey(parent * (long) 1e6 + (long) node)) {
            int index = guessesIndex.get(parent * (long) 1e6 + (long) node);
            rightGuesses0[index] = !rightGuesses0[index];
            if (rightGuesses0[index]) {
                result[node]++;
            } else result[node]--;

        }
        if (guessesIndex.containsKey(node * (long) 1e6 + (long) parent)) {
            Integer indexReversed = guessesIndex.get(node * (long) 1e6 + (long) parent);
            rightGuesses0[indexReversed] = !rightGuesses0[indexReversed];
            if (rightGuesses0[indexReversed]) {
                result[node]++;
            } else result[node]--;

        }
        if (result[node] >= k) {
            answer[0]++;
        }
        for (Integer nei : graph.get(node)) {
            if (nei != parent) {
                dfs(nei, node, graph, rightGuesses0, guessesIndex, result, answer, k);
            }
        }

    }

    void dfs0(int node, int parent, List<List<Integer>> graph, boolean[] rightGuesses0,
              Map<Long, Integer> guessesIndex, int[] result) {
        if (guessesIndex.containsKey(parent * (long) 1e6 + (long) node)) {
            int index = guessesIndex.get(parent * (long) 1e6 + (long) node);
            rightGuesses0[index] = true;
            result[0]++;
        }
        for (Integer nei : graph.get(node)) {
            if (nei != parent) {
                dfs0(nei, node, graph, rightGuesses0, guessesIndex, result);
            }
        }
    }
}