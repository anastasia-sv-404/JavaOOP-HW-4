import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        TaskManager tm = new TaskManager();


        System.out.println(tm.isEmpty()); // Проверка списка задач на пустоту.
        System.out.println();

        PersonalTask task = new PersonalTask("Сделать ДЗ", 1, "03.04.2023");
        WorkTask task2 = new WorkTask("Сделать работу", 1, "27.03.2023", "начальник");
        PersonalTask task3 = new PersonalTask("Убрать", 2, "03.04.2023");
        WorkTask task4 = new WorkTask("Сделать работу2", 4, "28.03.2023", "другой начальник");
        tm.addTask(task); // Добавить задачу
        tm.addTask(task2);
        tm.addTask(task3);
        tm.addTask(task4);

        task.completeTask();// Выполнить задачу

        ExportTasks et = new ExportTasks(tm.getCommonList()); // Вывести список задач в cvs файл.
        System.out.println();

        tm.print(); // Вывести на экран список задач.
        System.out.println();

        Collections.sort(tm.getCommonList());
        tm.print();// Естественная сортировка по приоритету. Если приоритеты
        // одинаковые, то дополнительно по дедлайну.
        System.out.println();

        tm.removeTask(task); // Удалить задачу.
        tm.print();
        System.out.println();

        tm.searchTaskById(2).print(); // Найти задачу по id.
        System.out.println();

        LinkedList<Task> list = tm.searchTaskByDescription("работ"); // Поиск задач по части наименования
        printList(list);
        System.out.println();

        LinkedList<Task> list2 = tm.getListOfTasks(TypesOfTasks.PersonalTask, State.actual); // Поиск задач по типу и статусу
        printList(list2);
    }

    static void printList(LinkedList<Task> list){
        for(Task task : list){
            task.print();
        }
    }

}