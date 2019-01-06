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
        Optional<Map.Entry<User, List<Account>>> entryUser = getUserRecord(passport);
        if (entryUser.isPresent() && !entryUser.get().getValue().contains(account)) {
                entryUser.get().getValue().add(account);
        }
    }

    /**
     * Delete account from user.
     * @param passport - passport.
     * @param account - account.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        getUserRecord(passport).ifPresent(s -> s.getValue().remove(account));
    }

    /**
     * Returns user record.
     * @param passport - passport.
     * @return - list of user accounts.
     */
    public Optional<Map.Entry<User, List<Account>>> getUserRecord(String passport) {
        return registry.entrySet().stream().filter(entry -> entry.getKey().getPassport().equals(passport)).findFirst();
    }

    /**
     * Returns user account.
     * @param passport - passport.
     * @param requisite - requisite.
     * @return - user account.
     */
    public Optional<Account> getUserAccount(String passport, String requisite) {
        Optional<Map.Entry<User, List<Account>>> entryUser = getUserRecord(passport);
        Optional<Account> account = Optional.empty();
        if (entryUser.isPresent()) {
            account = entryUser.get().getValue().stream().filter(item -> item.getRequisites().equals(requisite)).findFirst();
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
        Optional<Account> srcAccount = getUserAccount(srcPassport, srcRequisite);
        Optional<Account> destAccount = getUserAccount(destPassport, dstRequisite);
        if (amount > 0D && destAccount.isPresent() && srcAccount.isPresent() && srcAccount.get().getValue() >= amount) {
            srcAccount.get().addValue(-amount);
            destAccount.get().addValue(amount);
            perhaps = true;
        }
        return perhaps;
    }
}
