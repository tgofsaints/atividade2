import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private String name;
    private boolean completed;

    public Task(String name) {
        this.name = name;
        this.completed = false;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void complete() {
        completed = true;
    }

    @Override
    public String toString() {
        return "[" + (completed ? "X" : " ") + "] " + name;
    }
}

class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(String taskName) {
        Task task = new Task(taskName);
        tasks.add(task);
    }

    public void completeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).complete();
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }
}

public class TaskManagerApp {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Marcar tarefa como completa");
            System.out.println("3. Listar tarefas");
            System.out.println("0. Sair");
            

            int choice = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (choice) {
                case 1:
                    System.out.println("Digite o nome da tarefa:");
                    String taskName = scanner.nextLine();
                    taskManager.addTask(taskName);
                    break;
                case 2:
                    System.out.println("Digite o índice da tarefa para marcar como completa:");
                    int completeIndex = scanner.nextInt();
                    taskManager.completeTask(completeIndex - 1);
                    break;
                case 3:
                    List<Task> allTasks = taskManager.getTasks();
                    System.out.println("Lista de tarefas:");
                    for (int i = 0; i < allTasks.size(); i++) {
                        Task task = allTasks.get(i);
                        System.out.println(i + 1 + ". " + task);
                    }
                    break;
                case 6:
                    System.out.println("Saindo do aplicativo.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }
}
