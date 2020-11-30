- Exception
- an exceptional situation, which can occur
in given program

Throwable (first class)
-all exceptions are in the class Throwable, or at least
occur in an extended class of it

throwable splits in error and exceptions

error - is a large problem, that a program can't 
solve, even with help of exceptions

exceptions split in RuntimeException
- all RuntimeExceptions are unchecked exceptions
- they will work in java by it's own
- this hasn't to occur in your program, but can
- unchecked exceptions occur, if your
customer uses your code incorrectly
- compiler doesn't need to read this exceptions

- checked exceptions you have to put in sagnture
of your code, that it can occur
- exceptions you expect to occur
- compiler has to read this exceptions in code


syntax for exceptions:
- Exception ex = new IndexOutOfBounds();
  throw ex; (trow new IndexOOBE();)
  
try/catch marks the place in code, where exception can occur  
Library:
 class Ourclass{
 
  public void ourMethod(){
      throw new IndexOutOfBoundException();
        }
      }
 client code:
 
 
 OurClass instance = new OurClass();
 try {
        instance.ourMethod();
   }catch(IndexOutOfBoundExceptions e){
   //logic of program, which has be fulfilled if exceptions is catched
     

try {
someMethod();
}catch (A ex){
...}catch(B ex){
....}

try{
 someMethod();
 }catch(A|B ex){
 ...}
 
 
 
 }finally{ // will always execute // is mostly used to clean resources
 
 
 try{
   sout("try");
   throw new AException();
   } finally{
   sout("finally");
    throw new BExceptions();
   }
   
   
   BException has more priority, if there is no catch for AException,
   because there can't be thrown 2 Exceptions at same time.