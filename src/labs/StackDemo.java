package labs;


class Stack {

    int top;
    int[] stack;
    int n;

    Stack(int size) {

        n = size;
        stack = new int[n];
        top = -1;

    }


    // Declaration of function push() to push a number into stack
    void push(int num) {


        if (top == n - 1) {
            System.out.print("Overflow\n");

        } else {

            stack[++top] = num;
            System.out.print("Number pushed into stack\n");
        }

    }

    // Declaration of function pop() to delete a number from stack
    void pop() {


        if (top == -1) {
            System.out.print("Underflow\n");
        } else {

            System.out.printf("\nNumber poped from stack: %d", stack[top]);
            top--;
        }

        System.out.println();
    }


    // Declaration of function disp() to dispaly elements of stack
    void disp() {
        int i;

        if (top == -1) {
            System.out.print("The Stack is empty\n");
        } else {
            for (i = top; i >= 0; i--) {

                System.out.printf("%d  ", stack[i]);
            }
        }

        System.out.println();
    }


}

class StackDemo {


    public static void main(String[] args) {


        // Enter the size of the stack
        int size = 5;
        Stack ele = new Stack(size);


        for (int i = 0; i < size; i++) {

            ele.push(i + 2);
        }

        System.out.print("\nThe elements in stack:\n ");
        ele.disp();

        ele.pop();
        ele.pop();

        System.out.print("\nThe elements in stack:\n ");
        ele.disp();


    }


}



