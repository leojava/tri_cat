package dev.leobrut.tri_cat;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OutputWriter {

    void write(TriangleType type) {
        log.debug("output:");
        log.info("{}", type.output);
    }

}
