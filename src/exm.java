
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Scanner;

public class exm {

    public static void main(String args[]){
       int[] input = {4,2,3,5,2, 7,9,1};
        Map<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
        int min = input[0];
        int max = input[0];
        int diff=0;
        for(int i : input){
            min = min<i?min:i;
            if(max<i) {
                max=i;
                 diff = i-min;
            }
            else {
                 diff = -1;
            }
            map.put(i,diff);
            max=i;

        }
         diff=0;
    for(int i:map.keySet())
    diff = diff>map.get(i)?diff:map.get(i);
    System.out.print(diff);
    }
}
