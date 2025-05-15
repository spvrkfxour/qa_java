package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class FelineTest {
    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void eatMeat() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        assertEquals("Метод eatMeat() класса Feline выполнился с ошибкой", expected, actual);
    }

    @Test
    public void getFamilyTest() {
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals("Метод getFamily() класса Feline вернул неверное значение", expected, actual);
    }

    @Test
    public void getKittensWithKittensCount1Return1Test() {
        int expected = 1;
        int actual = feline.getKittens();
        assertEquals("Метод getKittens() класса Feline вернул неверное значение", expected, actual);
    }

    @Test
    public void getKittensWithKittensCount5Return5Test() {
        int expected = 5;
        int actual = feline.getKittens(5);
        assertEquals(String.format("Метод getKittens(int kittensCount) класса Feline вернул неверное значение при kittensCount=%s", actual),
                expected, actual);
    }

    @Test
    public void getKittensWithKittensCount10Return10Test() {
        int expected = 10;
        int actual = feline.getKittens(10);
        assertEquals(String.format("Метод getKittens(int kittensCount) класса Feline вернул неверное значение при kittensCount=%s", actual),
                expected, actual);
    }
}
