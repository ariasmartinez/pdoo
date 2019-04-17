require './SuppliesPackage'
require './SpaceStation'
require './Hangar'
require './Weapon'
require './WeaponType'
require './ShieldBooster'
require './Loot'
require './Damage'
require './GameUniverse'
module Deepspace

#puts "Probamos metodos de SpaceStation"
suministros = SuppliesPackage.new(3,10,2)
hangar = Hangar.new(20)
arma = Weapon.new("Laser1", WeaponType::LASER, 2)
arma2 = Weapon.new("Missile1", WeaponType::MISSILE, 1)
arma3 = Weapon.new("Laser2", WeaponType::LASER, 2)
escudo = ShieldBooster.new("escudo1", 40,2)
escudo2 = ShieldBooster.new("escudo2", 2,1)
escudo3 = ShieldBooster.new("escudo3", 2,3)
estacion = SpaceStation.new("Estacion SS", suministros)
estacion.receiveHangar(hangar)
estacion.receiveWeapon(arma)
estacion.receiveWeapon(arma2)
estacion.receiveWeapon(arma3)
estacion.receiveShieldBooster(escudo)
estacion.receiveShieldBooster(escudo2)
estacion.receiveShieldBooster(escudo3)
estacion.mountWeapon(0)
estacion.mountWeapon(0)
estacion.mountWeapon(0)
estacion.mountShieldBooster(1)
estacion.mountShieldBooster(0)
estacion.mountShieldBooster(0)
#puts estacion.fire
#puts estacion.to_s 
#puts estacion.protection
#puts estacion.receiveShot(30)

array = Array.new
array << WeaponType::LASER 
array << WeaponType::LASER
daño = Damage.newSpecificWeapons(array,1)
estacion.setPendingDamage(daño)
#puts "SpaceStation:: Probamos setLoot"
#botin = Loot.new(1,1,1, 0, 1)
#estacion.setLoot(botin)
#puts estacion.to_s
#puts "SpaceStation: Probamos discardWeapon"
#puts estacion.to_s
#estacion.discardWeapon(0)
#puts estacion.to_s

#discardWeapon pendiente de borrar todo el daño o no

#puts "Probamos DiscardShieldBoosters"
#estacion.discardShieldBooster(2)
#puts estacion.to_s



puts "Probamos GameUniverse:"

game = GameUniverse.new
nombres = Array.new
nombres << "Celia"
nombres << "Lucía"
nombres << "Jesús"
game.init(nombres)
#puts game.to_s
#puts "Probamos nextTurns"
game.nextTurn
puts game.to_s
puts "Probamos combat"
puts game.combat
puts game.to_s




end