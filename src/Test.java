import java.util.*;

public class Test {

	public static int menu() {
		System.out.println("Choose one option from following : ");
		System.out.println("1) Add a new employee.");
		System.out.println("2) Delete an employee via SSN.");
		System.out.println("3) Retrive an employee via SSN.");
		System.out.println("4) List all employees.");
		System.out.println("5) Exit.");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	public static void main(String[] args) {
		HashMap<String, Employee> employeesByKey = new HashMap<String, Employee>();
		TreeSet<Employee> employeesByName = new TreeSet<Employee>();

		int menuStore = menu();
		while (menuStore != 5) {
			System.out.println();
			switch (menuStore) {
			case 1:
				employeeInfo(employeesByKey, employeesByName);
				break;
			case 2:
				Scanner input2 = employeeDeleteInput();
				employeeDeleteRemoval(employeesByKey, employeesByName, input2);
				break;
			case 3:
				String retStr = employeeRetrievalInfo();
				employeeRetrievalCompare(employeesByKey, retStr);
				break;
			case 4:
				employeeList(employeesByName);
				break;
			case 5:
				break;
			}
			menuStore = menu();
		}
	}
	
	//----------------------------Case 1 ------------------------------------------------------------------//
	
	private static void employeeInfo(HashMap<String, Employee> employeesByKey, TreeSet<Employee> employeesByName) {
		Scanner input1 = new Scanner(System.in);

		System.out.println("Enter a SSN: ");
		String str1 = input1.nextLine();
		System.out.println("Enter Last Name: ");
		String str2 = input1.nextLine();
		System.out.println("Enter First Name: ");
		String str3 = input1.nextLine();

		employeeInfoAdd(employeesByKey, employeesByName, str1, str2, str3);
	}

	private static void employeeInfoAdd(HashMap<String, Employee> employeesByKey, TreeSet<Employee> employeesByName,
			String str1, String str2, String str3) {
		Employee newEmp = new Employee(str1, str2, str3);

		employeesByKey.put(newEmp.getSSN(), newEmp);
		employeesByName.add(newEmp);

		System.out.println();
	}

	//----------------------------Case 2 ------------------------------------------------------------------//
	
	private static Scanner employeeDeleteInput() {
		Scanner input2 = new Scanner(System.in);
		System.out.println("Please enter the SSN of the employee you wish to delete: ");
		return input2;
	}
	
	private static void employeeDeleteRemoval(HashMap<String, Employee> employeesByKey,
		TreeSet<Employee> employeesByName, Scanner input2) {
		String delStr = input2.nextLine();

		employeeDeleteCompare(employeesByKey, employeesByName, delStr);
	}
	
	private static void employeeDeleteCompare(HashMap<String, Employee> employeesByKey,
			TreeSet<Employee> employeesByName, String delStr) {
		if (employeesByKey.containsKey(delStr)) {
			employeeDeleteExist(employeesByKey, employeesByName, delStr);
		}
		else
			employeeDoesNotExist();
	}

	private static void employeeDeleteExist(HashMap<String, Employee> employeesByKey,
		TreeSet<Employee> employeesByName, String delStr) {
		Iterator<Employee> iterator = employeeDeleteIterator(employeesByKey, employeesByName, delStr);
		while (iterator.hasNext()) {
			employeeDeleteIteratorRemove(delStr, iterator);
		}
		employeeDeleteOutputResult();
	}
	
	private static Iterator<Employee> employeeDeleteIterator(HashMap<String, Employee> employeesByKey,
			TreeSet<Employee> employeesByName, String delStr) {
		employeesByKey.remove(delStr);

		Iterator<Employee> iterator;
		iterator = employeesByName.iterator();
		return iterator;
	}

	private static void employeeDeleteIteratorRemove(String delStr, Iterator<Employee> iterator) {
		Employee iterEmp = iterator.next();
		if (delStr.compareTo(iterEmp.getSSN()) == 0)
			iterator.remove();
	}
	
	private static void employeeDeleteOutputResult() {
		System.out.println("Employee removed.");
		System.out.println("");
	}

	//----------------------------Case 3 ------------------------------------------------------------------//
	
	private static String employeeRetrievalInfo() {
		Scanner input3 = new Scanner(System.in);
		System.out.println("Please enter the SSN of the employee you wish to retrive: ");
		String retStr = input3.nextLine();
		return retStr;
	}
	
	private static void employeeRetrievalCompare(HashMap<String, Employee> employeesByKey, String retStr) {
		if (employeesByKey.containsKey(retStr)) {
			employeeRetrievalExist(employeesByKey, retStr);
		} 
		else 
			employeeDoesNotExist();
	}

	private static void employeeRetrievalExist(HashMap<String, Employee> employeesByKey, String retStr) {
		Employee receivedEmployee = employeesByKey.get(retStr);
		System.out.println(receivedEmployee);
		System.out.println("");
	}
	
	private static void employeeDoesNotExist() {
		System.out.println("No such SSN.");
		System.out.println("");
	}
	
	//----------------------------Case 4------------------------------------------------------------------//
	
	private static void employeeList(TreeSet<Employee> employeesByName) {
		Iterator<Employee> iterator;
		iterator = employeesByName.iterator();

		if (employeesByName.isEmpty())
			System.out.print("List is empty.");
		else {
			employeeTreeListExist(iterator);
		}
		System.out.println("");
	}

	private static void employeeTreeListExist(Iterator<Employee> iterator) {
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}
	
}
