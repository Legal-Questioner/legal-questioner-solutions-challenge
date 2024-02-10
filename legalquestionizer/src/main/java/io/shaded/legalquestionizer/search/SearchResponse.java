package io.shaded.legalquestionizer.search;

import java.util.List;
import java.util.UUID;

public record SearchResponse(List<String> documentsLinks,
                             List<String> contents) {
}
