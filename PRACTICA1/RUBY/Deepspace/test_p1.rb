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

escudo = ShieldBooster.new("nombre", 3.5, 3)
puts "Mostramos los atributos del objeto de la clase ShieldBooster"
puts escudo.name, escudo.boost, escudo.uses
puts "Mostramos métodos"
escudo_copia = ShieldBooster.newCopy(escudo)
puts "El objeto creado es: "
puts escudo_copia.uses, escudo_copia.name, escudo_copia.boost
puts "Llamamos a useIt"
puts escudo.useIt
puts escudo.uses

sumin = SuppliesPackage.new(2.3, 4.5, 1.2)
puts "Mostramos los atributos del objeto de la clase SuppliesPackage"
puts sumin.ammoPower, sumin.fuelUnits, sumin.shieldPower
sumin_copia = SuppliesPackage.newCopy(sumin)
puts "Mostramos el objeto copiado: "
puts sumin_copia.ammoPower, sumin_copia.fuelUnits, sumin_copia.shieldPower

arma = Weapon.new("pistola", WeaponType::LASER, 4)
puts "Mostramos los atributos del objeto de la clase Weapon"
puts arma.name, arma.type, arma.uses
arma_copia = Weapon.newCopy(arma)
puts arma_copia.name, arma_copia.type, arma_copia.uses

puts "Mostramos el poder del arma"
puts arma.power

puts "Probamos metodo useIt"
puts arma.useIt


#Segunda parte del main
puts "Esta es la segunda parte del main: "
num_jugadores = 4
dado2 = Dice.new()
emp_hang = [0,0]
emp_weap = [0,0,0]
emp_shiel = [0,0]
jug_prim = [0,0,0,0]
disp_prim = [0,0]
mov_esp = [0,0]

for index in(0..99)
  emp_hang[dado2.initWithNHangars]+= 1
  emp_weap[dado2.initWithNWeapons-1]+= 1
  emp_shiel[dado2.initWithNShields]+= 1
  jug_prim[dado2.whoStarts(4)]+= 1
  if (dado2.firstShot == GameCharacter::ENEMYSTARSHIP)
    disp_prim[0]+= 1
  else
    disp_prim[1]+= 1
  end
  if (dado2.spaceStationMoves(0.5) == true)
    mov_esp[0]+= 1
  else
    mov_esp[1]+= 1
  end

end
puts "Probabilidad de 1 y 0 en initWithNHangars"
puts emp_hang[0]
puts emp_hang[1]
puts "Probabilidad de 3, 1, 2 en initWithNWeapons"
puts emp_weap[0]
puts emp_weap[1]
puts emp_weap[2]
puts "Probabilidad de 1 y 0 en initWithNShields"
puts emp_shiel[0]
puts emp_shiel[1]
puts "Probabilidad de que empiece cada jugador"
puts jug_prim[0]
puts jug_prim[1]
puts jug_prim[2]
puts jug_prim[3]
puts "Probabilidad de que empiece primero enemy o ss"
puts disp_prim[0]
puts disp_prim[1]
puts "Probabilidad de que mueve la ss"
puts mov_esp[0]
puts mov_esp[1]
