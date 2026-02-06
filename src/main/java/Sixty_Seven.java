import java.util.Scanner;
public class Sixty_Seven {

    public static void printEnding(){
        //printLine();
        System.out.println(" Bye. Hope to see you again soon!\n");
        printLine();
    }
    
    public static void printLine(){
        System.out.println("━".repeat(60));
    }

    private static void loop(Scanner input)throws Exception{
        Task[] List = new Task[100];
        int NumberofItems = 0;
        int TaskID;
        while(true){
            String EchoedLine = input.nextLine();
            printLine();
            String[] parts = EchoedLine.split(" ", 2);
            String command = parts[0];


            switch (command){
            case"list":
                System.out.println("Here are the tasks in your list:");
                for (int i=0;i<NumberofItems;i++){
                    System.out.println(Integer.toString(i+1)+"."+List[i].toString());
                }
                break;
            case"add":
                List[NumberofItems] = new Task(EchoedLine);
                System.out.println("added: " + EchoedLine);
                NumberofItems++;
                break;
            case"mark":
                if (parts.length < 2) {
                    System.out.println("Please specify a task number to mark!");
                    break;
                }
                TaskID = Integer.parseInt(parts[1]);
                List[TaskID-1].setIsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  " + List[TaskID-1].getStatusIcon() + " " + List[TaskID-1].getDescription());
                break;
            case"unmark":
                if (parts.length < 2) {
                    System.out.println("Please specify a task number to unmark!");
                    break;
                }
                TaskID = Integer.parseInt(parts[1]);
                List[TaskID-1].setIsUndone();
                System.out.println(" OK, I've marked this task as not done yet:");
                System.out.println("  " + List[TaskID-1].getStatusIcon() + " " + List[TaskID-1].getDescription());
                break;

            case "bye":
                printEnding();
                return;
            case"deadline":
            case"event":
            case "todo":
                List[NumberofItems] = Parser.parse(EchoedLine);
                NumberofItems++;
                System.out.println("Got it. I've added this task:");
                System.out.println(List[NumberofItems-1].toString());
                System.out.printf("Now you have %d tasks in the list.%n", NumberofItems);
                break;

            default:
                System.out.println("I'm sorry, I don't know what '" + command + "' means.");
                break;
            }
            printLine();
            }
        }

    private static void startSeq() {
        printLine();
        System.out.println("Hello! I'm Sixty_Seven");
        System.out.println("What can I do for you?");
        printLine();
    }

    public static void main(String[] args) throws Exception {
        startSeq();
        Scanner input = new Scanner(System.in);
        loop(input);
    }
}