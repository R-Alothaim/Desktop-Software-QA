package com.qaisr.util;

import java.util.Random;

/**
 * Utility that produces a random permutation of four answer-option indices.
 * <p>
 * After calling {@link #shuffle()}, fields {@code a}, {@code b}, {@code c}
 * and {@code d} each hold a distinct value from {0, 1, 2, 3}.
 * </p>
 */
public class AnswerShuffler {

    private static final Random RANDOM = new Random();

    public int a;
    public int b;
    public int c;
    public int d;

    /**
     * Generates a random permutation and stores the result in fields
     * {@code a}--{@code d}.
     */
    public void shuffle() {
        int raw = RANDOM.nextInt(111) * RANDOM.nextInt(111);
        switch (raw % 4) {
            case 3 -> { a = 2; b = 1; c = 0; d = 3; }
            case 2 -> { a = 0; b = 3; c = 1; d = 2; }
            case 1 -> { a = 2; b = 0; c = 3; d = 1; }
            default -> { a = 1; b = 2; c = 3; d = 0; }
        }
    }
}
