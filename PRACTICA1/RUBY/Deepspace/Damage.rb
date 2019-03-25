class Damage

  def initialize(w,s,t)
    @nShields = s #int
    @nWeapons = w #int
    @type = t.dup #Array tipo WeaponType  DUDA !! (hay que poner new?)

  end

  def self.newNumericWeapons()

  end

  def self.newSpecificWeapons(wl,s)

  end

  def self.newCopy(d)
    new(d.nWeapons, d.nShields, d.getWeapons)  #DUDA
  end

  def getUIversion
    DamageToUI.new(self)
  end

  def arrayContainsType(w,t)   #no entiendo que tiene que ver con la clase
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

  def adjust(w,s)   #no entido que hay que hacer
    danio = Damage.new(@nShields, @nWeapons, @type)  #utilizar el de copia?
    for i in w do
      discardWeapon(i)
    end
    for j in s do
      discardShieldBooster
    end





    #danio.each do i
      #if (danio[i].)
    #  nelem = w.count(@type[i])
#      if (nelem == 0)
#        @type.remove(@type[i])  #los elimina todos o uno?
#        @nWeapons = @nWeapons -1
#      end
#    end

  end

  def discardWeapon(w)
    if (@type.length != 0)
      num = @type.count(w.type)
      @type.delete(w.type)
      if ((@nWeapons - num) >= 0)
          @nWeapons = @nWeapons -num
      else
          @nWeapons = 0
      end
    end
    if (@nWeapons != 0)
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
    return @type
  end

  def to_s
   "El daño es "+@nWeapons.to_s+" armas, y "+@nShields.to_s+" escudos, la coleccion de armas es "+@type.to_s

  end

end
