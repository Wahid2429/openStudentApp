import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Test {

    public static int totaln=0;
    public static ArrayList<String> fname;
    public static ArrayList<String> lname;
    public static ArrayList<String> dob;
    public static ArrayList<String> gender;
    public static ArrayList<Integer> standard;
    public static ArrayList<Integer> rollno;
    public static ArrayList<Float> maths;
    public static ArrayList<Float> science;
    public static ArrayList<Float> social;
    public static ArrayList<Float> eng;
    public static ArrayList<Float> percentage ;

     public static void entry() {

        int num;

        try (Scanner sc = new Scanner(System.in)) {
			fname= new ArrayList<>();
			 lname= new ArrayList<>();
			 dob= new ArrayList<>();
			 gender= new ArrayList<>();
			 standard= new ArrayList<>();
			 rollno= new ArrayList<>();
			 maths =new ArrayList<>();
			 science = new ArrayList<>();
			 social = new ArrayList<>();
			 eng = new ArrayList<>();
			 percentage = new ArrayList<>();

			System.out.print("Enter the number of students: ");
			num = sc.nextInt();
			if(num==0 || num<0){
			    System.out.println("Invalid Entry.");
			}
			   else {
			        for (int i = 0; i < num; i++) {
			            System.out.println();
			            System.out.println("Student: " +(i+1));
			            System.out.print("Enter the standard: ");
			            standard.add(sc.nextInt());
			            System.out.print("Enter the first name: ");
			            fname.add(sc.next());
			            System.out.print("Enter the last name: ");
			            lname.add(sc.next());
			            System.out.print("Enter the roll no: ");
			            rollno.add(sc.nextInt());
			            System.out.print("Enter the date of birth: ");
			            dob.add(sc.next());
			            System.out.print("Enter the gender: ");
			            gender.add(sc.next());
			            System.out.print("Enter the marks in Maths: ");
			            maths.add(sc.nextFloat());
			            System.out.print("Enter the marks in Science: ");
			            science.add(sc.nextFloat());
			            System.out.print("Enter the marks in Social: ");
			            social.add(sc.nextFloat());
			            System.out.print("Enter the marks in English: ");
			            eng.add(sc.nextFloat());
			            percentage.add((maths.get(i)+ science.get(i)+ social.get(i)+ eng.get(i))/4);
			        }
			        totaln+=num;

			    }
		}


    }
    public static void display(){
        if(totaln==0){
            System.out.println("No data has been entered.");
        }
        else{
            System.out.println();
            System.out.println("Student Details");
            for (int i=0;i<totaln;i++){
                System.out.println();
                System.out.println("Name " +fname.get(i)+" "+lname.get(i));
                System.out.println("Standard: "+standard.get(i));
                System.out.println("Roll no: " +rollno.get(i));
                System.out.println("Date of birth: " +dob.get(i));
                System.out.println("Gender: " +gender.get(i));
                System.out.println("Percentage: " +percentage.get(i));
            }

        }

    }
    public static void search(){
        int roll;
        try (Scanner sc = new Scanner(System.in)) {
			if(totaln==0){
			    System.out.println("No data has been entered.");
			}
			else{
			    System.out.println();
			    System.out.println("Enter the roll no of the student to search: ");
			    roll = sc.nextInt();
			    int s=0;

			    for(int i=0;i<totaln;i++){
			        if(roll==rollno.get(i)){
			            s=s+1;
			            System.out.println();
			            System.out.println("Name " +fname.get(i)+" "+lname.get(i));
			            System.out.println("Standard: "+standard.get(i));
			            System.out.println("Roll no: " +rollno.get(i));
			            System.out.println("Maths: "+maths.get(i));
			            System.out.println("Science: "+science.get(i));
			            System.out.println("Social: "+social.get(i));
			            System.out.println("English: "+eng.get(i));
			            System.out.println("Percentage: " +percentage.get(i));

			        }

			    }
			    if(s>0) {
			        System.out.println("Invalid entry. ");
			    }
			}
		}

    }
    public static void sort(){
        if(totaln==0){
            System.out.println("No data has been entered.");
        }
        else{
            int c= percentage.size();
            for (int i=0; i<c-1; i++)
            {
                int pos = i;
                for (int j=i+1; j<c; j++)
                {
                    if (percentage.get(j) > percentage.get(pos))
                    {
                        pos = j;
                    }
                }
                float t1 = percentage.get(pos);
                percentage.add(pos, percentage.get(i)) ;
                percentage.add(i,t1);

                String f = fname.get(pos);
                fname.add(pos,fname.get(i));
                fname.add(i,f);

                String l = lname.get(pos);
                lname.add(pos,lname.get(i));
                lname.add(i,l);
            }
            System.out.println("The required order: ");

            for (int i=0;i<3;i++){
                System.out.println("Rank: " +(i+1));
                System.out.println("Percentage: "+percentage.get(i));
                System.out.println("Name: " +fname.get(i)+" "+lname.get(i));
            }



        }
    }

    public static void delete(){
        int roll;
        try (Scanner sc = new Scanner(System.in)) {
			if(totaln==0){
			    System.out.println("No data has been entered.");
			}
			else{
			    int choice;
			    System.out.println("Enter 1 to delete all record:");
			    System.out.println("Enter 2 to delete the record of a student");
			    choice= sc.nextInt();
			    if(choice==1){
			        totaln=0;
			        System.out.println("All the records have been deleted.");

			    }
			    else if(choice==2){
			        System.out.println();
			        System.out.println("Enter the roll no of the student you miss delete the record of: ");
			        roll = sc.nextInt();

			        for(int i=0;i<totaln;i++){
			            if(roll==rollno.get(i)){
			                for(int j=i;j<totaln;j++){
			                    standard.remove(j);
			                    fname.remove(j);
			                    lname.remove(j);
			                    rollno.remove(j);
			                    dob.remove(j);
			                    gender.remove(j);
			                    percentage.remove(j);
			                }
			                totaln--;
			                System.out.println("The record has been deleted.");

			            }
			        }

			    }
			    else {
			        System.out.println("Invalid input.");
			    }

			}
		}

    }

    public static void main(String[] args) throws NoSuchElementException {
        try (Scanner sc = new Scanner(System.in)) {
			int value;
			char ch;
			do {
			    System.out.println("Enter 1 to enter data.");
			    System.out.println("Enter 2 to show data.");
			    System.out.println("Enter 3 to search data.");
			    System.out.println("Enter 4 to view the result in descending order: ");
			    System.out.println("Enter 5 to delete data.");
			    System.out.println("Enter 6 to exit.");
			    System.out.println();
			    System.out.print("Enter the value: ");
			    value=sc.nextInt();
			    switch(value){
			        case 1:
			            entry();
			            break;
			        case 2:
			            display();
			            break;
			        case 3:
			            search();
			            break;
			        case 4:
			            sort();
			            break;
			        case 5:
			            delete();
			            break;
			        case 6:
			            break;
			        default:
			            System.out.println("Invalid input.");
			            break;
			    }
			    System.out.println("Do you want to continue(y/n): ");
			    ch=sc.next().charAt(0);
			}while(ch=='y' || ch=='Y');
		}
    }
}