package structures;
import java.util.Arrays;
/**
*The maximum sub-array is the problem in which we aim to get the contiguous sub-array which has the maximum sum
*The elements of the sub-array should be a mix of negative as well as positive numbers otherwise a set of positive numbers would yield the entire array as the maximum sub-array
*It uses the divide and conquer approach
*The time complexity is O(nlg n); where lg n is the log of n to base 2
*
*@author: Devesh Shetty
*/
public class MaximumSubArray{
   
    /**
    *This method calculates the maximum sub-array  
    *@param arr the integer array
    *@param low the start index
    *@param high the end index
    *@param res the array of length 3 where the result has to be stored; index 0 contains the start index of the maximum sub-array, index 1 contains the end index of the maximum sub-array, index 2 contains the sum of the maximum sub-array
    *@param debug a debug string
    *@exception throws IllegalArgumentException on the supplying the res array of length > 3 or length < 3
    */
    public static int[] findMaximumSubArray(int arr[], int low, int high, int res[],String debug){
        
        //the res array should be of length 3 to store the results
        if(res.length != 3){
            throw new IllegalArgumentException("The length of res array should be 3");
        }
        
        debug += "-"; //for debugging purposes
        
        if(low == high){
            //base case: when only single element exists
            res[0] = low;//the start index
            res[1] = high;//the end index
            res[2] = arr[low];//the sum
        }
        else{
            //recursive case
            int mid = (low + high)/2;
            
            int[] left = new int[3],//containing the result of the left sub-array
                    right = new int[3],//containing the result of right sub-array
                    cross = new int[3];//containing the result of merging the right and left sub-array
            
            left = findMaximumSubArray(arr, low, mid, left, debug);//left subarray
            //System.out.println(debug+"Left sub-array: "+Arrays.toString(left));
            right = findMaximumSubArray(arr, mid+1, high, right, debug);//right subarray
            //System.out.println(debug+"Right sub-array: "+ Arrays.toString(right));
            cross = findMaxCrossingSubArray(arr, low, mid, high, cross);
            //System.out.println(debug+"Cross: "+Arrays.toString(cross));
            
            //the last index contains the max sum of the sub-arrays
            if(left[2] >= right[2] && left[2] >= cross[2]){
                //left sub-array has the max sub-array
                res = left;
            }
            else if(right[2] >= cross[2]){
                //right sub-array contains the max elements
                res = right;
            }
            else{
                res = cross;
            }
            //System.out.println(debug+" Result= "+Arrays.toString(res));
        }
        return res;
    }
    
    /**
    *The purpose of this method is to calculate the max crossing sub-array 
    *@param arr the integer array
    *@param low the start index
    *@param mid the end index
    *@param high the end index
    *@param res the array of length 3 where the result has to be stored; index 0 contains the start index of the maximum sub-array, index 1 contains the end index of the maximum sub-array, index 2 contains the sum of the maximum sub-array
    */
    private static int[] findMaxCrossingSubArray(int arr[], int low, int mid, int high, int res[]){
        
        int leftMaxIndex = -1,
            rightMaxIndex = -1,
            leftSum = Integer.MIN_VALUE,//assign the lowest value possible
            rightSum = Integer.MIN_VALUE;//assign the lowest value possible
        
        int sum = 0;
        //calculating the sum of left sub-array
        for( int i = mid; i >= low; i--){
            sum+= arr[i];
            if(sum > leftSum){
                leftSum = sum;
                leftMaxIndex = i;
            }
        }
        
        sum = 0;
        //calculating the sum of right sub-array
        for( int i = mid + 1; i <= high;i++){
            sum+= arr[i];
            if(sum > rightSum){
                rightSum = sum;
                rightMaxIndex = i;
            }
        }
        
        res[0] = leftMaxIndex;//the start index of cross sub-array
        res[1] = rightMaxIndex;//the end index of the cross sub-array
        res[2] = leftSum + rightSum;// the sum of the sub-array
        
        return res;
        
    }
    
    
}