package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class AlexLionTest {
    private AlexLion alexLion;

    @Mock
    Feline feline;

    @Before
    public void setUp() throws Exception {
        this.alexLion = new AlexLion("Самец", feline);
    }

    @Test
    public void constructorTest() {
        assertNotNull(alexLion);
    }

    @Test
    public void getFriendsTest() {
        List<String> expected = List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман");
        List<String> actual = alexLion.getFriends();
        assertEquals("Метод getFriends() класса AlexLion вернул некорректное значение", expected, actual);
    }

    @Test
    public void getPlaceOfLivingTest() {
        String expected = "Нью-Йоркский зоопарк";
        String actual = alexLion.getPlaceOfLiving();
        assertEquals("Метод getPlaceOfLiving() класса AlexLion вернул некорректное значение", expected, actual);
    }

    @Test
    public void getKittensTest() {
        int expected = 0;
        int actual = alexLion.getKittens();
        assertEquals("Метод getKittens() класса AlexLion вернул некорректное значение", expected, actual);
    }
}
