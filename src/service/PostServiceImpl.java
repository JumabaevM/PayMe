package service;


import models.Account;

import models.Card;
import models.CardType;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PostServiceImpl implements PostService {

    private final Scanner scanner = new Scanner(System.in);
    private final List<CardType> cardTypeList = Arrays.asList(CardType.values());

    public PostServiceImpl(Account currentAccount) {

    }

    public void addKart() {
        System.out.println("Номер карты: ");
        String number = scanner.next();
        System.out.println("Срок действий: ");
        String expireDate = scanner.next();
        boolean b = true;
        while (b) {
            for (int i = 0; i < cardTypeList.size(); i++) {
                System.out.println((i + 1) + " -> " + cardTypeList.get(i));
            }
            int n = scanner.nextInt() -1;
            if (n > cardTypeList.size()) {
                System.out.println("Ошибка");
            } else {
                b = false;
                Card card = new Card(number, expireDate, cardTypeList.get(n));
                Account.getCardList().add(card);
            }
        }
    }

    public void myKart() {
        for (int i = 0; i < Account.getCardList().size(); i++) {
            System.out.println((i + 1) + " - " + Account.getCardList().get(i));
        }

    }

    public void perevodKart() {
        System.out.println("1 - Пополнить\n2 - Отправить");
        int m = scanner.nextInt();
        if (m == 1) {
            for (int i = 0; i < Account.getCardList().size(); i++) {
                System.out.println((i + 1) + " - " + Account.getCardList().get(i));
            }
            int n = scanner.nextInt() - 1;
            if (n > Account.getCardList().size()) {
                System.out.println("Ошибка");
            } else {
                System.out.print("Введите сумму: ");
                double balans = scanner.nextDouble();
                Account.getCardList().get(n).setBalans(Account.getCardList().get(n).getBalans() + balans);
            }
        } else {
            System.out.println("Выберите карту для оплаты: ");
            for (int i = 0; i < Account.getCardList().size(); i++) {
                System.out.println((i + 1) + " -> " + Account.getCardList().get(i));
            }

            int n = scanner.nextInt() - 1;
            if (n > Account.getCardList().size()) {
                System.out.println("Карта ненайден!");
            } else {
                System.out.print("Карта: ");
                String number = scanner.next();
                if (Account.getCardList().get(n).getNumber().equals(number)) {
                    System.out.println("Вы неможете отправить денги себе!");
                } else {
                    System.out.print("Введите сумму: ");
                    double uzs = scanner.nextDouble();
                    Account.getCardList().get(n).setBalans(Account.getCardList().get(n).getBalans() - uzs);
                }

            }

        }
    }
    public void balansKart () {

        for (int i = 0; i < Account.getCardList().size(); i++) {
            System.out.println((i + 1) + " - " + Account.getCardList().get(i).getBalans() + " uzs");
        }
    }


}
