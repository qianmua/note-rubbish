package _2020_10_13_.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class AllTrace {
    public List<String> res = new ArrayList<>();
    public int len;

    public List<String> generateParenthesis(int n) {
        if(n==0){
            return res;
        }
        len = n;

        int left = 0;
        int right = 0;
        String trace = "";
        dfs(trace, left, right);
        return res;
    }

    public void dfs(String trace, int left, int right){
        if(trace.length() == len * 2 && left == right){
            res.add(trace);
            return;
        }else if(trace.length() == len * 2){
            return;
        }
        if(right > left){
            return;
        }
        if(left > len){
            return;
        }

        dfs(trace+"(", left+1, right);

        dfs(trace+")", left, right+1);

        return;

    }

    public static void main(String[] args) {
        AllTrace allTrace = new AllTrace();
        allTrace.generateParenthesis(3);
    }
}
