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


        LogPas user = new LogPas(login, password, confirmPassword);
    }
}