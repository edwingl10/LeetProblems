package set1;

public class PrimeNumberSetBitsBinary {
	/**
	 * Given two integers L and R, find the count of number in the range [L, R] (inclusive)
	 * having a prime number of set bits in their binary representation.
	 * Input: L = 6, R = 10
	 * Output: 4
	 * Explanation:
	 * 6 -> 110 (2 set bits, 2 is prime)
	 * 7 -> 111 (3 set bits, 3 is prime)
	 * 9 -> 1001 (2 set bits , 2 is prime)
	 * 10->1010 (2 set bits , 2 is prime)
	 */
	
	public int countPrimeSetBits(int L, int R) {
		int result = 0;
		for(int i=L; i<=R; i++) {
			if(isPrime(countBits(i)))
				result++;
		}
		return result;
	}
	
	//returns whether number is prime or not
	boolean isPrime(int num) {
		if(num == 1)
			return false;
		
		for(int i = 2; i <= num/2; ++i) {
            // condition for non prime number
            if(num % i == 0)
            	return false;
        }

        return true;
    }
	
	//counts and returns how many bits in the binary version of the number
	int countBits(int num) {
		int bits = 0;
		while(num > 0) {
			if(num % 2 != 0)
				bits++;
			num /=2;
		}
		return bits;
	}
	
	public static void main(String[] args) {
		PrimeNumberSetBitsBinary s = new PrimeNumberSetBitsBinary();
		System.out.println(s.countPrimeSetBits(6,10));
	}

}
