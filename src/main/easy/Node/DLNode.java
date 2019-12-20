package easy.Node;

public class DLNode implements Node {

    private DLNode pre;

    private DLNode next;

    private Object element;

    public DLNode(){
        this(null,null,null);

    }
    public DLNode(Object obj,DLNode pre,DLNode next){
        this.pre = pre;
        this.next = pre;
        this.element = obj;
    }

    public DLNode getPre() {
        return pre;
    }

    public void setPre(DLNode pre) {
        this.pre = pre;
    }

    public DLNode getNext() {
        return next;
    }

    public void setNext(DLNode next) {
        this.next = next;
    }

    @Override
    public Object getData() {
        return element;
    }

    @Override
    public void setData(Object obj) {
        this.element = obj;
    }
}
