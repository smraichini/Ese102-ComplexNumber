/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ese102;
import complexnumber.*;
import java.io.*;
/**
 *
 * @author Simone
 */
public class Ese102 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader input= new InputStreamReader(System.in);
        BufferedReader tastiera= new BufferedReader(input);
        String r;
        int w=0;
        boolean v=false;
        double x = 0,y = 0;
        ComplexNumber.setInitRectangular(0,0);
        ComplexNumber.setInitPolar(0,0);
        ComplexNumber n1=new ComplexNumber();
        ComplexNumber n2=new ComplexNumber();
        n2.setRectangular(3, 4);
        System.out.println("Benvenuto nel più innovativo software di gestione di coordinate polari e rettangolari");
        while(w!=1 && w!=2)
        {
            try{
                System.out.println("Scegliere il tipo di coordinate da convertire Cartesiane/Polari (1/2)");
                r= tastiera.readLine();
               
                try {
                    w=Integer.valueOf(r).intValue();
                }
                catch (NumberFormatException e ){
                    System.out.println("Scelta non valida ");
                }
                
        if(w==1){
        while(!v)
        {
                
            System.out.print("Inserisci il valore della parte reale: ");
            r= tastiera.readLine();
            try {
                x=Double.valueOf(r).doubleValue();
                v = true;
            }
            catch (NumberFormatException e ){
                System.out.println("Numero non valido");
                    
            }        
        }
        v=false;
        
        while(!v)
        {
                System.out.print("Inserisci il valore della parte immaginaria: ");
               r= tastiera.readLine();
                try {
                    y=Double.valueOf(r).doubleValue();
                    v = true;
                }
                catch (NumberFormatException e ){
                    System.out.println("Numero non valido");
                }
         }
        n1.setRectangular(x,y);
        System.out.println("Il valore del modulo è"+" "+n1.getModulus());
        System.out.println("Il valore dell'argomento è"+" "+n1.getArgument());
        }
        else if(w==2){
            while(!v)
            {               
                System.out.print("Inserisci il valore dell'Argomento: ");
                r= tastiera.readLine();
                try {
                    y=Double.valueOf(r).doubleValue();
                    v = true;
                }
                catch (NumberFormatException e ){
                    System.out.println("Numero non valido");
                }
                 
        }
        v=false;
        while(!v)
        {
                System.out.print("Inserisci il valore del Modulo: ");
               r= tastiera.readLine();
                try {
                    x=Double.valueOf(r).doubleValue();
                    n1.setPolar(x, y);
                    v = true;
                }
                catch (NumberFormatException e ){
                    System.out.println("Numero non valido");
                }
                catch(IllegalArgumentException e)
                {
                System.out.println("Il valore del modulo deve essere maggiore o uguale a 0");
                }

                    
        }
          
        System.out.println("Il valore di Re è"+" "+n1.getRe());
        System.out.println("Il valore di Im è"+" "+n1.getIm());
        
        }

            }
           catch(NumberFormatException e ){
                 System.out.println("Scelta non valida");
           }
           
            
            System.out.println("Il valore del numero da te inserito sommato a 3+4i è uguale a:");
            ComplexNumber c=ComplexNumber.add(n1,n2);
            System.out.println(c.toString());
            c=new ComplexNumber();
            System.out.println("Il valore del numero da te inserito sottrattaendo 3+4i è uguale a:");
            c=ComplexNumber.sub(n1,n2);
            System.out.println(c.toString());
            c=new ComplexNumber();
            System.out.println("Il valore del numero da te inserito moltiplicato per 3+4i è uguale a:");
            c=ComplexNumber.multiply(n1,n2);
            System.out.println(c.toString());
            c=new ComplexNumber();
            System.out.println("Il valore del numero da te inserito diviso per 3+4i è uguale a:");
            c=ComplexNumber.divide(n1,n2);
            System.out.println(c.toString());
            System.out.println("Il valore del numero coniugato è "+ ComplexNumber.getConjugate(n1).toString());
         
    }
      
    }
      
}
