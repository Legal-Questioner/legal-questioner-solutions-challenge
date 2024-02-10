package io.shaded.legalquestionizer.context;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/api/query")
public class ContextController {
  private final ContextService contextService;

  public ContextController(ContextService contextService) {
    this.contextService = contextService;
  }

  @PostMapping
  public ResponseEntity<ContextResponse> getSimplification(@RequestBody ContextRequest request) throws IOException {
    String summary = contextService.getSimplification(
      request.question(),
      request.contents()
    );

    return ResponseEntity.ok(new ContextResponse(summary));
  }
}
