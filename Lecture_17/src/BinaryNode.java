public class BinaryNode {

    private BinaryNode right;
    private int weight;
    private BinaryNode left;
    private byte[] symbol;


    public BinaryNode(BinaryNode right, int weight, BinaryNode left, byte[] symvol) {
        this.right = right;
        this.weight = weight;
        this.left = left;
        this.symbol = symvol;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }
}

