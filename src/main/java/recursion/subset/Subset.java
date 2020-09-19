package recursion.subset;

import java.util.*;

public class Subset {

    private Stack<Integer> stack;
    private List<Set<Integer>> subSets;
    private int n;

    public Subset(int n) {
        this.n = n;

        stack = new Stack<>();
        subSets = new ArrayList<>();

        generate(0);
    }


    private void generate(int index) {
        saveSet();
        for (int i = index; i < n; i++) {
            stack.push(i);
            generate(i + 1);
            stack.pop();
        }
    }

    private void saveSet() {
        Set<Integer> set = new HashSet<>();

        Iterator<Integer> it = stack.iterator();
        while (it.hasNext()) {
            set.add(it.next());
        }

        subSets.add(set);
    }

    public List<Set<Integer>> getSubSets() {
        return subSets;
    }
}
