package lesson_2;

class SimpleEntry<K, V> {
    private K key;
    private V value;
    SimpleEntry<K, V> next;

    public SimpleEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        if (null != key) {
            return (Integer) key;
        }
        return 0;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setNext(SimpleEntry<K, V> next) {
        this.next = next;
    }

    public SimpleEntry<K, V> getNext() {
        return next;
    }

    public String toString() {
        return ("Key " + key + " , value " + value);
    }
}
