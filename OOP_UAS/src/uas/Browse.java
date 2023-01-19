package uas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Browse {

	private String id;
	private String name;
	private String date;
	private int print_price;
	private int e_price;
	private String subject;
	ArrayList<ArrayList<Object>> datalist = new ArrayList<ArrayList<Object>>();

	
	public void module(Scanner read, String use) {
		File modul_data = new File("data_modul.txt");
		datalist = new ArrayList<ArrayList<Object>>();
		try {
			read = new Scanner(modul_data);
			while(read.hasNextLine()) {
				List<Object> add_list = new ArrayList<>();
				String data1 = read.next();
				String data2 = read.next();
				int data3 = read.nextInt();
				int data4 = read.nextInt();
				String data5 = read.next();


				add_list.add(data1);
				add_list.add(data2);
				add_list.add(data3);
				add_list.add(data4);
				add_list.add(data5);

				datalist.add((ArrayList<Object>) add_list);
			}
		} catch (FileNotFoundException e) {
			System.out.println("error get from file");
			e.printStackTrace();
		}
		
		int loop=1;
		do{
			read = new Scanner(System.in);
			System.out.print("1. Computer Science\n2. Math\n3. Biology\n4. Return \nInput[1-4]: ");
			int pilihan = read.nextInt();
			if(pilihan == 1) {
				this.subject = "computer_science";
				break;
			}
			else if(pilihan == 2) {
				this.subject = "math";
				break;
			}
			else if(pilihan == 3) {
				this.subject = "biology";
				break;
			}
			else if(pilihan == 4) {
				return;
			}	
			
			
		}while(loop==1);
		
		int no = 0;
		for (int i=0;i < datalist.size();i++) {	
			if(datalist.get(i).contains(subject)) {
				no++;
				this.id = (String) datalist.get(i).get(0);
				this.name = (String) datalist.get(i).get(1);
				this.print_price = (int) datalist.get(i).get(2);
				this.e_price = (int) datalist.get(i).get(3);
				this.subject = (String) datalist.get(i).get(4);
				
				System.out.println(no + ".");
				System.out.println("ID: " + this.id);
				System.out.println("Name: " + this.name);
				System.out.println("Harga Print: " + this.print_price);
				System.out.println("Harga Elektronik: " + this.e_price);
			}
		}
		
		int pilihan;
		do{
			read = new Scanner(System.in);
			System.out.print("1. Add, 2. Return" + "\n" + "Input[1 - 2]: ");
			pilihan = read.nextInt();
			
			
			if(pilihan == 1) {
				int n = 0;
				System.out.println("Pilih yang ingin dipesan berdasarkan nomor" + "\n" + "Input: ");
				int nomor = read.nextInt();				
				for (int i=0;i < datalist.size();i++) {	
					if(datalist.get(i).contains(subject)) {
						n++;
					}
					if(datalist.get(i).contains(subject) && nomor == n) {
						this.id = (String) datalist.get(i).get(0);
						this.name = ((String) datalist.get(i).get(1)).replace(' ', '_');
						this.print_price = (int) datalist.get(i).get(2);
						this.e_price = (int) datalist.get(i).get(3);
						this.subject = (String) datalist.get(i).get(4);
						
						File keranjang = new File("keranjang.txt");
						try {
							FileWriter new_data = new FileWriter(keranjang, true);
							BufferedWriter output = new BufferedWriter(new_data);
							output.write("\n" + this.id + " " + this.name + " - " + 
							this.print_price + " " + this.e_price + " " + this.subject + " 1");
							
							output.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else continue;
				}
				
			}
			else return;
			
			
		}while(pilihan == 1);
		
	}
	
	public void prev_exam(Scanner read, String use) {
		File exam = new File("exam.txt");
		datalist = new ArrayList<ArrayList<Object>>();
		try {
			read = new Scanner(exam);
			while(read.hasNextLine()) {
				List<Object> add_list = new ArrayList<>();
				String data1 = read.next();
				String data2 = read.next();
				String data3 = read.next();
				int data4 = read.nextInt();
				int data5 = read.nextInt();

				add_list.add(data1);
				add_list.add(data2);
				add_list.add(data3);
				add_list.add(data4);
				add_list.add(data5);

				datalist.add((ArrayList<Object>) add_list);
			}
		} catch (FileNotFoundException e) {
			System.out.println("error get from file");
			e.printStackTrace();
		}
		
		for (int i=0;i < datalist.size();i++) {	
			System.out.println("No. " + (i+1));
			for(int j=0; j< datalist.get(i).size();j++) {
				if(j==0) {
					System.out.print("ID: ");
					System.out.println(datalist.get(i).get(j));
				}
				else if(j==1) {
					System.out.print("Nama: ");
					System.out.println(((String) datalist.get(i).get(j)).replace('_', ' ') + " ");
				}
				else if(j==2) {
					System.out.print("Tanggal: ");
					System.out.println(datalist.get(i).get(j));			
				}
				else if(j==3) {
					System.out.print("Harga Elektronik: ");
					System.out.println(datalist.get(i).get(j));				
				}
				else if(j==4) {
					System.out.print("Harga Print: ");
					System.out.println(datalist.get(i).get(j));
				}
			}
			System.out.println("\n");
		}
		
		int pilihan;
		do{
			read = new Scanner(System.in);
			System.out.print("1. Add, 2. Return" + "\n" + "Input[1 - 2]: ");
			pilihan = read.nextInt();
			
			
			if(pilihan == 1) {
				
				System.out.println("Pilih yang ingin dipesan berdasarkan nomor" + "\n" + "Input: ");
				int nomor = read.nextInt();
				nomor--;
				
				for (int i=0;i < datalist.size();i++) {	
					if(i == nomor) {
						this.id = (String) datalist.get(i).get(0);
						this.name = ((String) datalist.get(i).get(1)).replace(' ', '_');
						this.date = (String) datalist.get(i).get(2);
						this.print_price = (int) datalist.get(i).get(3);
						this.e_price = (int) datalist.get(i).get(4);
						
						File keranjang = new File("keranjang.txt");
						try {
							FileWriter new_data = new FileWriter(keranjang, true);
							BufferedWriter output = new BufferedWriter(new_data);
							output.write("\n" + this.id + " " + this.name + " " + this.date + " " + 
							this.print_price + " " + this.e_price +" - 1");
							
							output.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else continue;
				}
				
			}
			else return;
			
			
		}while(pilihan == 1);
		
	}
	
	public void prac_paper(Scanner read, String use) {
		File practice = new File("practice.txt");
		datalist = new ArrayList<ArrayList<Object>>();
		try {
			read = new Scanner(practice);
			while(read.hasNextLine()) {
				List<Object> add_list = new ArrayList<>();
				String data1 = read.next();
				String data2 = read.next();
				int data4 = read.nextInt();
				int data5 = read.nextInt();

				add_list.add(data1);
				add_list.add(data2);
				add_list.add(data4);
				add_list.add(data5);

				datalist.add((ArrayList<Object>) add_list);
			}
		} catch (FileNotFoundException e) {
			System.out.println("error get from file");
			e.printStackTrace();
		}
		
		for (int i=0;i < datalist.size();i++) {	
			System.out.println("No. " + (i+1));
			for(int j=0; j< datalist.get(i).size();j++) {
				if(j==0) {
					System.out.print("ID: ");
					System.out.println(datalist.get(i).get(j));
				}
				else if(j==1) {
					System.out.print("Nama: ");
					System.out.println(((String) datalist.get(i).get(j)).replace('_', ' ') + " ");
				}
				else if(j==2) {
					System.out.print("Harga Elektronik: ");
					System.out.println(datalist.get(i).get(j));				
				}
				else if(j==3) {
					System.out.print("Harga Print: ");
					System.out.println(datalist.get(i).get(j));
				}
			}
			System.out.println("\n");
		}
		
		
		
		int pilihan;
		do{
			read = new Scanner(System.in);
			System.out.print("1. Add, 2. Return" + "\n" + "Input[1 - 2]: ");
			pilihan = read.nextInt();
			
			
			if(pilihan == 1) {
				
				System.out.println("Pilih yang ingin dipesan berdasarkan nomor" + "\n" + "Input: ");
				int nomor = read.nextInt();
				nomor--;
				
				for (int i=0;i < datalist.size();i++) {	
					if(i == nomor) {
						this.id = (String) datalist.get(i).get(0);
						this.name = ((String) datalist.get(i).get(1)).replace(' ', '_');
						this.print_price = (int) datalist.get(i).get(2);
						this.e_price = (int) datalist.get(i).get(3);
						
						File keranjang = new File("keranjang.txt");
						try {
							FileWriter new_data = new FileWriter(keranjang, true);
							BufferedWriter output = new BufferedWriter(new_data);
							output.write("\n" + this.id + " " + this.name + " " + "-" + " " + 
							this.print_price + " " + this.e_price +" - 1");
							
							output.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else continue;
				}
				
			}
			else return;
			
			
		}while(pilihan == 1);
	}
}
