package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.MockitoAnnotations.initMocks;


@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private final String sex;
    private final boolean hasMane;
    private Lion lion;

    @Mock
    Feline feline;

    public LionParameterizedTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters(name = "sex = {0}, hasMane = {1}")
    public static Object[][] data() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        lion = new Lion(sex, feline);
    }

    @Test
    public void doesHaveManeTest() {
        boolean expected = hasMane;
        boolean actual = lion.doesHaveMane();
        assertEquals("Метод doesHaveMane() класса Lion вернул некорректное значение", expected, actual);
    }
}
