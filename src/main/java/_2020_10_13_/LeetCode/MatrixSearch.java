package _2020_10_13_.LeetCode;

public class MatrixSearch {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null){
            return false;
        }
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int left = 0, right = colNum*rowNum-1;
        int mid = left + (right-left)/2;
        while(left<=right){
            mid = left + (right-left)/2;
            int i=mid/colNum;
            int j=mid%colNum;
            if(matrix[i][j]<target){
                left = mid+1;
            }else if(matrix[i][j]>target){
                right = mid-1;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        searchMatrix(matrix,3);
    }
}
