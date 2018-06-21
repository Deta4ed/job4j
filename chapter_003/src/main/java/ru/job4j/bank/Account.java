package ru.job4j.bank;

import java.util.Objects;

/**
 * Account.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class Account {
    private final String requisites;
    private Double value = 0D;
    public static final Account ACCOUNT_NOT_EXIST = new Account();

    private Account() {
        this.requisites = "";
    }

    public Account(String requisites) {
        this.requisites = requisites;
    }

    public void addValue(Double value) {
        this.value += value;
    }

    public Double getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisites, account.requisites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisites);
    }
}
