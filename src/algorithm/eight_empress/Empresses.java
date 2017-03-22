package algorithm.eight_empress;

/**
 * Created by pokerface_lx on 16/6/19.
 */
public class Empresses {

    // num个皇后
    private int num;

    // 用于表示index列是否有皇后,1表示有,0表示没有
    private int[] column;

    // 用于表示左斜线上是否有皇后,1表示有,0表示没有
    private int[] lSlant;

    // 用于表示右斜线上是否有皇后,1表示有,0表示没有
    private int[] rSlant;

    // 用于存储皇后在index行上的位置（列数)
    private int[] empresses;

    // 用于存储解的编号
    private int no;

    public Empresses(int num) {
        this.num = num;
        this.column = new int[num];
        this.lSlant = new int[num * 2 - 1];
        this.rSlant = new int[num * 2 - 1];
        this.empresses = new int[num];
        for (int i : column) {
            i = 0;
        }
        for (int i : lSlant) {
            i = 0;
        }
        for (int i : rSlant) {
            i = 0;
        }
    }

    public void backTrace(int i) {
        if (i == num) {
            no++;
            showEmpresses();
        } else {
            for (int j = 0; j < num; j++) {
                if (column[j] == 0 && lSlant[num - 1 - (i - j)] == 0 && rSlant[num * 2 - 2 - (i + j)] == 0) {
                    empresses[i] = j;
                    column[j] = lSlant[num - 1 - (i - j)] = rSlant[num * 2 - 2 - (i + j)] = 1;
                    backTrace(i + 1);
                    column[j] = lSlant[num - 1 - (i - j)] = rSlant[num * 2 - 2 - (i + j)] = 0;
                }
            }
        }
    }

    public void showEmpresses() {
        System.out.println("Answer " + this.no);
        for (int empress : empresses) {
            for (int i = 0; i < this.num; i++) {
                if (i == empress) {
                    System.out.print("E ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Empresses eightEmpresses = new Empresses(8);
        eightEmpresses.backTrace(0);
    }

}
