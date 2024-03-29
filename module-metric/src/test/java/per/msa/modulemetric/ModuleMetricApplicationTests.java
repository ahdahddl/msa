package per.msa.modulemetric;


import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@SpringBootTest
class ModuleMetricApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void givenGlobalRegistry_whenIncrementAnywhere_thenCounted() {
        class CountedObject {
            private CountedObject() {
                Metrics.counter("objects.instance").increment(1.0);
            }
        }
        Metrics.addRegistry(new SimpleMeterRegistry());

        Metrics.counter("objects.instance").increment();
        new CountedObject();

        Optional<Counter> counterOptional = Optional.ofNullable(Metrics.globalRegistry
                .find("objects.instance").counter());
        assertTrue(counterOptional.isPresent());
        assertEquals(2.0, counterOptional.get().count());
    }
}
