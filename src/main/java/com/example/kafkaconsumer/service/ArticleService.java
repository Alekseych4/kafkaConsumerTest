package com.example.kafkaconsumer.service;

import com.example.schemas.ArticleSchema;
import org.apache.avro.generic.GenericRecord;

import java.util.Optional;

public interface ArticleService {
    void consumeArticle(ArticleSchema record);
    Optional<ArticleSchema> getPersistedArticle(String key);
}
