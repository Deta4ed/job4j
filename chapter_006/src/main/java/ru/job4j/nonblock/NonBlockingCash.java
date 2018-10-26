package ru.job4j.nonblock;


import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

public class NonBlockingCash {
    private ConcurrentHashMap<Integer, Base> cash = new ConcurrentHashMap<>();

    public void add(Base model) {
        cash.putIfAbsent(model.getId(), model);
    }

    public void update(int version, Base model) throws OptimisticException {
        cash.computeIfPresent(model.getId(), (key, value) -> {
            if (value.getVersion() != version) {
                throw new OptimisticException("Invalid version");
            }
            model.updateVersion();
            return model;
        });
    }

    public void delete(Base model) {
        cash.remove(model.getId());
    }

    public Base get(int key) {
        return cash.get(key);
    }
}
