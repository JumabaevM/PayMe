package service;

import models.Account;

import java.util.Scanner;

public class AccountServiceImpl implements AccountService {
    private final Scanner scanner = new Scanner(System.in);
    private final Account[] accountList = new Account[100];
    private int count = 0;


    public void register() {
        System.out.print("Введите имя пользователя: ");
        String username = scanner.next();
        System.out.print("Введите парол: ");
        String password = scanner.next();
        System.out.print("Введите ваше имя: ");
        String fullName = scanner.next();
        System.out.print("Введите почту: ");
        String email = scanner.next();
        Account account = new Account(username, password, fullName, email);
        accountList[count++] = account;
    }


    public void login() {
        System.out.print("Введите имя пользователя: ");
        String username = scanner.next();
        System.out.print("Введите парол: ");
        String password = scanner.next();

        int index = -1;
        for (int i = 0; i < count; i++) {
            if (accountList[i].getUsername().equals(username) && accountList[i].getPassword().equals(password)) {
                index = i;
            }
        }

        if (index == -1) {
            System.out.println("\nАККАУНТ НЕ НАЙДЕН!!!❌❌\n");
        } else {
            System.out.println("\nДОБРО ПОЖАЛОВТЬ НА СИСТЕМУ!!! \uD83C\uDF89\uD83C\uDF89");
            PostService postService = new PostServiceImpl(accountList[index]);
            boolean exit = true;


            while (exit) {
                System.out.println("""
                        PayMe
                        1->Моии карты \uD83D\uDCB3
                        2->Переводи \uD83D\uDD01\s
                        3->Баланс \uD83D\uDCBC\s
                        4->Открыть карту 💎
                        5->Быход ⭕
                        """);
                int n = scanner.nextInt();
                switch (n) {
                    case 1 -> postService.myKart();
                    case 2 -> postService.perevodKart();
                    case 3 -> postService.balansKart();
                    case 4 -> postService.addKart();
                    case 5 -> exit = false;
                }
            }
        }
    }
}
