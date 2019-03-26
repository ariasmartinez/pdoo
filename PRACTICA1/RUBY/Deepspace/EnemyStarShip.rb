#encoding:utf-8
require './Loot'
require './Damage'
module Deepspace


# @author Lucía Salamanca López, Celia Arias Martínez
class EnemyStarShip

def initialize(n,a,s,l,d)
  @name = n   #string
  @ammoPower = a   #float
  @shieldPower = s  #float
  @loot = Loot.new(l.nSupplies, l.nWeapons, l.nShields, l.nHangars, l.nMedals)  #Loot
  @damage = Damage.newCopy(d)   #Damage
end

def self.newCopy(e)
  new(e.name, e.ammoPower, e.shieldPower, e.loot, e.damage)
end

def getUIversion
  EnemyToUI
end

def fire
  ammoPower
end

def ammoPower
  @ammoPower
end

def damage
  @damage
end

def loot
  @loot
end

def name
  @name
end

def shieldPower
  @shieldPower
end

def protection
  shieldPower
end

def receiveShot(shot)
  if (protection < shot)
    return ShotResult::DONOTRESIST
  else
    return ShotResult::RESIST
  end
end

def to_s
  return "Name: #{@name}, " + \
      "Ammo Power: #{@ammoPower}, " + \
      "Shield Power: #{@shieldPower}\n" + \
      "\tLoot..: #{@loot}\n" + \
      "\tDamage: #{@damage}"
end

end

end
