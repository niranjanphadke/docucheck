package com.samichinam.docucheck.service;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.embedding.openai.OpenAiEmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.qdrant.QdrantEmbeddingStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Manages persistence of guideline text in a Qdrant vector store.
 * Existing guidelines are replaced when new guidelines are uploaded.
 */
@Service
public class GuidelineService {

    private EmbeddingStore<TextSegment> store;
    private final EmbeddingModel embeddingModel;

    public GuidelineService() {
        this.embeddingModel = OpenAiEmbeddingModel.builder()
                .apiKey(System.getenv("OPENAI_API_KEY"))
                .build();
        this.store = QdrantEmbeddingStore.builder()
                .host("localhost")
                .port(6333)
                .collectionName("guidelines")
                .dimension(1536)
                .build();
    }

    /**
     * Replaces any existing guidelines with the provided list.
     */
    public void replaceGuidelines(List<String> guidelines) {
        this.store = QdrantEmbeddingStore.builder()
                .host("localhost")
                .port(6333)
                .collectionName("guidelines")
                .dimension(1536)
                .recreateCollection(true)
                .build();

        List<Embedding> embeddings = embeddingModel.embedAll(guidelines);
        List<TextSegment> segments = guidelines.stream()
                .map(TextSegment::from)
                .collect(Collectors.toList());
        store.addAll(embeddings, segments);
    }

    /**
     * Searches for guidelines similar to the given query text.
     */
    public List<String> search(String query) {
        Embedding queryEmbedding = embeddingModel.embed(query);
        return store.findRelevant(queryEmbedding, 5).stream()
                .map(match -> match.embedded().text())
                .collect(Collectors.toList());
    }
}
