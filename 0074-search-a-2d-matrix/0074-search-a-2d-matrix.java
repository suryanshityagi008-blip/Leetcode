class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length, n=matrix[0].length;

        int left=0, right=m*n-1;

        while(left<=right){
            int mid = (left +right) / 2;
            int value = matrix[mid/n][mid%n];

            if(target==value){
                return true;
            }else if(target<value){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
            
        }
        return false;
    }
        
    }
