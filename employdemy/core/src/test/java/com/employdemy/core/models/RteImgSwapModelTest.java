package com.employdemy.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({AemContextExtension.class,MockitoExtension.class})
public class RteImgSwapModelTest {
    
    RteImgSwapModel rteimg=new RteImgSwapModel();
    
    @BeforeEach
    void setup() throws IllegalAccessException {
        FieldUtils.writeField(rteimg, "direction", "left", true);
        FieldUtils.writeField(rteimg, "image", "/content/image", true);
        FieldUtils.writeField(rteimg, "imgRte", "<h1>image rte</h1>", true);
    }

    @Test
    void testGetdirection() {
        assertEquals("left", rteimg.getDirection());
    }

    @Test
    void testGetimage() {
        assertEquals("/content/image", rteimg.getImage());
    }

    @Test
    void testGetimgRte() {
        assertEquals("<h1>image rte</h1>", rteimg.getImgRte());
    }
    
}
