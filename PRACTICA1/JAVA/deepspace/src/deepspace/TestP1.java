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
public class TestP1 {
    public static void main(String [] args){
// Loot
		Loot botin = new Loot(8,4,3,5,6);
		System.out.println("Botín: ");
		System.out.println("Suministros: "+botin.getNSupplies);
		System.out.println("Armas : "+botin.getNWeapons);
		System.out.println("Escudos: "+botin.getNShields);
		System.out.println("Hangares: "+botin.getNHangars);
		System.out.println("Medallas: "+botin.getNMedals);

// SupliesPackage
		SuppliesPackage PaqueteSum = new SuppliesPackage(24.5f,22.5,23.2);
		System.out.println("Suministros: ");
		System.out.println("Municiones: "+PaqueteSum.getAmmoPower);
		System.out.println("Combustible: "+PaqueteSum.getFuelUnits);
		System.out.println("Poder de escudo: "+PaqueteSum.getShieldPower);

		SuppliesPackage PaqueteSumCopia = new SuppliesPackage(PaqueteSum);
		System.out.println("Suministros de copia: ");
		System.out.println("Municiones: "+PaqueteSumCopia.getAmmoPower);
		System.out.println("Combustible: "+PaqueteSumCopia.getFuelUnits);
		System.out.println("Poder de escudo: "+PaqueteSumCopia.getShieldPower);

// ShieldBooster
		ShieldBooster escudo = new ShieldBooster("Escudo", 4.5f, 3);
		System.out.println("ShieldBooster: ");
		System.out.println("Nombre: "+);
}
