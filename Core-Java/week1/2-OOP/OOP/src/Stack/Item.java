package Stack;

public class Item {
    private Object value;
    private Object pPrev;

    public Item(Object obj) {
        this.setValue(obj);
        this.setpPrev(null);
    }

    public void setpPrev(Object pPrev) {
        this.pPrev = pPrev;
    }

    public Object getPrev() {
        return this.pPrev;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}