import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author lmignot
 */
public class Tree {

    private Integer value = null;
    private Tree left = null;
    private Tree right = null;

    public Tree() {}

    public Tree(int val) {
        value = val;
    }

    public Tree add(int val) {
        Objects.requireNonNull(val);
        if (value == null) {
            setValue(val);
        } else {
            if (val < value) {
                if (left == null) {
                    left = new Tree(val);
                } else {
                    left.add(val);
                }
            } else {
                if (right == null) {
                    right = new Tree(val);
                } else {
                    right.add(val);
                }
            }
        }
        return this;
    }

    public void setValue(int val) {
        value = val;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "(", ")");
        sj.setEmptyValue("empty");
        if (value == null) { return sj.toString(); }

        sj.add(String.valueOf(value));
        sj.add(left != null ? left.toString() : "empty");
        sj.add(right != null ? right.toString() : "empty");

        return sj.toString();
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        System.out.println(tree.toString());

        tree.add(7).add(5).add(4).add(16).add(8).add(2).add(3).add(15).add(24).add(11);

        System.out.println(tree.toString());
    }
}
