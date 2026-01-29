package practic;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class taskPractic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Task myTasks = new Task();
        while (true) {
            System.out.println("Список задач на сегодня:");
            myTasks.println();
            System.out.println("Хотите что-то добавить в список дел?(да/нет):");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("да")) {
                System.out.println("Круто! Какую задачу желаете добавить?");
                String newTask = scanner.next();
                myTasks.addTask(newTask);
            }
            if (choice.equalsIgnoreCase("нет")) {
                System.out.println("Тогда чиллБро!");
                break;
            }
        }

    }

    static class Task {
        ArrayList<String> tasks = new ArrayList<>();

        Task() {
            tasks.add("Clean");
            tasks.add("PushUps");
            tasks.add("VibeCoding");
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
    }
}




