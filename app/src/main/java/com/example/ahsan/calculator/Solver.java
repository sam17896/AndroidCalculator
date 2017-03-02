package com.example.ahsan.calculator;

/**
 * Created by AHSAN on 7/30/2016.
 */
public class Solver {
    boolean number = false;
    @SuppressWarnings("empty-statement")
    public String convertion(String str)
    {
        String profix = "";
        char value;
        Stack stack = new Stack(str.length());
        for(int i=0;i<str.length();i++)
        {
            char op = str.charAt(i);
            switch(op)
            {
                case '(':
                {
                    if(number)
                    {
                        number=false;
                        profix += ',';
                    }
                    stack.push(op);
                    break;
                }
                case ')':
                {
                    if(number)
                    {
                        number=false;
                        profix += ',';
                    }
                    while(stack.TOS()!='(')
                    {
                        //value = stack.pop();
                        profix = profix + stack.pop();
                        //System.out.println(value);
                    }
                    stack.pop();
                    break;
                }
                case '/':
                {
                    if(number)
                    {
                        number=false;
                        profix += ',';
                    }
                    stack.push(op);
                    break;
                }
                case '*':
                {
                    if(number)
                    {
                        number=false;
                        profix += ',';
                    }
                    while(stack.TOS()=='/'||stack.TOS()=='*')
                    {
                        profix = profix + stack.pop();
                    }
                    stack.push(op);
                    break;
                }
                case '+':
                {
                    if(number)
                    {
                        number=false;
                        profix += ',';
                    }
                    while(stack.TOS()=='/'||stack.TOS()=='*'||stack.TOS()=='+')
                    {
                        profix = profix + stack.pop();
                    }
                    stack.push(op);
                    break;
                }
                case '-':
                {
                    if(number)
                    {
                        number=false;
                        profix += ',';
                    }
                    while(stack.TOS()=='/'||stack.TOS()=='*'||stack.TOS()=='-')
                    {
                        profix = profix + stack.pop();
                    }
                    stack.push(op);
                    break;
                }
                case '.':
                {
                    profix = profix + op;
                    break;
                }
                default:
                {
                    number=true;
                    profix = profix + (op-'0');
                    break;
                }
            }
        }
        profix += ',';
        while(!stack.isEmpty())
        {
            char temp = stack.pop();
            if(temp!='(')
            {
                profix = profix + temp;
            }
        }
        return profix;
    }
    public double solve(String str)
    {
        double value=0;
        double mul = 10;
        double div = 10;
        double dec = 1;
        int j=0;
        boolean decimal = false;
        StackInt stack = new StackInt(str.length());
        for(int i=0;i<str.length();i++)
        {
            double r,l;
            char op;
            if(str.charAt(i)=='+'||str.charAt(i)=='/'||str.charAt(i)=='-'||str.charAt(i)=='*')
            {
                double val = 0;
                l=stack.pop();
                r=stack.pop();
                op=str.charAt(i);
                if(op=='+')
                {
                    val=r+l;
                    System.out.println(r+"+"+l+"="+val);
                }
                if(op=='-')
                {
                    val=r-l;
                    System.out.println(r+"-"+l+"="+val);
                }
                if(op=='/')
                {
                    val=r/l;
                    System.out.println(r+"/"+l+"="+val);
                }
                if(op=='*')
                {
                    val = r*l;
                    System.out.println(r+"*"+l+"="+val);
                }
                stack.push(val);
            }
            else if(str.charAt(i)==',')
            {
                continue;
            }
            else
            {
                if(str.charAt(i)=='.')
                {
                    decimal = true;
                    i++;
                    dec = str.charAt(i)-'0';
                }
                else
                    value = str.charAt(i)-'0';
                i++;
                while(str.charAt(i)!=',')
                {
                    if(str.charAt(i)=='.')
                    {
                        decimal=true;
                        i++;
                        dec = str.charAt(i)-'0';
                        j=0;
                        mul=10;
                    }
                    int temp = str.charAt(i)-'0';
                    if(!decimal)
                    {
                        value*=mul;
                        value+=temp;
                        i++;
                        if(i==str.length())
                            break;
                    }
                    else{
                        if(j==0)
                        {
                            j++;
                            i++;
                        }
                        else if(j>0)
                        {
                            dec*=mul;
                            div*=10;
                            dec+=temp;
                            i++;
                            if(i==str.length())
                                break;
                        }
                    }
                }
                if(decimal)
                {
                    dec/=div;
                    value+=dec;
                }
                mul = 10;
                System.out.println(value);
                stack.push(value);
                value = 0;
                j=0;
                decimal = false;
                dec = 0;
            }
        }
        return stack.pop();
    }
}

class Stack
{
    char []arr;
    int max;
    int top;
    Stack(int size)
    {
        max=size;
        arr = new char[max];
        top=0;
    }
    boolean isFull()
    {
        return top==max;
    }
    boolean isEmpty()
    {
        return top==0;
    }
    void push(char x)
    {
        if(!isFull())
        {
            arr[top]=x;
            top++;
        }
        else
        {
            System.out.println("The stack is full");
        }
    }
    char TOS()
    {
        if(!isEmpty())
            return arr[top-1];
        else return ' ';
    }
    char pop()
    {
        char value = ' ';
        if(!isEmpty())
        {
            value = arr[top-1];
            top--;
        }
        else
        {
            System.out.println("The Stack is Empty!!");
        }
        return value;
    }
}

class StackInt
{
    double []arr;
    int max;
    int top;
    StackInt(int size)
    {
        max=size;
        arr = new double[max];
        top=0;
    }
    boolean isFull()
    {
        return top==max;
    }
    boolean isEmpty()
    {
        return top==0;
    }
    void push(double x)
    {
        if(!isFull())
        {
            arr[top]=x;
            top++;
        }
        else
        {
            System.out.println("The stack is full");
        }
    }
    double pop()
    {
        if(!isEmpty())
        {
            double value = arr[top-1];
            top--;
            return value;
        }
        else
        {
            System.out.println("The Stack is Empty!!");
            return 0;
        }
    }
}
