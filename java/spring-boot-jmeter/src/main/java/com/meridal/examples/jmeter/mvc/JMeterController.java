package com.meridal.examples.jmeter.mvc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.meridal.examples.jmeter.domain.JMeterValue;

@Tag(name = "JMeter test endpoint", description = "An Endpoint that echoes the input with two extra random values.")
@RestController
@RequestMapping("/jmeter")
public class JMeterController {

    private static final Logger LOG = LoggerFactory.getLogger(JMeterController.class);

    @Operation(summary = "Get some values.")
    @GetMapping("/{first}/{second}/")
    public final JMeterValue get(@PathVariable final String first, @PathVariable final String second) {
        LOG.info("{} {}", first, second);
        return JMeterValue.create(first, second);
    }
}
