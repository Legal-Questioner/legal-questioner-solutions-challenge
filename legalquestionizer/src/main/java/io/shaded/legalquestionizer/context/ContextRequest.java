package io.shaded.legalquestionizer.context;

import java.util.List;

public record ContextRequest(String question, List<String> contents) {
}
