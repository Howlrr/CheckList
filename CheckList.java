package practic;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class taskPractic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Task myTasks = new Task();
        fileManager fm = new fileManager();
        myTasks.tasks = fm.loadTasks();


        while (true) {
            System.out.println("Список задач на сегодня:");
            myTasks.println();
            System.out.println("Что делаем?(добавляем/удаляем/выход):");
            String choice = scanner.nextLine().toLowerCase();
            if (choice.equalsIgnoreCase("добавляем")) {
                System.out.println("Круто! Какую задачу желаете добавить?");
                String newTask = scanner.nextLine();
                myTasks.addTask(newTask);
                fm.saveTasks(myTasks.tasks);
            }
            else if (choice.equalsIgnoreCase("удаляем")) {
                if (myTasks.tasks.size() == 0) {
                    System.out.println("Список и так пуст");
                    continue;
                }
                System.out.println("Какую задачу сносим?");
                
                try {
                    int num = Integer.parseInt(scanner.nextLine());
                    myTasks.removeTask(num - 1);
                    fm.saveTasks(myTasks.tasks); 
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: нужно ввести именно число!");
                }
            } else if (choice.equals("выход")) {
                System.out.println("Данные сохранены. Чиллбро!");
                break;
            }
            else {
                System.out.println("Я тебя не понял, попробуй еще раз.");
            }
        }


        }

    static class Task {
        ArrayList<String> tasks = new ArrayList<>();

        Task() {

        }
        void println(){
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
        void addTask(String taskName) {
            tasks.add(taskName);
            System.out.println("Задача добавлена!!!");
        }
        void removeTask(int index) {
            if (index >= 0 && index < tasks.size()) {
                tasks.remove(index);
                System.out.println("Задача удалена.");
            } else {
                System.out.println("Нет задачи с таким номером!");
            }
        }

    }

    public static class fileManager {
        private String fileName = "sohra.txt";

        public void saveTasks(ArrayList<String> tasksStrings) {
            try (BufferedWriter writer= new BufferedWriter(new FileWriter(fileName))){
                for (String task : tasksStrings) {
                    writer.write(task);
                    writer.newLine();
                }
                System.out.println("--- Прогресс сохранен в Айнкрад (tasks.txt) ---");
            }
            catch (IOException e) {
                System.out.println("Ошибка при сохранении" + e.getMessage());


            }

        }
        public ArrayList<String> loadTasks() {
            ArrayList<String> loadedTasks = new ArrayList<>();
            File file = new File(fileName);

            if (!file.exists()) {
                return loadedTasks;
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    loadedTasks.add(line);
                }
                System.out.println("--- Данные успешно загружены из Айнкрада! ---");
            } catch (IOException e) {
                System.out.println("Ошибка при загрузке: " + e.getMessage());
            }
            return loadedTasks;
        }
    }
}







