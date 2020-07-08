package _a_alg_;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/7/8  22:23
 * @description :
 */
public class _800 {

    @Test
    public void m1(){
        wordBreak1("cars",
                Arrays.stream(new String[]{"car", "ca","rs"}).collect(Collectors.toList()));
    }

    /**
     * 记忆化
     * @param s
     * @param wordDict
     * @return
     */
    HashSet<Boolean> set = new HashSet<>();
    public boolean wordBreak1(String s, List<String> wordDict) {
        dp1(s,wordDict,-1);
        for (boolean o : set) {
            if (o){
                return true;
            }
        }
       return false;
    }
    void dp1(String s, List<String> wordDict , int count){
        final String[] s1 = {s};
        if (wordDict.size() == 0){
            return ;
        }
        wordDict.forEach( v -> s1[0] = s1[0].replaceAll(v, ""));
        wordDict.remove(count + 1);
        set.add( s1[0].length() == 0);
        dp1(s,wordDict,count);
    }

    HashMap<String , Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        return dp(s, wordDict);
    }
    boolean dp(String s, List<String> wordDict ){
        if (s.equals("")){
            return true;
        }
        if (map.containsKey(s)){
            return false;
        }
        boolean res = false;
        int i = s.length();
        for (int i1 = 0; i1 < i; i1++) {
            if (wordDict.contains(s.substring(0 , i1+1))){
                res = res|| dp(s.substring(i1 + 1) , wordDict);
                if (!res){
                    map.put(s.substring(i1 + 1) , true);
                }
            }
        }
        return res;
    }
}
