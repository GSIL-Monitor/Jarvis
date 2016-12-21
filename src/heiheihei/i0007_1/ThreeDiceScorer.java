package heiheihei.i0007_1;

public class ThreeDiceScorer extends ThreeDice {

    public ThreeDiceScorer(int s1, int s2, int s3) {
        super(s1, s2, s3);
    }

    public int getPoints() {
        int score = this.die1 + this.die2 + this.die3;
        if (threeSame()) {
            score = score + 60;
        } else if (runOfThree()) {
            score = score + 40;
        } else if (pair()) {
            score = score + 20;
        }
        return score;
    }

    public static ThreeDiceScorer getDiceScorer() {
        int s1 = (int) (Math.random() * 6) + 1;
        int s2 = (int) (Math.random() * 6) + 1;
        int s3 = (int) (Math.random() * 6) + 1;
        return new ThreeDiceScorer(s1,s2,s3);
    }

    @Override
    public String toString() {
        return this.die1 + " " + this.die2 + " " + this.die3;
    }
}
