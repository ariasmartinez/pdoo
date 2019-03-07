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

 def initWithNHangars
   if (generator > NHANGARSPROB )
     return 1
   else
     return 0
   end

 end

 def initWithNWeapons
   if (generator > NWEAPONSPROB)
     return 1

   else
   end

 end

 def initWithNShields
   if (generator > NSHIELDSPROB )
     return 1
   else
     return 0
   end
 end

 def whoStarts(nPlayers)
   rand(nPlayers)
 end

 def firstShot
   if (generator > FIRSTSHOTPROB )
     return Deepspace::GameCharacter::ENEMYSTARSHIP
   else
     return Deepspace::GameCharacter::SPACESTATION
   end

 end

 def spaceStationMoves(speed)
   if (generator > speed)
     return false 
   else
     return true
   end
 end




end
