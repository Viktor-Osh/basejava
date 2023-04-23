import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int length;

    void clear() {
        //Clears an array of non-null elements
        for (int i = 0; i < length; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        //saves the element into the array after the last non-null element
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) continue;
            storage[i] = r;
            length++;
            break;
        }
    }

    Resume get(String uuid) {

        //Returns the element that contains the uuid, if there is no such element print a string indicating it and return null

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
        // delete an element and move the rest by one
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
        /*
      returns the number of elements in an array that are not null
         */
        return length;
    }
}
