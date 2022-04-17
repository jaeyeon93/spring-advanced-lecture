package me.jimmy.advanced;

import me.jimmy.advanced.trace.logtrace.FieldLogTrace;
import me.jimmy.advanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new FieldLogTrace();
    }
}