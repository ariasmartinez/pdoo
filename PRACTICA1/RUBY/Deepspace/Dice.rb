#encoding:utf-8

module Deepspace


# @author Lucía Salamanca López, Celia Arias Martínez

class Dice

#No sé si es así
 def initialize
   @NHANGARSPROB=0.25
   @NSHIELDSPROB=0.25
   @NWEAPONSPROB=0.33
   @FIRSTSHOTPROB=0.5
   @generator=rand
 end

# Para hacer los consultores directamente no sé si funciona
# Si no funciona el fallo está aquí
attr_reader :NHANGARSPROB, :NSHIELDSPROB, :NWEAPONSPROB, :FIRSTSHOTPROB, :generator

#he puesto el @ antes de los atributos, son de instancia no??
 def initWithNHangars
   @generator=rand
   if (@generator > @NHANGARSPROB )
     return 1
   else
     return 0
   end
 end

 def initWithNWeapons
   @generator=rand
   if (@generator > 2*@NWEAPONSPROB)
     return 3
   else
     if (@generator < @NWEAPONSPROB)
       return 1
     else
       return 2
     end
   end
 end

 def initWithNShields
   @generator=rand
   if (@generator > @NSHIELDSPROB )
     return 1
   else
     return 0
   end
 end

 def whoStarts(nPlayers)
   rand(nPlayers)
 end

#le he quitado el Deepspace:: porque daba error
 def firstShot
   @generator=rand
   if (@generator > @FIRSTSHOTPROB )
     return GameCharacter::ENEMYSTARSHIP
   else
     return GameCharacter::SPACESTATION
   end

 end

 def spaceStationMoves(speed)
   @generator=rand
   if (@generator > speed)
     return false
   else
     return true
   end
 end

 def to_s
   "Este dado tiene de probabilidad de Hangar :"+@NHANGARSPROB.to_s+", de Shield: " +@NSHIELDSPROB.to_s+", de Weapons: " +@NWEAPONSPROB.to_s+", y de FirstShot: "+ @FIRSTSHOTPROB.to_s+"."
 end



end

end
