package uas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Customer extends User{
	
	private String id_product;
	private String status;
	private String address;
	private String postal_code;
	private String email_add;
	private int bank;
	
	public void register(File new_acc) {
		Scanner read = new Scanner(System.in);
		System.out.print("Input Nama: ");
		String in_nama = read.nextLine();
		this.nama = in_nama.replace(" ", "_");
		System.out.print("Input Email: ");
		String in_email = read.nextLine();
		this.email = in_email;
		System.out.print("Input Password: ");
		String in_pass = read.nextLine();
		this.pass = in_pass;
		
		this.status = "customer";
		Random rand = new Random();
		int id_num = rand.nextInt(99999);
		this.id = "C" + id_num;
		try {
			FileWriter new_acc2 = new FileWriter(new_acc, true);
			BufferedWriter out = new BufferedWriter(new_acc2);
			out.write("\n" + this.email + " " + this.pass + " " + this.status + " " + this.nama + " " + this.id);
			out.close();
			System.out.println("Register Successfull!...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void browsing() {
		// pick which to browse
		Scanner read = new Scanner(System.in);
		Browse opsi = new Browse();
		int loop = 1;
		int pilihan;
		String use = "customer";
		do {
			System.out.println("1. Lecture Module \n2. Previous Exam Paper \n3. Practice Paper \n4. Keluar");
			System.out.print("Pilihan[1-4]: ");
			pilihan = read.nextInt();
			
			if(pilihan == 1) {
				opsi.module(read, use);
			}
			if(pilihan == 2) {
				opsi.prev_exam(read, use);
			}
			if(pilihan == 3) {
				opsi.prac_paper(read, use);
			}
			if(pilihan == 4) {
				return;
			}
			
		}while(loop==1);
	}
	
	public void cart() {
		File keranjang = new File("keranjang.txt");
		ArrayList<ArrayList<Object>> datalist = new ArrayList<ArrayList<Object>>();
		
		try {
			Scanner read = new Scanner(keranjang);
			while(read.hasNextLine()) {
				List<Object> add_list = new ArrayList<>();
				String data1 = read.next();
				String data2 = read.next();
				String data3 = read.next();
				int data4 = read.nextInt();
				int data5 = read.nextInt();
				String data6 = read.next();
				int data7 = read.nextInt();

				add_list.add(data1);
				add_list.add(data2);
				add_list.add(data3);
				add_list.add(data4);
				add_list.add(data5);
				add_list.add(data6);
				add_list.add(data7);

				datalist.add((ArrayList<Object>) add_list);
			}
		} catch (FileNotFoundException e) {
			System.out.println("error get from file");
			e.printStackTrace();
		}
		
		for (int i=0;i < datalist.size();i++) {	
			System.out.println("No. " + (i+1));
			System.out.println("ID: " + datalist.get(i).get(0));
			String name = (String) datalist.get(i).get(1);
			System.out.println("Name: " + name.replace("_"," "));
			if(((String) datalist.get(i).get(0)).contains("M")) {
				String subject = (String) datalist.get(i).get(5);
				System.out.println("Subject: " + subject.replace("_"," "));
				System.out.println("Quantity: " + datalist.get(i).get(6));
			}
			if(((String) datalist.get(i).get(0)).contains("E")) {
				System.out.println("Quantity: " + datalist.get(i).get(6));
			}
			if(((String) datalist.get(i).get(0)).contains("P")) {
				System.out.println("Quantity: " + datalist.get(i).get(6));
			}
			System.out.println("");
		}
		
		int loop=1;
		do{
			Scanner read = new Scanner(System.in);
			System.out.print("1. Edit Quantity\n2. Cancel Order\n3. Check Out\n4. Return \nInput[1-4]: ");
			int pilihan = read.nextInt();
			if(pilihan == 1) {
				int quan;
				for (int i=0;i < datalist.size();i++) {
					System.out.print("ID: " + datalist.get(i).get(0) + ", New quantity = ");
					read = new Scanner(System.in);
					quan = read.nextInt();
					datalist.get(i).set(6, quan);
				}
			}
			else if(pilihan == 2) {
				PrintWriter delete;
				try {
					delete = new PrintWriter(keranjang);
					delete.print("");
					delete.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return;
			}
			else if(pilihan == 3) {
				int total = 0;
				int input;
				read = new Scanner(System.in);
				System.out.print("Print atau Elektronik?\nInput [1=print, 2=elektronik]: ");
				input = read.nextInt();
				
				if(input==1) {
					read = new Scanner(System.in);
					System.out.println("Insert Address: ");
					this.address = read.next();
					System.out.println("Insert Postal Code: ");
					this.postal_code = read.next();
				}
				
				if(input==2) {
					read = new Scanner(System.in);
					System.out.println("Insert Email Address: ");
					this.email_add = read.next();
				}
				
				for (int i=0;i < datalist.size();i++) {
					if(input == 1) {
						int quan = (int) datalist.get(i).get(6);
						int harga = (int) datalist.get(i).get(3);
						total = total + (quan * harga);
					}
					if(input == 2) {
						int quan = (int) datalist.get(i).get(6);
						int harga = (int) datalist.get(i).get(4);
						total = total + (quan * harga);
					}
				}
				System.out.println("Total Harga = " + total);
				read = new Scanner(System.in);
				System.out.println("Insert Bank Number for Payment: ");
				this.bank = read.nextInt();
				File record = new File("record.txt");
				Random rand = new Random();
				int id_num = rand.nextInt(99999);
				this.id_product = "T" + id_num;
				if(input == 1) {
					try {
						FileWriter new_data = new FileWriter(record, true);
						BufferedWriter output = new BufferedWriter(new_data);
						output.write("\n" + this.id_product + " " + this.address + " " + this.postal_code + " " + 
						"Rp." + total + " " + this.bank);
						
						output.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(input == 2) {
					try {
						FileWriter new_data = new FileWriter(record, true);
						BufferedWriter output = new BufferedWriter(new_data);
						output.write("\n" + this.id_product + " " + this.email_add + " " + 
						"Rp." + total + " " + this.bank);
						
						output.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				PrintWriter delete;
				try {
					delete = new PrintWriter(keranjang);
					delete.print("");
					delete.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return;
				
			}
			else if(pilihan == 4) {
				return;
			}	
			
			
		}while(loop==1);
		
	}
	
}
