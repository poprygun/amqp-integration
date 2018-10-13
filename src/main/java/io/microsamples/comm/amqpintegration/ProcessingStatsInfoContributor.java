package io.microsamples.comm.amqpintegration;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProcessingStatsInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Integer> stats = new HashMap<>();
        stats.put("active", 123);
        stats.put("inactive", 456);

        builder.withDetail("processed", stats);
    }
}
