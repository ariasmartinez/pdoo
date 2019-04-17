
require './Dice'

require './ShieldBooster'
require './Weapon'
require './WeaponType'
require './Damage'
module P1
	class ExamenP1 
		@@contadorEjecuciones = 0
		def principal
			
			array_daño = Array.new
			3.times do 
				array_daño << Deepspace::WeaponType::PLASMA
			end
			2.times do
				array_daño << Deepspace::WeaponType::LASER
			end
			daño = Deepspace::Damage.newSpecificWeapons(array_daño, 5)
			puts daño.to_s
			array_armas2 = Array.new	
			array_armas2 << Deepspace::Weapon.new("arma2", Deepspace::WeaponType::PLASMA, 3)
			array_armas2 << Deepspace::Weapon.new("arma2", Deepspace::WeaponType::LASER, 4)
			array_armas2 << Deepspace::Weapon.new("arma2", Deepspace::WeaponType::LASER, 4)
			array_armas2 << Deepspace::Weapon.new("arma2", Deepspace::WeaponType::LASER, 4)
			array_armas2 << Deepspace::Weapon.new("arma2", Deepspace::WeaponType::PLASMA, 5)
			#array_armas2 << Deepspace::Weapon.new("arma2", Deepspace::WeaponType::PLASMA, 6)
			array_escudo2 = Array.new
			array_escudo2 << Deepspace::ShieldBooster.new("escudo2", 3,4)
			array_escudo2 << Deepspace::ShieldBooster.new("escudo2", 5,6)
			daño2 = daño.adjust(array_armas2, array_escudo2)
			puts "Las armas que tenemos son " 
			puts array_armas2.to_s
			puts daño2.to_s

		end
		
		def self.contadorEjecuciones
			@@contadorEjecuciones
		end
	end

end

ex1 = P1::ExamenP1.new
ex1.principal

