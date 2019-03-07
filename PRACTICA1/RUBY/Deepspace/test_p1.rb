require './Dice.rb'
require './Loot.rb'
require './GameCharacter'
require './ShieldBooster'
require './SuppliesPackage'
require './Weapon'
require './WeaponType'
puts "Vamos a crear un objeto de cada clase y lo mostraremos"

dado1 = Dice.new()
puts "Mostramos los atributos del objeto de la clase Dice"
puts dado1.NHANGARSPROB, dado1.NSHIELDSPROB, dado1.NWEAPONSPROB, dado1.FIRSTSHOTPROB, dado1.generator
puts "Mostramos los metodos del objeto de la clase Dice"
puts dado1.initWithNHangars
puts dado1.initWithNWeapons
puts dado1.initWithNShields
puts dado1.whoStarts(4)
puts dado1.firstShot
puts dado1.spaceStationMoves(0.5)

botin = Loot.new(1,2,3,4,5)
puts "Mostramos los atributos del objeto de la clase Loot"
puts botin.nSupplies, botin.nWeapons, botin.nShields, botin.nHangars, botin.nMedals

escudo = ShieldBooster.new("nombre", 3.5, 0)
puts "Mostramos los atributos del objeto de la clase ShieldBooster"
puts escudo.name, escudo.boost, escudo.uses
puts "Mostramos métodos"
#escudo_copia = escudo.self.newCopy
escudo.uses= 3
puts escudo.uses
puts escudo.useIt

sumin = SuppliesPackage.new(2.3, 4.5, 1.2)
puts "Mostramos los atributos del objeto de la clase Dice"
puts sumin.ammoPower, sumin.fuelUnits, sumin.shieldPower

#wtf como se hace eso
#tipo_arma = WeaponType.new
arma = Weapon.new("pistola", tipo_arma, 4)
