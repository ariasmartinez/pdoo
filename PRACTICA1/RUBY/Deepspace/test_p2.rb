require './Damage.rb'
require './WeaponType.rb'
require './Weapon'
require './ShieldBooster'
require './GameUniverse'
puts "Creamos un objeto de la clase Damage"
array_weap = [WeaponType::LASER,WeaponType::LASER]
puts array_weap.to_s
daño = Damage.new(3,4, array_weap)
daño2 = Damage.newCopy(daño)
puts daño.to_s
puts daño2.to_s
arma = Weapon.new("pistola", WeaponType::MISSILE, 1)
daño2.discardWeapon(arma)
daño2.discardShieldBooster
puts daño2.hasNoEffect
arma2 = Weapon.new("bomba",WeaponType::MISSILE, 2)
array_arma=[arma, arma2]
pos =  daño.arrayContainsType(array_arma, WeaponType::MISSILE)
puts pos
escudo1 = ShieldBooster.new("uno",2,3)
escudo2 = ShieldBooster.new("dos",4,3)
array_escudo = [escudo1, escudo2]
puts "Probamos adjust"
daño.adjust(array_arma,array_escudo)
puts daño.to_s

puts "Creamos un objeto damage con newNumericWeapons"
daño_num = Damage.newNumericWeapons(3,2)
puts daño_num.to_s
puts "Creamos un objeto Damage con newSpecificWeapons"
daño_esp = Damage.newSpecificWeapons(array_arma,3)
puts daño_esp.to_s
puts "Creamos objeto de la clase GameUniverse"
juego = GameUniverse.new
puts juego.to_s
