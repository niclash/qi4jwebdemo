package org.hedhman.qi4jwebdemo.model.person;

import org.apache.polygene.api.property.Property;

import java.time.LocalDate;

public interface Person
{
    Property<String> name();

    Property<LocalDate> birthDate();
}
