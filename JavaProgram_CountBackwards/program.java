/*
Write a program in Python or Java that counts backwards from 100 to 1 and prints: “Agile” if the number is divisible by 5,
“Software” if the number is divisible by 3, “Testing” if the number is divisible by both, or prints just the number if none of those cases are true.
 */

public class CountBackwards {
    public static void main(String[] args) {
        for (int i = 100; i > 0; i--) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("Testing");
            } else if (i % 3 == 0) {
                System.out.println("Software");
            } else if (i % 5 == 0) {
                System.out.println("Agile");
            } else {
                System.out.println(i);
            }
        }
    }
}