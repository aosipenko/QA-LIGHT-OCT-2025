package org.qa.light.session21.junit;

import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.time.LocalDateTime;
import java.util.Random;

@Execution(ExecutionMode.CONCURRENT)
public class JUnitParallel {

    private final static Random RANDOM = new Random();

    private String s;

    @BeforeEach
    public void beforeEach() {
        System.out.println(">>>>>>" + LocalDateTime.now());
    }

    @SneakyThrows
    @Test
    public void test1(){
        Thread.sleep(RANDOM.nextInt(100));
        s = RandomStringUtils.insecure().nextAlphabetic(5);
        Thread.sleep(RANDOM.nextInt(100));
        System.out.println(s);
    }

    @SneakyThrows
    @Test
    public void test2(){
        Thread.sleep(RANDOM.nextInt(100));
        s = RandomStringUtils.insecure().nextAlphabetic(5);
        Thread.sleep(RANDOM.nextInt(100));
        System.out.println(s);
    }

    @SneakyThrows
    @Test
    public void test3(){
        Thread.sleep(RANDOM.nextInt(100));
        s = RandomStringUtils.insecure().nextAlphabetic(5);
        Thread.sleep(RANDOM.nextInt(100));
        System.out.println(s);
    }

    @SneakyThrows
    @Test
    public void test4(){
        Thread.sleep(RANDOM.nextInt(100));
        s = RandomStringUtils.insecure().nextAlphabetic(5);
        Thread.sleep(RANDOM.nextInt(100));
        System.out.println(s);
    }

    @SneakyThrows
    @Test
    public void test5(){
        Thread.sleep(RANDOM.nextInt(100));
        s = RandomStringUtils.insecure().nextAlphabetic(5);
        Thread.sleep(RANDOM.nextInt(100));
        System.out.println(s);
    }

    @SneakyThrows
    @Test
    public void test6(){
        Thread.sleep(RANDOM.nextInt(100));
        s = RandomStringUtils.insecure().nextAlphabetic(5);
        Thread.sleep(RANDOM.nextInt(100));
        System.out.println(s);
    }

    @SneakyThrows
    @Test
    public void test7(){
        Thread.sleep(RANDOM.nextInt(100));
        s = RandomStringUtils.insecure().nextAlphabetic(5);
        Thread.sleep(RANDOM.nextInt(100));
        System.out.println(s);
    }

    @SneakyThrows
    @Test
    public void test8(){
        Thread.sleep(RANDOM.nextInt(100));
        s = RandomStringUtils.insecure().nextAlphabetic(5);
        Thread.sleep(RANDOM.nextInt(100));
        System.out.println(s);
    }

    @SneakyThrows
    @Test
    public void test9(){
        Thread.sleep(RANDOM.nextInt(100));
        s = RandomStringUtils.insecure().nextAlphabetic(5);
        Thread.sleep(RANDOM.nextInt(100));
        System.out.println(s);
    }

    @SneakyThrows
    @Test
    public void test10(){
        Thread.sleep(RANDOM.nextInt(100));
        s = RandomStringUtils.insecure().nextAlphabetic(5);
        Thread.sleep(RANDOM.nextInt(100));
        System.out.println(s);
    }

    @SneakyThrows
    @Test
    public void test11(){
        Thread.sleep(RANDOM.nextInt(100));
        s = RandomStringUtils.insecure().nextAlphabetic(5);
        Thread.sleep(RANDOM.nextInt(100));
        System.out.println(s);
    }
}
