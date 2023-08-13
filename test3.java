package myproject.samples;

import java.util.HashMap;

public class test3 {

	  public static void main(String[] args) {
		  int[] arr = {15, 4, -2, 2, 5, -8, 1, 7, 10, 23}; 
	      System.out.println("Max Length = " + largestZeroSubArraySumBruteForce(arr));
	      //System.out.println("Max Length = " + largestZeroSubArraySumHashMap(arr));
	    }

	private static int largestZeroSubArraySumHashMap(int[] arr) {
		
		int len = arr.length;
		int maxLen = 0;
		HashMap<Integer,Integer> hMap = new HashMap<>();
		int sumSubArray = 0;
		/*-2, 2
		-8, 1, 7
		-2, 2, -8, 1, 7  == len 5
		output: 5      -2, 2, -8, 1, 7 */
		//looping through each item of an array	        
		for(int i=0;i<len;i++) {
			//inner loop for preparing subarray with summing up
			sumSubArray = sumSubArray + arr[i];
			if(sumSubArray == 0) {
				maxLen = Math.max(maxLen,i+1);
			}
		    if(!hMap.containsKey(sumSubArray)) {
		    	hMap.put(sumSubArray, i);
		    } else {
		    	maxLen = Math.max(maxLen, i - hMap.get(sumSubArray));
		    }
		}
		return maxLen;
	}

	private static int largestZeroSubArraySumBruteForce(int[] arr) {
		int len = arr.length;
		int maxLen = 0;
		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				int sumSubArray = 0;
				for (int k = i; k <= j; k++) {
					sumSubArray = sumSubArray + arr[k];
				}
				if (sumSubArray == 0) {
					if (maxLen < j - i + 1)
						maxLen = j - i + 1;
				}
			}

		}
		return maxLen;
	}
	
	private static int largestZeroSubArraySumOptimize(int[] arr) {
		int len = arr.length;
		int maxLen = 0;
		for (int i = 0; i < len; i++) {
			Integer sumSubArray = 0;
			for (int j = i; j < len; j++) {
					sumSubArray = sumSubArray + arr[j];
					if(sumSubArray==0) {
						if(maxLen < j - i + 1)
							maxLen= j - i + 1;
					}
			}
		}
		return maxLen;
	}
}
