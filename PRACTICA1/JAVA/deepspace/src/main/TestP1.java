/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import deepspace.Dice;
import deepspace.GameCharacter;
import deepspace.Loot;
import deepspace.ShieldBooster;
import deepspace.SuppliesPackage;
import deepspace.Weapon;
import deepspace.WeaponType;

/**
 *
 * @author celia
 */
public class TestP1 {
    public static void main(String [] args){
                // LOOT
		deepspace.Loot botin = new deepspace.Loot(8,4,3,5,6);
		System.out.println("Botín: ");
		System.out.println("Suministros: "+botin.getNSupplies());
		System.out.println("Armas : "+botin.getNWeapons());
		System.out.println("Escudos: "+botin.getNShields());
		System.out.println("Hangares: "+botin.getNHangars());
		System.out.println("Medallas: "+botin.getNMedals());

                // SUPPLIESPACKAGE
		deepspace.SuppliesPackage PaqueteSum = new SuppliesPackage(24.5f,22.5f,23.2f);
		System.out.println("Suministros: ");
		System.out.println("Municiones: "+PaqueteSum.getAmmoPower());
		System.out.println("Combustible: "+PaqueteSum.getFuelUnits());
		System.out.println("Poder de escudo: "+PaqueteSum.getShieldPower());

		SuppliesPackage PaqueteSumCopia = new SuppliesPackage(PaqueteSum);
		System.out.println("Suministros de copia: ");
		System.out.println("Municiones: "+PaqueteSumCopia.getAmmoPower());
		System.out.println("Combustible: "+PaqueteSumCopia.getFuelUnits());
		System.out.println("Poder de escudo: "+PaqueteSumCopia.getShieldPower());

                // SHIELDBOOSTER
		ShieldBooster escudo = new ShieldBooster("Escudo", 4.5f, 3);
		System.out.println("ShieldBooster: ");
                System.out.println("Boost: "+escudo.getBoost());
                System.out.println("Usos: "+escudo.getUses());
                System.out.println("Boost a partir de la función useIt: "+escudo.useIt());
                System.out.println("Usos después de useIt: "+escudo.getUses());
                
                ShieldBooster escudoCopia = new ShieldBooster(escudo);
                System.out.println("ShieldBooster de copia: ");
                System.out.println("Boost: "+escudo.getBoost());
                System.out.println("Usos: "+escudo.getUses());
                
                // WEAPON
                Weapon arma = new Weapon("armita", WeaponType.LASER,4 );
                
                System.out.println("Arma: ");
                System.out.println("Tipo: "+arma.getType());
                System.out.println("Usos: "+arma.getUses());
                System.out.println("Poder: "+arma.useIt());
                System.out.println("Usos después de useIt: "+arma.useIt());
                
                Weapon armaCopia = new Weapon(arma);
                System.out.println("Arma de copia: ");
                System.out.println("Tipo: "+armaCopia.getType());
                System.out.println("Usos: "+armaCopia.getUses());
                System.out.println("Poder: "+armaCopia.power());
                
                // DICE 
                // No sé si hace falta hacerlo o con poner Dice dado ya vale 
                Dice dado = new Dice();
                int[] hangars = new int[2];
                // Para comprobar que son cero 
                System.out.println("hangars[0]"+hangars[0]);
                System.out.println("hangars[1]"+hangars[1]);

                for (int i=0; i<100; i++){
                    hangars[dado.initWithNHangars()]++;
                }
                System.out.println("Probabilidad hangar 0= "+hangars[0]);
                System.out.println("Probabilidad hangar 1= "+hangars[1]);
                int[] weapons = new int[3];
                for (int i=0; i<100; i++){
                    weapons[dado.initWithNWeapons()-1]++;
                }
                System.out.println("Probabilidad weapons 1= "+weapons[0]);
                System.out.println("Probabilidad weapons 2= "+weapons[1]);
                System.out.println("Probabilidad weapons 3= "+weapons[2]);

                int[] shields = new int[2];
                for (int i=0; i<100; i++){
                    shields[dado.initWithNShields()]++;
                }
                System.out.println("Probabilidad shields 0= "+shields[0]);
                System.out.println("Probabilidad shields 1= "+shields[1]);

                int[] character = new int [2];
                
                for (int i=0; i<100; i++){
                   if(dado.firstShot()==GameCharacter.SPACESTATION){
                    character[0]++;
                   }
                   else {
                    character[1]++;
                   }   
                }
                
                System.out.println("Probabilidad SPACESTATION= "+character[0]);
                System.out.println("Probabilidad ENEMYSTARSHIP= "+character[1]);
                
                //probamos toString 
                System.out.println(dado.toString());
    }           
}
