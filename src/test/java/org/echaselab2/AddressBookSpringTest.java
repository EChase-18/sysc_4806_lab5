package org.echaselab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

@SpringBootTest
public class AddressBookSpringTest {
    @Autowired
    private AddressBookViewController controller;

    public void testAddressBooks() throws Exception{
        assertThat(controller).isNotNull();
    }
}
