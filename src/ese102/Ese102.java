/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ese102;
import complexnumber.*;
/**
 *
 * @author Simone
 */
public class Ese102 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ComplexNumber n1=new ComplexNumber();
        n1.setCartesian(-3, 3);
        System.out.println(n1.getModulus());
        System.out.println(n1.getArgument());
    }
    
}
