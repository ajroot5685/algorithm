package com.programmers.hashing;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class 베스트앨범_level_3 {

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    public static int[] solution(String[] genres, int[] plays) {
        List<Integer> result = new ArrayList<>();

        Map<String, Integer> genrePlay = new HashMap<>();
        Map<String, PriorityQueue<Song>> song = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            genrePlay.put(genre, genrePlay.getOrDefault(genre, 0) + play);

            if (!song.containsKey(genre)) {
                song.put(genre, new PriorityQueue<>());
            }
            song.get(genre).offer(new Song(i, play));
        }

        List<String> orderedGenre = genrePlay.entrySet().stream()
                .sorted(Entry.<String, Integer>comparingByValue().reversed())
                .map(Entry::getKey)
                .collect(Collectors.toList());
        for (String genre : orderedGenre) {
            for (int i = 0; i < 2; i++) {
                Song bestSong = song.get(genre).poll();
                if (bestSong != null) {
                    result.add(bestSong.num);
                }
            }
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    static class Song implements Comparable<Song> {
        int num;
        int play;

        Song(int num, int play) {
            this.num = num;
            this.play = play;
        }

        @Override
        public int compareTo(Song o) {
            if (this.play == o.play) {
                return this.num - o.num;
            } else {
                return o.play - this.play;
            }
        }
    }
}
