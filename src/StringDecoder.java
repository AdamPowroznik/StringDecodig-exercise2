	import java.util.*;
	
public class StringDecoder {
		public static void main(String[] args) {
				String stringToDecode1 = "13 PUSH 7 PUSH POP 3 8 9 PUSH + 0 PUSH 8 PUSH POP - 3 PUSH 7 PUSH 8 POP";
				System.out.println("Top value of the stack is: "+Solution(stringToDecode1));
				System.out.println("\n\n\n");
				
				String stringToDecode2 = "10 PUSH 11 99999999999999999999999999999999999999999999999999999999 PUSH -";
				System.out.println("Top value of the stack is: "+Solution(stringToDecode2));
				System.out.println("\n\n\n");
				
				String stringToDecode3 = "11 PUSH 10 99999999999999999999999999999999999999999999999999999999 PUSH -";
				System.out.println("Top value of the stack is: "+Solution(stringToDecode3));
				System.out.println("\n\n\n");
				
				String stringToDecode4 = "- PUSH - - PUSH -";
				System.out.println("Top value of the stack is: "+Solution(stringToDecode4));
				System.out.println("\n\n\n");
				
				String stringToDecode5 = "999999999 PUSH 10 PUSH +";
				System.out.println("Top value of the stack is: "+Solution(stringToDecode5));
				System.out.println("\n\n\n");
				
		}
	/**
	 * I can't remember exactly content of this exercise (1:1) but as far as I remember:
	 * Function Solution takes some String S as a parameter, and returns int value from the top of a stack. 
	 * String S contains commands: 
	 * PUSH - pushes an item (last valid) onto the top of the stack,
	 * POP - removes an item at the top of the stack,
	 * + - add two top items of the stack and place the value at the top of the stack and NOT (?) remove those two added items from the stack,
	 * - - subtract two top items of the stack and place the value at the top of the stack, and NOT (?) remove those two subtracted items from the stack, 
	 * S also contains some positive integers (with 0?), but I can't remember exactly what they were.
	 * Every to commands are separated by empty space (" "). But I'm only a human and I can be wrong. 
	 * @param S - Thats the String to decode
	 * @return The Value from the top of the stack or -1 i the stack is empty.
	 */
		public static int Solution(String S) {
			Stack<Integer> stack = new Stack<Integer>();
			int currentNumber = -1;
			outerLoop:
			while(!S.isEmpty()) 
			{
				String commandString = "";
				S.trim();
				if(S.contains(" ")) {
					commandString = S.substring(0, S.indexOf(" "));
					S = S.substring(S.indexOf(" ")+1);
				}

					
				else {
					commandString = S;
					S = "";
				}
				
				if(commandString.equalsIgnoreCase("PUSH")) {
					if(currentNumber >= 0) {
						stack.push(currentNumber);
					}
				}
				else if(commandString.equalsIgnoreCase("POP")) {
					if(!stack.isEmpty()) {
						stack.pop();
					}
				}
				else if(commandString.equals("+")) {
					if(stack.size()>=2) {
						int newValue = stack.peek() + stack.elementAt(stack.size()-2);
						if(newValue >= 0)
						stack.push(newValue);
					}
					
				}
				else if(commandString.equals("-")) {
					if(stack.size()>=2) {
						int newValue = stack.peek() - stack.elementAt(stack.size()-2);
						if(newValue >= 0)
						stack.push(newValue);
					}
				}
				else {
					try { 
				        Integer.parseInt(commandString);
						
				       /* catch(NumberFormatException e) { 
					       
					    } catch(NullPointerException e) {
					        
					    }*/
				    } catch(Exception e) { 
				    	System.out.println("Nieprawid³owa liczba\n");
				    	continue outerLoop;
				    } 
					currentNumber = Integer.parseInt(commandString); //wont go if commandString is not an valid Integer
				}
				
				//DEBUG SECTION
				System.out.println("Command: "+commandString);
				if(stack.size()>0)
					System.out.println("Top value: "+stack.peek());
				System.out.println("Stack size: "+stack.size()+"\n");
			}
			
			if(stack.size()>0)
				return stack.peek();
			else 
				return -1;
		}
}
