package ex06_BinaryNumber;

import java.util.ArrayList;
import java.util.List;

public class BinaryNumber {
  
  /* 10진수 */ private int number;
  /* 2진수 */  private List<Integer> binary;
  
  
  // new BinaryNumber(32) 2진수: 100000
  public BinaryNumber(int number) {
    this.number = number;
    // binary.get(0) : 0
    // binary.get(1) : 0
    // binary.get(2) : 0
    // binary.get(3) : 0
    // binary.get(4) : 0
    // binary.get(5) : 1
    
    binary = new ArrayList<Integer>();
    if(number == 0) {
      binary.add(0);
    } else {
      while(number > 0){
        binary.add(number % 2);
        number /= 2;
      }        
    }
  }
  
    @Override
    public String toString() {
    String result = "";
    for(int i = binary.size() - 1; i >= 0; i--) {
      result += binary.get(i);
    }
    return result;
    }
}
