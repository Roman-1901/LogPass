public class LogPas {
    private String login;
    private String password;

    public LogPas(String login, String password, String confirmPassword) {
        this.login = "Dimon123";
        this.password = "Password123";
        if (!login.equals(this.login) || !password.equals(this.password) || !confirmPassword.equals(this.password)) {
            try {
                throw new RuntimeException("Неверно казаны логин или пароль");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Данные введены корректно");
        }
    }
}
