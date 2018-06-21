package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<Account> accounts = new ArrayList<>();
        for (Map.Entry<User, List<Account>> entry : registry.entrySet()) {
            if (passport.equals(entry.getKey().getPassport())) {
                accounts = entry.getValue();
                break;
            }
        }
        return accounts;
    }

    /**
     * Returns user account.
     * @param passport - passport.
     * @param requisite - requisite.
     * @return - user account.
     */
    public Account getUserAccountByRequisite(String passport, String requisite) {
        Account account = Account.ACCOUNT_NOT_EXIST;
        List<Account> accounts = getUserAccounts(passport);
        for (Account current : accounts) {
            if (current.getRequisites().equals(requisite)) {
                account = current;
                break;
            }
        }
        return account;
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
