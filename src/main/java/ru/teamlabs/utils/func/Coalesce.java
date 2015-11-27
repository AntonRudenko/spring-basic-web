package ru.teamlabs.utils.func;

import java.util.Optional;

/**
 * Created by Anton Rudenko on 25.05.15.
 */
public class Coalesce {

    public static <T> T of(T... objects) {
        for (T object : objects) {
            if (object != null) {
                return object;
            }
        }
        return null;
    }

    public static <T> Optional<T> ofOptional(T... objects) {
        for (T object : objects) {
            if (object != null) {
                return Optional.of(object);
            }
        }
        return Optional.empty();
    }


}
