package org.qa.light.session21.multithread;

import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomUtils;
import org.awaitility.Awaitility;
import org.testng.annotations.Test;

import java.time.Duration;

public class AwaitilityTests {

    @SneakyThrows
    @Test
    public void testAwait() {
        Awaitility.await()
                .atMost(Duration.ofSeconds(2))
                .alias("Await for random utils to be > 90")
                .until(() -> {
                    if (RandomUtils.insecure().randomInt(0, 100) > 90) {
                        return true;
                    }
                    Thread.sleep(750);
                    return false;
                });
        System.out.println("OK");
    }
}
