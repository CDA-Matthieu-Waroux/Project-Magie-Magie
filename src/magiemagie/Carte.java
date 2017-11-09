/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magiemagie;

/**
 *
 * @author Administrateur
 */
public class Carte {
    
    public enum TypeCarte{
        
        BAVE_DE_CRAPAUD,
        AILE_DE_CHAUVE_SOURIS,
        LAPIS_LAZULI,
        MANDRAGORE,
        CORNE_DE_LICORNE,
        PUSTULE_DE_SORCIERE,
    }
    
    protected TypeCarte types ;

    public Carte() {
    }

    
    
    public Carte(TypeCarte types) {
        this.types = types;
    }

    public TypeCarte getTypes() {
        return types;
    }

    public void setTypes(TypeCarte types) {
        this.types = types;
    }

    @Override
    public String toString() {
        
        return this.types.toString();
    }

    

    
    
}
    
    
   
    

