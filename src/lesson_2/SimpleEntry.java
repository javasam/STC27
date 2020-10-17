package lesson_2;

class SimpleEntry {
    private Object key;
    private Object value;
    SimpleEntry next;

    public SimpleEntry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        if (null != key) {
            return key;
        }
        return 0;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setNext(SimpleEntry next) {
        this.next = next;
    }

    public SimpleEntry getNext() {
        return next;
    }

    public String toString() {
        return ("Key " + key + " , value " + value);
    }
}
