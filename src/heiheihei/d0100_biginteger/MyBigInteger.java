package heiheihei.d0100_biginteger;

/**
 * Created by Poker on 2016/11/29.
 */
public class MyBigInteger implements Comparable {

    private int length = 0;
    private int[] nums = new int[50];

    public MyBigInteger() {
        initNumArray();
    }

    public MyBigInteger(int num) {
        String s = String.valueOf(num);
        initNumArray();
        this.length = s.length();
        if (s.length() > nums.length) {
            nums = new int[s.length()];
        }
        for (int i = 0; i < s.length(); i++) {
            nums[i] = s.charAt(s.length() - i - 1) - '0';
        }
    }

    public MyBigInteger(String s) {
        initNumArray();
        this.length = s.length();
        if (s.length() > nums.length) {
            nums = new int[s.length()];
        }
        for (int i = 0; i < s.length(); i++) {
            nums[i] = s.charAt(s.length() - i - 1) - '0';
        }
    }

    public MyBigInteger(MyBigInteger a) {
        initNumArray();
        this.length = a.length;
        for (int i = 0; i < a.nums.length; i++) {
            if (a.nums[i] != -1) {
                this.nums[i] = a.nums[i];
            }
        }
    }

    public MyBigInteger add(MyBigInteger addend) {
        MyBigInteger result = new MyBigInteger(this);
        for (int i = 0; i < addend.length; i++) {
            if (result.nums[i] == -1) {
                result.nums[i] = addend.nums[i];
                result.length++;
            } else {
                result.nums[i] += addend.nums[i];
            }

        }
        carryBits(result);
        return result;
    }

    public MyBigInteger multiply(MyBigInteger multiplier) {
        if (this.toInteger() == 0 || multiplier.toInteger() == 0) {
            MyBigInteger a = new MyBigInteger(0);
            return a;
        }
        MyBigInteger result = new MyBigInteger();
        for (int i = 0; i < multiplier.length; i++) {
            for (int j = 0; j < this.length; j++) {
                if (i + j >= result.nums.length) {
                    result.enlarge();
                }
                if (result.nums[i + j] == -1) {
                    result.nums[i + j] = multiplier.nums[i] * nums[j];
                    result.length++;
                } else {
                    result.nums[i + j] += multiplier.nums[i] * nums[j];
                }
            }
            carryBits(result);
        }
        return result;
    }

    public MyBigInteger exponentiate(int exponentiator) {
        if (exponentiator == 0) {
            return new MyBigInteger(1);
        }
        if (exponentiator == 1) {
            return this;
        }
        if (exponentiator % 2 == 0) {
            MyBigInteger half = this.exponentiate(exponentiator / 2);
            return half.multiply(half);
        } else {
            return this.exponentiate(exponentiator - 1).multiply(this);
        }
    }

    public int toInteger() {
        try {
            int num = Integer.parseInt(this.toString());
            return num;
        } catch (Exception e) {
            return -1;
        }
    }

    private void carryBits(MyBigInteger target) {
        for (int i = 0; i < target.length; i++) {
            String s = String.valueOf(target.nums[i]);
            target.nums[i] = s.charAt(s.length() - 1) - '0';
            for (int j = 1; j < s.length(); j++) {
                if (i + j >= target.nums.length) {
                    target.enlarge();
                }
                if (target.nums[i + j] == -1) {
                    target.nums[i + j] = s.charAt(s.length() - 1 - j) - '0';
                    s = String.valueOf(target.nums[i]);
                    target.length++;
                } else {
                    target.nums[i + j] += (s.charAt(s.length() - 1 - j) - '0');
                    s = String.valueOf(target.nums[i]);
                }
            }
        }
    }

    private void initNumArray() {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = -1;
        }
    }

    private void enlarge() {
        int[] tmp = new int[nums.length << 1];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = nums[i];
        }
        nums = tmp;
    }

    /**
     * @param o
     * @return this is larger   1
     * o is larger      -1
     * equal            0
     * o isn't BigInteger -2
     */
    @Override
    public int compareTo(Object o) {
        if (!(o instanceof MyBigInteger)) {
            return -2;
        }
        MyBigInteger target = (MyBigInteger) o;
        if (this.length > target.length) {
            return 1;
        }
        if (target.length < target.length) {
            return -1;
        }
        for (int i = length - 1; i >= 0; i--) {
            if (nums[i] > target.nums[i]) {
                return 1;
            }
            if (nums[i] < target.nums[i]) {
                return -1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == -1) {
                continue;
            }
            sb.append(nums[i]);
        }
        return sb.toString();
    }
}