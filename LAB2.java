import java.util.*;
public class LAB2 { 
    private static final Map<Integer, Map<Character, Set<Integer>>> transitions = new HashMap<>();
    
    static {
        Map<Character, Set<Integer>> q0 = new HashMap<>();
        
        q0.put('a', new HashSet<>(Arrays.asList(0, 1)));
        
        q0.put('b', new HashSet<>(Arrays.asList(0)));
        transitions.put(0, q0);

        Map<Character, Set<Integer>> q1 = new HashMap<>();
        
        q1.put('a', new HashSet<>(Arrays.asList(1)));
        
        q1.put('b', new HashSet<>(Arrays.asList(2)));
        transitions.put(1, q1);

        Map<Character, Set<Integer>> q2 = new HashMap<>();
        
        q2.put('a', new HashSet<>(Arrays.asList(2)));
        q2.put('b', new HashSet<>(Arrays.asList(2)));
        transitions.put(2, q2);
    }

    public static boolean isAccepted(String input) {
        Set<Integer> currentStates = new HashSet<>(Arrays.asList(0));
        final int ACCEPTING_STATE = 2;

        for (char symbol : input.toCharArray()) {
            
            Set<Integer> nextState = new HashSet<>();

            for (int state : currentStates) {
                Map<Character, Set<Integer>> transition = transitions.get(state);

                if (transition != null && transition.containsKey(symbol)) {
                    nextState.addAll(transition.get(symbol));
                }
                
            }
            currentStates = nextState;
            
            if (currentStates.isEmpty()) {
                return false; 
            }
        }

        return currentStates.contains(ACCEPTING_STATE);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("\nEnter string: ");
            String inp = scanner.nextLine().trim();

            boolean accepted = isAccepted(inp);

            if (accepted) {
                System.out.println("Output: Accepted");
            } else {
                System.out.println("Output: Rejected");
            }
        }

    }
}
