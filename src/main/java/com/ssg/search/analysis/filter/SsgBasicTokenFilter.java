package com.ssg.search.analysis.filter;

import java.io.IOException;
import org.apache.lucene.analysis.TokenStream;

public class SsgBasicTokenFilter extends TokenStream {

  private KoreanBasicParser parser;

  public SsgBasicTokenFilter(TokenStream tokenStream) {
    super(tokenStream);
  }

  @Override
  public boolean incrementToken() throws IOException {
    return false;
  }
}
