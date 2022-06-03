import java.util.*;

class Subject{
    private String name; // creating variable name to store name of the subject
    private String code; // creating code variable to store code for the subject

    // initalixing the objec of the Subejct class using empty constructer
    public Subject(){}
    
   // parameterized constructor to initalize the data members
    public Subject(String name, String code)
    {
        this.name = name;
        this.code = code;
    }
    
    //method to assign passed values from the main method
    public void add(String name, String code){
        this.name = name;
        this.code = code;
    }
    
    // setter method to set user defined values to the private scope data member name
    public void setName(String name){
        this.name = name; 
    }
    
    // getter method to dispaly name of the subject which is in the private scope
    public String getName(){
        return name;
    }
    
    // setter method to set user defined values to the private scope data member code
    public void setCode(String code){
        this.code = code;
    }

    // getter method to dispaly code of the subject which is in the private scope
    public String getCode(){
        return code;
    }

   // to override predefined function toString inorder to diaplay the object value in string format
    @Override
    public String toString(){
        return (name + " " + code + "\n");
    }

    // to check weather the value of code for the subject is in correct format or not
    public boolean isValid(String code){
        this.code = code;
        boolean flag= false;
        out:
        if(code.length()==7)
        {
            char[] a=code.toCharArray();
            // check for arrary elements result = passed
            // System.out.println("check for char array: " + a);
            // for (char ele: a) {
            //     System.out.println(ele);
            // }
            int i=0;
            //out:
            for(i=0; i<3; i++)
            {           
                 flag = Character.isLetter(a[i]);
                 if(flag == false)
                 {
                    System.out.println("Invalid format: Use Alphabets upto 3rd place");
                    break out;
                 }
            }
            for(i=3; i<7; i++)
            {           
                 flag = Character.isDigit(a[i]);
                 if(flag == false)
                 {
                    System.out.println("Invalid format: Use numbers from 4rd place");
                    break out;
                 }
            }
        }
        else
        {
            System.out.println("The code is invalid.");
        }
        return flag;        
    }
    
    // method to check weather the user provided code is unique or not
    public int codeExist(Subject[] sub, int a)
    {
        int n = a;
        int x = 0;
        out:
        if(n > 0)
        {
            for(int i = 0; i < n; i++)
            {
                for(int j=i+1; j <= n; j++)
                {
                    //System.out.println(sub[i].code + " this if from codeExist " + sub[j].code);
                    String s1 = sub[i].code;
                    String s2 = sub[j].code;

                    if(s1.equals(s2))
                    {
                        System.out.println("But the subject code already exists.\n");
                        x = 1;
                        break out;
                        
                    }
                }
            }

        }  
        return x;

    }
    
    // method to diaplay the names of the subject in alphabetical order along with the subject codes 
    public void sortDiscipline(Subject[] sub)
    {
        int n = sub.length;
        String names[] = new String[n];
        String codes[] = new String[n];
        for(int i=0; i < n; i ++)
        {
           names[i] = sub[i].name;
           codes[i] = sub[i].code;
        }
        String temp, ctemp;


        if(n > 1)
        {
            for (int i = 0; i < n; i++) 
            {
                for (int j = i + 1; j < n; j++) 
                {
                        // to compare one string with other strings
                        if (names[i].compareTo(names[j]) > 0) 
                        {
                            // swapping
                            temp = names[i];
                            ctemp = codes[i];

                            names[i] = names[j];
                            codes[i] = codes[j];

                            names[j] = temp;     
                            codes[j] = ctemp;                   
                        }
                }
            }

        }
       // print output array of names of the subjects in alphabetical order
       System.out.println("\nThe names in alphabetical order are: ");
       for (int i = 0; i < n; i++) 
       {
           System.out.println(i+1 + ". " + names[i] + " " +codes[i]);
        }
    }
}
public class subjectTest {
    public static void main(String[] args) 
    {
        // creating an array of object of class Student 
        Subject[] sub = new Subject[5];

        // assign object to each of the assigned array index
        sub[0] = new Subject();

        // implementing array with assigning name and subject code into the each object of class Student within array index one by one
        for(int i = 0; i < sub.length; i++)  // to access each object of student
        {
            sub[i] = new Subject(); // assign object of Student class to array
            Scanner sc = new Scanner(System.in);  // scanner function to read data from user

            // reading subject name from the user
            System.out.print("\nEnter subject name: ");
            String name = sc.nextLine();
            sub[i].setName(name);
            sub[i].getName();
           
            restart:

            for(int j=0; j < 3; j++)
            {

                // reading subject code from the user
                System.out.print("Enter subject code: ");
                String code = sc.nextLine();
                sub[i].setCode(code);
                sub[i].getCode();

                // checking the format of code either valid or not
                

                if( sub[i].isValid(sub[i].getCode()) == true)
                {
                    System.out.println("Successfully inserted.");

                    // checking weather the subject code already exist or not
                    if(sub[i].codeExist(sub, i) == 1)
                    {
                        continue restart; 
                    }

                    break restart;
                }
                //restart:
                else
                {
                    System.out.println("Invalid Code (Use code format as: 'BIT2018')");
                    
                }
            }
           // System.out.println("\nsubject: " + sub[i].getName() + "\n" + "Code: " + sub[i].getCode() );
            // System.out.println(sub[i].toString());
        }
        // to display the name of the subject in alphabetical order along with subject codes
        sub[4].sortDiscipline(sub);
    }

}
