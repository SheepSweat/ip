import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import sixtyseven.Exceptions.EmptyDescriptionException;
import sixtyseven.Exceptions.EmptyTaskNumberException;
import sixtyseven.Exceptions.InvalidCommandException;
import sixtyseven.Exceptions.InvalidTaskNumberException;
import sixtyseven.Exceptions.Sixty_SevenException;
import sixtyseven.Ui;
import sixtyseven.task.CommandHandler;
import sixtyseven.task.Storage;
import sixtyseven.task.Task;
import sixtyseven.Parser;

public class Sixty_Seven {
    private Storage File;
    private ArrayList<Task> taskList;
    private Ui userInterface;
    private String filename = "C:\\nus\\NUS MODs\\CS2113\\task.txt";

    public Sixty_Seven() {
        userInterface = new Ui();

        try{
            File = new Storage(filename);
            taskList = File.readFileContents();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    // to change 
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
                }
        }
    }

    public static void main(String[] args) throws Exception {
        new Sixty_Seven().loop();
    }
}