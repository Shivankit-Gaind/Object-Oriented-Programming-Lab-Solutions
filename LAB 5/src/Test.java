class A { public int a =100;} // End of class A
class B extends A { public int a =80; } // End of class B
class C extends B { public int a =60; } // End of class C
class D extends C { public int a =40; } // End of class D
class E extends D
{
public int a =10;
public void show()
{
int a =0;
System.out.println(a);
System.out.println(this.a);
System.out.println(new A().a);
System.out.println(new B().a);
System.out.println(new C().a);
System.out.println(super.a);
} // End of show() Method
}// End of class E

class Test {
public static void main(String args[]){
new E().show(); // This is an example of anonymous object
A a1 = new E();
D d1 = (D) a1; //What does that mean??
}// End of main()
}// End of class EX3Test
