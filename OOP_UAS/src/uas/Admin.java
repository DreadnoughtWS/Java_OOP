package uas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Admin extends User{

	public void browsing() {
		Scanner read = new Scanner(System.in);
		Browse opsi = new Browse();
		int loop = 1;
		int pilihan;
		String use = "admin"; 
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
}
