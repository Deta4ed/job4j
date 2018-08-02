package ru.job4j.generic;

/**
 * UserStore.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class UserStore extends AbstractStore<User> {
    public UserStore(SimpleArray<User> repository) {
        super(repository);
    }
}
