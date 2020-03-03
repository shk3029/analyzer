package com.ssg.search.analysis.filter;

import com.ssg.search.analysis.autocomplete.parser.KoreanBasicParser;
import java.io.IOException;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

public class SsgBasicTokenFilter extends TokenFilter {

  private KoreanBasicParser parser;
  private CharTermAttribute termAtt;

  public SsgBasicTokenFilter(TokenStream tokenStream) {
    super(tokenStream);
    this.parser = new KoreanBasicParser();
    this.termAtt = addAttribute(CharTermAttribute.class);
  }

  @Override
  public boolean incrementToken() throws IOException {
    if (input.incrementToken()) {
      CharSequence parserdData = parser.parse(termAtt.toString());
      termAtt.setEmpty();
      termAtt.append(parserdData);
      return true;
    }

    return false;
  }
}
