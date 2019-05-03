import java.io.*;
import java.util.*;

public class BobTheBear {

    public static void main(String args[]) throws Exception {
        int n;
        ArrayList<Integer> len = new ArrayList<Integer>();
        ArrayList<Integer> start = new ArrayList<Integer>();
        // Code for Input
         Scanner s = new Scanner(System.in);
         n = s.nextInt();
        for (int i = 0; i < n; i++)
         len.add(s.nextInt());
         for (int i = 0; i < n; i++)
          start.add(s.nextInt());
        String st = s.nextLine();
        while(s.findInLine("(?=\\S)") != null){
            if(s.hasNextLine()) {
                s.nextLine();
            }else
                break;
        }
        System.out.println(Salmon(n, len, start));

    }

    public static int Salmon(int n, ArrayList<Integer> len, ArrayList<Integer> start) {
        ArrayList<Integer> end = new ArrayList<Integer>();
        int i, j, salmonsCount = 0, first = 0, second = 0;
        ArrayList<ArrayList<Integer>> salmonsAtT = new ArrayList<ArrayList<Integer>>();
        HashSet<Integer> salmonsCaught = new HashSet<Integer>();
        for (i = 0; i < n; i ++)
            end.add(start.get(i) + len.get(i));
       // endTime = Collections.max(start);
        for (i = 0; i < n; i ++){
            int startTime = start.get(i);
            int endTime = end.get(i);
            ArrayList<Integer> salmonsAtStart = new ArrayList<Integer>();
            ArrayList<Integer> salmonsAtEnd = new ArrayList<Integer>();
            for (j = 0; j < n; j++){
                if(start.get(j) <= startTime && startTime <= end.get(j))
                    salmonsAtStart.add(j);
                if(start.get(j) <= endTime && endTime <= end.get(j))
                    salmonsAtEnd.add(j);
            }
            if (!(salmonsAtStart.isEmpty() || salmonsAtT.contains(salmonsAtStart)))
                salmonsAtT.add(salmonsAtStart);
            if (!(salmonsAtEnd.isEmpty() || salmonsAtT.contains(salmonsAtEnd)))
                salmonsAtT.add(salmonsAtStart);
        }

        if(salmonsAtT.size() > 1){
            for(i = 0; i < salmonsAtT.size()-1 && salmonsCount < n; i++){
                for(j = i + 1; j < salmonsAtT.size(); j++){
                    ArrayList<Integer> temp =  new ArrayList<Integer>(salmonsAtT.get(i));
                    temp.addAll(salmonsAtT.get(j));
                    HashSet<Integer> totalSalmons = new HashSet<Integer>(temp);
                    if(salmonsCount < totalSalmons.size()){
                        salmonsCount = totalSalmons.size();
                        salmonsCaught = new HashSet<Integer>(totalSalmons);
                        first = i;
                        second = j;
                    }
                }
            }
        } else {
            salmonsCaught = new HashSet<Integer>(salmonsAtT.get(0));
            salmonsCount = salmonsCaught.size();
        }
        return salmonsCount;
    }
}