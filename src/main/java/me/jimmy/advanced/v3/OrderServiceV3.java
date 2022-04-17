package me.jimmy.advanced.v3;

import lombok.RequiredArgsConstructor;
import me.jimmy.advanced.trace.TraceStatus;
import me.jimmy.advanced.trace.logtrace.FieldLogTrace;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {
    private final OrderRepositoryV3 orderRepository;
    private final FieldLogTrace trace;

    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderService.orderItem()");
            orderRepository.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
