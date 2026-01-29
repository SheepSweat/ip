import java.util.Scanner;
public class Sixty_Seven {
    public static class Task {
        protected String description;
        protected boolean isDone;

        public Task(String description) {
            this.description = description;
            this.isDone = false;
        }
        public String getStatusIcon() {
            return (isDone ? "X" : " "); // mark done task with X
        }
        public String getDescription() {
            return description;
        }
        public void SetIsDone() {
            this.isDone = true;
        }
        public void SetIsUndone() {
            this.isDone = false;
        }
    }

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
        Task[] List = new Task[100];
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
                    String status = List[i].getStatusIcon();
                    System.out.println( (i+1) + ".[" + status + "] " + List[i].getDescription());
                }
                System.out.println("━".repeat(60));
            }
            else if(!EchoedLine.equals("bye")){
                if (EchoedLine.startsWith("mark"))
                {
                    String[] parts = EchoedLine.split(" ");
                    int TaskID = Integer.parseInt(parts[1]);
                    List[TaskID-1].SetIsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("  [" + List[TaskID-1].getStatusIcon() + "] " + List[TaskID-1].getDescription());
                    System.out.println("━".repeat(60));
                } else if (EchoedLine.startsWith("unmark")) {
                    String[] parts = EchoedLine.split(" ");
                    int TaskID = Integer.parseInt(parts[1]);
                    List[TaskID-1].SetIsUndone();
                    System.out.println(" OK, I've marked this task as not done yet:");
                    System.out.println("  [" + List[TaskID-1].getStatusIcon() + "] " + List[TaskID-1].getDescription());
                    System.out.println("━".repeat(60));
                }else {
                    List[NumberofItems] = new Task(EchoedLine);
                    System.out.println("added: " + EchoedLine);
                    System.out.println("━".repeat(60));
                    NumberofItems++;
                }
            }
        } while(!EchoedLine.equals("bye"));
        printEnding();
    }
}