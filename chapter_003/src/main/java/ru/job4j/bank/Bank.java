package ru.job4j.bank;

import java.util.*;

/**
 * Bank.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class Bank {
    private final Map<User, List<Account>> registry = new HashMap<>();

    /**
     * Add user.
     * @param user - user.
     */
    public void addUser(User user) {
        registry.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Delete user.
     * @param user - user.
     */
    public void deleteUser(User user) {
        registry.remove(user);
    }

    /**
     * Add account to user.
     * @param passport - passport.
     * @param account - account.
     */
    public void addAccountToUser(String passport, Account account) {
        List<Account> accounts = getUserAccounts(passport);
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
    }

    /**
     * Delete account from user.
     * @param passport - passport.
     * @param account - account.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        List<Account> accounts = getUserAccounts(passport);
        accounts.remove(account);
    }

    /**
     * Returns a list of user accounts.
     * @param passport - passport.
     * @return - list of user accounts.
     */
    public List<Account> getUserAccounts(String passport) {
        Map.Entry<User, List<Account>> empty = new AbstractMap.SimpleEntry<>(null, new ArrayList<>());
        return registry.entrySet().stream().filter(entry -> entry.getKey().getPassport().equals(passport)).findFirst().orElse(empty).getValue();
    }

    /**
     * Returns user account.
     * @param passport - passport.
     * @param requisite - requisite.
     * @return - user account.
     */
    public Account getUserAccountByRequisite(String passport, String requisite) {
        Account account = Account.ACCOUNT_NOT_EXIST;
        return getUserAccounts(passport).stream().filter(item -> item.getRequisites().equals(requisite)).findFirst().orElse(account);
    }

    /**
     * Money transfer.
     * @param srcPassport - source passport.
     * @param srcRequisite - source of passport requisites.
     * @param destPassport - destination passport.
     * @param dstRequisite - destination of passport requisites.
     * @param amount - amount of money for transfer.
     * @return - result of transfer.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean perhaps = false;
        Account srcAccount = getUserAccountByRequisite(srcPassport, srcRequisite);
        Account destAccount = getUserAccountByRequisite(destPassport, dstRequisite);
        if (amount > 0D && !destAccount.equals(Account.ACCOUNT_NOT_EXIST) && srcAccount.getValue() >= amount) {
            srcAccount.addValue(-amount);
            destAccount.addValue(amount);
            perhaps = true;
        }
        return perhaps;
    }
}
