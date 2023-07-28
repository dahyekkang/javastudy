package ex07_ScoreHandle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ScoreHandler {
  
  private List<Map<String, Object>> students;

  // new ScoreHandler()
  public ScoreHandler() {
    students = new ArrayList<Map<String,Object>>();
  }
  
  public void addScore(Map<String, Object> student) {
    students.add(student);
  }
  
  public Map<String, Number> get() {   
    int max = (int)(students.get(0).get("score"));
    for(int i = 1, length = students.size(); i < length; i++) {
      int score = (int)(students.get(i).get("score"));
      if(max < score) {
        max = score;
      }     
    }
    return max;
  }
  
  public int getMin() {
    int min = (int)(students.get(0).get("score"));
    for(int i = 1, length = students.size(); i < length; i++) {
      int score = (int)students.get(i).get("score");
      if(min > score) {
        min = score;
      }
    }
    return min;
  }
  
  
  public int getTotal() {
    int total = 0;
    for(int i = 0, length = students.size(); i < length; i++) {
      total += (int)(students.get(i).get("score"));
    }
    return total;
  }
  
  
  public double getAverage() {
    double average = 0.0;
    average = (double)getTotal()/students.size();
    return average;
  }
  
}
