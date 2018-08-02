package ru.job4j.generic;

/**
 * AbstractStore.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public abstract class AbstractStore<T extends Base> implements Store {
    private final SimpleArray<T> repository;

    public AbstractStore(SimpleArray<T> repository) {
        this.repository = repository;
    }

    @Override
    public void add(Base model) {
        repository.add((T) model);
    }

    @Override
    public boolean replace(String id, Base model) {
        boolean result = false;
        int index = getIndex(id);
        if (index != -1) {
            result = true;
            repository.set(index, (T) model);
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        int index = getIndex(id);
        if (index != -1) {
            result = true;
            repository.delete(index);
        }
        return result;
    }

    @Override
    public Base findById(String id) {
        return repository.get(getIndex(id));
    }

    private int getIndex(String id) {
        int result = -1;
        for (int index = 0; index != repository.size(); index++) {
            if (repository.get(index).getId().equals(id)) {
                result = index;
                break;
            }
        }
        return result;
    }
}
