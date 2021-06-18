import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * This is a Project Management System for a structural engineering firm called
 * "Poised". Poised does the engineering needed to ensure the structural
 * integrity of various buildings. They want a Java program that they can use to
 * keep track of the many projects on which they work.
 * 
 * @author Nada
 *
 */
public class Main {
	/**
	 * Initializes the menu for the application
	 */
	public int menu;
	/**
	 * Initializes the project list
	 */
	public static Project[] projectList = new Project[500];
	/**
	 * Sets the counter for projects in the list to zero
	 */
	public static int projCount = 0;
	/**
	 * Sets the boolean value for checking if digits are in the mobile number input
	 */
	public boolean isNumber = false;

	/**
	 * Constructor for creating a new project
	 */
	public static void newProject() {
		String structType;
		String structAddress;
		String erfNum;
		String custFirstName;
		String custLastName;
		String custPhone;
		String custEmail;
		String custAddress;
		String contFirstName;
		String contLastName;
		String contPhone;
		String contEmail;
		String contAddress;
		String archFirstName;
		String archLastName;
		String archPhone;
		String archEmail;
		String archAddress;
		double invTotal = 0;
		String dueD;
		Scanner input = new Scanner(System.in);

		// Asks user for the information required to create a new project
		System.out.print("Project Name: ");
		String projName = input.nextLine();

		// Checks that Structure Type input is not empty
		while (true) {
			System.out.print("Structure Type: ");
			structType = input.nextLine();
			if (structType != null && !structType.isEmpty()) {
				break;
			} else {
				System.out.println("This is a required field.");
			}
		}
		// Checks that Structure Address input is not empty
		while (true) {
			System.out.print("Structure Address: ");
			structAddress = input.nextLine();
			if (structAddress != null && !structAddress.isEmpty()) {
				break;
			} else {
				System.out.println("This is a required field.");
			}
		}
		// Checks that ERF input is not empty
		while (true) {
			System.out.print("ERF Number: ");
			erfNum = input.nextLine();
			if (erfNum != null && !erfNum.isEmpty()) {
				break;
			} else {
				System.out.println("This is a required field.");
			}
		}
		// Checks that the user has input a valid date
		while (true) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
			sdf.setLenient(false);
			System.out.print("Due Date (dd/mm/yyy): ");
			dueD = input.nextLine();
			try {
				sdf.parse(dueD);
				break;
			} catch (Exception e) {
				System.out.println(dueD + " is not a valid Date");
			}
		}
		// Checks that the user enters numbers and not letters
		while (true) {
			try {
				System.out.print("Invoice Total: R ");
				input = new Scanner(System.in);
				invTotal = input.nextDouble();
				break;
			} catch (Exception e) {
				System.out.println("Please enter a numerical value.");
			}
		}

		// Adds all the contact details for Customer
		System.out.println("\nAdd Customer\n--------------------------------");
		String clearline = input.nextLine();

		// Checks that First Name input is not empty
		while (true) {
			System.out.print("First Name: ");
			custFirstName = input.nextLine();
			if (custFirstName != null && !custFirstName.isEmpty()) {
				break;
			} else {
				System.out.println("This is a required field.");
			}
		}
		// Checks that Last Name input is not empty
		while (true) {
			System.out.print("Last Name: ");
			custLastName = input.nextLine();
			if (custLastName != null && !custLastName.isEmpty()) {
				break;
			} else {
				System.out.println("This is a required field.");
			}
		}
		// Checks that the user enters 10 digits and no chars
		while (true) {
			System.out.print("Mobile Number: ");
			custPhone = input.nextLine();
			if (isNumber(custPhone) && (custPhone.length() == 10)) {
				break;
			} else {
				System.out.println("Please enter 10 digits.");
			}
		}
		// Checks that Email input is not empty
		while (true) {
			System.out.print("Email: ");
			custEmail = input.nextLine();
			if (custEmail != null && !custEmail.isEmpty()) {
				break;
			} else {
				System.out.println("This is a required field.");
			}
		}
		// Checks that Address input is not empty
		while (true) {
			System.out.print("Address: ");
			custAddress = input.nextLine();
			if (custAddress != null && !custAddress.isEmpty()) {
				break;
			} else {
				System.out.println("This is a required field.");
			}
		}
		// Creates new customer
		Person customer = new Person(custFirstName, custLastName, custPhone, custEmail, custAddress);

		// Adds all the contact details for Contractor
		System.out.println("\nAdd Contractor\n--------------------------------");

		// Checks that First Name input is not empty
		while (true) {
			System.out.print("First Name: ");
			contFirstName = input.nextLine();
			if (contFirstName != null && !contFirstName.isEmpty()) {
				break;
			} else {
				System.out.println("This is a required field.");
			}
		}
		// Checks that Last Name input is not empty
		while (true) {
			System.out.print("Last Name: ");
			contLastName = input.nextLine();
			if (contLastName != null && !contLastName.isEmpty()) {
				break;
			} else {
				System.out.println("This is a required field.");
			}
		}
		// Checks that the user enters 10 digits and no chars
		while (true) {
			System.out.print("Mobile Number: ");
			contPhone = input.nextLine();
			if (isNumber(contPhone) && (contPhone.length() == 10)) {
				break;
			} else {
				System.out.println("Please enter 10 digits.");
			}
		}
		// Checks that Email input is not empty
		while (true) {
			System.out.print("Email: ");
			contEmail = input.nextLine();
			if (contEmail != null && !contEmail.isEmpty()) {
				break;
			} else {
				System.out.println("This is a required field.");
			}
		}
		// Checks that Address input is not empty
		while (true) {
			System.out.print("Address: ");
			contAddress = input.nextLine();
			if (contAddress != null && !contAddress.isEmpty()) {
				break;
			} else {
				System.out.println("This is a required field.");
			}
		}
		// Creates new contractor
		Person contractor = new Person(contFirstName, contLastName, contPhone, contEmail, contAddress);

		// Adds all the contact details for Architect
		System.out.println("\nAdd Architect\n--------------------------------");
		// Checks that First Name input is not empty
		while (true) {
			System.out.print("First Name: ");
			archFirstName = input.nextLine();
			if (archFirstName != null && !archFirstName.isEmpty()) {
				break;
			} else {
				System.out.println("This is a required field.");
			}
		}
		// Checks that Last Name input is not empty
		while (true) {
			System.out.print("Last Name: ");
			archLastName = input.nextLine();
			if (archLastName != null && !archLastName.isEmpty()) {
				break;
			} else {
				System.out.println("This is a required field.");
			}
		}
		// Checks that the user enters 10 digits and no chars
		while (true) {
			System.out.print("Mobile Number: ");
			archPhone = input.nextLine();
			if (isNumber(archPhone) && (archPhone.length() == 10)) {
				break;
			} else {
				System.out.println("Please enter 10 digits.");
			}
		}
		// Checks that Email input is not empty
		while (true) {
			System.out.print("Email: ");
			archEmail = input.nextLine();
			if (archEmail != null && !archEmail.isEmpty()) {
				break;
			} else {
				System.out.println("This is a required field.");
			}
		}
		// Checks that Address input is not empty
		while (true) {
			System.out.print("Address: ");
			archAddress = input.nextLine();
			if (archAddress != null && !archAddress.isEmpty()) {
				break;
			} else {
				System.out.println("This is a required field.");
			}
		}
		// Creates new architect
		Person architect = new Person(archFirstName, archLastName, archPhone, archEmail, archAddress);

		String projStatus = "In Progress";

		// Adds a new project to the projectList
		projectList[projCount] = new Project(projName, structType, structAddress, erfNum, dueD, projStatus, invTotal,
				customer, contractor, architect);

		// Writes the projects to projects.txt file
		writeProjectToFile(projName, structType, structAddress, erfNum, dueD, projStatus, invTotal, custFirstName,
				custLastName, custPhone, custEmail, custAddress, contFirstName, contLastName, contPhone, contEmail,
				contAddress, archFirstName, archLastName, archPhone, archEmail, archAddress);

		// Increments the project counter
		projCount += 1;
	}

	/**
	 * This is the main method for running the application
	 * @param args
	 */
	public static void main(String[] args) {
		int menu = 0;
		System.out.println("POISED\nProject Management System");

		// Reads the projects from projects.txt file
		readsProjectFromFile();

		do {
			try {
				Scanner input = new Scanner(System.in);

				System.out.println("\nMain Menu\n--------------------------------");
				// The mainMenu() method displays all the menu items for the main menu of the
				// system
				menu = mainMenu(input);

				switch (menu) {
				case 1:
					System.out.print("\nAdd New Project\n--------------------------------\n");
					// The newProject() method creates a new project
					newProject();
					break;

				case 2:
					System.out.println("\nSearch\n--------------------------------");
					String findProj = null;

					// Asks user to input the project name or ID to search for existing project
					System.out.print("Enter ID or Project Name: ");
					findProj = input.next();

					// Loops through the list of projects
					for (int i = 0; i < projectList.length; i++) {
						// Checks if the project name or ID is valid
						if (projectList[i].getProjName().equalsIgnoreCase(findProj)
								|| projectList[i].getProjId().equalsIgnoreCase(findProj)) {

							while (menu != 6) {
								System.out.println("\nProject: " + projectList[i].getProjId()
										+ "\n--------------------------------");
								// Displays the menu items for the Selected Project
								menu = projectMenu(input);

								switch (menu) {
								case 1:
									// Prints out the selected project
									System.out.println(projectList[i]);
									break;

								case 2:
									System.out.println("\nAdd Payment\n--------------------------------");
									// Displays the current invoice total and amount owed to the user
									System.out.print("Invoice Total: "
											+ projectList[i].fmt.format(projectList[i].getInvTotal()));
									System.out.print("\nAmount Owed: "
											+ projectList[i].fmt.format(projectList[i].getInvBalance()));

									// Checks that the user inputs numbers and not letters
									while (true) {
										try {
											input = new Scanner(System.in);

											// Asks user to input a new payment amount
											System.out.print("\nEnter payment amount: R ");
											double userInputDbl = input.nextDouble();
											double payment = userInputDbl;

											// invBalance = invBalance - payment for the current project in the
											// newProject
											projectList[i].invPayment(payment);
											break;

										} catch (Exception e) {
											System.out.println("Please enter a numerical value.");
										}
									}

									// Prints out new balance
									System.out.println("\nNew Balance: "
											+ projectList[i].fmt.format(projectList[i].getInvBalance()));
									input.nextLine();
									break;

								case 3:
									System.out.println("\nEdit Due Date\n--------------------------------");
									// Displays the current due date
									System.out.print("Current due date: " + projectList[i].getDueD());

									// Checks that the new date is in the correct format
									while (true) {
										SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
										sdf.setLenient(false);

										// Asks user to input a new due date
										System.out.print("\nNew Due Date (dd/mm/yyy): ");
										String dueD = input.nextLine();

										try {
											sdf.parse(dueD);
											// Updates dueDate() with the new user input
											projectList[i].setDueD(dueD);
											System.out.print("\nSuccessfully updated to " + dueD + "\n");
											break;
										} catch (Exception e) {
											System.out.println(dueD + " is not a valid Date");
										}
									}
									break;

								case 4:
									while (menu != 2) {
										System.out.println("\nSet Project Status\n--------------------------------");
										// The projectStatusMenu() method displays all the menu items update the Project
										// Status
										menu = projectStatusMenu(input);

										switch (menu) {
										case 1:
											// Sets the currently selected project status to "Finalized on todayD"
											// and generates invoice if invBalance > 0
											projectList[i].makeFinal();
											System.out.print(
													"\nProject set to: " + projectList[i].getProjStatus() + "\n");

											if (projectList[i].getInvBalance() > 0) {
												projectList[i].getInvBalance();

												// If amount owed > 0 it prints invoice to a text file
												writeInvoiceToFile(i);

												// Writes the finalized project to completed-project.txt file
												writeCompletedProjToFile(i);

											} else {
												projectList[i].getInvBalance();
											}
											break;

										case 2:
											// Sets the currently selected project's status to "In Progress"
											projectList[i].makeInProg();
											System.out.print(
													"\nProject status: " + projectList[i].getProjStatus() + "\n");
											break;

										default:
											System.out.println(menu + " is an invalid entry. Please try again.");
										}
										break;
									}
									break;

								case 5:
									while (menu != 4) {
										// Person Contact Editing section
										System.out.println("\nEdit Contacts\n--------------------------------");
										menu = personMenu(input);

										switch (menu) {
										case 1:
											while (menu != 6) {
												System.out.println(
														"\nCustomer Contact Details\n--------------------------------");
												// This method displays all the menu items to update Customer details
												menu = updateCustomerMenu(input);

												// This method contains the switch menu items for customer
												customerSwitchCase(menu, input, i);
											}
											break;

										case 2:
											while (menu != 6) {
												System.out.println(
														"\nContractor Contact Details\n--------------------------------");
												// This method displays all the menu items to update Contractor details
												menu = updateContractorMenu(input);

												// This method contains the switch menu items for contractor
												contractorSwitchCase(menu, input, i);
											}
											break;

										case 3:
											while (menu != 6) {
												System.out.println(
														"\nArchitect Contact Details\n--------------------------------");
												// This method displays all the menu items to update Architect details
												menu = updateArchitectMenu(input);

												// This method contains the switch menu items for architect
												architectSwitchCase(menu, input, i);
											}
											break;

										case 4:
											break;

										default:
											System.out.println(menu + " is an invalid entry. Please try again.");
										}
									}
									break;

								case 6:
									break;

								default:
									System.out.println(menu + " is an invalid entry. Please try again.");
								}
							}
							break;
						}
					}
					break;

				case 3:
					while (menu != 4) {
						System.out.println("\nReports\n--------------------------------");
						boolean noProjects = true;
						boolean noIncomplete = true;
						boolean noOverdue = true;

						// The projectReportsMenu() method displays the menu items to view reports
						menu = projectReportsMenu(input);

						switch (menu) {
						case 1:
							System.out.println("\nAll Projects List\n--------------------------------");
							System.out.println("View full individual project details in 'Search' section\n");
							// Loops through project list
							for (int i = 0; i < projectList.length; i++) {

								if (projectList[i] != null) {
									noProjects = false;
									// Prints out the full list of all projects
									System.out.println("ID: " + projectList[i].getProjId() + " | Project Name: "
											+ projectList[i].getProjName() + " | Project Status: "
											+ projectList[i].getProjStatus() + " | Structure Type: "
											+ projectList[i].getStructType() + " | Due Date: "
											+ projectList[i].getDueD() + " | Total Owed: "
											+ projectList[i].fmt.format(projectList[i].getInvBalance()));
								}
							}
							if (noProjects == true) {
								System.out.println("No projects.");
							}
							break;

						case 2:
							System.out.println("\nIncomplete Project List\n--------------------------------");
							System.out.println("View full individual project details in Search section\n");
							// Loops through project list
							for (int i = 0; i < projectList.length; i++) {
								if (projectList[i] != null) {
									noIncomplete = false;

									// Checks if the status is finalized, if not then prints out the list
									if (projectList[i].isFinalised() == false) {
										// If the project is completed then it print out the row
										System.out.println("ID: " + projectList[i].getProjId() + " | Project Name: "
												+ projectList[i].getProjName() + " | Project Status: "
												+ projectList[i].getProjStatus() + " | Structure Type: "
												+ projectList[i].getStructType() + " | Due Date: "
												+ projectList[i].getDueD() + " | Total Owed: "
												+ projectList[i].fmt.format(projectList[i].getInvBalance()));
									}
								}
							}
							if (noIncomplete == true) {
								System.out.println("No incomplete projects.");
							}
							break;

						case 3:
							System.out.println("\nOverdue Project List\n--------------------------------");
							System.out.println("View full individual project details in Search section\n");
							// Loops through project list
							for (int i = 0; i < projectList.length; i++) {

								if (projectList[i] != null) {
									noOverdue = false;

									// Converts the input string date into date format
									Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(projectList[i].getDueD());

									// Gets todays date
									Date date2 = new Date();

									// Compares the dates to see if dueD is before or after today's date
									if (date1.compareTo(date2) == -1 || date1.compareTo(date2) == 0) {
										projectList[i].setOverdue(true);

										// If the project is overdue then it print out the row
										System.out.println("ID: " + projectList[i].getProjId() + " | Project Name: "
												+ projectList[i].getProjName() + " | Project Status: "
												+ projectList[i].getProjStatus() + " | Structure Type: "
												+ projectList[i].getStructType() + " | Due Date: "
												+ projectList[i].getDueD() + " | Total Owed: "
												+ projectList[i].fmt.format(projectList[i].getInvBalance()));
									}
								}
							}
							if (noOverdue == true) {
								System.out.println("No overdue projects.");
							}
							break;

						case 4:
							break;

						default:
							System.out.println(menu + " is an invalid entry. Please try again.");
						}
					}
					break;

				case 4:
					// Quits the program
					System.out.println("\nExiting program...");

					// Clear the current project.txt
					PrintWriter pw = new PrintWriter("projects.txt");
					pw.close();

					// Save the projects back to projects.txt in case there were any updates.
					for (int i = 0; i < projectList.length; i++) {

						if (projectList[i] != null) {
							writeProjectToFile(projectList[i].getProjName(), projectList[i].getStructType(),
									projectList[i].getStructAddress(), projectList[i].getErfNum(),
									projectList[i].getDueD(), projectList[i].getProjStatus(),
									projectList[i].getInvTotal(), projectList[i].getCustomer().getFirstName(),
									projectList[i].getCustomer().getLastName(), projectList[i].getCustomer().getPhone(),
									projectList[i].getCustomer().getEmail(), projectList[i].getCustomer().getAddress(),
									projectList[i].getContractor().getFirstName(),
									projectList[i].getContractor().getLastName(),
									projectList[i].getContractor().getPhone(),
									projectList[i].getContractor().getEmail(),
									projectList[i].getContractor().getAddress(),
									projectList[i].getArchitect().getFirstName(),
									projectList[i].getArchitect().getLastName(),
									projectList[i].getArchitect().getPhone(), projectList[i].getArchitect().getEmail(),
									projectList[i].getArchitect().getAddress());
						}
					}
					System.exit(0);
					break;

				default:
					System.out.println(menu + " is an invalid entry. Please try again.");
				}

			} catch (Exception e) {
				System.out.println("Invalid entry. Please try again.");
			}

		} while (true);

	}

	/**
	 * This method creates a new file and then writes the completed project data and
	 * appends to the list
	 * 
	 * @param i
	 */
	private static void writeCompletedProjToFile(int i) {
		try {
			BufferedWriter myWriter = new BufferedWriter(new FileWriter("completed-project.txt", true));
			String projLine = projectList[i].toString();
			myWriter.write(projLine);
			myWriter.close();
			System.out.println("Saved project to completed-project.txt");

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	/**
	 * This method creates a new file and then writes the invoice data and appends
	 * to the list
	 * 
	 * @param i
	 */
	private static void writeInvoiceToFile(int i) {
		try {
			BufferedWriter myWriter = new BufferedWriter(new FileWriter("invoice.txt", true));
			String invLine = projectList[i].inv();
			myWriter.write(invLine);
			myWriter.close();
			System.out.println("Saved invoice to invoice.txt");

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	/**
	 * This method reads the projects.txt to get all the info for each project
	 * 
	 * @throws NumberFormatException
	 */
	private static void readsProjectFromFile() throws NumberFormatException {
		String[] proj = new String[22];
		try {
			BufferedReader br = new BufferedReader(new FileReader("projects.txt"));
			String line;
			// read the file content line by line
			while ((line = br.readLine()) != null) {
				// Splits the items with hash
				proj = line.split("#");
				projectList[projCount] = new Project(proj[0], proj[1], proj[2], proj[3], proj[4], proj[5],
						Double.parseDouble(proj[6]), new Person(proj[7], proj[8], proj[9], proj[10], proj[11]),
						new Person(proj[12], proj[13], proj[14], proj[15], proj[16]),
						new Person(proj[17], proj[18], proj[19], proj[20], proj[21]));
				projCount++;
			}
			br.close();
		} catch (IOException ioe) {
			System.err.println("IOException: " + ioe.getMessage());
		}
	}

	/**
	 * This method writes a project with all required parameters to text file -
	 * projects.txt
	 * 
	 * @param projName
	 * @param structType
	 * @param structAddress
	 * @param erfNum
	 * @param dueD
	 * @param projStatus
	 * @param invTotal
	 * @param custFirstName
	 * @param custLastName
	 * @param custPhone
	 * @param custEmail
	 * @param custAddress
	 * @param contFirstName
	 * @param contLastName
	 * @param contPhone
	 * @param contEmail
	 * @param contAddress
	 * @param archFirstName
	 * @param archLastName
	 * @param archPhone
	 * @param archEmail
	 * @param archAddress
	 * 
	 */
	private static void writeProjectToFile(String projName, String structType, String structAddress, String erfNum,
			String dueD, String projStatus, double invTotal, String custFirstName, String custLastName,
			String custPhone, String custEmail, String custAddress, String contFirstName, String contLastName,
			String contPhone, String contEmail, String contAddress, String archFirstName, String archLastName,
			String archPhone, String archEmail, String archAddress) {
		// Writes the projects to projects.txt file
		try {
			BufferedWriter myWriter = new BufferedWriter(new FileWriter("projects.txt", true));
			// Add all the string items for the project
			myWriter.write(projName + "#" + structType + "#" + structAddress + "#" + erfNum + "#" + dueD + "#"
					+ projStatus + "#" + invTotal + "#" + custFirstName + "#" + custLastName + "#" + custPhone + "#"
					+ custEmail + "#" + custAddress + "#" + contFirstName + "#" + contLastName + "#" + contPhone + "#"
					+ contEmail + "#" + contAddress + "#" + archFirstName + "#" + archLastName + "#" + archPhone + "#"
					+ archEmail + "#" + archAddress);
			myWriter.newLine();
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	/**
	 * The mainMenu() method holds the Main menu options
	 * 
	 * @param input
	 * @return
	 */
	private static int mainMenu(Scanner input) {
		int menu;
		System.out.print("1 - Add Project \n");
		System.out.print("2 - Search/Edit\n");
		System.out.print("3 - Reports\n");
		System.out.print("4 - Exit\n");
		System.out.print("Enter your selection: ");
		menu = input.nextInt();
		input.nextLine();
		return menu;
	}

	/**
	 * The projectMenu() method holds the Project specific menu displayed after
	 * search success
	 * 
	 * @param input
	 * @return
	 */
	private static int projectMenu(Scanner input) {
		int menu;
		System.out.print("1 - View Project\n");
		System.out.print("2 - Add Payment\n");
		System.out.print("3 - Edit Due Date\n");
		System.out.print("4 - Project Status\n");
		System.out.print("5 - Edit Contact Details\n");
		System.out.print("6 - Main Menu\n");
		System.out.print("Enter your selection: ");
		menu = input.nextInt();
		input.nextLine();
		return menu;
	}

	/**
	 * This method displays the edit person contact details menu items
	 * 
	 * @param input
	 * @return
	 */
	private static int personMenu(Scanner input) {
		int menu;
		System.out.print("1 - Edit Customer\n");
		System.out.print("2 - Edit Contractor\n");
		System.out.print("3 - Edit Architect\n");
		System.out.print("4 - Back\n");
		System.out.print("Enter your selection: ");
		menu = input.nextInt();
		input.nextLine();
		return menu;
	}

	/**
	 * The updateCustomerMenu() method displays the Customer contact update menu
	 * 
	 * @param input
	 * @return
	 */
	private static int updateCustomerMenu(Scanner input) {
		return updatePersonInput(input);
	}

	/**
	 * The updateContractorMenu() method displays the Contractor contact update menu
	 * 
	 * @param input
	 * @return
	 */
	private static int updateContractorMenu(Scanner input) {
		return updatePersonInput(input);
	}

	/**
	 * The updateArchitectMenu() method displays the Architect contact update menu
	 * 
	 * @param input
	 * @return
	 */
	private static int updateArchitectMenu(Scanner input) {
		return updatePersonInput(input);
	}

	/**
	 * The projectStatusMenu() method displays the Project status menu options
	 * 
	 * @param input
	 * @return
	 */
	private static int projectStatusMenu(Scanner input) {
		int menu;
		System.out.print("1 - Finalised \n");
		System.out.print("2 - In Progress\n");
		System.out.print("Enter your selection: ");
		String in = input.nextLine();
		menu = Integer.valueOf(in);
		return menu;
	}

	/**
	 * The updatePersonInput() method displays the menu options for generic contact
	 * input details for updating a contact
	 * 
	 * @param input
	 * @return
	 */
	private static int updatePersonInput(Scanner input) {
		int menu;
		System.out.print("1 - Update First Name\n");
		System.out.print("2 - Update Last Name\n");
		System.out.print("3 - Update Mobile Number\n");
		System.out.print("4 - Update Email\n");
		System.out.print("5 - Update Address\n");
		System.out.print("6 - Back\n");
		System.out.print("Enter your selection: ");
		String in = input.nextLine();
		menu = Integer.valueOf(in);
		return menu;
	}

	/**
	 * The projectReportsMenu() method displays the Project lists options
	 * 
	 * @param input
	 * @return
	 */
	private static int projectReportsMenu(Scanner input) {
		int menu;
		System.out.print("1 - All Projects\n");
		System.out.print("2 - Incomplete Projects\n");
		System.out.print("3 - Overdue Projects\n");
		System.out.print("4 - Main Menu\n");
		System.out.print("Enter your selection: ");
		String in = input.nextLine();
		menu = Integer.valueOf(in);
		return menu;
	}

	/**
	 * The customerSwitchCase() method holds all the switch menu cases for editing
	 * the Customer Contact Details
	 * 
	 * @param menu
	 * @param input
	 * @param i
	 */
	private static void customerSwitchCase(int menu, Scanner input, int i) {
		switch (menu) {
		case 1:
			// Update first name
			while (true) {
				System.out.print("\nUpdate First Name: ");
				String firstName = input.nextLine();
				if (firstName != null && !firstName.isEmpty()) {
					projectList[i].getCustomer().setFirstName(firstName);
					break;
				} else {
					System.out.println("This is a required field.");
				}
			}
			break;

		case 2:
			while (true) {
				System.out.print("\nUpdate Last Name: ");
				String lastName = input.nextLine();
				if (lastName != null && !lastName.isEmpty()) {
					projectList[i].getCustomer().setLastName(lastName);
					break;
				} else {
					System.out.println("This is a required field.");
				}
			}
			break;

		case 3:
			// Update phone
			while (true) {
				System.out.print("\nUpdate Mobile Number: ");
				String phone = input.nextLine();
				if (isNumber(phone) && (phone.length() == 10)) {
					projectList[i].getCustomer().setPhone(phone);
					break;
				} else {
					System.out.println("Please enter 10 digits.");
				}
			}
			break;

		case 4:
			// Update email
			while (true) {
				System.out.print("\nUpdate Email: ");
				String email = input.nextLine();
				if (email != null && !email.isEmpty()) {
					projectList[i].getCustomer().setEmail(email);
					break;
				} else {
					System.out.println("This is a required field.");
				}
			}
			break;

		case 5:
			// Update address
			while (true) {
				System.out.print("\nUpdate Address: ");
				String address = input.nextLine();
				if (address != null && !address.isEmpty()) {
					projectList[i].getCustomer().setAddress(address);
					break;
				} else {
					System.out.println("This is a required field.");
				}
			}
			break;

		case 6:
			break;

		default:
			System.out.println(menu + " is not a valid Menu option. Please try again.");
		}
	}

	/**
	 * The contractorSwitchCase() method holds all the switch menu cases for editing
	 * the Contractor Contact Details
	 * 
	 * @param menu
	 * @param input
	 * @param i
	 */
	private static void contractorSwitchCase(int menu, Scanner input, int i) {
		switch (menu) {
		case 1:
			// Update first name
			System.out.print("\nUpdate First Name: ");
			String firstName = input.nextLine();
			projectList[i].getContractor().setFirstName(firstName);
			break;

		case 2:
			// Update last name
			System.out.print("\nUpdate Last Name: ");
			String lastName = input.nextLine();
			projectList[i].getContractor().setLastName(lastName);
			break;

		case 3:
			// Update phone
			while (true) {
				System.out.print("\nUpdate Mobile Number: ");
				String phone = input.nextLine();
				if (isNumber(phone) && (phone.length() == 10)) {
					projectList[i].getCustomer().setPhone(phone);
					break;
				} else {
					System.out.println("Please enter 10 digits.");
				}
			}
			break;

		case 4:
			// Update email
			System.out.print("\nUpdate Email: ");
			String email = input.nextLine();
			projectList[i].getContractor().setEmail(email);
			break;

		case 5:
			// Update address
			System.out.print("\nUpdate Address: ");
			String address = input.nextLine();
			projectList[i].getContractor().setAddress(address);
			break;

		case 6:
			break;

		default:
			System.out.println(menu + " is not a valid Menu option. Please try again.");
		}
	}

	/**
	 * The architectSwitchCase() method holds all the switch menu cases for editing
	 * the Architect Contact Details
	 * 
	 * @param menu
	 * @param input
	 * @param i
	 */
	private static void architectSwitchCase(int menu, Scanner input, int i) {
		switch (menu) {
		case 1:
			// Update first name
			System.out.print("\nUpdate First Name: ");
			String firstName = input.nextLine();
			projectList[i].getArchitect().setFirstName(firstName);
			break;

		case 2:
			// Update last name
			System.out.print("\nUpdate Last Name: ");
			String lastName = input.nextLine();
			projectList[i].getArchitect().setLastName(lastName);
			break;

		case 3:
			// Update phone
			while (true) {
				System.out.print("\nUpdate Mobile Number: ");
				String phone = input.nextLine();
				if (isNumber(phone) && (phone.length() == 10)) {
					projectList[i].getCustomer().setPhone(phone);
					break;
				} else {
					System.out.println("Please enter 10 digits.");
				}
			}
			break;

		case 4:
			// Update email
			System.out.print("\nUpdate Email: ");
			String email = input.nextLine();
			projectList[i].getArchitect().setEmail(email);
			break;

		case 5:
			// Update address
			System.out.print("\nUpdate Address: ");
			String address = input.nextLine();
			projectList[i].getArchitect().setAddress(address);
			break;

		case 6:
			break;

		default:
			System.out.println(menu + " is not a valid Menu option. Please try again.");
		}
	}

	/**
	 * This method checks to see if the user has input digits
	 * 
	 * @param userInput
	 * @return
	 */
	static boolean isNumber(String userInput) {
		try {
			Long.parseLong(userInput);
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}
}