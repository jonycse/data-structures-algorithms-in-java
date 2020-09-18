package recursion.pascaltriangle;

import utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public  static List<Integer> getRows(int index) {
        List<Integer> result = new ArrayList<>();
        if (index == 0) {
            result.add(1);
            return result;
        }

        List<Integer> prev = getRows(index - 1);

        result.add(1);
        for (int i = 1; i < index; i++) {
            result.add(prev.get(i) + prev.get(i - 1));
        }
        result.add(1);

        return result;
    }
}
