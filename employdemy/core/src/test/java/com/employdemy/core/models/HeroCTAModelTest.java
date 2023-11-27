package com.employdemy.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
public class HeroCTAModelTest {

    AemContext aemContext = new AemContext();
    HeroCTAModel heroCTAModel = new HeroCTAModel();

    @BeforeEach
    void setup() throws IllegalAccessException {
        FieldUtils.writeField(heroCTAModel, "heroCTAImage", "/content/image", true);
        FieldUtils.writeField(heroCTAModel, "heroCTAImageAltText", "image 1", true);
        FieldUtils.writeField(heroCTAModel, "heroCTADescription", "Description", true);
    }

    @Test
    void testGetHeroCTADescription() {
        assertEquals("Description", heroCTAModel.getHeroCTADescription());
    }

    @Test
    void testGetHeroCTAImage() {
        assertEquals("/content/image", heroCTAModel.getHeroCTAImage());
    }

    @Test
    void testGetHeroCTAImageAltText() {
        assertEquals("image 1", heroCTAModel.getHeroCTAImageAltText());
    }
}
