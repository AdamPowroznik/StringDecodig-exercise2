This app contains a Solution to some excercise.
The Solution decodes a String S which contains positive integers or commands where all commands and integers are separated by empty space (" "),
* Function Solution takes some String S as a parameter, and returns int value from the top of a stack. 
* String S contains commands: 
* 'PUSH' - pushes an item (last valid) onto the top of the stack,
* 'POP' - removes an item at the top of the stack,
* '+' - add two top items of the stack and place the value at the top of the stack and NOT (?) remove those two added items from the stack,
* '-' - subtract two top items of the stack and place the value at the top of the stack, and NOT (?) remove those two subtracted items from the stack, 
* S also contains positive integers (with 0).
* Every two commands are separated by empty space (" "). 
* @param S - Thats the String to decode
* @return The Value from the top of the stack or -1 i the stack is empty.
