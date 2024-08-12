package com.tracking.number.tracking.number.service;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@Service
public class TrackingNumberService {
    private final AtomicInteger sequence = new AtomicInteger(0);
    private final String nodeId;

    public TrackingNumberService() {
        this.nodeId = UUID.randomUUID().toString().substring(0, 8); // Unique per instance
    }

    public String generateTrackingNumber() {
        long timestamp = Instant.now().toEpochMilli();
        int sequenceNumber = sequence.getAndIncrement();
        return String.format("%s-%d-%d", nodeId, timestamp, sequenceNumber);
    }

    public Stream<String> generateMultipleTrackingNumbers(int count) {
        return Stream.generate(this::generateTrackingNumber).limit(count).parallel();
    }
}
