import java.io.*;

public class LinkedListCalculator {	
	
	
	public static void main(String[] args) {
		String s1, s2;
		int i;
		
		
		try {
			BufferedReader rd = new BufferedReader(new FileReader("input.txt"));
			BufferedWriter wr = new BufferedWriter(new FileWriter("output.txt"));
		
			s1 = rd.readLine();
			s2 = rd.readLine();
			
			LinkedList llist1 = new LinkedList();
			LinkedList llist2 = new LinkedList();
			LinkedList llist_temp = new LinkedList();
			LinkedList llist_final = new LinkedList();
			
			
			if ( s1.length() > s2.length() ) {
				
				for(i=0; i<s1.length(); i++) {
					llist1.InsertAtFront(s1.charAt(i));
				}
				
				for(i=0; i < (s1.length() - s2.length()); i++) {
					llist2.InsertAtFront('0');
				}
				
				for(i=0; i<s2.length(); i++) {
					llist2.InsertAtFront(s2.charAt(i));
				}
				
				int carry = 0;
				
				for(i=0; i<s1.length(); i++) {
										
					int digit = 9 - llist2.getData(llist2.cur) + llist1.getData(llist1.cur) + carry;
					llist1.cur = llist1.cur.next;
					llist2.cur = llist2.cur.next;
					
					if (digit < 10) {
						llist_temp.InsertAtEnd(digit);
						carry = 0;
						
					} else if (digit >= 10) {
						digit = digit - 10;
						carry = 1;
						llist_temp.InsertAtEnd(digit);
					}	
				}

				
				int beforeAdd = 0;
				llist_temp.cur = llist_temp.first;
			
				for (i=0; i<s1.length(); i++) {
					beforeAdd = llist_temp.cur.data;
			
				if (beforeAdd < 9) {
					llist_temp.setData(llist_temp.cur, beforeAdd + 1);
					break;
				}
				
				else if (beforeAdd == 9) {
					int afterAdd = 0;
					llist_temp.setData(llist_temp.cur, afterAdd);
					llist_temp.cur = llist_temp.cur.next;
				}
			}

				for(i=0; i<s1.length(); i++)
				{
					llist_final.InsertAtFront(llist_temp.first.data);
					llist_temp.first = llist_temp.first.next;
				}
				
				String s = "";
						
				
				for(i=0; i<s1.length(); i++) {
					if (llist_final.first.data == 0)
						llist_final.first = llist_final.first.next;
					else 
						break;
					}
				
				for(i=0; i<s1.length(); i++) {
					if (llist_final.first == null) {
						break;
					}
					
					s += llist_final.first.data;
					llist_final.first = llist_final.first.next;
				}
				
				System.out.println(s);
				wr.write(s);
				
				
			} else if ( s1.length() < s2.length() ) {
				
				
				for(i=0; i < (s2.length() - s1.length()); i++) {
					llist1.InsertAtFront('0');
				}
				
				for(i=0; i<s1.length(); i++) {
					llist1.InsertAtFront(s1.charAt(i));
				}
				
				
				for(i=0; i<s2.length(); i++) {
					llist2.InsertAtFront(s2.charAt(i));
				}
				
				int carry = 0;
				
				for(i=0; i<s2.length(); i++) {
										
					int digit = 9 - llist1.getData(llist1.cur) + llist2.getData(llist2.cur) + carry;
					llist1.cur = llist1.cur.next;
					llist2.cur = llist2.cur.next;
					
					if (digit < 10) {
						llist_temp.InsertAtEnd(digit);
						carry = 0;
						
					} else if (digit >= 10) {
						digit = digit - 10;
						carry = 1;
						llist_temp.InsertAtEnd(digit);
					}	
				}

				
				int beforeAdd = 0;
				llist_temp.cur = llist_temp.first;
			
				for (i=0; i<s2.length(); i++) {
					beforeAdd = llist_temp.cur.data;
			
				if (beforeAdd < 9) {
					llist_temp.setData(llist_temp.cur, beforeAdd + 1);
					break;
				}
				
				else if (beforeAdd == 9) {
					int afterAdd = 0;
					llist_temp.setData(llist_temp.cur, afterAdd);
					llist_temp.cur = llist_temp.cur.next;
				}
			}

				for(i=0; i<s2.length(); i++)
				{
					llist_final.InsertAtFront(llist_temp.first.data);
					llist_temp.first = llist_temp.first.next;
				}
				
				String s = "";
						
				
				for(i=0; i<s2.length(); i++) {
					if (llist_final.first.data == 0)
						llist_final.first = llist_final.first.next;
					else 
						break;
					}
				
				for(i=0; i<s2.length(); i++) {
					if (llist_final.first == null) {
						break;
					}
					
					s += llist_final.first.data;
					llist_final.first = llist_final.first.next;
				}
				
				System.out.println(s);
				wr.write(s);
				
				
			} else if (s1.length() == s2.length() ) {
				
				for(i=0; i<s1.length(); i++) {
					llist1.InsertAtFront(s1.charAt(i));
				}
				
				for(i=0; i<s2.length(); i++) {
					llist2.InsertAtFront(s2.charAt(i));
				}
				
				if (s1.compareTo(s2) == 0) {
					
					for (i=0; i<s1.length(); i++) {
						int digit = llist1.getData(llist1.cur) - llist2.getData(llist2.cur);
						llist_temp.InsertAtFront(digit);
					}
					
					for (i=0; i<s1.length() - 1; i++) {
						llist_temp.cur = llist_temp.cur.next;
					}
					
					for (i=0; i<s1.length(); i++) {
						System.out.println(llist_temp.cur.data);
						wr.write(String.valueOf(llist_temp.cur.data));
						if (llist_temp.cur == llist_temp.last)
							break;
					}
				}
				
				if (s1.compareTo(s2) > 0) {
					
					int carry = 0;
					
					for(i=0; i<s1.length(); i++) {
						
						
						int digit = 9 - llist2.getData(llist2.cur) + llist1.getData(llist1.cur) + carry;
						llist1.cur = llist1.cur.next;
						llist2.cur = llist2.cur.next;
						
						if (digit < 10) {
							llist_temp.InsertAtEnd(digit);
							carry = 0;
							
						} else if (digit >= 10) {
							digit = digit - 10;
							carry = 1;
							llist_temp.InsertAtEnd(digit);
						}	
					}

					
				int beforeAdd = 0;
				llist_temp.cur = llist_temp.first;
				
				for (i=0; i<s1.length(); i++) {
					beforeAdd = llist_temp.cur.data;
				
					if (beforeAdd < 9) {
						llist_temp.setData(llist_temp.cur, beforeAdd + 1);
						break;
					}
					
					else if (beforeAdd == 9) {
						int afterAdd = 0;
						llist_temp.setData(llist_temp.cur, afterAdd);
						llist_temp.cur = llist_temp.cur.next;
					}
				}

				for(i=0; i<s1.length(); i++)
				{
					llist_final.InsertAtFront(llist_temp.first.data);
					llist_temp.first = llist_temp.first.next;
				}
				
				String s = "";
						
				
				for(i=0; i<s1.length(); i++) {
					if (llist_final.first.data == 0)
						llist_final.first = llist_final.first.next;
					else 
						break;
					}
				
				for(i=0; i<s1.length(); i++) {
					if (llist_final.first == null) {
						break;
					}
					
					s += llist_final.first.data;
					llist_final.first = llist_final.first.next;
				}
				
				System.out.println(s);
				wr.write(s);
				
				
				}
					
				
				if (s1.compareTo(s2) < 0) {
					
					int carry = 0;
					
					for(i=0; i<s1.length(); i++) {
						int digit = 9 - llist1.getData(llist1.cur) + llist2.getData(llist2.cur) + carry;
						llist1.cur = llist1.cur.next;
						llist2.cur = llist2.cur.next;
						
						if (digit < 10) {
							llist_temp.InsertAtEnd(digit);
							carry = 0;
							
						} else if (digit >= 10) {
							digit = digit - 10;
							carry = 1;
							llist_temp.InsertAtEnd(digit);
						}	
					}

					
				int beforeAdd = 0;
				llist_temp.cur = llist_temp.first;
				
				for (i=0; i<s1.length(); i++) {
					beforeAdd = llist_temp.cur.data;
				
					if (beforeAdd < 9) {
						llist_temp.setData(llist_temp.cur, beforeAdd + 1);
						break;
					}
					
					else if (beforeAdd == 9) {
						int afterAdd = 0;
						llist_temp.setData(llist_temp.cur, afterAdd);
						llist_temp.cur = llist_temp.cur.next;
					}
				}

				for(i=0; i<s1.length(); i++)
				{
					llist_final.InsertAtFront(llist_temp.first.data);
					llist_temp.first = llist_temp.first.next;
				}
				
				String s = "";
						
				
				for(i=0; i<s1.length(); i++) {
					if (llist_final.first.data == 0)
						llist_final.first = llist_final.first.next;
					else 
						break;
					}
				
				for(i=0; i<s1.length(); i++) {
					if (llist_final.first == null) {
						break;
					}
					
					s += llist_final.first.data;
					llist_final.first = llist_final.first.next;
				}
				
				System.out.println(s);
				wr.write(s);
				}		
			}
			
			rd.close();
			wr.close(); 
			}
			
			 catch (Exception e) {
					System.out.println("ERROR");
			 }
	
	}
	
	}