package myproject.samples;

import java.util.HashMap;
import java.util.Hashtable;

public class test1 {

	public static void main(String args[]) {
		int arr[] = {14,-1,1,-6,1,5,12,17} ;
		System.out.println(largestZeroSubArraySumBruteForce(arr));

		//System.out.println(largestZeroSubArraySumHashMap(arr));
	}

	private static int largestZeroSubArraySumBruteForce(int[] arr) {
		int maxLength=0;
		int n = arr.length;
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				int subArraySum = 0;
				for(int k=i;k<=j;k++) {
					subArraySum = subArraySum+ arr[k];
				}
				if(subArraySum==0) {
					if(maxLength < j-i+1)
						maxLength = j-i+1;
				}
					
			}
		}
		return maxLength;
	}
	
	private static int largestZeroSubArraySumHashMap(int[] arr) {


		HashMap<Integer,Integer> hmap = new HashMap<>();
		int subArraySum=0;
		int maxLength=0;
		for(int i=0;i<arr.length;i++) {
			subArraySum = subArraySum+arr[i];
			if(subArraySum==0) {
				maxLength = Math.max(maxLength,i+1);
			} else if(!hmap.containsKey(subArraySum)) {
				hmap.put(subArraySum, i);
			} else
				maxLength = Math.max(maxLength, i - hmap.get(subArraySum));
		}
		return maxLength;
	}

}
