package slist;

public class SNode<E> {
    E element;
    SNode<E> next;
   
    public SNode(E element, SNode<E> next) {
        this.element = element;
        this.next = next;
    }

    public SNode(E element) {
        this.element = element;
        this.next = null;        
    }
    
}
