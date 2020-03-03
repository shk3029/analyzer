package com.ssg.search.analysis.autocomplete.parser;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KoreanChosungParserTest {
  KoreanChosungParser parser;
  String[] keywords;
  String[] results;

  @Before
  public void init() {
    parser = new KoreanChosungParser();
    keywords = new String[]{"우유", "테스트", "대한민국", "dndb우유", "dn123db우유"};
    results = new String[]{"ㅇㅇ", "ㅌㅅㅌ", "ㄷㅎㅁㄱ", "dndbㅇㅇ", "dn123dbㅇㅇ"};
  }

  @Test
  public void parse() {
    for (int i = 0; i < keywords.length; i++) {
      assertEquals(results[i], parser.parse(keywords[i]));
    }
  }
}