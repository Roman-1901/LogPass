import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    public static boolean check (String text) {
        String WORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{4,20}$";
        Pattern pl = Pattern.compile(WORD_REGEX);
        Matcher m = pl.matcher(text);
        return m.matches();
    }

    public static void LogPass(String log, String pass, String confirmPass) {
        String login = "Dimon123";
        String password = "Password123";
        if (confirmPass.equals(pass)) {
            if (!log.equals(login) || !pass.equals(password)) {
                try {
                    throw new RuntimeException("Учетные данные отсутсвуют в системе");
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Данные введены корректно");
            }
        } else {
            try {
                throw new RuntimeException("Некорректное подтверждение пароля");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static void main(String[] args) {
        boolean checkLog;
        boolean checkPass;
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Введите логин");
        String login =  sc1.nextLine();
        Scanner sc2= new Scanner(System.in);
        System.out.println("Введите пароль");
        String password =  sc2.nextLine();
        Scanner sc3= new Scanner(System.in);
        System.out.println("Подтвердите пароль");
        String confirmPassword =  sc3.nextLine();


        checkLog = check(login);
        checkPass = check(password);
        if (checkLog && checkPass) {
            LogPass(login, password, confirmPassword);
        } else {
            try {
                throw new RuntimeException("Данные логина (пароля) не соответствуют правилам ввода");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }


    }

}

