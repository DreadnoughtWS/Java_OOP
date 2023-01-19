package fin_pro;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.*;

public class Penumpang extends User implements Menu1{
	private String status;
	
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
		
		this.status = "penumpang";
		Random rand = new Random();
		int id_num = rand.nextInt(99999);
		this.id = "P" + id_num;
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
	
	public void View_data() {
		File view_data = new File("data_perjalanan.txt");
		Data_Perjalanan view = new Data_Perjalanan();
		view.get_data(view_data);
	}
	public void pesan_tiket(File pesanTiket, File report) {
		Pemesanan_Ticket pesan = new Pemesanan_Ticket();
		String penum_id = this.id;
		pesan.pickPerjalanan(penum_id, pesanTiket, report);
	}
	public void check_in() {
		File e_tiket = new File("e_tiket.txt");
		
	}

}
