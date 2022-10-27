import service.AccountService;
import service.AccountServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AccountService accountService = new AccountServiceImpl();
        do {
            System.out.println("1 - Регистрация 2 - Войти");
            int n = scanner.nextInt();
            switch (n) {
                case 1 -> accountService.register();
                case 2 -> accountService.login();
            }
        } while (true);
    }
}