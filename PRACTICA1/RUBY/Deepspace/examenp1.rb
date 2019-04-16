# require_relative "LootExamen"
require_relative "Dice"
require_relative "Weapon"
require_relative "ShieldBooster"
# require_relative "Enum"
require_relative "WeaponType"
require_relative "Damage"
module P1
	class ExamenP1
		@@contadorejecuciones = 0
		
		def initialize

		end 

		def principal 
			@@contadorejecuciones += 1
			puts "Contador ejecuciones: "+ExamenP1.contadorejecuciones.to_s+"\n"

			tipos=[Deepspace::WeaponType::LASER,Deepspace::WeaponType::PLASMA]
			danio = Deepspace::Damage.newSpecificWeapons(tipos,5)
			puts danio.to_s
			armas2=[Deepspace::Weapon.new("Arma",Deepspace::WeaponType::PLASMA,1),Deepspace::Weapon.new("Arma",Deepspace::WeaponType::MISSILE,1),Deepspace::Weapon.new("Arma",Deepspace::WeaponType::PLASMA,1)]
			puts "Longitud armas" +armas2.length.to_s
			escudos2=[Deepspace::ShieldBooster.new("Escudo",3,2),Deepspace::ShieldBooster.new("Escudo",5,6)]
			puts escudos2.length.to_s
			danio2 =danio.adjust(armas2,escudos2)
			puts danio2.to_s
		end 
	
		def self.contadorejecuciones
			@@contadorejecuciones
		end 
	end 
	
	examen = ExamenP1.new
	examen.principal 

end
