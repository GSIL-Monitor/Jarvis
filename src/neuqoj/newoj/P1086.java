package neuqoj.newoj;

import java.util.*;

/**
 * Author: liuxiao
 * Created: 2018/1/23 16:10
 * Description:
 */
public class P1086 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n1 = scan.nextInt();
            int n2 = scan.nextInt();
            List<Student> studentList = new ArrayList<>(n1 + n2);
            for (int i = 0; i < n1 + n2; i++) {
                studentList.add(new Student(scan.nextInt(), scan.nextInt()));
            }
            Collections.sort(studentList);
            for (int i = 0, n = studentList.size(); i < n; i++) {
                System.out.println(studentList.get(i).toString());
            }
        }

    }

    private static class Student implements Comparable {
        private int no;
        private int score;

        public Student(int no, int score) {
            this.no = no;
            this.score = score;
        }

        public int getNo() {
            return no;
        }

        public int getScore() {
            return score;
        }

        @Override
        public int compareTo(Object o) {
            if (!(o instanceof Student)) {
                return -1;
            }
            return score - ((Student) o).getScore();
        }

        @Override
        public String toString() {
            return "" + no + " " + score;
        }
    }

}
