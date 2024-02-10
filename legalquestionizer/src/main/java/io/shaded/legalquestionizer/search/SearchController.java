package io.shaded.legalquestionizer.search;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/search")
public class SearchController {
  private final SearchService searchService;

  public SearchController(SearchService searchService) {
    this.searchService = searchService;
  }

  @PostMapping
  public ResponseEntity<SearchResponse> searchDocuments(@RequestBody SearchRequest request) {
    List<String> links = searchService.search(request.input());
    List<String> contents = searchService.searchForContents(request.input());

    return ResponseEntity.ok(new SearchResponse(links, contents));
  }
}
