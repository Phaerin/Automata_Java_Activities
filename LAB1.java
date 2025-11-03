import java.util.*;
public class LAB1 {
    public static boolean isAccepted(String inp) {
        if (inp == null || inp.length() < 2) {
            return false;
        }
        int state = 0;
    
        for (int i = 0; i < inp.length(); i++) {
            char symbol = inp.charAt(i);

            switch (state) {
                case 0: //state q0
                    if (symbol == '0') {
                        state = 1;
                    }
                    break;
                
                case 1: //state q1
                    if (symbol == '1') {
                        state = 2; // q1 -> q2 on '1'
                    } else {
                        state = 1;
                    }
                    break;
                
                case 2: //state final
                    if (symbol == '0'){
                        state = 1;
                    } else {
                        state = 0;
                    }
                    break;
                
            }
        }
        return (state == 2);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        while (true) {
        System.out.print("Input: ");
        String inp = s.nextLine().trim();
        

        boolean accepted = isAccepted(inp);

        if (accepted) {
            System.out.println("Output: Accepted");
        } else {
            System.out.println("Output: Rejected");
        }
    }
    }
}

  

