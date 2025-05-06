package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


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
        Assert.assertEquals("", "Мяу", cat.getSound());
    }

    @Test
    public void getFoodTest() throws Exception {

    }
}
