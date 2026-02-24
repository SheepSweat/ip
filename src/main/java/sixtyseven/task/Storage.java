package sixtyseven.task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import sixtyseven.Exceptions.Sixty_SevenException;
import sixtyseven.Parser;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public void saveToFile(String path, ArrayList<Task> taskList, int numberOfTasks) throws IOException {
        FileWriter fw = new FileWriter(path);
        for (int i = 0; i < numberOfTasks; i++) {

            fw.write(taskList.get(i).toSaveString() + System.lineSeparator());
        }
        fw.close();
    }


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


