import java.util.Scanner;
public class Sixty_Seven {
    public static void printEnding(){
        //System.out.println("━".repeat(60));
        System.out.println(" Bye. Hope to see you again soon!\n");
        System.out.println("━".repeat(60));
    }

    public static void main(String[] args) {
        System.out.println("━".repeat(60));
        System.out.println("Hello! I'm Sixty_Seven");
        System.out.println("What can I do for you?");
        System.out.println("━".repeat(60));
        String EchoedLine;
        Scanner input = new Scanner(System.in);
        do {
            EchoedLine = input.nextLine();
            System.out.println("━".repeat(60));
            System.out.println(EchoedLine);
            System.out.println("━".repeat(60));
        }while(!EchoedLine.equals("bye"));
        printEnding();
    }
}
