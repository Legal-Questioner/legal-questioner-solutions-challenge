package io.shaded.legalquestionizer.documents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/api/documents")
public class DocumentController {
  private final DocumentService documentService;

  @Autowired
  public DocumentController(DocumentService documentService) {
    this.documentService = documentService;
  }

  @PostMapping
  public ResponseEntity<DocumentCreateResponse> createDocument(@RequestBody DocumentCreateRequest request) {
    Document document = documentService.createDocument(request.name(),
      request.link(),
      request.contents());
    return ResponseEntity.ok(new DocumentCreateResponse(document));
  }

  @GetMapping("/name/{id}")
  public ResponseEntity<Document> getDocumentByName(@PathVariable String id) {
    return this.documentService.getDocumentByName(id)
      .map(ResponseEntity::ok)
      .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/id/{id}")
  public ResponseEntity<Document> getDocumentByName(@PathVariable UUID id) {
    return this.documentService.getDocumentById(id)
      .map(ResponseEntity::ok)
      .orElse(ResponseEntity.notFound().build());
  }
}
