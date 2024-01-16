package entities;

public class Employee {

	private String name;
	protected Integer hours;
	protected Double valuePerHour;
	
	public Employee() {
	}
	
	public Employee(String name, Integer hours, Double valuePerHour) {
		this.name = name;
		this.hours = hours;
		this.valuePerHour = valuePerHour;
	}
	
	public Double payment() {
		return valuePerHour * hours;
	}
	
	public String getName() {
		return name;
	}
	
}
