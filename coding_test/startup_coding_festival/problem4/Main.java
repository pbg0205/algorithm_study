package coding_test.startup_coding_festival.problem4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double[] scoreArr = new double[5];
        Map<Character, Double> map = new HashMap<>();

        char[][] watchedMap;
        char[][] genreMap;

        int index = 0;
        while (st.hasMoreTokens()) {
            map.put((char) ('A' + index++), Double.parseDouble(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());

        watchedMap = new char[rowSize][colSize];
        genreMap = new char[rowSize][colSize];

        init(br, watchedMap, rowSize, colSize);
        init(br, genreMap, rowSize, colSize);

        List<info> list = new ArrayList<>();

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                char genre = genreMap[row][col];
                list.add(new info(genre, watchedMap[row][col], map.get(genre), row, col));
            }
        }

        list.sort(new Comparator<info>() {
            @Override
            public int compare(info o1, info o2) {
                if (o1.getWatchStatus() < o2.getWatchStatus()) {
                    return 1;
                } else if(o1.getWatchStatus() > o2.getWatchStatus()) {
                    return -1;
                } else {
                    if(o1.score < o2.score) {
                        return 1;
                    } else if(o1.score > o2.score) {
                        return -1;
                    } else {
                        if(o1.col > o2.col) {
                            return 1;
                        } else if(o1.col < o2.col) {
                            return -1;
                        } else {
                            if(o1.row > o2.row) {
                                return 1;
                            } else if(o1.row < o2.row) {
                                return -1;
                            } else {
                                return 0;
                            }
                        }
                    }
                }
            }
        });

        for (info info : list) {
            if(info.watchedStatus == 'W') {
                continue;
            }

            System.out.println(info.genre + " " + info.score + " " + info.row + " " + info.col);
        }
    }

    private static void init(BufferedReader br, char[][] watchedMap, int rowSize, int colSize) throws IOException {
        for (int row = 0; row < rowSize; row++) {
            String line = br.readLine();
            for (int col = 0; col < colSize; col++) {
                watchedMap[row][col] = line.charAt(col);
            }
        }
    }
}

class info {
    char genre;
    char watchedStatus;
    double score;
    int row;
    int col;

    public info(char genre, char watchedStatus, double score, int row, int col) {
        this.genre = genre;
        this.watchedStatus = watchedStatus;
        this.score = score;
        this.row = row;
        this.col = col;
    }

    public int getWatchStatus() {
        if (this.watchedStatus == 'Y') {
            return 2;
        }

        if (this.watchedStatus == 'O') {
            return 1;
        }

        return 0;
    }
}
