package uas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class User {

	String id;
	String nama;
	String email;
	String pass;
	
	
	public void login(File acc, int masuk) {
		int repeat = 1;
		do {
		ArrayList<ArrayList<Object>> acclist = new ArrayList<ArrayList<Object>>();
		Scanner reader;
		reader = new Scanner(System.in);
		System.out.print("input email: ");
		String email = reader.nextLine();
		System.out.print("input password: ");
		String pass = reader.nextLine();
		
		
		try {
			reader = new Scanner(acc);
			while(reader.hasNextLine()) {
				List<Object> add_acc = new ArrayList<>();
				String data1 = reader.next();
				String data2 = reader.next();
				String data3 = reader.next();
				String data4 = reader.next();
				String data5 = reader.next();

				add_acc.add(data1);
				add_acc.add(data2);
				add_acc.add(data3);
				add_acc.add(data4);
				add_acc.add(data5);
				acclist.add((ArrayList<Object>) add_acc);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String check = "false";
		for (int i=0;i < acclist.size();i++) {	
			if(check == "true") {
				break;
			}

			for(int j=1; j< acclist.get(i).size();j++) {

				if(j==1 && acclist.get(i).get(j).equals(pass) && acclist.get(i).get(j-1).equals(email)) {
					check = "true";
					j++;
				}
				if(check == "true" && acclist.get(i).get(j).equals("customer") && masuk == 2) {
					repeat = 0;
					this.email = email;
					this.nama = ((String) acclist.get(i).get(j+1)).replace('_', ' ');
					this.id = (String) acclist.get(i).get(j+2);
					break;
				}
				if(check == "true" && acclist.get(i).get(j).equals("admin") && masuk == 1) {
					repeat = 0;
					this.email = email;
					this.nama = ((String) acclist.get(i).get(j+1)).replace('_', ' ');
					this.id = (String) acclist.get(i).get(j+2);
					break;
				}
			}
		}
		if(check == "false") {
			System.out.println("Account doesn't exists or wrong password...");
		}
		
		}while(repeat == 1);
		System.out.println("Success");
		
		System.out.println(id);
		System.out.println(nama);
		System.out.println(email);


	}
	
	public void browsing() {
		//method for browsing data
	}
	
}
