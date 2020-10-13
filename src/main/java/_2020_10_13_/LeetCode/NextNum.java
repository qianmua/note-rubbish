package _2020_10_13_.LeetCode;

public class NextNum {
    public String getPermutation(int n, int k) {
        if(n<2){
            return "1";
        }

        int[] src = new int[n];
        for (int i=0; i<n; i++){
            src[i] = i+1;
        }

        String s="";
        if(k==1){
            for(int i=0; i<n;i++){
                s += String.valueOf(src[i]);
            }
            return s;
        }

        for(int i=0; i<k-1; i++){
            nextNum(src);
        }

        for(int i=0; i<n;i++){
            s += String.valueOf(src[i]);
        }
        return s;
    }

    public void nextNum(int[] src){
        int len = src.length;
        int i=len-2;
        while(i>=0 && src[i]>src[i+1]){
            i--;
        }
        if(i==-1){
            reverse(src, i+1);
        }else{
            int j=len-1;
            while(src[j]<src[i]){
                j--;
            }
            swap(src, i, j);
            reverse(src, i+1);
        }
        return;
    }

    public void reverse(int[] src, int i){
        int j = src.length - 1;
        while(i<j){
            swap(src,i,j);
            i++;
            j--;
        }
        return;
    }

    public void swap(int[] src, int i, int j){
        int t = src[i];
        src[i] = src[j];
        src[j] = t;
        return;
    }

    public static void main(String[] args) {
        NextNum nextNum = new NextNum();
        String s = nextNum.getPermutation(3,3);
        System.out.println(s);
    }
}
