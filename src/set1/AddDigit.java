package set1;

public class AddDigit {
	/**
	 * Given a non-negative integer sum, repeatedly add all its digits until the result has only one digit
	 * e.g. 38 -> 3+8 = 11 -> 1+1 = 2
	 * return 2 since it has on digit
	 */
	public int addDigits(int num) {
		int total = getSum(num);
		while(total / 10 > 0)
			total = getSum(total);
		
		return total;
	}
	public int getSum(int n) {
		int sum = 0;
		while(n!=0) {
			sum+= n%10;
			n=n/10;
		}
		return sum;
	}
	public static void main(String[] args) {
		AddDigit a = new AddDigit();
		System.out.println(a.addDigits(19));
	}
}
