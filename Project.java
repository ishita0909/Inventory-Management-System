import java.util.*;
import java.io.*;



class Project{

void addItem(String a,String b){
try{
FileWriter fw=new FileWriter("C:\\Users\\hp/Documents\\javaprogram\\Inventory.txt",true);
fw.write(a+" : Rs."+b+"\n");
fw.close();

}
catch(Exception e){
System.out.println(e);
}
}

void deleteItem(String i){
try{
File f=new File("C:\\Users\\hp/Documents\\javaprogram\\Inventory.txt");
Scanner sc=new Scanner(f);
String s="";
while(sc.hasNext()){
String temp=sc.nextLine();
if(temp.indexOf(i)==-1){
s=s+temp+"\n";
}
else if(temp.equals("")){
System.out.println("Inventory is empty");
}
}

FileWriter fw=new FileWriter("C:\\Users\\hp\\Documents\\javaprogram\\Inventory.txt");
fw.write(s);
fw.close();
}
catch(Exception e){
System.out.println(e);
}
}

void updatePrice(String oldP,String newP){
try{
File f=new File("C:\\Users\\hp\\Documents\\javaprogram\\Inventory.txt");
Scanner sc=new Scanner(f);
String s="";
while(sc.hasNext()){
s=s+sc.nextLine()+"\n";
}
s=s.replaceAll(oldP,newP);
FileWriter fw=new FileWriter("C:\\Users\\hp\\Documents\\javaprogram\\Inventory.txt");
fw.write(s);
fw.close();
}
catch(Exception e){
System.out.println(e);
}
}

void printInventory(){
try{
File f=new File("C:\\Users\\hp\\Documents\\javaprogram\\Inventory.txt");
Scanner sc=new Scanner(f);
while(sc.hasNext()){
System.out.println(sc.nextLine());
}

}
catch(Exception e){
System.out.println(e);
}
}

void bill(String p){
try{
File f=new File("C:\\Users\\hp\\Documents\\javaprogram\\Inventory.txt");
Scanner sc=new Scanner(f);
String s="";
while(sc.hasNext()){
String temp=sc.nextLine();
if(temp.indexOf(p)==0){
s=s+temp+"\n";
}
}
FileWriter fw=new FileWriter("C:\\Users\\hp\\Documents\\javaprogram\\Bill.txt",true);
fw.write(s);
fw.close();
}
catch(Exception e){
System.out.println(e);
}
}

void printBill(){
try{
File f=new File("C:\\Users\\hp\\Documents\\javaprogram\\Bill.txt");
Scanner sc=new Scanner(f);
while(sc.hasNext()){
System.out.println(sc.nextLine());
}

}
catch(Exception e){
System.out.println(e);
}
}

public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
Project pr=new Project();
System.out.println("1.Admin");
System.out.println("2.User");
System.out.println("Enter option");
int ch=sc.nextInt();
String user_A="",pass_A="",user_C="",pass_C="";
char c,g;
switch(ch){
case 1:
System.out.println("Enter admin username");
   user_A=sc.next();
System.out.println("Enter admin password");
pass_A=sc.next();
if(user_A.equals("ABC")&&pass_A.equals("1234")){
do{
System.out.println("Welcome Admin");
System.out.println("1.Add an item");
System.out.println("2.Delete an item");
System.out.println("3.Update price");
System.out.println("Enter choice");
int t=sc.nextInt();
switch(t){
case 1:
System.out.println("Enter item name");
String itemName=sc.next();
System.out.println("Enter price");
String price=sc.next();
pr.addItem(itemName,price);
break;
case 2:
System.out.println("Enter item");
String item_R=sc.next();
pr.deleteItem(item_R);
break;
case 3:
System.out.println("Existing Inventory:");
pr.printInventory();
System.out.println("Enter item to be updated");
String item=sc.next();
System.out.println("Enter old price");
String o=sc.next();
System.out.println("Enter new price");
String np=sc.next();
pr.updatePrice(o,np);
break;
default:
System.out.println("Entered choice is invalid");
}
System.out.println("Would you like to further continue editing the inventory?");
c=sc.next().charAt(0);
}while(c=='y'||c=='Y');
}//close of if
else if(user_A.equals("ABC")&&!pass_A.equals("1234"))
System.out.println("Incorrect Password");
else
System.out.println("Entered login details are invalid");
break;
case 2:
System.out.println("Enter username");
user_C=sc.next();
System.out.println("Enter password");
pass_C=sc.next();
if(user_C.equals("XYZ")&&pass_C.equals("4567")){
do{
System.out.println("Welcome Customer");
System.out.println("List of items in the Inventory:");
pr.printInventory();
System.out.println("Enter item to be purchased");
String purchase=sc.next();
pr.bill(purchase);
System.out.println("Would you like to purchase another item?");
g=sc.next().charAt(0);
}while(g=='y'|| g=='Y');
System.out.println("Items purchased");
pr.printBill();
}
else if(user_C.equals("XYZ")&&!pass_C.equals("5678"))
System.out.println("Incorrect Password");
else
System.out.println("Entered login details are invalid");
break;
default:
System.out.println("Entered choice is invalid");
}
}
}