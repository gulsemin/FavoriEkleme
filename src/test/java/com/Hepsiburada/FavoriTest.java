package com.Hepsiburada;

import org.junit.Test;

import static org.junit.Assert.*;

public class FavoriTest extends Islemler {

    @Test
    public void login() {
        new Favori(driver).login("gulseminrisvan@gmail.com","12345g");
    }
}