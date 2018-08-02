package ru.job4j.generic;

/**
 * RoleStore.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class RoleStore extends AbstractStore<Role> {
    public RoleStore(SimpleArray<Role> repository) {
        super(repository);
    }
}
