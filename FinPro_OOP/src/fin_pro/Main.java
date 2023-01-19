package fin_pro;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		File acc = new File("accounts.txt");
		if(acc.exists()) {
		} 
		else {
			try {
				acc.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		File view_data = new File("data_perjalanan.txt");
		if(view_data.exists()) {
		} 
		else {
			try {
				view_data.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		File pesanTiket = new File("pesan_tiket.txt");
		if(pesanTiket.exists()) {
		} 
		else {
			try {
				pesanTiket.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		File report = new File("report_tiket.txt");
		if(report.exists()) {
		} 
		else {
			try {
				report.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		
		File confirmed = new File("e_tiket.txt");
		if(report.exists()) {
		} 
		else {
			try {
				confirmed.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		Scanner read = new Scanner(System.in);
		System.out.print("Masuk sebagai Admin atau Penumpang? [1 = Admin, 2 = Penumpang, 3 = Keluar]: ");
		int masuk = read.nextInt();
		
		if(masuk == 1) {
			Admin pegawai= new Admin();
			pegawai.login(acc, masuk);
			admin_login(pegawai, pesanTiket, report);
		}
		
		if(masuk == 2) {
			Penumpang pengguna = new Penumpang();
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
			
			penumpang_login(pengguna, pesanTiket, report);
		}
		else return;
		
		
		
	}
	
	public static void penumpang_login(Penumpang pengguna, File pesanTiket, File report) {
		int loop = 1;
		int pilihan;
		do {
			Scanner read = new Scanner(System.in);
			System.out.println(pengguna.nama);
			System.out.println("1. Lihat Perjalanan Kereta Api\n2. Pemesanan Tiket Kereta Api\n3. Check In\n4. Keluar");
			System.out.print("Pilihan[1-4]: ");
			pilihan = read.nextInt();
			
			if(pilihan == 1) {
				pengguna.View_data();
			}
			if(pilihan == 2) {
				pengguna.pesan_tiket(pesanTiket, report);
			}
			if(pilihan == 3) {
				pengguna.check_in();
			}
			if(pilihan == 4) {
				return;
			}
			
			
		}while(loop==1);
		
	}
	
	public static void admin_login(Admin pegawai,File pesanTiket,File report) {
		int loop = 1;
		int pilihan;
		do {
			Scanner read = new Scanner(System.in);
			System.out.println(pegawai.nama);
			System.out.println("1. Lihat & Edit Perjalanan Kereta Api\n2. Konfirmasi\n3. Cetak\n4. Keluar");
			System.out.print("Pilihan[1-4]: ");
			pilihan = read.nextInt();
			
			if(pilihan == 1) {
				pegawai.View_data();
			}
			if(pilihan == 2) {
				pegawai.confirmation(pesanTiket, report);	
			}
			if(pilihan == 3) {
				
			}
			if(pilihan == 4) {
				return;
			}
		}while(loop==1);
	}
	
}
