package ru.job4j.bank;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankTest {

    @Test
    public void whenAddAccountToUserInRegisterAccountPresent() {
        Bank bank = new Bank();
        User user = new User("Ivan", "125125");
        Account account = new Account("28600900");
        bank.addUser(user);
        bank.addAccountToUser("125125", account);
        Account result = bank.getUserAccountByRequisite("125125", "28600900");
        assertThat(result, is(account));
    }

    @Test
    public void whenDeleteAccountOfUserThenAccountIsAbsent() {
        Bank bank = new Bank();
        User user = new User("Petr", "124640");
        Account account = new Account("28600978");
        bank.addUser(user);
        bank.addAccountToUser("124640", account);
        bank.deleteAccountFromUser("124640", account);
        Account result = bank.getUserAccountByRequisite("124640", "28600978");
        assertThat(result, is(new Account()));
    }
    @Test
    public void whenDeleteUserThenAccountIsAbsent() {
        Bank bank = new Bank();
        User user = new User("Petr", "124640");
        Account account = new Account("28600978");
        bank.addUser(user);
        bank.addAccountToUser("124640", account);
        bank.deleteUser(user);
        Account result = bank.getUserAccountByRequisite("124640", "28600978");
        assertThat(result, is(new Account()));
    }

    @Test
    public void whenTransferMoneyToNonexistingUserThenImpossible() {
        Bank bank = new Bank();
        User user = new User("Petr", "124640");
        Account account = new Account("28600978");
        account.addValue(1000D);
        bank.addUser(user);
        bank.addAccountToUser("124640", account);
        boolean result = bank.transferMoney("124640", "28600978", "356", "28600956", 100);
        assertThat(result, is(false));
    }

    @Test
    public void whenTransferMoneyToNonexistingAccountThenImpossible() {
        Bank bank = new Bank();
        User user = new User("Petr", "124640");
        User user1 = new User("Mikle", "568932");
        Account account = new Account("28600978");
        account.addValue(1000D);
        bank.addUser(user);
        bank.addAccountToUser("124640", account);
        boolean result = bank.transferMoney("124640", "28600978", "568932", "28600956", 100);
        assertThat(result, is(false));
    }

    @Test
    public void whenTransfer100MoneyThenBalance900() {
        Bank bank = new Bank();
        User user = new User("Petr", "124640");
        User user1 = new User("Mikle", "568932");
        Account account = new Account("28600978");
        Account account1 = new Account("28600956");
        account.addValue(1000D);
        bank.addUser(user);
        bank.addAccountToUser("124640", account);
        bank.addUser(user1);
        bank.addAccountToUser("568932", account1);
        bank.transferMoney("124640", "28600978", "568932", "28600956", 100);
        assertThat(account.getValue(), is(900D));
    }
}
