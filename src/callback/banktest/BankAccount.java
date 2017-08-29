package callback.banktest;

/**
 * Created by liuxiao on 2017/6/11.
 */
public class BankAccount {

    private String name;
    private double leftMoney;

    public BankAccount(String name) {
        this.name = name;
        leftMoney = 0;
    }

    public BankAccount(String name, double leftMoney) {
        this.name = name;
        this.leftMoney = leftMoney;
    }

    public void setLeftMoney(double leftMoney) {
        this.leftMoney = leftMoney;
    }

    public String getName() {

        return name;
    }

    public double getLeftMoney() {
        return leftMoney;
    }

    @Override
    public String toString() {
        return "name: " + name + ", leftMoney: " + leftMoney + "\n";
    }

    public interface CallBack {

        void success();

        void fail();

    }


}
