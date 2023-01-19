package uas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		File acc = new File("accounts.txt");
		if(acc.exists()) {
		} 
		else {
			try {
				acc.createNewFile();
				FileWriter new_acc2 = new FileWriter(acc, true);
				BufferedWriter out = new BufferedWriter(new_acc2);
				out.write("admin1 " + "111 " + "admin " + "pegawai1 " + "A001");
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		File modul_data = new File("data_modul.txt");
		if(modul_data.exists()) {
		} 
		else {
			try {
				modul_data.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		File exam = new File("exam.txt");
		if(exam.exists()) {
		} 
		else {
			try {
				exam.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		File practice = new File("practice.txt");
		if(practice.exists()) {
		} 
		else {
			try {
				practice.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		
		File keranjang = new File("keranjang.txt");
		if(keranjang.exists()) {
		} 
		else {
			try {
				keranjang.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		
		File record = new File("record.txt");
		if(record.exists()) {
		} 
		else {
			try {
				record.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		
		Scanner read = new Scanner(System.in);
		System.out.print("Masuk sebagai Admin atau Customer? [1 = Admin, 2 = Customer, 3 = Keluar]: ");
		int masuk = read.nextInt();
		
		if(masuk == 1) {
			Admin pegawai= new Admin();
			pegawai.login(acc, masuk);
			admin_login(pegawai);
		}
		
		if(masuk == 2) {
			Customer pengguna = new Customer();
			System.out.print("Login atau Register?: [1 = Login, 2 = Register, 3 = Keluar]: ");
			int pilihan = read.nextInt();
			switch(pilihan) {
			case 1:
				pengguna.login(acc, masuk);
				break;
			case 2:
				pengguna.register(acc);
				break;
			case 3:
				System.out.println("Come back again...");
				return;
			default:
				System.out.println("Input Error, try again...");
			}
			
			penumpang_login(pengguna);
		}
		else return;
		
		
		
	}
	
	public static void penumpang_login(Customer pengguna) {
		int loop = 1;
		int pilihan;
		do {
			Scanner read = new Scanner(System.in);
			System.out.println(pengguna.nama);
			System.out.println("1. Browse\n2. Shopping Cart\n3. Keluar");
			System.out.print("Pilihan[1-3]: ");
			pilihan = read.nextInt();
			
			if(pilihan == 1) {
				pengguna.browsing();
			}
			if(pilihan == 2) {
				pengguna.cart();
			}
			if(pilihan == 3) {
				File keranjang = new File("keranjang.txt");
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
			
		}while(loop==1);
		
	}
	
	public static void admin_login(Admin pegawai) {
		int loop = 1;
		int pilihan;
		do {
			Scanner read = new Scanner(System.in);
			System.out.println(pegawai.nama);
			System.out.println("1. \n2. Keluar");
			System.out.print("Pilihan[1-2]: ");
			pilihan = read.nextInt();
			
			if(pilihan == 1) {
				pegawai.browsing();
			}

			if(pilihan == 2) {
				return;
			}
		}while(loop==1);
	}
}
