package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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
    public void getKittensTest() {
        lion.getKittens();
        verify(feline, times(1)).getKittens();
    }

    @Test
    public void getFoodTest() throws Exception {
        lion.getFood();
        verify(feline, times(1)).getFood("Хищник");
    }
}
