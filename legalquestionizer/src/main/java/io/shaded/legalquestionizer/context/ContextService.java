package io.shaded.legalquestionizer.context;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ContextService {
  private final ContextStrategy context;

  public ContextService(ContextStrategy context) {
    this.context = context;
  }

  public String getSimplification(String question, List<String> documentTexts) throws IOException {
      return context.getSimplification(question, documentTexts);
  }
}
