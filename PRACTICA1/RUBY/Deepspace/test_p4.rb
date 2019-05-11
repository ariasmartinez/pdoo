module Deepspace
    require'./Damage.rb'
    require'./NumericDamage.rb'
    require'./SpecificDamage.rb'
    require'./WeaponType.rb'
    require './ShieldBooster.rb'
    require './Weapon.rb'
    require './SpaceStation'
    require './SpaceCity'
    require './Loot'
    d = Damage.new(4)
    #puts d.to_s
    array = Array.new
    array << WeaponType::MISSILE
    array << WeaponType::LASER
    array << WeaponType::MISSILE
    d2 = SpecificDamage.new(array, 1)
    puts d2.nShields
    d2.discardShieldBooster
    puts d2.nShields
    puts d2.to_s

    puts d2.copy
    array2 = Array.new
    array2 << Weapon.new("a",WeaponType::MISSILE,3)
    array3 = Array.new
    array3 << ShieldBooster.new(2,3,2)
    array3 << ShieldBooster.new(2,3,2)
    puts d2.adjust(array2, array3)
    d2.discardWeapon(Weapon.new("a",WeaponType::MISSILE,3))
    d2.discardWeapon(Weapon.new("a",WeaponType::LASER,3))
    d2.discardShieldBooster
    d2.discardShieldBooster
    puts d2.to_s
    puts d2.hasNoEffect

    d3 = NumericDamage.new(3,2)
    #puts d3.copy
    puts d3.to_s
    #puts d3.adjust(array2, array3)
    d3.discardWeapon(Weapon.new("a",WeaponType::MISSILE,3))
    d3.discardWeapon(Weapon.new("a",WeaponType::MISSILE,3))
    d3.discardWeapon(Weapon.new("a",WeaponType::MISSILE,3))
    d3.discardShieldBooster
    d3.discardShieldBooster
    d3.discardShieldBooster
    puts d3.to_s
    puts d3.hasNoEffect

    supplies = SuppliesPackage.new(1,2,3)
    estaciones = Array.new
    estaciones << SpaceStation.new("a",supplies )
    estaciones << SpaceStation.new("a",supplies )
    estacion = SpaceStation.new("a",supplies )
    city = SpaceCity.new(estacion, estaciones)
    puts city.fire
    puts city.protection
    puts city.to_s

    loot = Loot.new(1,2,3,4,5, true, true)
    puts loot.to_s

end