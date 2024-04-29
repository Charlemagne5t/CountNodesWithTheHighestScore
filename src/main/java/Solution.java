import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Solution {
    public int countHighestScoreNodes(int[] parents) {
        List<List<Integer>> graphChildren = new ArrayList<>();
        int n = parents.length;
        for(int i = 0; i < n; i++) {
            graphChildren.add(new ArrayList<>());
        }

        for(int i = 1; i < n; i++) {
            graphChildren.get(parents[i]).add(i);
        }
        List<List<Integer>> graphParents = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graphParents.add(new ArrayList<>());
        }

        for(int i = 1; i < n; i++) {
            graphParents.get(i).add(parents[i]);
        }

        int[] subtreeSizes = new int[n];
        Arrays.fill(subtreeSizes, 1);
        dfs(0, graphChildren, subtreeSizes);

        long max = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            long res = 0L;
            if(subtreeSizes[i] == 1){
                res = n - 1;
            }else {
                long parentPart = graphParents.get(i).isEmpty() ? 1 : n - subtreeSizes[i];
                long leftPart = subtreeSizes[graphChildren.get(i).get(0)];
                long rightPart = graphChildren.get(i).size() < 2 ? 1 : subtreeSizes[graphChildren.get(i).get(1)];
                res = parentPart * leftPart * rightPart;
            }

            if(res > max){
                max = res;
                count = 1;
            }else if(res == max){
                count++;
            }
        }
        return count;
    }

    void dfs(int root, List<List<Integer>> graph, int[] res) {

        if(graph.get(root).size() == 0){
            res[root] = 1;
            return;
        }
        if(graph.get(root).size() > 0){
            dfs(graph.get(root).get(0), graph, res);
            res[root] += res[graph.get(root).get(0)];
        }
        if(graph.get(root).size() > 1){
            dfs(graph.get(root).get(1), graph, res);
            res[root] += res[graph.get(root).get(1)];
        }


    }
}
