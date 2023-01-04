import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    public static boolean check(String text) {
        boolean result = false;
        if (text.matches("[a-zA-z0-9]*") && text.length() <= 20) {
            result = true;
        }
        return result;
    }

    public static void LogPass(String log, String pass, String confirmPass) {
        boolean checkLog;
        boolean checkPass;
        checkLog = check(log);
        checkPass = check(pass);
        if (checkLog && checkPass) {
            if (confirmPass.equals(pass)) {
                System.out.println("Данные введены корректно");
            } else {
                try {
                    throw new RuntimeException("Некорректное подтверждение пароля");
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }
        } else {
            try {
                throw new RuntimeException("Некорректный ввод данных логина или пароля");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите логин");
        String login = sc.nextLine();
        System.out.println("Введите пароль");
        String password = sc.nextLine();
        System.out.println("Подтвердите пароль");
        String confirmPassword = sc.nextLine();


        LogPass(login, password, confirmPassword);


    }

}

