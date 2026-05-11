import java.io.*;
import java.util.*;

class Main {
   int grade(float per)
{
    if(per>=90)
    System.out.println("Grade:A+");
    else if(per>=80)
    System.out.println("Grade:A");
    else if(per>=70)
    System.out.println("Grade:B");
    else if(per>=60)
    System.out.println("Grade:C");
    else if(per>=50)
    System.out.println("Grade:D");
    else if(per>=40)
    System.out.println("Grade:E");
    else
    System.out.println("Grade:F");
    return 0;
}
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Main obj=new Main();
        
        System.out.print("Enter no of subjects:");
        int n=sc.nextInt();
        sc.nextLine(); 
        
        String[] subs=new String[n];
        float[] marks=new float[n];
        float sum=0;
        boolean isFail=false;
        if(n>0)
        {
            for(int i=0;i<n;i++)
            {
              System.out.print("\nEnter name of the subject "+(i+1)+": ");
              subs[i]=sc.nextLine();
              float mark;
              while(true)
              {
                 System.out.print("Enter marks for "+subs[i]+": ");
                 mark=sc.nextFloat();
                 if(mark>0 && mark<=100)
                    break;
                else
                    System.out.println("Invalid marks!!");
              }
              sc.nextLine();
              if(mark<40)
                isFail=true;
            sum+=mark;
            }
            float per=sum/n;
            if(isFail)
            {
                System.out.println("RESULT:FAIL");
            }
            else
            {
                
                System.out.println("Total marks:"+sum);
                obj.grade(per);
                System.out.println("Result:PASS");
            }
        }
        
    }
}










