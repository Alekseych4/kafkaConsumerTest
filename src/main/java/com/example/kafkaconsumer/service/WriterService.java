package com.example.kafkaconsumer.service;

import com.example.schemas.WriterSchema;
import org.apache.avro.generic.GenericRecord;

import java.util.Optional;

public interface WriterService {
    void consumeWriter(WriterSchema record);
    void updateRating(String writerId, double updatingValue);
    Optional<WriterSchema> getPersistedWriter(String key);
}
