package CrestMart;

public class Manager extends Employee {

	private double yearlySalary;
	
	//Constructor Methods 
	
	public Manager(String f, String l, double S )
	{
	super (f,l);
	
	yearlySalary = S;
	
	
	}


public double pay(double weeks)
{
	double payEarned;
	
	payEarned = yearlySalary/52 * weeks;
	
	return payEarned;
}

public String toString()
{
	return(super.toString()
			+ ", Manager"
			+ "Salary:"
			+ yearlySalary);
	
}







}
