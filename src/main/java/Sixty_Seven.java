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
        String[] List = new String[100];
        int NumberofItems = 0;
        Scanner input = new Scanner(System.in);
        do {
            EchoedLine = input.nextLine();
            System.out.println("━".repeat(60));
            if(EchoedLine.equals("list"))
            {
                for (int i=0;i<NumberofItems;i++)
                {
                    //System.out.println("━".repeat(60));
                    System.out.println( (i+1) + ". "+ List[i]);
                }
                System.out.println("━".repeat(60));
            }
            else if(!EchoedLine.equals("bye")){
                List[NumberofItems] = EchoedLine;
                System.out.println("added: " + EchoedLine);
                System.out.println("━".repeat(60));
                NumberofItems++;
            }
        } while(!EchoedLine.equals("bye"));
        printEnding();
    }
}