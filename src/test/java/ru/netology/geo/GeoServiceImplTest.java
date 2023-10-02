package ru.netology.geo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    GeoService geoService = new GeoServiceImpl();
    @DisplayName("Проверка московского ip")
    @Test
    void byIpMoscow() {
        Location location = geoService.byIp("172.0.32.11");

        assertEquals(Country.RUSSIA, location.getCountry());
        assertEquals("Moscow", location.getCity());
        assertEquals("Lenina", location.getStreet());
    }

    @DisplayName("Проверка нью-йорского ip")
    @Test
    void byIpNewYork(){
        Location location = geoService.byIp("96.30.172.312");

        assertEquals(Country.USA, location.getCountry());
    }
}