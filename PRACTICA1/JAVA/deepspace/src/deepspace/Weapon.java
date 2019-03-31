/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

/**
 *
 * @author celia
 */
class Weapon {
   private String name;
   private WeaponType type;
   private int uses;
   
   Weapon(String nom, WeaponType tipo, int uso){
       name = nom;
       type = tipo;
       uses = uso;
   }
   
   Weapon(Weapon otro){
       name = otro.name;
       type = otro.type;
       uses = otro.uses;
   }
   
   public WeaponType getType(){
       return type;
   }
   
   public int getUses(){
       return uses;
   }
   
   public float power(){
       return type.getPower();
   }
   
   public float useIt(){
       if (uses > 0){
           uses--;
           return power();
       }
       return 1.0f;
   }
   
   public String toString(){
       String mensaje = "El arma se llama: "+name+", es de tipo: "+type+" y tiene "+uses+" usos.";
       return mensaje;
   }
   //cambio EnemytoUI por WeapontoUI
   WeaponToUI getUIversion(){
       throw new UnsupportedOperationException(); 
    }
}
