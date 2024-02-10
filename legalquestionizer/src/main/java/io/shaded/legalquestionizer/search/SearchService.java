package io.shaded.legalquestionizer.search;

import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
  private final Jdbi jdbi;

  @Autowired
  public SearchService(Jdbi jdbi) {
    this.jdbi = jdbi;
  }

  /**
   * Searches both the documents and contexts to obtain the closest document's
   * links for that input
   *
   * @param input The input string form the front end.
   * @return A list of documents that are similar to that input
   */
  public List<String> search(String input) {
    // Handle the case of null input / empty string.
    if (input == null || input.isEmpty()) {
      return List.of();
    }

    return jdbi.withHandle(handle -> handle.createQuery
        ("""
          SELECT link FROM documents
          WHERE search_vector @@ plainto_tsquery(:input)
          OR contents % :input
          OR name % :input
          """)
      .bind("input", input)
      .mapTo(String.class)
      .list());
  }

  /**
   * Searches both the documents and contexts to obtain the closes document's
   * contents for that input
   *
   * @param input The input string form the front end.
   * @return A list of documents that are similar to that input
   */
  public List<String> searchForContents(String input) {
    // Handle the case of null input / empty string.
    if (input == null || input.isEmpty()) {
      return List.of();
    }

    return jdbi.withHandle(handle -> handle.createQuery
        ("""
          SELECT contents FROM documents
          WHERE search_vector @@ plainto_tsquery(:input)
          OR contents % :input
          OR name % :input
          """)
      .bind("input", input)
      .mapTo(String.class)
      .list());
  }
}
