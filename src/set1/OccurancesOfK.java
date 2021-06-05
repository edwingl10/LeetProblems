package set1;

/*
Given a sorted array and a number, write a function that counts the occurances of x in the array.
 */

public class OccurancesOfK {
    enum SearchType{FIRST, LAST}

    public int freq(int[] arr, int k){
        int firstOccurance = occurance(arr, k, 0, arr.length-1, SearchType.FIRST);
        // if we can't find first occurrence, return -1
        if(firstOccurance == -1)
            return -1;
        int secondOccurance = occurance(arr, k, 0, arr.length-1, SearchType.LAST);
        return secondOccurance - firstOccurance +1;
    }

    int occurance(int[] arr, int k, int left, int right, SearchType search){
        if(arr.length == 0 || left>right)
            return -1;
        int mid = left + (right-left)/2;

        if(arr[mid] == k){
            // if searching for first occurrence
            if(search == SearchType.FIRST){
                // if left index is within bounds and left item is same as mid item, go left
                if(isInBounds(arr, mid-1) && arr[mid] == arr[mid-1])
                    return occurance(arr, k, left, mid-1, search);
            }
            // if searching for last occurrence
            if(search == SearchType.LAST){
                // if right index is within bounds and right item is same as mid item, go right
                if(isInBounds(arr, mid+1) && arr[mid] == arr[mid+1])
                    return occurance(arr, k, mid+1, right, search);
            }
            return mid;
        }
        // if mid item is less than k, go right
        else if(arr[mid] < k)
            return occurance(arr, k, mid+1, right, search);
        // go left
        else
            return occurance(arr, k, left, right-1, search);
    }

    // checks if index is within bounds of array
    boolean isInBounds(int[] arr, int index){
        return index >= 0 && index < arr.length;
    }

    public static void main(String[] args){
        OccurancesOfK o = new OccurancesOfK();
        int[] arr = {1,1,1,2,3};
        System.out.println(o.freq(arr, 1));
    }
}
