package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> listEmployee = new ArrayList<>();

		System.out.print("Enter the number of employees: ");
		
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Employee #"+(i+1)+" data:");
			
			System.out.print("Outsourced (y/n)? ");
			String confirm = sc.next();
			
			if(!yesOrNo(confirm)) {
				Employee emp = collectInfoEmployee(sc);
				listEmployee.add(emp);
			} else {
				Employee empOutsource = collectInfoOutsourcedEmployee(sc);
				listEmployee.add(empOutsource);
			}
				
		}
		
		System.out.println("PAYMENTS:");
		
		for(Employee emp : listEmployee) {
			System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
		}
		
		sc.close();;
		
	}
	
	public static Boolean yesOrNo(String letter) {
		if(letter.equals("n")) {
			return false;
		} else {
			return true;
		}
	}
	
	public static Employee collectInfoEmployee(Scanner sc) {
		System.out.print("Name: ");
		sc.nextLine();
		String name = sc.nextLine();
		
		System.out.print("Hours: ");
		Integer hours = sc.nextInt();
		
		System.out.print("Value per hour: ");
		Double valuePerHour = sc.nextDouble();
		
		Employee employee = new Employee(name, hours, valuePerHour);
		
		return employee;
	}
	
	public static OutsourcedEmployee collectInfoOutsourcedEmployee(Scanner sc) {
		System.out.print("Name: ");
		sc.nextLine();
		String name = sc.nextLine();
		
		System.out.print("Hours: ");
		Integer hours = sc.nextInt();
		
		System.out.print("Value per hour: ");
		Double valuePerHour = sc.nextDouble();
		
		System.out.print("Additional charge: ");
		Double additionalCharge = sc.nextDouble();
		
		OutsourcedEmployee employeeOutsourced = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
		
		return employeeOutsourced;
	}

}
