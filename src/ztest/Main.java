package ztest;

/**
 * Created by coderxiao on 16/8/10.
 */
public class Main {

    public static void main(String[] args) {
        DotaHero.TINY.hit(DotaHero.CM);
    }

    private enum DotaHero {
        CM, TINY, COCO, SF;

        void hit(DotaHero aHero) {
            System.out.println(this + " hits " + aHero);
        }
    }

}