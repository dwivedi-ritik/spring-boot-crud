package dev.ritik.movies.utils;

public class Util {
    public static Long generateRandomInt(Integer lowerBound, Integer upperBound) {
        long rand = (long) Math.floor(Math.random() * (upperBound - lowerBound + 1) + lowerBound);
        return Long.valueOf(rand);
    }

}
