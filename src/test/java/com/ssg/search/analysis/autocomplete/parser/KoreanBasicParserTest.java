package com.ssg.search.analysis.autocomplete.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class KoreanBasicParserTest {

  KoreanBasicParser parser;
  String[] keywords;
  String[] results;

  @Before
  public void init() {
    parser = new KoreanBasicParser();
    keywords = new String[]{"우유", "테스트", "대한민국", "dndb우유", "dn123db우유"};
    results = new String[]{"ㅇㅜㅇㅠ", "ㅌㅔㅅㅡㅌㅡ", "ㄷㅐㅎㅏㄴㅁㅣㄴㄱㅜㄱ", "dndbㅇㅜㅇㅠ", "dn123dbㅇㅜㅇㅠ"};
  }

  @Test
  public void parse() {
    for (int i = 0; i < keywords.length; i++) {
      System.out.println(parser.parse(keywords[i]));
      System.out.println(results[i]);
      assertEquals(results[i], parser.parse(keywords[i]));
    }
  }
}