import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

public class TestListExamples {
  // Write your grading tests here!
  @Test
  public void testMerge() {

    ArrayList<String> list1 = new ArrayList<>();
    ArrayList<String> list2 = new ArrayList<>();
    list1.add("aa");
    list1.add("bb");
    list1.add("ca");
    list1.add("da");
    list1.add("db");

    list2.add("ab");
    list2.add("ba");
    list2.add("cb");
    
    ArrayList<String> result = new ArrayList<>();
    result.add("aa"); result.add("ab"); result.add("ba"); result.add("bb"); 
    result.add("ca"); result.add("cb"); result.add("da"); result.add("db");
    assertArrayEquals(result.toArray(), ListExamples.merge(list1, list2).toArray()); 
  }

  class CheckIsEvenLetters implements StringChecker {

    public boolean checkString(String s) {
      return s.length() % 2 == 0;
    }
  }

  @Test
  public void testFilter(){
    StringChecker check = new CheckIsEvenLetters();
    ArrayList<String> list1 = new ArrayList<>();
    ArrayList<String> expectedArray = new ArrayList<>();
    list1.add("apple");
    list1.add("fortnite"); expectedArray.add("fortnite");
    list1.add("123456"); expectedArray.add("123456");
    assertArrayEquals(expectedArray.toArray(), ListExamples.filter(list1, check).toArray());
  }
}
