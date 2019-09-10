package HuffmanTree;

import Node.BinTreeNode;

public class HuffmanTreeNode extends BinTreeNode {
    private int weight;
    private String coding = "";
    public HuffmanTreeNode(int weight,Object e){
        super(e);
        this.weight = weight;
    }
    public HuffmanTreeNode(int weight){
        this(weight,null);
    }
    public HuffmanTreeNode getParant(){
        return (HuffmanTreeNode)super.getParent();
    }
    public HuffmanTreeNode getLChild(){
        return (HuffmanTreeNode)super.getlChild();
    }
    public HuffmanTreeNode getRChild(){
        return (HuffmanTreeNode)super.getrChild();
    }
    public int getWeight(){
        return weight;
    }

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }
}
