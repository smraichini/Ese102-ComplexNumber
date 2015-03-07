/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexnumber;


public class ComplexNumber {
    private double re;
    private double im;
 
    /**
  * Stampa il numero immaginario nel formato seguente: Parte Reale+(Parte Immaginaria)
  * @return 
  */
    public String formatComplexNumber() {
        String r = this.getRe() + "+(" + this.getIm() + ")i";
        return r;
    }

    /**
 * Richiede modulo e argomento,considerare che la classe gestisce tutti gli angoli in modo sessagesimale
 * e che il modulo non può essere minore di 0
 * @param mod
 * @param arg 
 */
    public void setPolar(double mod, double arg){
     if(mod>=0)
     {
        this.re = Math.cos(arg*Math.PI/180)*mod;
        if(arg == 180){
          this.im = 0;
        }
        else{
         this.im = Math.sin(arg*Math.PI/180)*mod;
        }
     }
     else
     {
        throw new IllegalArgumentException("Il valore del modulo deve essere maggiore di 0");
     }
    }
    
    /**
     * Richiede le coordinate rettangolari di x e y
     * @param re
     * @param im 
     */
    public void setRectangular(double re, double im ){
        this.im=im;
        this.re=re;
        }
    
    /**
     * Restiutisce il valore del modulo
     * @return 
     */
    public double getModulus(){
        
        return(Math.sqrt(Math.pow(this.re,2)+Math.pow(this.im,2)));
    }
    
    /**
     * Restituisce il valore dell'argomento in (angoli sessagesimali)
     * @return 
     */
    public double getArgument(){
     int bugFix = 0;
     if(this.re  < 0 && this.im == 0){
     bugFix = 180;
    }
    return((Math.atan(this.im/this.re)*180)/Math.PI+bugFix);
    }
    
    /**
     * Restituisce il valore della parte Reale
     * @return 
     */  
    public double getRe() {
        return re;
    }
    
    /**
     * Restituisce il valore della parte Immaginaria
     * @return 
     */
    public double getIm() {
        return im;
    }
    
    public ComplexNumber add(ComplexNumber adde){
        ComplexNumber somma = new ComplexNumber();
        double reSomm=this.re+adde.getRe();
        double imSomm=this.im+adde.getIm();
        somma.setRectangular(reSomm, imSomm);
        return somma;
    }
    
    public ComplexNumber sub(ComplexNumber subs){
        ComplexNumber sottr = new ComplexNumber();
        double reSottr=this.re-subs.getRe();
        double imSottr=this.im-subs.getIm();
        sottr.setRectangular(reSottr, imSottr);
        return sottr;
    }
    
    public ComplexNumber mult(ComplexNumber molti){
        ComplexNumber moltiplic = new ComplexNumber();
        double modMoltiplic=this.getModulus()*molti.getModulus();
        double argMoltiplic=this.getArgument()+molti.getArgument();
        moltiplic.setPolar(modMoltiplic, argMoltiplic);
        return moltiplic;
    }
    
    public ComplexNumber div(ComplexNumber molti){
        ComplexNumber division = new ComplexNumber();
        double modDivision=this.getModulus()/division.getModulus();
        double argDivision=this.getArgument()-division.getArgument();
        division.setPolar(modDivision, argDivision);
        return division;
    }
}

/*
        Nella classe non sono presenti metodi costruttori perchè essendo questa classe 
        una classe che gestisce numeri complessi sia attraverso le coordinate Cartesiane che
        quelle Polari, entrambi i metodi costruttori richiederebbero come parametri due valori 
        double e ,di conseguenza, non potendo esistere due metodi costruttori che richiedono lo stesso 
        numero di parametri con lo stesso tipo nello stesso ordine,ho deciso di non preferire nessuno
        dei duei metodi all'altro, l'utente così dovrà utilizzare semplicemente o il metodo setRectangular
        o il metodo setPolar per inizializzare lo stato dei campi.
    */