package edu.gcccd.csis.p1;

public class SequenceSearchImpl extends SequenceSearch {

    public SequenceSearchImpl(final String content, final String start, final String end) {
        super(content, start, end);
    }

    @Override
    public String[] getAllTaggedSequences() {
        int startTagPosition = startTag.length();
        int endTagPosition = 0;

        String [] tagged = new String [numberOfTaggedSqueuences()];
        for (int i = 0; i < tagged.length; i++){
            startTagPosition =+ content.indexOf(startTag);
            if (startTagPosition == endTagPosition){
                startTagPosition =+ content.indexOf(startTag);
            }
            if (endTagPosition == startTagPosition){
                endTagPosition =+ content.indexOf(endTag);
            }
            endTagPosition =+ content.indexOf(endTag);

            tagged[i] = content.substring(startTagPosition, endTagPosition);
        }
      return tagged;
    }

    public int numberOfTaggedSqueuences(){
        int counter = 0;
        int i = -startTag.length();
        do{
            if (-1 < (i = content.indexOf(startTag, i + startTag.length()))){
                counter++;
            }
        }while(-1 != i);
        return counter;
    }

    @Override
    public String getLongestTaggedSequence() {
        String longest = "";
        String [] temp = getAllTaggedSequences().clone();
        for (int i = 0; i < temp.length-2 ; i++){
            if(temp[i].length() > temp[i + 1].length()){
                temp[i] = longest;
            }
        }
        return longest;
    }

    @Override
    public String displayStringArray() {
       return null;
    }

    @Override
    public String toString() {
        return null;
    }

}