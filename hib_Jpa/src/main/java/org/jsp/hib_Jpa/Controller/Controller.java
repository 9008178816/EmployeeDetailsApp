package org.jsp.hib_Jpa.Controller;

import java.util.Scanner;

import org.jsp.hib_Jpa.DAO.EmployeeDAO;
import org.jsp.hib_Jpa.DTO.Employee;

public class Controller {

	static Scanner sc = new Scanner(System.in);
	static EmployeeDAO dao = new EmployeeDAO();

	public static void main(String[] args) {
		
		while (true) {
			System.out.println(
					"1. Save the employee \n2. Update the employee \n3. Find the employee By Id \n4. Delete the Employee by Id \n5. Verify the Password \n6. exit");
			int option = sc.nextInt();
			
			
			switch (option) {
			case 1: {
				save();
				break;
			}
			case 2: {
				update();
				break;
			}
			case 3: {
				findById();
				break;
			}
			case 4: {
				dltById();
				break;
			}
			case 5: {
				System.out.println(
						"Select the option \n1. Verify the id with password\n2. Verify the phone with password\n3. Verify the email with the password");
				int opt = sc.nextInt();
				switch (opt) {
				case 1: {
					verifyById();
					break;
				}
				case 2: {
					verifyByPhone();
					break;
				}
				case 3: {
					verifyByEmail();
					break;
				}
				}
			}
			case 6: {
				System.exit(0);
				break;
			}

			}
		}

	}

	public static void save() {
		System.out.println("Enter the name,phone,email,designation,salary and password to save the employee details");
		Employee e = new Employee();
		e.setName(sc.next());
		e.setPhone(sc.nextLong());
		e.setEmail(sc.next());
		e.setDesg(sc.next());
		e.setSalary(sc.nextDouble());
		e.setPassword(sc.next());
		dao.saveDetails(e);
		System.out.println("Employee details saved successfully....!!!!! \n\n\n");
	}

	public static void update() {
		System.out.println("Enter the Employee id you wish to update");
		int id = sc.nextInt();
		System.out.println("Enter the name,phone,email,designation,salary and password to update the employee details");
		Employee e = new Employee();
		e.setId(id);
		e.setName(sc.next());
		e.setPhone(sc.nextLong());
		e.setEmail(sc.next());
		e.setDesg(sc.next());
		e.setSalary(sc.nextDouble());
		e.setPassword(sc.next());
		dao.UpdateEmp(e);
		System.out.println("The employee details was updated...!!! \n\n\n");
	}

	public static void findById() {
		System.out.println("Enter the Employeee id you want to fetch the details :");
		int id = sc.nextInt();
		Employee e = dao.findById(id);
		if (e != null) {
			System.out.println("Employee Id          : "+e.getId());
			System.out.println("Employee Name        : "+e.getName());
			System.out.println("Employee Phone       : "+e.getPhone());
			System.out.println("Employee Email       : "+e.getEmail());
			System.out.println("Employee Designation : "+e.getDesg());
			System.out.println("Employee Salary      : "+e.getSalary());
			System.out.println("Employee Password    : "+e.getPassword()+"\n\n\n");
		} else {
			System.err.println("Sorry you enter the invalid id...!!!\nplease enter the valid id \n\n\n");
		}
	}

	public static void dltById() {
		System.out.println("Enter the employee's id you want to delete");
		int id = sc.nextInt();
		boolean dlt = dao.DeleteEmp(id);
		if (dlt) {
			System.out.println("Successfully employee id " + id + "was deleted ");
		} else {
			System.err.println("Sorry you have entered the invalid id...!!!\nPlease enter the valid id to delete \n\n\n");
		}
	}

	public static void verifyById() {
		System.out.println("Enter the Employee id and password to verify");
		int id = sc.nextInt();
		String pass = sc.next();
		Employee e = dao.verify(id, pass);
		if (e != null) {
			System.out.println("Verification Successful...!!! \n\n\n");
		} else {
			System.err.println("Sorry you have entered invalid id or password...!!! \n\n\n");
		}
	}

	public static void verifyByPhone() {
		System.out.println("Enter the Employee phone_number and password to verify");
		Long phone = sc.nextLong();
		String pass = sc.next();
		Employee e = dao.verify(phone, pass);
		if (e != null) {
			System.out.println("Verification Successful...!!! \n\n\n");
		} else {
			System.err.println("Sorry you have entered invalid phone_number or password...!!! \n\n\n");
		}
	}

	public static void verifyByEmail() {
		System.out.println("Enter the Employee Email and password to verify");
		String email = sc.next();
		String pass = sc.next();
		Employee e = dao.verify(email, pass);
		if (e != null) {
			System.out.println("Verification Successful...!!! \n\n\n");
		} else {
			System.err.println("Sorry you have entered invalid id or password...!!! \n\n\n");
		}
	}

}
