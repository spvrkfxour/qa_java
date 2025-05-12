package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private Cat cat;

    @Mock
    Feline feline;

    @Before
    public void setUp() {
        this.cat = new Cat(feline);
    }

    @Test
    public void constructorTest() {
        assertNotNull(cat);
    }

    @Test
    public void getSoundTest() {
        String expected = "Мяу";
        String actual = cat.getSound();
        assertEquals("Метод getSound() класса Cat вернул неверное значение", expected, actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        cat.getFood();
        verify(feline, times(1)).eatMeat();
    }
}
