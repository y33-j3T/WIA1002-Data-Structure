package slist;

public class TestSList {
    public static void main(String[] args) {
        SList<String> list= new SList<>();
        
        list.appendEnd("Linked ");
        list.appendEnd("list, ");
        list.appendEnd("is, ");
        list.appendEnd("easy.");
        
        list.display();
        
        list.removeInitial();
        list.removeInitial();
        list.display();
        
        System.out.println(list.contains("difficult"));
        
        list.clear();
    }
}
