package ru.job4j.storage;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.util.ArrayList;
import java.util.List;

/**
 * UserStorage.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    private final List<User> storage;

    public UserStorage() {
        this.storage = new ArrayList<>();
    }

    public synchronized boolean add(final User user) {
        if (!storage.contains(user)) {
            storage.add(user);
            return true;
        }
        return false;
    }

    public synchronized boolean delete(final User user) {
        if (storage.contains(user)) {
            storage.remove(user);
            return true;
        }
        return false;
    }

    public synchronized boolean update(final User user) {
        for (int index = 0; index != storage.size(); index++) {
            if (storage.get(index).equals(user)) {
                storage.set(index, user);
                return true;
            }
        }
        return false;
    }

    private synchronized User findById(int id) {
        User result = null;
        for (User current : storage) {
            if (current.getId() == id) {
                result = current;
                break;
            }
        }
        return result;
    }

    public synchronized boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;
        User fromUser = findById(fromId);
        User toUser = findById(toId);
        if (fromUser != null && fromUser.getAmount() >= amount && toUser != null) {
            this.update(new User(fromId, fromUser.getAmount() - amount));
            this.update(new User(toId, toUser.getAmount() + amount));
            result = true;
        }
        return result;
    }

    public synchronized List<User> getStorage() {
        return storage;
    }
}
