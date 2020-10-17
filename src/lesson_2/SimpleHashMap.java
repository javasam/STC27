package lesson_2;

import java.util.*;

public class SimpleHashMap implements Iterable {

    private int capacity = 16;
    private int size;
    private int modificationCount;

    @SuppressWarnings("unchecked")
    private final SimpleEntry[] array = new SimpleEntry[capacity];

    public SimpleHashMap() {
    }

    public SimpleHashMap(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Put into SimpleHashMap method
     *
     * @param key   key param
     * @param value value param
     */
    public void put(Object key, Object value) {
        modificationCount++;
        int numBasket;
        if (key == null) {
            if (array[0] == null) {
                array[0] = new SimpleEntry(key, value);
                size++;
            } else {
                array[0].setValue(value);
            }
        }

        if (null == key) {
            numBasket = 0;
        } else {
            numBasket = Math.abs(key.hashCode()) % capacity;
        }


        if (null == array[numBasket]) {
            array[numBasket] = new SimpleEntry(key, value);
        } else {
            SimpleEntry entry = array[numBasket];

            while (true) {
                if (null != entry.getKey() & Objects.equals(entry.getKey(), key)) {
                    entry.setValue(value);
                    return;
                }

                if (entry.getNext() == null) {
                    break;
                }
                entry = entry.getNext();
            }

            entry.setNext(new SimpleEntry(key, value));
        }
        size++;
    }

    /**
     * Get from SimpleHashMAp method
     *
     * @param key seek by key param
     * @return Value associated with key
     */
    public Object get(Object key) {

        if (key == null) {
            if (array[0] == null) {
                return null;
            }

            return array[0].getValue();
        }

        int numBasket = Math.abs(key.hashCode()) % capacity;

        if (array[numBasket] == null) {
            return null;
        } else {
            SimpleEntry entry = array[numBasket];

            while (true) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }

                if (entry.getNext() == null) {
                    return null;
                }

                entry = entry.getNext();
            }
        }
    }

    /**
     * Remove form SimpleHashMap method
     *
     * @param key by key param
     */
    public void remove(Object key) {
        if (key == null) {
            if (array[0] != null) {
                modificationCount++;
                size--;

                if (array[0].getNext() != null) {
                    array[0] = array[0].getNext();
                }
            }
            return;
        }

        int numBasket = Math.abs(key.hashCode()) % capacity;

        if (array[numBasket] != null) {
            if (array[numBasket].getKey().equals(key)) {
                array[numBasket] = array[numBasket].getNext();
                modificationCount++;
                size--;
                return;
            }

            if (array[numBasket].getNext() != null) {
                SimpleEntry prev = array[numBasket];
                SimpleEntry entry = array[numBasket].getNext();
                SimpleEntry next = entry.getNext();

                while (true) {
                    if (entry.getKey().equals(key)) {
                        modificationCount++;
                        size--;

                        prev.setNext(next);
                        return;
                    }

                    if (next == null) {
                        return;
                    }

                    prev = entry;
                    entry = next;
                    next = next.getNext();
                }
            }
        }
    }

    /**
     * Size method
     *
     * @return SimpleHashMAp size
     */
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {

        return new Iterator() {

            private int expectedModificationCount;
            private int currentNumBasket;
            private SimpleEntry nextEntry;
            private SimpleEntry currentEntry;

            {
                expectedModificationCount = modificationCount;
                for (SimpleEntry entry : array) {
                    if (entry != null) {
                        nextEntry = entry;
                        break;
                    }
                }
            }

            @Override
            public boolean hasNext() {
                return nextEntry != null;
            }

            @Override
            public SimpleEntry next() {
                if (modificationCount != expectedModificationCount) {
                    throw new ConcurrentModificationException();
                }
                currentEntry = nextEntry;

                if (nextEntry.getNext() == null) {
                    nextEntry = null;
                    for (++currentNumBasket; currentNumBasket < capacity; currentNumBasket++) {
                        if (array[currentNumBasket] != null) {
                            nextEntry = array[currentNumBasket];
                        }
                    }
                } else {
                    nextEntry = nextEntry.getNext();
                }

                return currentEntry;
            }

            public void remove() {
                if (modificationCount != expectedModificationCount) {
                    throw new ConcurrentModificationException();
                }

                if (currentEntry == null) {
                    throw new UnsupportedOperationException();
                }

                SimpleHashMap.this.remove(currentEntry.getKey());
                expectedModificationCount++;
            }

        };
    }

    public Set entrySet() {
        Set set = new HashSet();

        for (SimpleEntry entry : array) {
            while (entry != null) {
                set.add(entry);
                entry = entry.getNext();
            }
        }

        return set;
    }

    public Set keySet() {
        Set set = new HashSet();

        for (SimpleEntry entry : array) {
            while (entry != null) {
                set.add(entry.getKey());
                entry = entry.getNext();
            }
        }

        return set;
    }

    @Override
    public String toString() {
        return "SimpleHashMap{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}