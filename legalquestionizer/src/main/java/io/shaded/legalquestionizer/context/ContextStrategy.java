package io.shaded.legalquestionizer.context;

import java.io.IOException;
import java.util.List;

public interface ContextStrategy {
  String getSimplification(String question,
                           List<String> documentTexts) throws IOException;
}
