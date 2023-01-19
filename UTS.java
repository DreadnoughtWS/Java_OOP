package test;
import java.util.*;
public class UTS {
	public static void main(String[] args) {
		try (Scanner read = new Scanner(System.in)) {
			System.out.println("Input:");
			System.out.println("1st Number:");
			char[] roman = read.next().toCharArray();
			System.out.println("2nd Number:");
			char[] roman2 = read.next().toCharArray();

			List<Character> numerals = new ArrayList<Character>();
			List<Character> numerals2 = new ArrayList<Character>();
			
			System.out.println("Steps: ");
			System.out.print("Input: ");
			transfer(roman, numerals);
			System.out.print(" + ");
			transfer(roman2, numerals2);
			
			System.out.println("\n\n1. Convert subtractive to additive  : ");
			conversion(numerals);
			System.out.print(" + ");
			conversion(numerals2);

			System.out.println("\n\n2. Combine two numerals into one  : ");
			numerals.addAll(numerals2);
			for(int iterate=0;iterate<numerals.size();iterate++ )
				System.out.print(numerals.get(iterate));

			System.out.println("\n\n3. Sort numeral symbols  : ");
			sorted(numerals);
			System.out.println("\n\nResult   :");
			for(int iterate=0;iterate<numerals.size();iterate++ )
				System.out.print(numerals.get(iterate));
		}	
	}
	
	
	public static void transfer(char roman[], List<Character> numerals) {
		for(int i=0; i<roman.length;i++) {
			numerals.add(new Character(roman[i]));
			System.out.print(roman[i]);
		}
	}


	public static void conversion(List<Character> numerals) {
		for(int i=1; i<numerals.size();i++) {
			if(numerals.get(i)== 'M' && numerals.get(i-1)=='C') {
				numerals.remove(i);
				numerals.remove(i-1);
				numerals.add(i-1,'C');
				numerals.add(i-1,'C');
				numerals.add(i-1,'C');
				numerals.add(i-1,'C');
				numerals.add(i-1,'D');
			}
			
			else if(numerals.get(i)== 'D' && numerals.get(i-1)=='C') {
				numerals.remove(i);
				numerals.remove(i-1);
				numerals.add(i-1,'C');
				numerals.add(i-1,'C');
				numerals.add(i-1,'C');
				numerals.add(i-1,'C');
			}
			
			else if(numerals.get(i)== 'C' && numerals.get(i-1)=='X') {
				numerals.remove(i);
				numerals.remove(i-1);
				numerals.add(i-1,'X');
				numerals.add(i-1,'X');
				numerals.add(i-1,'X');
				numerals.add(i-1,'X');
				numerals.add(i-1,'L');
			}
			
			else if(numerals.get(i)== 'L' && numerals.get(i-1)=='X') {
				numerals.remove(i);
				numerals.remove(i-1);
				numerals.add(i-1,'X');
				numerals.add(i-1,'X');
				numerals.add(i-1,'X');
				numerals.add(i-1,'X');
			}
			
			else if(numerals.get(i)== 'X' && numerals.get(i-1)=='I') {
				numerals.remove(i);
				numerals.remove(i-1);
				numerals.add(i-1,'I');
				numerals.add(i-1,'I');
				numerals.add(i-1,'I');
				numerals.add(i-1,'I');
				numerals.add(i-1,'V');
			}
			
			else if(numerals.get(i)== 'V' && numerals.get(i-1)=='I') {
				numerals.remove(i);
				numerals.remove(i-1);
				numerals.add(i-1,'I');
				numerals.add(i-1,'I');
				numerals.add(i-1,'I');
				numerals.add(i-1,'I');
			}
			
		}
		for(int i=1; i<numerals.size();i++) {
			System.out.print(numerals.get(i));
		}
	}


	public static void sorted(List<Character> numerals) {
		int m=0;
		int d=0;
		int c=0;
		int l=0;
		int x=0;
		int v=0;
		int i=0;
		for(int j = 0;j <numerals.size();j++) {
			if(numerals.get(j)=='M') {
				m++;
			}
			if(numerals.get(j)=='D') {
				d++;
			}
			if(numerals.get(j)=='C') {
				c++;
			}
			if(numerals.get(j)=='L') {
				l++;
			}
			if(numerals.get(j)=='X') {
				x++;
			}
			if(numerals.get(j)=='V') {
				v++;
			}
			if(numerals.get(j)=='I') {
				i++;
			}
		}
	
		numerals.removeAll(numerals);
		for(int h=0;h<m;h++) {
			if(m==0) {
				break;
			}
			numerals.add('M');
		}
		
		for(int h=0;h<d;h++) {
			if(d==0) {
				break;
			}
			numerals.add('D');
		}
		for(int h=0;h<c;h++) {
			if(c==0) {
				break;
			}
			numerals.add('C');
		}
		for(int h=0;h<l;h++) {
			if(l==0) {
				break;
			}
			numerals.add('L');
		}
		for(int h=0;h<x;h++) {
			if(x==0) {
				break;
			}
			numerals.add('X');
		}
		for(int h=0;h<v;h++) {
			if(v==0) {
				break;
			}
			numerals.add('V');
		}
		for(int h=0;h<i;h++) {
			if(i==0) {
				break;
			}
			numerals.add('I');
		}
	
		for(int iterate=0;iterate<numerals.size();iterate++ )
			System.out.print(numerals.get(iterate));
		
		System.out.println("\n\n4. Simplify by removing symbols from left to right   :");
			simplify(numerals,m,d,c,l,x,v,i);	
	}


	public static void simplify(List<Character> numerals, int m, int d, int c, int l, int x, int v, int i) {
		while(d>=2 || c>=5 || l>=2 || x>=5 || v>=2 || i>=5) {
			int j=0;
			if(i>=5) {
				char word = 'I';
				j=traverse(numerals,j, word);
				numerals.add(j, 'V');
				v++;
				for(int num=0;num<=4;num++) {
					numerals.remove(j+1);
					i--;
				}
				System.out.println("Replace IIIII with V to get");
			}
		
			else if(v>=2) {
				char word = 'V';
				j=traverse(numerals,j, word);
				numerals.add(j, 'X');
				x++;
				for(int num=0;num<2;num++) {
					numerals.remove(j+1);
					v--;
				}
				System.out.println("\nReplace VV with X to get");
			}
		
			else if(x>=5) {
				char word = 'X';
				j=traverse(numerals,j, word);
				numerals.add(j, 'L');
				l++;
				for(int num=0;num<=4;num++) {
					numerals.remove(j+1);
					x--;
				}
				System.out.println("\nReplace XXXXX with L to get");
			}
		
			else if(l>=2) {
				char word = 'L';
				j=traverse(numerals,j, word);
				numerals.add(j, 'C');
				c++;
				for(int num=0;num<2;num++) {
					numerals.remove(j+1);
					l--;
				}
				System.out.println("\nReplace LL with C to get");
			}
		
			else if(c>=5) {
				char word = 'C';
				j=traverse(numerals,j, word);
				numerals.add(j, 'D');
				d++;
				for(int num=0;num<=4;num++) {
					numerals.remove(j+1);
					c--;
				}
				System.out.println("\nReplace CCCCC with D to get");
			}
		
			else if(d>=2) {
				char word = 'D';
				j=traverse(numerals,j, word);
				numerals.add(j, 'M');
				m++;
				for(int num=0;num<2;num++) {
					numerals.remove(j+1);
					d--;
				}
				System.out.println("\nReplace DD with M to get");
			}
			for(int iterate=0;iterate<numerals.size();iterate++ )
				System.out.print(numerals.get(iterate));
		}
		
		System.out.println("\n\n5. Convert additive back to subtractive   :");
		reconvert(numerals, m,d,c,l,x,v,i);
	}


	public static void reconvert(List<Character> numerals, int m, int d, int c, int l, int x, int v, int i) {
		char word;
		int j=0;
			if(i==4 && v!=1) {
				word='I';
				for(int num=0;num<3;num++) {
					j=traverse(numerals,j, word);
					numerals.remove(j);
					j=0;
				}
				numerals.add('V');

			}
			
			 if(i==4 && v==1) {
				 word='I';
				for(int num=0;num<3;num++) {
					j=traverse(numerals,j, word);
					numerals.remove(j);
					j=0;
				}
				numerals.set(numerals.indexOf('V')+2, 'X');
				numerals.remove(numerals.indexOf('V'));
	
	
			}
			
			 if(x==4 && l!=1) {
				 word='X';
				for(int num=0;num<3;num++) {
					j=traverse(numerals,j, word);
					numerals.remove(j);
				}
				numerals.add(j+1,'L');
				
			}
			
			 if(x==4 && l==1) {
				 word='X';
				for(int num=0;num<3;num++) {
					j=traverse(numerals,j, word);
					numerals.remove(j);
					j=0;
				}
				numerals.add(numerals.indexOf('L')+2, 'C');
				numerals.remove(numerals.indexOf('L'));
			}
			
			 if(c==4 && d!=1) {
				 word='C';
				for(int num=0;num<3;num++) {
					j=traverse(numerals,j, word);
					numerals.remove(j);
				}
				numerals.add(j+1,'D');
			}
			
			 if(c==4 && d==1) {
				 word='C';
				for(int num=0;num<3;num++) {
					j=traverse(numerals,j, word);
					numerals.remove(j);
					j=0;
				}
				numerals.set(numerals.indexOf('D')+2, 'M');
				numerals.remove(numerals.indexOf('D'));
	
			}
			 for(int iterate=0;iterate<numerals.size();iterate++ )
					System.out.print(numerals.get(iterate));
	}


	public static int traverse(List<Character> numerals, int j, char word) {
		for(int i = 0; i<numerals.size();i++) {
			if (numerals.get(i)==word) {
				j=i;
				break;
			}
		}
		return j;
	}
	
}
