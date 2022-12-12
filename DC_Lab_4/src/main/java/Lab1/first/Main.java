package Lab1.first;

public class Main {
    public static void main(String[] args) {
        Task task = new Task();
        new Thread(task::phoneBySurname, "Surname finder 1").start();
        new Thread(task::phoneBySurname, "Surname finder 2").start();
        new Thread(task::fullNameByPhone, "Full name finder 1").start();
        new Thread(task::fullNameByPhone, "Full name finder 1").start();
        new Thread(task::edit, "Editor 1").start();
        new Thread(task::edit, "Editor 2").start();
    }
}
