package io.shaded.legalquestionizer.documents;

import java.util.UUID;

public record Document(UUID id, String name, String link, String contents) {
}
