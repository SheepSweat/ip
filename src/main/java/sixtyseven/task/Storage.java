package sixtyseven.task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import sixtyseven.Parser;

/**
 *  Represents the mechanism to store or retrieve inputs from txt file
 */
public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Saves status of ArrayList into txt file.
     * @param path txt file path
     * @param taskList Arraylist
     * @param numberOfTasks size of ArrayList
     * @throws IOException if unable to find file
     */
    public void saveToFile(String path, ArrayList<Task> taskList, int numberOfTasks) throws IOException {
        FileWriter fw = new FileWriter(path);
        for (int i = 0; i < numberOfTasks; i++) {

            fw.write(taskList.get(i).toSaveString() + System.lineSeparator());
        }
        fw.close();
    }

    /**
     * Reads txt file and copies content into Arraylist
     * @return ArrayList
     * @throws Exception if unable to scan,find file or parse error.
     */

    public ArrayList<Task> readFileContents() throws Exception {
        ArrayList<Task> taskList = new ArrayList<>();
        File f = new File(filePath);

        if (!f.exists()) {
            return taskList;
        }

        Scanner s = new Scanner(f);
        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] parts = line.split("\\|", 2);

            String status = parts[0].trim();
            String command = parts[1].trim();
                Task newTask = Parser.parse(command);
                newTask.setCommand(command);
                taskList.add(newTask);
                if (status.equals("1")) {
                    newTask.setIsDone();
                }
                saveToFile(filePath, taskList, taskList.size());
            }
        s.close();
        return taskList;
    }
}


