require './Damage.rb'
require './WeaponType.rb'
require './Weapon'
require './ShieldBooster'
require './GameUniverse'
require './SpaceStation'
require './SuppliesPackage'
require './EnemyStarShip'

puts "Creamos un objeto de la clase Damage"
array_weap = [Deepspace::WeaponType::LASER,Deepspace::WeaponType::LASER]
puts array_weap.to_s
daño = Deepspace::Damage.new(3,4, array_weap)
daño2 = Deepspace::Damage.newCopy(daño)
puts daño.to_s
puts daño2.to_s
arma = Deepspace::Weapon.new("pistola", Deepspace::WeaponType::MISSILE, 1)
daño2.discardWeapon(arma)
daño2.discardShieldBooster
puts daño2.hasNoEffect
arma2 = Deepspace::Weapon.new("bomba",Deepspace::WeaponType::MISSILE, 2)
array_arma=[arma, arma2]
pos =  daño.arrayContainsType(array_arma, Deepspace::WeaponType::MISSILE)
puts pos
escudo1 = Deepspace::ShieldBooster.new("uno",2,3)
escudo2 = Deepspace::ShieldBooster.new("dos",4,3)
array_escudo = [escudo1, escudo2]
puts "Probamos adjust"
daño.adjust(array_arma,array_escudo)
puts daño.to_s

puts "Creamos un objeto damage con newNumericWeapons"
daño_num = Deepspace::Damage.newNumericWeapons(3,2)
puts daño_num.to_s
puts "Creamos un objeto Damage con newSpecificWeapons"
daño_esp = Deepspace::Damage.newSpecificWeapons(array_arma,3)
puts daño_esp.to_s
#FALTA PROBAR ADJUST (y mirar discard)


#puts "Creamos objeto de la clase GameUniverse"
#juego = Deepspace::GameUniverse.new
#puts juego.to_s
#FALTAN COSAS POR PROBAR

puts "Probamos SpaceStation"
provisiones = Deepspace::SuppliesPackage.new(2,3,4)
estacion = Deepspace::SpaceStation.new("nave1", provisiones)
puts estacion.to_s
#FALTAN COSAS POR PROBAR

puts "Probamos EnemyStarShip"
bot = Deepspace::Loot.new(1,2,3,4,5)
dan = Deepspace::Damage.newNumericWeapons(2,5)
enemigo = Deepspace::EnemyStarShip.new("enem",3, 2, bot, dan)
puts enemigo.to_s
