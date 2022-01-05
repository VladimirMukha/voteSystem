package utilits;

import utilits.exception.NotFoundException;

public class Validation {

    private Validation() {
    }

    public static void checkNotFoundWithId(boolean found, int id) {
        checkNotFound(found, "id=" + id);
    }

    public static <T> T checkNotFoundWithId(T object, int id) {
        return checkNotFound(object, "id=" + id);
    }

    public static void checkNotFound(boolean found, String arg) {
        if (!found) {
            throw new NotFoundException(arg);
        }
    }

    public static <T> T checkNotFound(T object, String arg) {
        checkNotFound(object != null, arg);
        return object;
    }
}