package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    @Test
    void locale() {
        LocalizationService local = new LocalizationServiceImpl();
        assertEquals(local.locale(Country.RUSSIA), "Добро пожаловать");
        assertEquals(local.locale(Country.BRAZIL), "Welcome");
    }
}