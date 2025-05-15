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
public class LionTest {
    private Lion lion;

    @Mock
    Feline feline;

    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самец", feline);
    }

    @Test
    public void constructorTest() {
        String invalidSex = "Никто";
        try {
            lion = new Lion(invalidSex, feline);
        } catch (Exception e) {
            assertEquals(String.format("Некорректный текст ошибки в конструкторе класса Lion при попытке создать объект с некорректным sex=%s", invalidSex),
                    "Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }

    @Test
    public void getKittensTest() {
        when(feline.getKittens()).thenReturn(1);
        lion.getKittens();
        verify(feline, times(1)).getKittens();
    }

    @Test
    public void getFoodTest() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        lion.getFood();
        verify(feline, times(1)).getFood("Хищник");
    }
}
