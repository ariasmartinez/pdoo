#encoding:utf-8

module Deepspace


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
    new(d.nWeapons, d.nShields, d.getWeapons)  #DUDA
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
    danio = Damage.newCopy(self)
    if (danio.nWeapons == nil)
      for i in danio.getWeapons #cada i es de tipo WeaponType
        if (danio.arrayContainsType(w, i) == -1)
          danio.getWeapons.delete(i)
        end
      end
    else
      if (danio.nWeapons > w.length)
        (danio.nWeapons-w.length).times do
          danio.discardWeapon(w[0])    #bastante chapucero pero no se me ocurria otra cosa
        end
      end
    end

    if (danio.nShields > s.length)
      (danio.nShields-s.length).times do
        danio.discardShieldBooster
      end
    end

  return danio
  end

  def discardWeapon(w)
    if (@nWeapons == 0)
        @weapons.delete(w.type)
    else
        @nWeapons = @nWeapons-1
    end
  end

  def discardShieldBooster
    if (@nShields != 0)
      @nShields = @nShields-1
    end
  end

  def hasNoEffect
   if (@nShields == 0 && @nWeapons == 0)
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

  def getWeapons
    return @weapons
  end

  def to_s
   "El daño es "+@nWeapons.to_s+" armas, y "+@nShields.to_s+" escudos, la coleccion de armas es "+@weapons.to_s

  end

end

end
