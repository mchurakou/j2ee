package com.mikalai.j2ee;


import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


@ApplicationPath("rs")
public class ApplicationConfig extends Application {

    // ======================================
    // =             Attributes             =
    // ======================================

    private final Set<Class<?>> classes;

    // ======================================
    // =            Constructors            =
    // ======================================

    public ApplicationConfig() {
        HashSet<Class<?>> c = new HashSet<>();
        c.add(BookRestService.class);

        c.add(JacksonJsonProvider.class);

        classes = Collections.unmodifiableSet(c);
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}
