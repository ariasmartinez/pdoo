require './SuppliesPackage'
require './SpaceStation'
require './Hangar'
require './Weapon'
require './WeaponType'
require './ShieldBooster'
require './Loot'
require './Damage'
module Deepspace

puts "Probamos metodos de SpaceStation"
suministros = SuppliesPackage.new(3,10,2)
hangar = Hangar.new(4)
arma = Weapon.new("Laser1", WeaponType::LASER, 2)
arma2 = Weapon.new("Missile1", WeaponType::MISSILE, 1)
escudo = ShieldBooster.new("escudo1", 40,2)
escudo2 = ShieldBooster.new("escudo2", 2,1)
estacion = SpaceStation.new("Estacion SS", suministros)
estacion.receiveHangar(hangar)
estacion.receiveWeapon(arma)
estacion.receiveWeapon(arma2)
estacion.receiveShieldBooster(escudo)
estacion.receiveShieldBooster(escudo2)
estacion.mountWeapon(0)
estacion.mountWeapon(0)
estacion.mountShieldBooster(0)
#estacion.mountShieldBooster(0)
puts estacion.fire
puts estacion.to_s 
#puts estacion.protection
puts estacion.receiveShot(30)

daño = Damage.newNumericWeapons(2,3)
estacion.setPendingDamage(daño)
puts "SpaceStation:: Probamos setLoot"
botin = Loot.new(1,1,1, 0, 1)
estacion.setLoot(botin)
puts estacion.to_s
estacion.discardWeapon(0)
puts estacion.to_s






end