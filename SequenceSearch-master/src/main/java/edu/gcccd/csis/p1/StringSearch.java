package edu.gcccd.csis.p1;

public class StringSearch {

    final String s = "The quick brown fox jumps over the lazy dog";
    final String tag= "he";

    boolean isPartOf(final String s, final String t){
        return 0 <= s.indexOf(t);
    }
    int howManyTimes(final String s, final String t){
        int counter = 0;
        int fromIndex = -tag.length();
        do{
            fromIndex = s.indexOf(tag, fromIndex + tag.length());
            if (fromIndex != -1){
                counter++;
            }
//            String taggedString = s.substring(x,y);
        }while(0 <= fromIndex);
        return counter;
    }

    public static void main(String[] args) {
        StringSearch s = new StringSearch();
        System.out.print(s.howManyTimes("The quick brown fox jumps over the lazy dog he he her rhehrrr", "r"));
    }

}
