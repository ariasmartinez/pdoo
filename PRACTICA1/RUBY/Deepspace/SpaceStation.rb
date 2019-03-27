#encoding:utf-8
require './Hangar'
require './Damage'

module Deepspace


# @author Lucía Salamanca López, Celia Arias Martínez
class SpaceStation
  @@MAXFUEL = 100
  @@SHIELDLOSSPERUNITSHOT = 0.1

 # las medallas como coño se saben
  def initialize(n, supplies)     #string int, supplies SuppliesPackage
    @ammoPower = supplies.ammoPower  #float
    @fuelUnits = supplies.fuelUnits #float
    @name = n #string
    @nMedals = 0 #int    Lo inicializo a cero pero no se
    @shieldPower = supplies.shieldPower  #float
    @hangar = nil   #Hangar.new(0)       #Hangar 0..1   lo pongo a nil para que funcione receiveHangar
    @pendingDamage = nil # Damage 0..1   rt
    @shieldBoosters = Array.new   #array de ShieldBooster
    @weapons = Array.new    #array de Weapon
  end

  def assignFuelValue(f)   
    if (f <= @@MAXFUEL)
      @fuelUnits = f
    else
      @fuelUnits = @@MAXFUEL
    end
  end

  def cleanPendingDamage
    if (pendingDamage.hasNoEffect)
      @pendingDamage = nil
    end
  end

# SI PETA ES ESTO
  def cleanUpMountedItems
    for w in weapons do
      if (w.uses == 0)
        @weapons.delete(w)
      end
    end

    for sb in shieldBoosters do
      if (sb.uses == 0)
        @shieldBoosters.delete(sb)
      end
    end
  end

  def discardHangar
    @hangar = nil
  end

  def discardShieldBooster(i)
    #siguiente práctica
  end

  def discardShieldBoosterinHangar(i)
    if (@hangar != nil)
      @hangar.removeShieldBooster(i)
    end
  end

  def discardWeapon(i)
    #siguiente práctica
  end

  def discardWeaponinHangar(i)
    if (@hangar != nil)
      @hangar.removeWeapon(i)
    end
  end

  def fire
    #práctica siguiente
  end

  def ammoPower
    @ammoPower
  end

  def fuelUnits
    @fuelUnits
  end

  def hangar
    @hangar
  end

  def name
    @name
  end

  def nMedals
    @nMedals
  end

  def pendingDamage
    @pendingDamage
  end

  def shieldBoosters
    @shieldBoosters
  end

  def shieldPower
    @shieldPower
  end

  def getSpeed
   return (@fuelUnits.to_f/@@MAXFUEL)
  end

  def getUIversion
    SpaceStationToUI.new(self)
  end

  def weapons
    @weapons
  end

  def mountShieldBooster(i)
    if (hangar != nil)
      potenEscudo= @hangar.removeShieldBooster(i)
      if (potenEscudo != nil)
        @shieldBoosters << potenEscudo
      end
    end
  end

  def mountWeapon(i)
    if (hangar != nil)
      arma = @hangar.removeWeapon(i)
      if (arma != nil)
        @weapons << arma
      end
    end
  end

  def move
    if ((fuelUnits - getSpeed*fuelUnits) > 0)
      @fuelUnits = fuelUnits-getSpeed()*fuelUnits
    else
      @fuelUnits = 0
    end
  end

  def protection
    #siguiente práctica
  end

  def receiveHangar(h)
    if (@hangar == nil)
      @hangar = h
    end
  end

  def receiveShieldBooster(s)
    if (hangar != nil)
      return @hangar.addShieldBooster(s)
    else
      return false
    end
  end

  def receiveShot(shot)
    #siguiente práctica
  end

  def receiveSupplies(s)
    @fuelUnits += s.fuelUnits
    @ammoPower += s.ammoPower
    @shieldPower += s.shieldPower
  end

  def receiveWeapon(w)
    if (hangar != nil)
      return @hangar.addWeapon(w)
    else
      return false
    end
  end

  def setLoot(loot)
    # Siguiente práctica
  end

  def setPendingDamage(d)
    @pendingDamage = d.adjust(@weapons, @shieldBoosters)
  end

  def validState
    if (@pendingDamage == nil || @pendingDamage.hasNoEffect)
        return true
    else
      false
    end
  end

  def to_s
    out="Space Station - Name: #{@name}\n"
    out+="\tnMedals: #{@nMedals}, Fuel units: #{@fuelUnits.round(2)}, Power: #{@ammoPower}, Shields: #{@shieldPower}\n"
    out+="\tWeapons: [#{@weapons.join(', ')}]\n"
    out+="\tShieldBooster: [#{@shieldBoosters.join(', ')}]\n"
    out+="\tHangars: #{@hangar}\n"
    out+="\tPendingDamage: #{@pendingDamage}\n"
    out+="------- end of Space Station >> #{@name} << -------"
    return out
  end

end

end
