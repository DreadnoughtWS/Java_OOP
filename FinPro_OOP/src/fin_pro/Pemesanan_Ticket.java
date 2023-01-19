package fin_pro;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Pemesanan_Ticket {

	private String id_ticket;
	private String id_penum;
	private String jenis_ticket;
	private String nama_penum;
	private String tanggal;
	private String jam;
	private String nama_kereta;
	private String rute;
	private String st_awal;
	private String st_akhir;
	private int harga_ticket_bisnis;
	private int harga_ticket_eksekutif;
	private int kode_bank;
	private int total_harga = 0;

	
	public void pickPerjalanan(String penum_id, File pesanTiket, File report){
		ArrayList<ArrayList<Object>> tiket = new ArrayList<ArrayList<Object>>();
		File view_data = new File("data_perjalanan.txt");
		Data_Perjalanan view = new Data_Perjalanan();
		view.get_data(view_data);
		Scanner read;
		read = new Scanner(System.in);
		System.out.println("Pilih Perjalanan yang Diinginkan: ");
		int urutan = read.nextInt();
		urutan--;
		
		for (int i=0;i < view.datalist.size();i++) {	
			if(i == urutan) {
				this.nama_kereta = (String) view.datalist.get(i).get(1);
				this.rute = (String) view.datalist.get(i).get(2);
				this.st_awal = (String) view.datalist.get(i).get(3);
				this.st_akhir = (String) view.datalist.get(i).get(4);
				this.jam  = (String) view.datalist.get(i).get(5);
				this.harga_ticket_bisnis = (int) view.datalist.get(i).get(8);
				this.harga_ticket_eksekutif = (int) view.datalist.get(i).get(11);
			}
		}
		read = new Scanner(System.in);
		String tanggal1;
		System.out.print("Tanggal [hh-mm-yyyy]: ");
		tanggal1 = read.nextLine();
		this.tanggal = tanggal1 + "_" + this.jam;
		
		read = new Scanner(System.in);
		int jumlah;
		System.out.print("Berapa Tiket? ");
		jumlah = read.nextInt();
		this.id_penum = penum_id;
		Random rand = new Random();
		int id_num = rand.nextInt(99999);
		String id_add = "T" + id_num;
		this.id_ticket = id_add;
		
		for (int i=0;i<jumlah;i++) {
			read = new Scanner(System.in);
			System.out.print("\nNama: ");
			this.nama_penum = read.nextLine();
			
			System.out.print("\nJenis Tiket [Bisnis / Eksekutif][Case Sensitive]: ");
			String jenis = read.nextLine();
			
			if(jenis.equalsIgnoreCase("Bisnis")) {
				this.total_harga = this.total_harga + this.harga_ticket_bisnis;
				this.jenis_ticket = jenis;
			}
			if(jenis.equalsIgnoreCase("Eksekutif")) {
				this.total_harga = this.total_harga + this.harga_ticket_eksekutif;
				this.jenis_ticket = jenis;
			}
			List<Object> list_tiket = new ArrayList<>();
			
			list_tiket.add(this.id_ticket);
			list_tiket.add(this.id_penum);
			list_tiket.add(this.nama_kereta.replace(" ", "_"));
			list_tiket.add(this.st_awal.replace(" ", "_"));
			list_tiket.add(this.st_akhir.replace(" ", "_"));
			list_tiket.add(this.tanggal.replace("_", " "));
			list_tiket.add(this.nama_penum.replace(" ", "_"));
			list_tiket.add(this.jenis_ticket);

			tiket.add((ArrayList<Object>) list_tiket);
		}

		System.out.println("\nTotal Pembayaran: " + this.total_harga);
		System.out.print("\nMasukkan Kode Bank Untuk Transfer: ");
		read = new Scanner(System.in);
		this.kode_bank = read.nextInt();
		System.out.print("\nKonfirmasi Pemesanan?[1 = iya, 2 = batal]: ");
		read = new Scanner(System.in);
		int konfirmasi = read.nextInt();
		
		if(konfirmasi == 1) {
			try {
				
				
				for (int l=0;l < tiket.size();l++) {	
					FileWriter new_data = new FileWriter(pesanTiket, true);
					BufferedWriter output = new BufferedWriter(new_data);
					output.write("\n" + tiket.get(l).get(0) + " " + tiket.get(l).get(1) + " "+ tiket.get(l).get(2) + " " + 
					tiket.get(l).get(3) + " " + tiket.get(l).get(4) + " " + tiket.get(l).get(5) 
					+ " " + tiket.get(l).get(6) + " " + tiket.get(l).get(7));
					
					output.close();
				}				
				String status = "unconfirmed";
				FileWriter new_data1 = new FileWriter(report, true);
				BufferedWriter output1 = new BufferedWriter(new_data1);
				output1.write("\n" + this.id_ticket + " " + this.id_penum + " "+ tanggal1 + " " + this.total_harga + " " + this.kode_bank + " " + status);
				
				output1.close();
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(konfirmasi == 2) {
			return;
		}
		
		
		
	}
}
