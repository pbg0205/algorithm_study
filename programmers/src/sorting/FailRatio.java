package sorting;

import java.util.*;

class FailRatio {
    public static void main(String[] args) {
        int n = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        int n2 = 4;
        int[] stages2 = {4, 1, 2, 3};

        FailRatio failRatio = new FailRatio();
        int[] answer = failRatio.solution(n, stages);

        for (int each : answer) {
            System.out.println(each);
        }
    }

    public int[] solution(int N, int[] stages) {
        List<Stage> stageList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            int challenger = 0;
            int clearedMember = 0;

            for (int stage : stages) {
                if (i == stage) {
                    challenger += 1;
                }

                if (i <= stage) {
                    clearedMember += 1;
                }
            }

            if (challenger == 0) {
                stageList.add(new Stage(i, 0));
            } else {
                stageList.add(new Stage(i, (double) challenger / clearedMember));
            }
        }

        stageList.sort((o1, o2) -> {
            if (o1.failRatio != o2.failRatio) {
                return -Double.compare(o1.failRatio, o2.failRatio);
            } else {
                return Integer.compare(o1.no, o2.no);
            }
        });

        for (Stage stage : stageList) {
            System.out.println(stage.no + " " + stage.failRatio);
        }

        return stageList.stream()
                .mapToInt(stage -> stage.no)
                .toArray();
    }

    class Stage {
        private int no;
        private double failRatio;

        public Stage(int no, double failRatio) {
            this.no = no;
            this.failRatio = failRatio;
        }
    }
}
