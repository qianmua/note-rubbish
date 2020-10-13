package _2020_10_13_.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class BackTrack {
    List<List<Integer>> res = new ArrayList<>();
    int k;
    int n;

    public  List<List<Integer>> combine(int n, int k) {
        if(n==0 || k==0){
            return res;
        }
        int[] visited = new int[n];
        this.k = k;
        this.n = n;
        List<Integer> trace = new ArrayList<>();

        backTrace(trace, visited);

        return res;
    }

    public void backTrace(List<Integer> trace, int[] visited){
        if(trace.size()==k){
            res.add(new ArrayList<>(trace));
            return;
        }

        for(int i=0; i<n; i++){
            if(visited[i]==0){
                visited[i]=1;
                trace.add(i+1);
                backTrace(trace, visited);
                int size = trace.size();
                int temp = trace.get(size-1);
                trace.remove(size-1);
                visited[temp-1] = 0;
            }
        }
        return;
    }

    public static void main(String[] args) {
        BackTrack backTrack = new BackTrack();
        backTrack.combine(4,2);
    }
}
