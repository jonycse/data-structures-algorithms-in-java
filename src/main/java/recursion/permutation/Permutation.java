package recursion.permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static List<String> permute(String str){
        List<String> results = new ArrayList<>();
        permute(str.toCharArray(), 0, str.length() - 1, results);
        return results;
    }


    private static void permute(char[] str, int lo, int hi, List<String> results){
        if(lo == hi){
            results.add(String.valueOf(str));
        }else{
            for(int i = lo; i <= hi; i++){
                swap(str, lo, i);
                permute(str, lo+1, hi, results);
                swap(str, i, lo);
            }
        }
    }

    private static void swap(char[] str, int i, int j){
        char c = str[i];
        str[i] = str[j];
        str[j] = c;
    }
}
