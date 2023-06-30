package com.example.demo.filter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.AbstractMatcherFilter;
import ch.qos.logback.core.spi.FilterReply;
import org.slf4j.MDC;

public class PortFilterNull extends AbstractMatcherFilter<ILoggingEvent> {
    @Override
    public FilterReply decide(ILoggingEvent event) {
        if (MDC.get("port") == null) {
            return onMatch;
        } else {
            return onMismatch;
        }
    }
}
