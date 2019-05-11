#encoding:utf-8
require './Hangar'
require './Damage'
require './ShotResult'
require './CardDealer'
require './SpaceStationToUI'
require './Transformation'
module Deepspace


# @author Lucía Salamanca López, Celia Arias Martínez
class SpaceStation
  @@MAXFUEL = 100
  @@SHIELDLOSSPERUNITSHOT = 0.1


  def initialize(n, supplies)     #string n, supplies SuppliesPackage
    @ammoPower = 0  #float
    @fuelUnits = 0 #float
    @name = n #string
    @nMedals = 0 #int
    @shieldPower = 0  #float
    @hangar = nil   #Hangar
    @pendingDamage = nil # Damage
    @shieldBoosters = Array.new   #array de ShieldBooster
    @weapons = Array.new    #array de Weapon
    receiveSupplies(supplies)

  end

  def copy(base)    #copiamos uno a uno
    @ammoPower = base.ammoPower
    @fuelUnits = base.fuelUnits
    @name = base.name
    @nMedals = base.nMedals
    @shieldPower = base.shieldPower
    if (base.hangar != nil)   
      @hangar = Hangar.newCopy(base.hangar)
    else @hangar = nil
    end
    if (base.pendingDamage != nil) 
      @pendingDamage = base.pendingDamage.copy
    else @pendingDamage = nil 
    end
    for i in base.shieldBoosters
      @shieldBoosters << i 
    end 
    for i in base.weapons
      @weapons << i 
    end
  end
  
  def assignFuelValue(f)
    if (f <= @@MAXFUEL)
      @fuelUnits = f
    else
      @fuelUnits = @@MAXFUEL
    end
  end

  def cleanPendingDamage
    if (pendingDamage != nil)
      if (pendingDamage.hasNoEffect)
        @pendingDamage = nil
      end
    end
  end


  def cleanUpMountedItems
    ind_armas = Array.new
    i = 0
    for w in weapons do
      if (w.uses == 0)
        ind_armas << i
      end
      i+=1
    end
    ind_armas = ind_armas.sort.reverse
    for a in ind_armas do
      @weapons.delete_at(a)
    end
    ind_shield = Array.new
    j = 0
    for sb in shieldBoosters do
      if (sb.uses == 0)
        ind_shield << j
      end
      j+=1
    end
    ind_shield = ind_shield.sort.reverse
    for a in ind_shield do
      @shieldBoosters.delete_at(a)
    end
  end

  def discardHangar
    @hangar = nil
  end


  def discardShieldBooster(i)  #i es un int, devuelve void
    if (i >= 0 and i < @shieldBoosters.length)
      sh = @shieldBoosters.delete_at(i)
      if (@pendingDamage != nil)
        @pendingDamage.discardShieldBooster
        cleanPendingDamage()
      end
    end
  end

  def discardShieldBoosterInHangar(i)
    if (@hangar != nil)
      @hangar.removeShieldBooster(i)
    end
  end


  def discardWeapon(i)   #devuelve void
    if (i >= 0 and i < @weapons.length)
      w = @weapons.delete_at(i)
      if (@pendingDamage != nil)
        @pendingDamage.discardWeapon(w)
        cleanPendingDamage()
      end
    end
  end

  def discardWeaponInHangar(i)
    if (@hangar != nil)
      @hangar.removeWeapon(i)
    end
  end

 
  def fire
    factor = 1
    for w in @weapons do
      factor*= w.useIt()
    end
    return @ammoPower*factor
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
    factor = 1
    for sh in @shieldBoosters do
      factor*=sh.useIt
    end
    return factor*@shieldPower
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


  def receiveShot(shot)   #shot es un float, devuelve un ShotResult
    myProtection = protection()
    if (myProtection >= shot)
      @shieldPower-=@@SHIELDLOSSPERUNITSHOT*shot
      serie = [0.0, @shieldPower]
      @shieldPower = serie.max_by{|serie| serie}
      return ShotResult::RESIST
    else
      @shieldPower = 0.0
      return ShotResult::DONOTRESIST
    end
  end



  def receiveSupplies(s)
    assignFuelValue(@fuelUnits+s.fuelUnits)
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


  def setLoot(loot)   #recibe un Loot, devuelve Transformation (mirar el final)
    dealer = CardDealer.instance
    h = loot.nHangars
    if (h > 0)
      hangar = dealer.nextHangar
      receiveHangar(hangar)
    end
    elements = loot.nSupplies
    for i in (1..elements) do
      sup = dealer.nextSuppliesPackage()
      receiveSupplies(sup)
    end
    elements = loot.nWeapons
    for i in (1..elements) do
      weap = dealer.nextWeapon()
      receiveWeapon(weap)
    end
    elements = loot.nShields
    for i in (1..elements) do
      sh = dealer.nextShieldBooster()
      receiveShieldBooster(sh)
    end
    medals = loot.nMedals
    @nMedals+=medals
    if (loot.getEfficient)
      return Transformation::GETEFFICIENT 
    elsif(loot.spaceCity)
      return Transformation::SPACECITY 
    else
      return Transformation::NOTRANSFORM
    end
  end

  def setPendingDamage(d)
    @pendingDamage = d.adjust(@weapons, @shieldBoosters)
    cleanPendingDamage()
  end

  def validState
    if ((@pendingDamage == nil) or @pendingDamage.hasNoEffect)
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
