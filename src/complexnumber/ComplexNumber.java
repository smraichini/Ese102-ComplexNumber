/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexnumber;


public class ComplexNumber {
    private double re;
    private double im;
 
    public String formatComplexNumber() {
        String r = this.getRe() + "+(" + this.getIm() + ")i";
        return r;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }
    
    public void setPolar(double mod, double arg){
        this.im=Math.sin(arg)*mod;
        this.re=Math.cos(arg)*mod;
        }
    
    public void setCartesian(double re, double im ){
        this.im=im;
        this.re=re;
        }
    
    
    public double getModulus(){
        
        return(Math.sqrt(Math.pow(this.re,2)+Math.pow(this.im,2)));
    }
    
    public double getArgument(){
        return((Math.atan(this.im/this.re)*180)/3.14);
    }
    
    
}