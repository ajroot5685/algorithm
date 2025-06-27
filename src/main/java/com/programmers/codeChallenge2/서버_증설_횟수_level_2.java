package com.programmers.codeChallenge2;

import java.io.*;
import java.util.*;

public class 서버_증설_횟수_level_2 {

    public static void main(String[] args) {
        int[] players = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        int m = 3;
        int k = 5;
        System.out.println(solution(players, m, k));
    }

    public static int solution(int[] players, int m, int k) {
        int[] server = new int[24];

        int result = 0;

        for (int i = 0; i < players.length; i++) {
            if (players[i] < m) {
                continue;
            }
            if (players[i] >= (server[i] + 1) * m) {
                int plus = players[i] / m - server[i];
                for (int j = 0; j < k; j++) {
                    if (i + j == 24) {
                        break;
                    }
                    server[i + j] += plus;
                }
                result += plus;
            }
        }

        return result;
    }
}
