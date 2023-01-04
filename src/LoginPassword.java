public class LoginPassword {
    private String login;
    private String password;


    public LoginPassword(String login, String password, String confirmPass) {
        setLogin(login);
        if (confirmPass.equals(password)) {
            setPassword(password);
        }
        else {
            throw new RuntimeException("Подтвердите пароль корректно");
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        boolean check;
        if (login.length() > 20 || login.length() == 0) {
            throw new RuntimeException("Длина логина превышает 20 символов, либо указан пустой логин");
        } else {
            check = checkLoginPassword(login);
        }
        if (check) {
            check = checkLoginPassword2(login);
            if (check) {
                this.login = login;
            } else {
                throw new RuntimeException("Логин должен содержать заглавные, строчные буквы и цифры");
            }
        } else {
            throw new RuntimeException("Некорректно введен логин. Допускаются только латинские буквы и цифры");
        }
    }


    public void setPassword(String password) {
        boolean check;
        if (password.length() > 20 || password.length() == 0) {
            throw new RuntimeException("Длина пароля превышает 20 символов, либо указан пустой логин");
        } else {
            check = checkLoginPassword(password);
        }
        if (check) {
            check = checkLoginPassword2(password);
            if (check) {
                this.password = password;
            } else {
                throw new RuntimeException("Пароль должен содержать заглавные, строчные буквы и цифры");
            }
        } else {
            throw new RuntimeException("Некорректно введен пароль. Допускаются только латинские буквы и цифры");
        }
    }

    private boolean checkLoginPassword(String logPass) {
        boolean check = true;
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        for (int i = 0; i < logPass.length(); i++) {
            if (check) {
                for (int j = 0; j < letters.length(); j++) {
                    if (logPass.charAt(i) != letters.charAt(j)) {
                        check = false;
                    } else {
                        check = true;
                        break;
                    }
                }
            } else break;
        }
        return check;
    }

    private boolean checkLoginPassword2(String logPass) {
        boolean check1 = false;
        boolean check2 = false;
        boolean check3 = false;
        String bigLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "1234567890";
        for (int i = 0; i < bigLetters.length(); i++) {
            for (int j = 0; j < logPass.length(); j++) {
                if (bigLetters.charAt(i) == logPass.charAt(j)) {
                    check1 = true;
                    break;
                }
            }
        }
        if (check1) {
            for (int i = 0; i < smallLetters.length(); i++) {
                for (int j = 0; j < logPass.length(); j++) {
                    if (smallLetters.charAt(i) == logPass.charAt(j)) {
                        check2 = true;
                        break;
                    }
                }
            }
        }
        if (check2) {
            for (int i = 0; i < numbers.length(); i++) {
                for (int j = 0; j < logPass.length(); j++) {
                    if (numbers.charAt(i) == logPass.charAt(j)) {
                        check3 = true;
                        break;
                    }
                }
            }
        }
        return check3;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "LoginPassword{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
