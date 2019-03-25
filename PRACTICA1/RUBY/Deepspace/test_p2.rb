require './Damage.rb'
require './WeaponType.rb'
require './Weapon'
require './ShieldBooster'
require './GameUniverse'
puts "Creamos un objeto de la clase Damage"
array_weap = [WeaponType::LASER,WeaponType::LASER]
puts array_weap.to_s
daño = Damage.new(0,0, array_weap)
daño2 = Damage.newCopy(daño)
puts daño.to_s
puts daño2.to_s
arma = Weapon.new("pistola", WeaponType::LASER, 1)
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
daño.adjust(array_arma,array_escudo)
puts daño.to_s


puts "Creamos objeto de la clase GameUniverse"
juego = GameUniverse.new
puts juego.to_s
