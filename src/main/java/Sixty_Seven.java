import java.util.ArrayList;

import sixtyseven.Exceptions.Sixty_SevenException;
import sixtyseven.Ui;
import sixtyseven.task.CommandHandler;
import sixtyseven.task.Storage;
import sixtyseven.task.Task;

/**
 * Main class for the Sixty_Seven task management application.
 * Coordinates the interaction between storage, logic, and user interface.
 */
public class Sixty_Seven {
    private Storage File;
    private ArrayList<Task> taskList;
    private Ui userInterface;
    private String filename = "./data/task.txt";
    /**
     * Initializes a new instance of the Sixty_Seven application.
     * Sets up the UI, loads the storage file, and populates the task list from disk.
     * @throws RuntimeException if the file loading process fails unexpectedly.
     */
    public Sixty_Seven() {
        userInterface = new Ui();

        try{
            File = new Storage(filename);
            taskList = File.readFileContents();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Starts the main application loop.
     * Continuously reads user input, processes commands via the CommandHandler,
     * and displays output until the "bye" command is received.
     * @throws Exception if an error occurs during command processing.
     */

    public void loop()throws Exception {
        userInterface.showWelcome();
            while (true) {
                String fullCommand = userInterface.readCommand();
                userInterface.showLine();
                if (fullCommand.toLowerCase().equals("bye")) {
                    return;
                }
                try{
                    CommandHandler.handleCommand
                            (fullCommand,File,userInterface,taskList,filename);
                    userInterface.showLine();
                }catch(Sixty_SevenException e){
                    userInterface.showError(e.getMessage());
                    userInterface.showLine();
                }catch (NumberFormatException e) {
                    // Handles "mark a", "delete b", etc.
                    userInterface.showError("Error: Please enter a valid number!");
                    userInterface.showLine();
                }
        }
    }
    /**
     * The entry point of the application.
     * @param args Command line arguments (not used).
     * @throws Exception if the application loop encounters a fatal error.
     */
    public static void main(String[] args) throws Exception {
        new Sixty_Seven().loop();
    }
}