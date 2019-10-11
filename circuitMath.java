import java.util.*;


public class circuitMath {

    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);

        int numVariables = s1.nextInt();

        boolean[] states = new boolean[numVariables];

        // Reading inputs and the variables
        for (int i = 0; i < numVariables; i++) {
            String s = s1.next();
            if (s.equals("T")) {
                states[i] = true; // if input is T, the the ith variable is true
            } else {
                states[i] = false; // // if input is F, the the ith variable is false
            }
        }

        // A list of all the circuit elements: the alphabets and the signs
        ArrayList<Character> leafs = new ArrayList<>();
        while (s1.hasNext()) {
            String leaf = s1.next();
            leafs.add(leaf.charAt(0));
        }

        // Reversing the arraylist so we read from right to left
        Collections.reverse(leafs);
        Node tree = getTree(leafs);

        boolean result = tree.getValue(states);
        if (result)
        {
            System.out.println("T");
        }
        else
        {
            System.out.println("F");
        }
    }

    static Node getTree(ArrayList<Character> leafs)
    {
        char leaf = leafs.get(0);
        leafs.remove(0);
        Node left;
        Node right;
        switch (leaf)
        {
            case '+':
            case '*':
                // These calls are mutating
                left = getTree(leafs);
                right = getTree(leafs);
                return new Node(leaf, left, right);
            case '-':
                left = getTree(leafs);
                return new Node(leaf, left, null);
            default:
                return new Node(leaf, null, null);
        }
    }

}

class Node
{
    char leaf;
    Node left;
    Node right;

    Node(char leaf, Node left, Node right)
    {
        this.leaf = leaf;
        this.left = left;
        this.right = right;
    }

    boolean getValue(boolean[] states)
    {
        switch (leaf)
        {
            case '+':
                return left.getValue(states) || right.getValue(states);

            case '*':
                return left.getValue(states) && right.getValue(states);

            case '-':
                return !left.getValue(states);

            default:
                // It's a letter
                boolean truth_value = states[leaf - 'A'];
                return truth_value;
        }
    }
}
