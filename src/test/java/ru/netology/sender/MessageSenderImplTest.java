package ru.netology.sender;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class MessageSenderImplTest {
    Map<String, String> x = new HashMap<>();
    @BeforeEach
    void BeforeEach(){
        System.out.println();
    }
    @DisplayName("Проверка на Россию")
    @Test
    public void testRussianTextSentForRussianIp() {

        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);

        when(geoService.byIp(Mockito.anyString())).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));

        when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        assertEquals("Добро пожаловать", messageSender.send(x));
    }

    @DisplayName("Проверка на США")
    @Test
    public void testEnglishTextSentForAmericanIp() {
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);

        when(geoService.byIp(Mockito.anyString())).thenReturn(new Location("New York", Country.USA, "10th Avenue", 32));

        when(localizationService.locale(Country.USA)).thenReturn("Welcome");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        assertEquals("Welcome", messageSender.send(x));
    }
}