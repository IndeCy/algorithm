package easy.Node;


public class BinTreeNode implements Node {

    private Object data;

    private BinTreeNode parent;

    private BinTreeNode lChild;

    private BinTreeNode rChild;

    private int height;

    private int size;

    public BinTreeNode(){
        this(null);
    }

    public BinTreeNode(Object e){
        data =e;
        height=0;
        size =1;
        parent=lChild=rChild=null;
    }

    public boolean hasParent(){
        return parent!=null;
    }
    public boolean hasLChild(){
        return lChild!=null;
    }
    public boolean hasRChild(){
        return rChild!=null;
    }
    public boolean isLeaf(){
        return !hasLChild()&&!hasRChild();
    }
    public boolean isLChild(){
        return hasParent() && this==parent.lChild;
    }
    public boolean isRPChild(){
        return hasParent() && this==parent.rChild;
    }
    public int getHeight(){
        return height;
    }
    public void updateHeight(){
        int newH =0;
        if(hasLChild()){
            newH = Math.max(newH,1 + getlChild().getHeight());
        }
        if (hasRChild()) {
            newH = Math.max(newH,1 + getrChild().getHeight());
        }
        if(newH == height) return;;
        height = newH;
        if(hasParent()){
            getParent().updateHeight();
        }
    }


    public void updateSize(){
        size =1;
        if(hasLChild()){
            size += getlChild().getSize();
        }
        if(hasRChild()){
            size += getrChild().getSize();
        }
        if(hasParent()){
            getParent().updateSize();
        }
    }

    public void sever(){
        if(!hasParent()){
            return;
        }
        if(isLChild()){
            parent.lChild=null;
        }else{
            parent.rChild=null;
        }
        parent.updateHeight();
        parent.updateSize();
        parent=null;
    }

    public BinTreeNode setlChild(BinTreeNode lc){
        BinTreeNode oldLC = this.lChild;
        if(hasLChild()){
            lChild.sever();
        }
        if(lc!=null){
            lc.sever();
            this.lChild = lc;
            lc.parent = this;
            this.updateHeight();
            this.updateSize();
        }
        return oldLC;
    }

    public BinTreeNode setrChild(BinTreeNode rc){
        BinTreeNode oldRC = this.rChild;
        if(hasRChild()){
            rChild.sever();
        }
        if(rc!=null){
            rc.sever();
            this.rChild = rc;
            rc.parent = this;
            this.updateHeight();
            this.updateSize();
        }
        return oldRC;
    }

    @Override
    public Object getData() {
        return data;
    }

    @Override
    public void setData(Object obj) {
        this.data = obj;
    }

    public BinTreeNode getParent() {
        return parent;
    }

    public void setParent(BinTreeNode parent) {
        this.parent = parent;
    }

    public BinTreeNode getlChild() {
        return lChild;
    }


    public BinTreeNode getrChild() {
        return rChild;
    }


    public int getSize() {
        return size;
    }

}
