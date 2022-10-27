package models;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private final String username;
    private final String password;
    private static final List<Card> cardList = new ArrayList<>();



    public Account(String username, String password, String fullName, String email) {
        this.username = username;
        this.password = password;
    }

    public static List<Card> getCardList() {
        return cardList;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }



}
