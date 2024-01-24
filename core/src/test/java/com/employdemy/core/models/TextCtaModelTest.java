package com.employdemy.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({AemContextExtension.class,MockitoExtension.class})
public class TextCtaModelTest {

    AemContext aemContext=new AemContext();

    @InjectMocks
    TextCtaModel textCtaModel;

    TextCtaModel.ButtonFieldList fieldList=new TextCtaModel.ButtonFieldList();

    @BeforeEach
    void setup() throws IllegalAccessException{

        FieldUtils.writeField(textCtaModel, "heading","hello", true);
        FieldUtils.writeField(textCtaModel, "background","rgb(247,247,247)", true);
        FieldUtils.writeField(fieldList, "buttonText","CAREERS & INTERNSHIPS", true);
        FieldUtils.writeField(fieldList, "buttonUrl","/content/communities/templates/functions/forum.html", true);
    }


    @Test
    void testGetBackground() {
        assertEquals("rgb(247,247,247)",textCtaModel.getBackground());
    }

    @Test
    void testGetButtonText() {
        assertEquals("CAREERS & INTERNSHIPS",fieldList.getButtonText());
    }

    @Test
    void testGetButtonUrl() {
        assertEquals("/content/communities/templates/functions/forum.html",fieldList.getButtonUrl());
    }

    @Test
    void testGetHeading() {
        assertEquals("hello",textCtaModel.getHeading());
    }
}
