import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Введите логин");
        String login =  sc1.nextLine();

        Scanner sc2= new Scanner(System.in);
        System.out.println("Введите пароль");
        String password =  sc2.nextLine();

        Scanner sc3= new Scanner(System.in);
        System.out.println("Подтвердите пароль");
        String confirmPassword =  sc3.nextLine();


        LogPass(login, password, confirmPassword);

    }

    public static void LogPass(String log, String pass, String confirmPass) {
        String login = "Dimon123";
        String password = "Password123";
        if (!log.equals(login) || !pass.equals(password) || !confirmPass.equals(password)) {
            try {
                throw new RuntimeException("Неверно указаны логин или пароль");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Данные введены корректно");
        }
    }

}

