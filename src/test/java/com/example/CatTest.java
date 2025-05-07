package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private Cat cat;

    @Before
    public void setUp() {
        this.cat = new Cat(feline);
    }

    @Mock
    Feline feline;

    @Test
    public void getSoundTest() {
        String expected = "Мяу";
        String actual = cat.getSound();
        assertEquals("Метод getSound() класса Cat вернул неверное значение", expected, actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expected);
        List<String> actual = cat.getFood();
        verify(feline, times(1)).eatMeat();
        assertEquals("Метод getFood() класса Cat выполнился с ошибкой", expected, actual);
    }
}
