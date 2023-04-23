import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) continue;
            storage[i] = r;
        }
    }

    Resume get(String uuid) {
        int index = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid.equals(uuid)) {
                index = i;
                break;
            }
        }
        return storage[index];
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (!storage[i].uuid.equals(uuid)) {
                continue;
            } else {
                if (storage[i + 1] == null || i + 1 == storage.length) {
                    storage[i] = null;
                    break;
                } else {
                    for (int j = i; j < storage.length-1; j++) {
                        if (storage[j+1] == null) break;
                        storage[j] = storage[j + 1];
                    }
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int length = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null){
                length = i;
                break;
            }
        }
        return Arrays.copyOfRange(storage,0, length);
    }

    int size() {
        return 0;
    }
}
