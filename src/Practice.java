class Practice{
    public boolean isAsc(String[] words){
        for(int i=0; i<words.length-1; i++){
            String current = words[i];
            String nextWord = words[i+1];
            int first = 0;
            int second = 0;
            if(current.charAt(first) > nextWord.charAt(second))
                return false;
            else if(current.charAt(first) == nextWord.charAt(second)){
                while(first < current.length() || second < current.length()){
                    first++;
                    second++;
                    if(first >= current.length() || second < nextWord.length())
                        break;
                    if(first >= current.length() && second >= nextWord.length())
                        return false;
                    if(current.charAt(first) > nextWord.charAt(second))
                        return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args){
        Practice p = new Practice();
        String[] words = new String[]{"abcdssd", "b", "abcasd"}; // true
        // String[] words2 = new String[]{"abc", "abc", "c"}; // false

        boolean test1 = p.isAsc(words);
        // boolean test2 = p.isAsc(words2);

        System.out.println(test1);
        // System.out.println(test2);
    }
}