package main;

import java.util.Arrays;

public class Search {

	public boolean linearSearch(int[] data, int key) {
		for (int i = 0; i < data.length; i++)
			if (data[i] == key)
				return true;
		return false;
	}

	public boolean binarySearch(int[] data, int key) {
		int low = 0;
		int high = data.length - 1;
		while (low < high) {
			int mid = (low + high) >> 1;
			if (key < data[mid]) high = mid - 1;
			else if (key > data[mid]) low = mid + 1;
			return true;
		}
		return false;
	}

	public int lonelySearch(int[] arr) {
		int lonely = 0;
		for (int i = 0; i < arr.length; i++)
			lonely = lonely ^ arr[i];
		return lonely;
	}

	public int findFirstOccurance(int[] arr, int key) {
		int retval = -1;
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) >> 1;
			if (key < arr[mid]) high = mid - 1;
			else if (key > arr[mid]) low = mid + 1;
			else {
				retval = mid;
				high = mid - 1;
			} 
		}
		return retval;
	}

	public int findLastOccurance(int[] arr, int key) {
		int retval = -1;
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) >> 1;
			if (key < arr[mid]) high = mid - 1;
			else if (key > arr[mid]) low = mid + 1;
			else {
				retval = mid;
				low = mid + 1;
			} 
		}
		return retval;
	}

	public int findOccuranceCount(int[] arr, int key) {
		int firstIndex = findFirstOccurance(arr, key);
		int lastIndex = findLastOccurance(arr, key);
		return lastIndex - firstIndex + 1;
	}

	public int findMissingNumber(Integer[] nums) {
		boolean[] exist = new boolean[nums.length + 1];
		Arrays.fill(exist, false);
		for (int i = 0; i < nums.length; i++)
			if (nums[i] != null)
				exist[nums[i]] = true;
		for (int i = 1; i < exist.length; i++)
			if (exist[i] == false)
				return i;
		return -1;
	}
}