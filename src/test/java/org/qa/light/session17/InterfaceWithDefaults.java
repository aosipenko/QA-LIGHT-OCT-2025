package org.qa.light.session17;

public interface InterfaceWithDefaults {
    default void methodWithDefault() {
        System.out.println("Default method");
    }

    void methodWithoutDefault();
}
