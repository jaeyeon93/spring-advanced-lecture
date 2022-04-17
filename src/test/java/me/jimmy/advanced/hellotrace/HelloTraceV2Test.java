package me.jimmy.advanced.hellotrace;

import me.jimmy.advanced.trace.TraceStatus;
import me.jimmy.advanced.trace.hellotrace.HelloTraceV2;
import org.junit.jupiter.api.Test;

public class HelloTraceV2Test {

    @Test
    void begin_end() {
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status1 = trace.begin("hello");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "hello2");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception() {
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status = trace.begin("hello");
        trace.exception(status, new IllegalArgumentException());
    }
}
