package Lab11;
import java.util.ArrayList;

public class Main {
    final static int inf = Integer.MAX_VALUE;
    public static void main(String[] args) {
        q2();
    }
    static void q2() {
                            // A    B   C   D   E
        int[][] thisGraph = {
                            { inf, 3, inf, inf, 2 }, // your 1.1
                            { inf, inf, 1, inf, inf },
                            { inf, inf, inf, 4, inf },
                            { inf, inf, inf, inf, 5 },
                            { inf, inf, inf, inf, inf }
                        };
        System.out.println("computing dfs");
        q2_dfs(thisGraph);
    }
    private static void q2_dfs(int[][] thisGraph) {
        ArrayList<Integer> stack = new ArrayList<>();
        ArrayList<Integer> visited = new ArrayList<>();
        stack.add(0); // root is at A, we'll suffix next city
        while (notEmpty(stack)) {
            int parent = stack.remove(stack.size() - 1);
            visited.add(parent);
            for (int x = 0; x < thisGraph.length; x++) {
                if (0 < thisGraph[parent][x] && thisGraph[parent][x] < inf && !visited.contains(x)) {  
                    stack.add(x);
                    System.out.println("from " + parent + " to " + x);
                }
            } //for
        }
    }
    private static boolean notEmpty(ArrayList<Integer> stack) {
        return !stack.isEmpty();
    }
}
