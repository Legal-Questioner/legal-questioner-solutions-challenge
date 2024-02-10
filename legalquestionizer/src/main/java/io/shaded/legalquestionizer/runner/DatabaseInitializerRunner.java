package io.shaded.legalquestionizer.runner;

import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializerRunner implements ApplicationRunner {
  private final Jdbi jdbi;

  @Autowired
  public DatabaseInitializerRunner(Jdbi jdbi) {
    this.jdbi = jdbi;
  }

  @Override
  public void run(ApplicationArguments args) {
    jdbi.useTransaction(handle -> handle.execute(
      """
        CREATE EXTENSION IF NOT EXISTS pg_trgm;

        CREATE TABLE IF NOT EXISTS documents(
          id  UUID PRIMARY KEY,
          name VARCHAR(36) NOT NULL,
          link TEXT NOT NULL,
          contents TEXT NOT NULL,
          search_vector tsvector
        );

        CREATE INDEX IF NOT EXISTS idx_documents_search_vector ON documents USING gin(search_vector);
        """));
  }
}
