package hackerranck.ns.contest.w5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by ahernandez on 3/16/17.
 */
public class RepeatString2 {

    public static int max = 0;

    private static List<List<Integer>> listDoubleSequences(String in)
    {
        List<List<Integer>> result = new ArrayList<>();
        Map<Character, List<Integer>> posMap = new HashMap<>();

        for(int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);
            if(posMap.get(c) == null) {
                posMap.put(c, new ArrayList<>());
            }
            posMap.get(c).add(i);
        }

        for(List<Integer> values : posMap.values()) {
            for(int i=0; i<values.size(); i++) {
                for(int j=i+1; j<values.size(); j++) {
                    List<Integer> seq = new ArrayList<>();
                    seq.add(values.get(i));
                    seq.add(values.get(j));
                    result.add(seq);
                }
            }
        }
        return result;
    }

    private static List<Integer> merge(List<Integer> a , List<Integer> b)
    {
        if(a.contains(b.get(0)) || a.contains(b.get(1)))
            return null;

        List<Integer> result = new ArrayList<>(a);

        result.addAll(b);
        Collections.sort(result);

        if(result.indexOf(b.get(1)) - result.indexOf(b.get(0)) == result.size() / 2)
            return result;
        else
            return null;
    }

    public static void sqrSubseqCount(String in) {
        List<List<Integer>> len_2_seq = listDoubleSequences(in);
        List<List<Integer>> prev_round = new ArrayList<>(len_2_seq);
        final Set<List<Integer>> next_round = new HashSet<>();

        while(!prev_round.isEmpty()) {
            next_round.clear();
            prev_round.forEach(l -> len_2_seq.forEach(l2 -> {
                List<Integer> merge = merge(l , l2);

                if(merge != null && !next_round.contains(merge))
                {
                    next_round.add(merge);
                    lengthMax(in , merge);
                }
            }));
            prev_round.clear();
            prev_round.addAll(next_round);
        }
        System.out.println(max);
    }

    private static void lengthMax(String in , List<Integer> seq)
    {
        String seqStr = "";
        for(int i : seq) {
            seqStr += in.charAt(i);
        }

        if(seqStr.length() > max) {
            max = seqStr.length();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String data = scan.nextLine();
        sqrSubseqCount(data);
    }

}
