package model;

import java.util.ArrayList;
import java.util.List;

public class Patient {

    private String passport;
    private String surname;
    private String birthday;
    private List<Purchase> purchases;

    public Patient(String passport, String surname, String birthday) {
        this.passport = passport;
        this.surname = surname;
        this.birthday = birthday;

        purchases = new ArrayList<>();
    }

    public String getPassport() {
        return passport;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public String toString() {
        return passport + ", " + surname;
    }

    public String detailedToString() {
        return "Паспорт: " + passport + "\nПІБ: " + surname + "\nДень народження: " + birthday;
    }
}
