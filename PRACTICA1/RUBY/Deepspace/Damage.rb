#encoding:utf-8

module Deepspace

require_relative "DamageToUI"

# @author Lucía Salamanca López, Celia Arias Martínez

class Damage

  def initialize(w,s,t)
    @nWeapons = w #int
    @nShields = s #int
    #@weapons = t.dup #Array tipo WeaponType  DUDA !! (hay que poner new?)
    @weapons = Array.new(t) #Array tipo WeaponType
  end

  def self.newNumericWeapons(w,s)  #le pasamos un int(de weapons) y otro int (de shields)
    vacio = Array.new
    new(w,s, vacio)
  end

  def self.newSpecificWeapons(wl,s) #le pasamos un arraylist de weapons y un int de shields
    new(0, s, wl)
  end

  def self.newCopy(d)
    new(d.nWeapons, d.nShields, d.weapons)  #DUDA
  end

  def getUIversion
    DamageToUI.new(self)
  end

  def arrayContainsType(w,t)   #w es array de Weapons y t de tipo WeaponType
    pos = -1
    cond = false
    i = 0
    while(cond == false and  i<w.length)
      if (w[i].type == t)
        pos = i
        cond = true
      end
      i+=1
    end
    return pos
  end

  def adjust(w,s)  #w es array de Weapons y s array de SHieldbooster

    if (nShields > s.length)
      shields = s.length
    else
      shields = nShields
    end

    if (nWeapons == 0)
      weapon_prov = []
      for i in weapons
        if (arrayContainsType(w,i)!= -1)
          weapon_prov << i
        end
      end

      return Damage.newSpecificWeapons(weapon_prov,shields)

    else
      if (nWeapons > w.length)
        return Damage.newNumericWeapons(w.length,shields)
      else
        return Damage.newNumericWeapons(nWeapons,shields)
      end
    end

  end

  def discardWeapon(w)
    if (@weapons.length!=0)
        @weapons.delete(w.type)
    elsif (@nWeapons!=0)
        @nWeapons = @nWeapons-1
    end
  end

  def discardShieldBooster
    if (@nShields != 0)
      @nShields = @nShields-1
    end
  end

  def hasNoEffect
   if (@nShields == 0 && @nWeapons == 0 && @weapons.length == 0)
      return true
   end
   return false
  end

  def nShields
    @nShields
  end

  def nWeapons
    @nWeapons
  end

  def weapons
    return @weapons
  end

  def to_s
   "El daño es #{@nWeapons} armas, y  #{@nShields} escudos, la coleccion de armas es "+@weapons.to_s

  end


end

end
