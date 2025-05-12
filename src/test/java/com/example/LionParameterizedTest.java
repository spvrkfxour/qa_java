package com.example;

import org.junit.Assume;
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
    private final boolean throwException;
    private Lion lion;

    @Mock
    Feline feline;

    public LionParameterizedTest(String sex, boolean hasMane, boolean throwException) {
        this.sex = sex;
        this.hasMane = hasMane;
        this.throwException = throwException;
    }

    @Parameterized.Parameters(name = "sex = {0}, hasMane = {1}, throwException = {2}")
    public static Object[][] data() {
        return new Object[][] {
                {"Самец", true, false},
                {"Самка", false, false},
                {"Никто", false, true}
        };
    }

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        if (!throwException) {
            lion = new Lion(sex, feline);
        }
    }

    @Test
    public void constructorTest() {
        if (throwException) {
            try {
                lion = new Lion(sex, feline);
            } catch (Exception e) {
                assertEquals(String.format("Некорректный текст ошибки в конструкторе класса Lion при попытке создать объект с некорректным sex=%s", sex),
                        "Используйте допустимые значения пола животного - самец или самка", e.getMessage());
            }
        }
    }

    @Test
    public void doesHaveManeTest() {
        Assume.assumeFalse("Тест getKittensTest() пропущен, так как конструктор тестового класса выбросил исключение", throwException);
        boolean expected = hasMane;
        boolean actual = lion.doesHaveMane();
        assertEquals("Метод doesHaveMane() класса Lion вернул некорректное значение", expected, actual);
    }
}
