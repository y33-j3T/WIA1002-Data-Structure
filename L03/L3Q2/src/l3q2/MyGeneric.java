package l3q2;

public class MyGeneric<e> {
    
    private e item;
    
    public MyGeneric() {
    }

    public MyGeneric(e item) {
        this.item = item;
    }

    public e getItem() {
        return item;
    }

    public void setItem(e item) {
        this.item = item;
    }
    
    public static void main(String[] args) {
        MyGeneric<String> strObj = new MyGeneric("Hello");
        MyGeneric<Integer> intObj = new MyGeneric(12345);
        System.out.println(strObj.getItem());
        System.out.println(intObj.getItem());
    }
}
