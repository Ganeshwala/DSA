package Data.Structure.Algo.Arrays;
/**
 * 	
 * Given an array of integers arr, return true if and only if it is a valid mountain array.

	Recall that arr is a mountain array if and only if:

	arr.length >= 3
	There exists some i with 0 < i < arr.length - 1 such that:
	arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
	arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 */
public class MountainArray {

	public boolean validMountainArray(int[] arr) {
        if(arr.length<3){
            return false;
        }
        if(arr[0] >= arr[1]){
            return false;
        }
        boolean goDown = false;
        for(int i=0;i<arr.length-1;i++){
            if(!goDown){
                // increasing 
                if(arr[i]>arr[i+1] && !goDown){
                    goDown = true;
                    continue;
                }else if(arr[i]==arr[i+1]){
                    return false;
                }else{
                    continue;
                }
            }
            else{
                // decreasing
                if(arr[i] <= arr[i+1]){
                    return false;
                }
            }
        }
        return goDown;
    }
}
