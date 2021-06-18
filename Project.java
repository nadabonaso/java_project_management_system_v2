import java.text.*;
import java.time.LocalDate;

/**
 * This is the project class which holds all the information to create a new
 * project object.
 * 
 * @author Nada
 *
 */
public class Project {
	// Instance variables used to create a new project.
	private static String companyName;
	private String projId;
	private String projName;
	private String structType;
	private String structAddress;
	private String erfNum;
	private String dueD;
	private String projStatus;
	private boolean finalised = false;
	private static String invNum;
	private double invTotal;
	private double invBalance = 0;
	private double payment = 0;
	private Person customer;
	private Person contractor;
	private Person architect;
	private static int id = 1000;
	private static int counter = 100;
	public LocalDate todayD = LocalDate.now();
	public NumberFormat fmt = NumberFormat.getCurrencyInstance();
	private boolean overdue = false;

	// Getters and Setters
	public String getProjId() {
		return projId;
	}

	public String getProjName() {
		return projName;
	}

	public String getStructType() {
		return structType;
	}

	public String getStructAddress() {
		return structAddress;
	}

	public String getErfNum() {
		return erfNum;
	}

	public String getDueD() {
		return dueD;
	}

	public void setDueD(String dueD) {
		this.dueD = dueD;
	}

	public String getProjStatus() {
		return projStatus;
	}

	public void setProjStatus(String projStatus) {
		this.projStatus = projStatus;
	}

	public boolean isFinalised() {
		return finalised;
	}

	public void setFinalised(boolean finalised) {
		this.finalised = finalised;
	}

	public double getInvTotal() {
		return invTotal;
	}

	public double getInvBalance() {
		return invBalance;
	}

	public Person getCustomer() {
		return customer;
	}

	public Person getContractor() {
		return contractor;
	}

	public Person getArchitect() {
		return architect;
	}

	public void setOverdue(boolean overdue) {
		this.overdue = overdue;
	}

	/**
	 * Default constructor
	 */
	public Project() {
	}

	/**
	 * These are all the elements require to add a new project
	 * 
	 * @param projName
	 * @param structType
	 * @param structAddress
	 * @param erfNum
	 * @param dueD
	 * @param projStatus
	 * @param invTotal
	 * @param customer
	 * @param contractor
	 * @param architect
	 */
	public Project(String projName, String structType, String structAddress, String erfNum, String dueD,
			String projStatus, double invTotal, Person customer, Person contractor, Person architect) {
		companyName = "Po";
		this.projName = projName;
		this.structType = structType;
		this.structAddress = structAddress;
		this.erfNum = erfNum;
		this.dueD = dueD;
		this.projStatus = projStatus;
		this.invTotal = invTotal;
		this.invBalance = invTotal;
		id++;
		projId = companyName.toUpperCase() + id; // Creates project id
		counter++;
		invNum = "INV" + counter; // Creates invoice number
		this.customer = customer;
		this.contractor = contractor;
		this.architect = architect;
		customProjName(); // Sets project name if empty
	}

	/**
	 * If the project name is empty then customProjName() will generate one
	 * combining structureType + customerLastName.
	 */
	public void customProjName() {
		if (projName.isEmpty()) {
			this.projName = getStructType() + " " + customer.getLastName();
		}
	}

	/**
	 * This is used to make a payment by checking the invoice balance and less the
	 * payment input
	 * 
	 * @param payment
	 */
	public void invPayment(double payment) {
		this.invBalance = invBalance - payment;
	}

	/**
	 * String inv() method is used to print out the invoice
	 * 
	 * @return
	 */
	public String inv() {
		String output = invNum;
		output += "\n-------------------------------";
		output += "\nDate: " + todayD;
		output += "\nTo: " + customer.getFirstName() + " " + customer.getLastName();
		output += "\nMobile Number: " + customer.getPhone();
		output += "\nEmail: " + customer.getEmail();
		output += "\nAddress: " + customer.getAddress();
		output += "\n-------------------------------";
		output += "\nTotal Owed: " + fmt.format(invBalance);
		output += "\n-------------------------------\n\n";
		return output;
	}

	/**
	 * The todayD() method gets today's date
	 * 
	 * @return
	 */
	public LocalDate todayD() {
		LocalDate date = LocalDate.now();
		date = LocalDate.now();
		return date;
	}

	/**
	 * The makeFinal() method finalizes the project and adds the date
	 */
	public void makeFinal() {
		setFinalised(true);
		setProjStatus("Finalised on " + todayD);
	}

	/**
	 * The makeInProg() method sets the project status to "In Progress"
	 */
	public void makeInProg() {
		setFinalised(false);
		setProjStatus("In Progress");
	}

	/**
	 * toString displays the Project summary when viewing it and also prints to
	 * completed-project.txt when project is finalised
	 */
	public String toString() {
		String output = "\n" + projId + "\n--------------------------------";
		output += "\nProject Name: " + projName;
		output += "\nProject Status: " + projStatus;
		output += "\nStructure Type: " + structType;
		output += "\nStructure Address: " + structAddress;
		output += "\nERF Number: " + erfNum;
		output += "\nProject Due Date: " + dueD;
		output += "\nInvoice Number: " + invNum;
		output += "\nInvoice Total: " + fmt.format(invTotal);
		output += "\nTotal Owed: " + fmt.format(invBalance);
		output += "\n\nCustomer Details\n--------------------------------";
		output += "\n" + customer;
		output += "\n\nContractor Details\n--------------------------------";
		output += "\n" + contractor;
		output += "\n\nArchitect Details\n--------------------------------";
		output += "\n" + architect + "\n\n";
		return output;
	}

}