import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int length;

    void clear() {
        for (int i = 0; i < length; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) continue;
            storage[i] = r;
            length++;
            break;
        }
    }

    Resume get(String uuid) {
        for (Resume resume : storage) {
            if (resume == null) break;
            if (resume.uuid.equals(uuid)) {
                return resume;
            }
        }
        System.out.println("no such element");
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid.equals(uuid)) {
                if (storage[i + 1] != null || i + 1 != storage.length) {
                    for (int j = i; j < storage.length - 1; j++) {
                        storage[j] = storage[j + 1];
                        if (storage[j + 1] == null) {
                            break;
                        }
                    }
                    length--;
                    break;
                } else {
                    storage[i] = null;
                    length--;
                    break;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, length);
    }

    int size() {
        return length;
    }
}
