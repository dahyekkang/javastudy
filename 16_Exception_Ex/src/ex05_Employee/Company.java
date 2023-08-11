package ex05_Employee;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Company {

	private List<Employee> employees = new ArrayList<Employee>();
	private Scanner sc = new Scanner(System.in);
	
	public Company() {
	  
	}


  public void addEmployee() {
		System.out.println("===== 고용 =====");
		  System.out.print("고용 형태 선택(1.정규 2.프리랜서) >>> ");
		  String type = sc.next();
		  if(!type.equals("1") && !type.equals("2")) {
		    throw new RuntimeException("올바르지 않은 고용 형태입니다.");
		  }
		  System.out.print("사원 번호 입력 >>> ");
		  String empNo = sc.next();
		  System.out.print("사원명 입력 >>> ");
		  String name = sc.next();

		  try {
		    
		    // 정규직 등록
		    if(type.equals("1")) {
		      System.out.print("기본급 입력 >>> ");
		      int salary = sc.nextInt();
		      if(salary <= 0) {
		        throw new RuntimeException("기본급");
		      }
		      Regular regular = new Regular(empNo, name);
		      regular.setSalary(salary);
		      employees.add(regular);
		    }
		    
		    // 프리랜서 등록
		    if(type.equals("2")) {
		      System.out.print("시간당 임금 입력 >>> ");
		      int hourlyWage = sc.nextInt();
          if(hourlyWage <= 0) {
            throw new RuntimeException("시간당 임금");
          }
		      System.out.print("근무한 시간 입력 >>> ");
		      int workingHours = sc.nextInt();
          if(workingHours <= 0) {
            throw new RuntimeException("근무한 시간");
          }
          Freelance freelance = new Freelance(empNo, name);
          freelance.setHourlyWage(hourlyWage);
          freelance.setWorkingHours(workingHours);
          employees.add(freelance);
		    }
		    // 사원 등록 확인
		    System.out.println("사원 등록이 완료되었습니다. 현재 등록된 사원은 " + employees.size() + "명입니다.");
		    
		  } catch(InputMismatchException e) {
		    System.out.println("기본급, 시간당 금액, 근무한 시간은 모두 정수로 입력해야 합니다.");
		  } catch(RuntimeException e) {
		    System.out.println(e.getMessage() + "은 0보다 작거나 같을 수 없습니다.");
		  }
		
	}
	
	public void dropEmployee() {
		System.out.println("===== 해고 =====");
		if(employees.isEmpty()) {
		  throw new RuntimeException("등록된 사원이 없습니다.");
		}
		System.out.print("삭제할 사원번호 입력 >>> ");
		String empNo = sc.next();
		for(int i = 0, length = employees.size(); i < length; i++) {
		  if(empNo.equals(employees.get(i).getEmpNo())) {
		    System.out.println("다음 사원이 삭제되었습니다.");
		    employees.get(i).info();
		    employees.remove(i);
		    return;
		  }
		}
		throw new RuntimeException(empNo + " 사원 번호를 가진 사원은 없습니다.");
		
	}
	
	public void findEmployee() {
		System.out.println("===== 조회 =====");
		if(employees.isEmpty()) {
		  throw new RuntimeException("등록된 사원이 없습니다.");
		}
		System.out.print("조회할 사원번호 입력 >>> ");
		String empNo = sc.next();
		for(int i = 0, length = employees.size(); i < length; i++) {
		  if(empNo.equals(employees.get(i).getEmpNo())) {
		    System.out.println("사원 조회 성공!");
		    employees.get(i).info();
		    return;
		  }
		}
		throw new RuntimeException(empNo + " 사원 번호를 가진 사원은 없습니다.");
	}
	
	
	public void printAllEmployee() {
		System.out.println("===== 전체조회 =====");
		if(employees.isEmpty()) {
		  throw new RuntimeException("조회할 사원이 없습니다.");
		}
		System.out.println("전체 사원(" + employees.size() + "명)");
		System.out.println("------------------");
		int total = 0;
		for(int i = 0, length = employees.size(); i < length; i++) {
		  if(employees.get(i) instanceof Regular)
		  {
		    total += ((Regular)employees.get(i)).getSalary();
		  } else {
		    total += (((Freelance)employees.get(i)).getHourlyWage() * ((Freelance)employees.get(i)).getWorkingHours());
		  }
		  employees.get(i).info();
		  System.out.println("------------------");
		}
		System.out.println("  [사원 전체 급여:" + total + "원]");
	}
	
	public void manage() {
		System.out.println("===== 사원관리프로그램 시작 =====");
		while(true) {
			try {
				System.out.print("\n1.고용 2.해고 3.조회 4.전체조회 0.종료 >>> ");
				String choice = sc.next();
				switch(choice) {
				case "1": addEmployee(); break;
				case "2": dropEmployee(); break;
				case "3": findEmployee(); break;
				case "4": printAllEmployee(); break;
				case "0": System.out.println("===== 사원관리프로그램 종료 ====="); return;
				default: throw new RuntimeException("잘못된 요청입니다. 다시 시도하세요.");
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
}
