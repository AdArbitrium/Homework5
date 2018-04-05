package edu.gcccd.csis.p1;

import java.util.ArrayList;

public class SequenceSearchImpl extends SequenceSearch {

    public SequenceSearchImpl(final String content, final String start, final String end) {
        super(content, start, end);
    }

    @Override
    public String[] getAllTaggedSequences() {
        ArrayList<Number> listOfStarts = new ArrayList<Number>();
        ArrayList<Number> listOfEnds= new ArrayList<Number>();
        String copyOfContent = content;
        String[] taggedSequences = null;
        int startIndex = 0;

        while (startIndex != -1){
            startIndex = -startTag.length();
            int endIndex = 0;
            startIndex = copyOfContent.indexOf(startTag, startIndex + startTag.length());
            if (startTag == endTag){
                endIndex = copyOfContent.indexOf(startTag,startIndex + startTag.length());
            }else{
                endIndex = copyOfContent.indexOf(endTag, endIndex + endTag.length());
            }
            if (endIndex < startIndex) {
                endIndex = copyOfContent.indexOf(endTag, endIndex + endTag.length());
            }
            String temp = "";
          if (endIndex == -1 ){
              break;
          }
            temp = copyOfContent.substring(startIndex + startTag.length(),endIndex);
          if (startIndex != endIndex){
              int firstInstanceOfStart = content.indexOf(startTag,0);
              int secondInstanceOfStart = content.indexOf(startTag,firstInstanceOfStart+startTag.length());
              int firstInstanceOfEnd = content.indexOf(endTag,0);
              int differenceOfStartTags = firstInstanceOfStart - secondInstanceOfStart;
              int differenceOfStartToEnd = firstInstanceOfStart - firstInstanceOfEnd;

              if ( differenceOfStartTags >= differenceOfStartToEnd){
                  while (startIndex < endIndex && copyOfContent.indexOf(startTag, startIndex + startTag.length()) < endIndex){
                      startIndex = copyOfContent.indexOf(startTag, startIndex + startTag.length());
                      temp = copyOfContent.substring(startIndex + startTag.length(),endIndex);
                  }
              }
          }

          taggedSequences = SequenceSearch.adds(taggedSequences, temp);
          copyOfContent = copyOfContent.substring(endIndex+ endTag.length(), copyOfContent.length());
        }
        if (taggedSequences == null)
            taggedSequences = new String[0];
        return taggedSequences;
    }

    @Override
    public String getLongestTaggedSequence() {
        String [] temp = getAllTaggedSequences().clone();
        String longest = null;
        if (temp.length > 0) {
            longest = temp[0];
            for (int i = 1; i < temp.length; i++) {
                if (temp[i].length() >= longest.length()) {
                    longest = temp[i];
                }
            }
        }
        return longest;
    }

    @Override
    public String displayStringArray() {
        String [] temp = getAllTaggedSequences();
        String display = "";
        for (String s:temp){
            display = display + s + " : " + s.length() + "\n";
        }
      return display;
    }

    @Override
    public String toString() {
        int beginIndex = 0;
        int endIndex = 0;
        String temp = content;
        beginIndex = temp.indexOf(startTag, beginIndex);
        endIndex = temp.indexOf(endTag, endIndex);
        while (beginIndex != -1 && endIndex !=-1) {
            temp =  temp.substring(0, beginIndex)
                    + temp.substring(beginIndex + startTag.length(), endIndex)
                    + temp.substring(endIndex + endTag.length(), temp.length());
            beginIndex = temp.indexOf(startTag, beginIndex);
            endIndex = temp.indexOf(endTag, endIndex);
        }
        return temp;
    }
}