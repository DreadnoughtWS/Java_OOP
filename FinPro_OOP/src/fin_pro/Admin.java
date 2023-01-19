package fin_pro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Admin extends User implements Menu2{

	public void View_data() {
		File view_data = new File("data_perjalanan.txt");
		Data_Perjalanan view = new Data_Perjalanan();
		view.get_data(view_data);
		int pilihan = 0;
		do {
				Scanner read1 = new Scanner(System.in);
				System.out.println("1. Edit, 2. Leave\nInput[1 or 2]: ");
				int pilih = read1.nextInt();
				if(pilih == 1) {
					view.edit_data(view_data);
				}
				if(pilih == 2) {
					return;
				}
		}while(pilihan == 0 );
	}
	
	
	public void confirmation(File pesanTiket, File report) {
		E_Ticket eticket = new E_Ticket();
		eticket.confirm(pesanTiket, report);
		eticket.update();
	}
	
	public void cetak_laporan() {
		
	}
	public void cetak_manifest() {
		
	}
	
}
