package fin_pro;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Data_Perjalanan {

	private String id_kereta;
	private String nama_kereta;
	private String nama_rute;
	private String st_awal;
	private String st_akhir;
	private String jam1;
	private String jam2;
	private String jadwal;
	private String bisnis;
	private int total_ticket_bisnis;
	private int harga_ticket_bisnis;
	private String eksekutif;
	private int total_ticket_eksekutif;
	private int harga_ticket_eksekutif;
	ArrayList<ArrayList<Object>> datalist = new ArrayList<ArrayList<Object>>();

	public void get_data(File view_data) {
		Scanner reader;
		try {
			reader = new Scanner(view_data);
			while(reader.hasNextLine()) {
				List<Object> add_list = new ArrayList<>();
				String data1 = reader.next();
				String data2 = reader.next();
				String data3 = reader.next();
				String data4 = reader.next();
				String data5 = reader.next();
				String jam = reader.next();
				String data6 = reader.next();
				int data7 = reader.nextInt();
				int data8 = reader.nextInt();
				String data9 = reader.next();
				int data10 = reader.nextInt();
				int data11 = reader.nextInt();


				add_list.add(data1);
				add_list.add(data2);
				add_list.add(data3);
				add_list.add(data4);
				add_list.add(data5);
				add_list.add(jam);

				add_list.add(data6);
				add_list.add(data7);
				add_list.add(data8);
				add_list.add(data9);
				add_list.add(data10);
				add_list.add(data11);

				datalist.add((ArrayList<Object>) add_list);
			}
		} catch (FileNotFoundException e) {
			System.out.println("error get from file");
			e.printStackTrace();
		}		
		for (int i=0;i < datalist.size();i++) {	
			System.out.println("No. " + (i+1));
			for(int j=0; j< datalist.get(i).size();j++) {
				if(j==9 || j==6) {
					System.out.println();
				}
				if(j==0) {
					System.out.print(datalist.get(i).get(j) + " ");
				}
				else if(j>0 && j<=5) {
					System.out.print(((String) datalist.get(i).get(j)).replace('_', ' ') + " ");
				}
				else if(j>=6 && j<=8) {
					System.out.print(datalist.get(i).get(j) + " ");
				}
				else if(j>=9 && j<=11) {
					System.out.print(datalist.get(i).get(j) + " ");
				}
			}
			System.out.println("\n");
		}
	}
	
	public void edit_data(File view_data) {
		Scanner reader;
		ArrayList<ArrayList<Object>> datalist = new ArrayList<ArrayList<Object>>();
		try {
			reader = new Scanner(view_data);
			while(reader.hasNextLine()) {
				List<Object> add_list = new ArrayList<>();
				String data1 = reader.next();
				String data2 = reader.next();
				String data3 = reader.next();
				String data4 = reader.next();
				String data5 = reader.next();
				String jam = reader.next();
				String data6 = reader.next();
				int data7 = reader.nextInt();
				int data8 = reader.nextInt();
				String data9 = reader.next();
				int data10 = reader.nextInt();
				int data11 = reader.nextInt();


				add_list.add(data1);
				add_list.add(data2);
				add_list.add(data3);
				add_list.add(data4);
				add_list.add(data5);
				add_list.add(jam);
				add_list.add(data6);
				add_list.add(data7);
				add_list.add(data8);
				add_list.add(data9);
				add_list.add(data10);
				add_list.add(data11);

				datalist.add((ArrayList<Object>) add_list);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int pilihan;
		do {
			Scanner read = new Scanner(System.in);
			System.out.println("1. Add, 2. Delete, 3. Return" + "\n" + "Input[1 - 3]: ");
			pilihan = read.nextInt();
			if(pilihan == 1) {
				read = new Scanner(System.in);
				System.out.print("Input Nama Kereta: ");
				String in_nama = read.nextLine();
				this.nama_kereta = in_nama.replace(" ", "_");
				
				System.out.print("Input ID Kereta: ");
				String in_idkereta = read.nextLine();
				this.id_kereta = in_idkereta;
				
				System.out.print("Input Nama Rute[eg: kotaA - kotaB]: ");
				String in_rute = read.nextLine();
				this.nama_rute = in_rute.replace(" ", "_");
				
				System.out.print("Input Nama Stasiun Keberangkatan: ");
				String in_awal = read.nextLine();
				this.st_awal = in_awal.replace(" ", "_");
				
				System.out.print("Input Nama Stasiun Kedatangan: ");
				String in_akhir = read.nextLine();
				this.st_akhir = in_akhir.replace(" ", "_");
				
				System.out.print("Input Jam Berangkat dan Sampai...\n ");
				System.out.print("Jam Berangkat[HH:mm]: ");
				this.jam1 = read.next();
				System.out.print("Jam Sampai[HH:mm]: ");
				this.jam2 = read.next();
				
				
				System.out.print("Input Jumlah dan Harga per Tiket kelas Bisnis...\n");
				System.out.print("Jumlah Tiket: ");
				this.total_ticket_bisnis = read.nextInt();
				System.out.print("Harga per Tiket: ");
				this.harga_ticket_bisnis = read.nextInt();
				this.bisnis ="Bisnis";
				
				System.out.print("Input Jumlah dan Harga per Tiket kelas Bisnis: \n");
				System.out.print("Jumlah Tiket: ");
				this.total_ticket_eksekutif = read.nextInt();
				System.out.print("Harga per Tiket: ");
				this.harga_ticket_eksekutif = read.nextInt();
				this.eksekutif = "Eksekutif";

				try {
					FileWriter new_data2 = new FileWriter(view_data, true);
					BufferedWriter out = new BufferedWriter(new_data2);
					out.write("\n" + this.id_kereta + " " + this.nama_kereta + " " + this.nama_rute + " " + this.st_awal + " " + 
					this.st_akhir + " " + this.jam1 + "-" + this.jam2 + " " + this.bisnis + " " + this.total_ticket_bisnis + " " + this.harga_ticket_bisnis + " " 
					+ this.eksekutif + " " + this.total_ticket_eksekutif + " " + this.harga_ticket_eksekutif);
					
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pilihan == 2) {
				Scanner read1 = new Scanner(System.in);
				System.out.println("Pilih List yang Dihapus Berdasarkan Urutan: ");
				int urutan = read1.nextInt();
				urutan--;
				for (int i=0;i < datalist.size();i++) {	
					if(i == urutan) {
						System.out.println(datalist.get(i));
						System.out.println("Hapus ini?");
						System.out.print("Input[1 = iya, 2 = tidak]: ");
						read = new Scanner(System.in);
						int hapus = read.nextInt();
						if(hapus==1) {
							datalist.remove(i);
							PrintWriter delete;
							try {
								delete = new PrintWriter(view_data);
								delete.print("");
								delete.close();
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							for (int l=0;l < datalist.size();l++) {	
								for (int k=0;k < datalist.get(l).size();k++) {	
									if(k == 0) {
										this.id_kereta = (String) datalist.get(l).get(k);
									}
									if(k == 1) {
										this.nama_kereta = (String) datalist.get(l).get(k);
									}
									if(k == 2) {
										this.nama_rute = (String) datalist.get(l).get(k);
									}
									if(k == 3) {
										this.st_awal = (String) datalist.get(l).get(k);
									}
									if(k == 4) {
										this.st_akhir = (String) datalist.get(l).get(k);
									}
									if(k == 5) {
										this.jadwal = (String) datalist.get(l).get(k);
									}
									if(k == 6) {
										this.bisnis = (String) datalist.get(l).get(k);
									}
									if(k == 7) {
										this.total_ticket_bisnis = (int) datalist.get(l).get(k);
									}
									if(k == 8) {
										this.harga_ticket_bisnis = (int) datalist.get(l).get(k);
									}
									if(k == 9) {
										this.eksekutif = (String) datalist.get(l).get(k);
									}
									if(k == 10) {
										this.total_ticket_eksekutif = (int) datalist.get(l).get(k);
									}
									if(k == 11) {
										this.harga_ticket_eksekutif = (int) datalist.get(l).get(k);
									}
									
								}
								try {
									FileWriter new_data = new FileWriter(view_data, true);
									BufferedWriter output = new BufferedWriter(new_data);
									output.write("\n" + this.id_kereta + " " + this.nama_kereta + " " + this.nama_rute + " " + this.st_awal + " " + 
									this.st_akhir + " " + this.jadwal + " " + this.bisnis + " " + this.total_ticket_bisnis + " " + this.harga_ticket_bisnis + " " 
									+ this.eksekutif + " " + this.total_ticket_eksekutif + " " + this.harga_ticket_eksekutif);
									
									output.close();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							return;
						}
						if(hapus==2) {
							return;
						}
					}
				}
				return;
			}
		}while(pilihan == 1 || pilihan == 2);
	}
	
}
