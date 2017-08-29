package data_structure.pair_list;

/**
 * Created by liuxiao on 2017/6/9.
 */
public class Pair<F, S> {

    private F first = null;
    private S second = null;

    public Pair(F f, S s) {
        first = f;
        second = s;
    }

    public F getFirst() {
        return first;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    public boolean equals(Pair obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (this.getFirst().equals(obj.getFirst()) && this.getSecond().equals(obj.getSecond())) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "(" + first.toString() + ", " + second.toString() + ")";
    }

}
