package set1;
import java.util.Map;
import java.util.HashMap;

public class FirstUniqueChar {
	/*
	 * Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.\
	 * e.g. s="leetcode" returns 0
	 * s="loveleetcode" returns 2
	 */
	
	public Map<Character, Integer> characterMap = new HashMap<Character, Integer>();
	
	public int findFirstUniqueCharacter(String s) {
		//stores keys/values in map
		for(int i=0; i<s.length(); i++) {
			Character key = s.charAt(i);
			
			try {
				this.characterMap.put(key, this.characterMap.get(key) + 1);
			}catch(Exception e) {
				this.characterMap.put(key, 1);
			}
		}
		
		for(int i=0; i<s.length(); i++) {
			if(this.characterMap.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}
	
	public void printMap() {
		for(Map.Entry<Character, Integer> entry: this.characterMap.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
	
	public static void main(String[] args) {
		FirstUniqueChar fuq = new FirstUniqueChar();
		
		int solution = fuq.findFirstUniqueCharacter("loveleetcode");
		System.out.println(solution);
	}

}
