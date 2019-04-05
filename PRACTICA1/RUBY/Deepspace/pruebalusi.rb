require_relative "Damage"
require_relative "Weapon"
require_relative "WeaponType"
require_relative "ShieldBooster"
module Deepspace
    class Prueba 
        
        def self.main
            arma = Weapon.new("armita", WeaponType::LASER, 240);
            arma2 = Weapon.new("armita2", WeaponType::PLASMA, 34)
            w = [arma,arma2,arma,arma2]
            shield = ShieldBooster.new("Escudito", 23, 56)
            shield2 = ShieldBooster.new("Escudito2", 28347, 2342)
            s = [shield, shield2]
            danio =  Damage.newNumericWeapons(2,3)
            puts danio.to_s
            danio2 = danio.adjust(w,s);
            puts danio2.to_s 
            danio3 = Damage.newSpecificWeapons([WeaponType::LASER,WeaponType::MISSILE, WeaponType::PLASMA], 7)
            puts danio3
            danio4 = danio3.adjust(w,s);
            puts danio4
        end 
        



    end 
    Prueba.main
end


