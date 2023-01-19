package fin_pro;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class E_Ticket {
	private String seek = null;
	public void confirm(File pesan_tiket, File report) {
		File confirmed = new File("e_tiket.txt");
		Scanner reader = new Scanner(System.in);
		ArrayList<ArrayList<Object>> report_list = new ArrayList<ArrayList<Object>>();
		ArrayList<ArrayList<Object>> tiket_queue = new ArrayList<ArrayList<Object>>();

		try {
			reader = new Scanner(report);
			while(reader.hasNextLine()) {
				List<Object> tiket_list = new ArrayList<>();
				String data1 = reader.next();
				String data2 = reader.next();
				String data3 = reader.next();
				int data4 = reader.nextInt();
				String data5 = reader.next();
				String data6 = reader.next();
				
				tiket_list.add(data1);
				tiket_list.add(data2);
				tiket_list.add(data3);
				tiket_list.add(data4);
				tiket_list.add(data5);
				tiket_list.add(data6);

				report_list.add((ArrayList<Object>) tiket_list);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		for (int i=0;i < report_list.size();i++) {	
			System.out.print((i+1) + ". ");
			for(int j=0; j< report_list.get(i).size();j++) {
				System.out.print(report_list.get(i).get(j) + " ");

			}
			System.out.println("");
		}
		
		System.out.println("Pilih Pembayaran untuk dikonfirmasi: ");
		reader = new Scanner(System.in);
		int pilihan = reader.nextInt();
		pilihan--;
		for (int i=0;i < report_list.size();i++) {	
			if(pilihan == i && report_list.get(i).get(5).equals("unconfirmed")) {
				reader = new Scanner(System.in);
				System.out.print("Konfirmasi Pembayaran? [1 = ya, 2 = tidak]: ");
				int konfirm = reader.nextInt();
				if(konfirm == 1) {
					report_list.get(i).set(5, "confirmed");
					this.seek = (String) report_list.get(i).get(0);
				}
				if(konfirm == 2) {
					return;
				}
			}
			else if(pilihan == i && report_list.get(i).get(5).equals("confirmed")) {
				System.out.println("Pembayaran sudah terkonfirmasi\n");
				return;
			}
		}

		try {
			reader = new Scanner(pesan_tiket);
			while(reader.hasNextLine()) {
				List<Object> tiket_content = new ArrayList<>();
				String data1 = reader.next();
				String data2 = reader.next();
				String data3 = reader.next().replace("_", " ");
				String data4 = reader.next().replace("_", " ");
				String data5 = reader.next().replace("_", " ");
				String data6 = reader.next();
				String data7 = reader.next();
				String data8 = reader.next();
				String data9 = reader.next();

				tiket_content.add(data1);
				tiket_content.add(data2);
				tiket_content.add(data3);
				tiket_content.add(data4);
				tiket_content.add(data5);
				tiket_content.add(data6);
				tiket_content.add(data7);
				tiket_content.add(data8);
				tiket_content.add(data9);

				tiket_queue.add((ArrayList<Object>) tiket_content);
			}
		} catch (FileNotFoundException e) {
			System.out.println("error get from file");
			e.printStackTrace();
		}
		PrintWriter delete;
		try {
			delete = new PrintWriter(report);
			delete.print("");
			delete.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
		for (int i=0;i < report_list.size();i++) {
				FileWriter new_data;
				new_data = new FileWriter(report, true);
				BufferedWriter output = new BufferedWriter(new_data);
				output.write("\n");
				for (int j=0;j < report_list.get(i).size();j++) {	
					if(j==5) {
						output.write(" " +report_list.get(i).get(j));
						break;
					}
					output.write(report_list.get(i).get(j) + " " );
				}
				output.close();
		}
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		try {
		for (int i=0;i < tiket_queue.size();i++) {
			FileWriter new_data;
			new_data = new FileWriter(confirmed, true);
			BufferedWriter output = new BufferedWriter(new_data);
			if(tiket_queue.get(i).get(0).equals(this.seek)) {
				output.write("\n");
				for (int j=0;j < tiket_queue.get(i).size();j++) {
					if(j==8) {
						output.write(" " +tiket_queue.get(i).get(j));
						break;
					}
					output.write(tiket_queue.get(i).get(j) + " ");
				}
			}
			output.close();
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void update() {
		File update_perjalanan = new File("data_perjalanan.txt");
		File tiket = new File("e_tiket.txt");
		Scanner reader;
		ArrayList<ArrayList<Object>> datalist = new ArrayList<ArrayList<Object>>();
		ArrayList<ArrayList<Object>> tiketlist = new ArrayList<ArrayList<Object>>();
		
		
		try {
			reader = new Scanner(update_perjalanan);
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
		
		try {
			reader = new Scanner(tiket);
			while(reader.hasNextLine()) {
				List<Object> tiket_content = new ArrayList<>();
				String data1 = reader.next();
				String data2 = reader.next();
				String data3 = reader.next().replace("_", " ");
				String data4 = reader.next().replace("_", " ");
				String data5 = reader.next().replace("_", " ");
				String data6 = reader.next();
				String data7 = reader.next();
				String data8 = reader.next().replace("_", " ");
				String data9 = reader.next();

				tiket_content.add(data1);
				tiket_content.add(data2);
				tiket_content.add(data3);
				tiket_content.add(data4);
				tiket_content.add(data5);
				tiket_content.add(data6);
				tiket_content.add(data7);
				tiket_content.add(data8);
				tiket_content.add(data9);

				tiketlist.add((ArrayList<Object>) tiket_content);
			}
		} catch (FileNotFoundException e) {
			System.out.println("error get from file");
			e.printStackTrace();
		}
		int bisnis;
		int eks;
		for (int l=0;l < tiketlist.size();l++) {	
			for (int k=0;k < datalist.size();k++) {
				if(tiketlist.get(l).get(0).equals(this.seek) && tiketlist.get(l).get(2).equals(datalist.get(k).get(1)) && tiketlist.get(l).get(8).equals("Bisnis")) {
					bisnis = (int) datalist.get(k).get(7);
					bisnis--;
					datalist.get(k).set(7, bisnis);
					break;
				}
				else if(tiketlist.get(l).get(0).equals(this.seek) && tiketlist.get(l).get(2).equals(datalist.get(k).get(1)) && tiketlist.get(l).get(8).equals("Eksekutif")) {
					eks = (int) datalist.get(k).get(10);
					eks--;
					datalist.get(k).set(10, eks);
					break;
				}
			}
		}
		
		PrintWriter delete;
		try {
			delete = new PrintWriter(update_perjalanan);
			delete.print("");
			delete.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			for (int i=0;i < datalist.size();i++) {
				FileWriter new_data;
				new_data = new FileWriter(update_perjalanan, true);
				BufferedWriter output = new BufferedWriter(new_data);
				output.write("\n");
				for (int j=0;j < datalist.get(i).size();j++) {
						if(j==11) {
							output.write(" " +datalist.get(i).get(j));
							break;
						}
					output.write(datalist.get(i).get(j) + " ");
				}
				output.close();
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
