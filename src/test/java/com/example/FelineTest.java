package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void eatMeat() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expected);
        List<String> actual = feline.eatMeat();
        verify(feline, times(1)).getFood("Хищник");
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
        verify(feline, times(1)).getKittens(1);
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
