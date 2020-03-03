package com.ssg.search.analysis.filter;

import com.ssg.search.analysis.autocomplete.parser.KoreanChosungParser;
import java.io.IOException;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

public class SsgChosungTokenFilter extends TokenFilter {

  private KoreanChosungParser parser;
  private CharTermAttribute termAtt;

  public SsgChosungTokenFilter(TokenStream tokenStream) {
    super(tokenStream);
    this.parser = new KoreanChosungParser();
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
