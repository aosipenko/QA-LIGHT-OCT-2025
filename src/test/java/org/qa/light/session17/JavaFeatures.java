package org.qa.light.session17;

import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

public class JavaFeatures {

    @Test
    public void testOptional() {
        String stringNull = null;
        String stringWithValue = "someValue";
        Optional<String> optionalEmpty = Optional.ofNullable(stringNull);
        Optional<String> optionalNotEmpty = Optional.ofNullable(stringWithValue);
//        System.out.println(optionalEmpty.isEmpty());
//        System.out.println(optionalNotEmpty.isEmpty());
//        System.out.println(optionalEmpty.orElse("default 1"));
//        System.out.println(optionalNotEmpty.orElse("default 2"));
        optionalEmpty.ifPresent(v -> System.out.println(v));
        optionalNotEmpty.ifPresent(this::myOwnMethod);
        List.of("a", "b", "c", "d", "e", "f").forEach(this::myOwnMethod);
    }

    @Test
    public void testInterfaceWithDefaultMethod() {
        SomeClass someClass = new SomeClass();
        someClass.methodWithDefault();
        someClass.methodWithoutDefault();
    }

    private void myOwnMethod(String s) {
        System.out.println("========================");
        System.out.println(s);
        System.out.println("========================");
    }
}
