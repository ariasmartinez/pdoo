#encoding:utf-8

module Deepspace


# @author Lucía Salamanca López, Celia Arias Martínez
class GameUniverse
  @@WIN = 10

# Hay que crear un dado
# controlador de estados?
  def initialize
    @currentStationIndex #int   # no sé que hay que poner
    @turns = 0 #int
    @dado = Dice::Dice.new #Dice     #hace falta poner new?  (poner new o no)
    @controlador_estado  = GameStateController.new   #GameStateController  (poner new o no)
    @est_espacial  = Array.new #Array SpaceStation  (poner new o no)
    @enemy = EnemyStarShip.new #EnemyStarShip

  end

  def combatGo(station, enemy)
#siguiente práctica
  end

  def combat
#siguiente práctica
  end

  def discardHangar
    if (@controlador_estado == INIT or @controlador_estado == AFTERCOMBAT)
      @est_espacial[@currentStationIndex].discardHangar
    end
  end

  def discardShieldBooster(i)
    if (@controlador_estado == INIT or @controlador_estado == AFTERCOMBAT)
      @est_espacial[@currentStationIndex].discardShieldBooster(i)
    end
  end

  def discardShieldBoosterinHangar(i)
    if (@controlador_estado == INIT or @controlador_estado == AFTERCOMBAT)
      @est_espacial[@currentStationIndex].discardShieldBoosterinHangar(i)
    end
  end

  def discardWeapon(i)
    if (@controlador_estado == INIT or @controlador_estado == AFTERCOMBAT)
      @est_espacial[@currentStationIndex].discardWeapon(i)
    end
  end

  def discardWeaponinHangar(i)
    if (@controlador_estado == INIT or @controlador_estado == AFTERCOMBAT)
      @est_espacial[@currentStationIndex].discardWeaponinHangar(i)
    end
  end

  def getState
    return @controlador_estado
  end

  def getUIversion
    GameUniverseToUI.new(self)
  end

  def haveAWinner
    if (@est_espacial[@currentStationIndex].nMedals == WIN)
      return true
    end
    return false
  end

  def init(names)
#siguiente práctica
  end

  def mountShieldBooster(i)
    if (@controlador_estado == INIT or @controlador_estado == AFTERCOMBAT)
      @est_espacial[@currentStationIndex].mountShieldBooster(i)
    end
  end

  def mountWeapon(i)
    if (@controlador_estado == INIT or @controlador_estado == AFTERCOMBAT)
      @est_espacial[@currentStationIndex].mountWeapon(i)
    end
  end

  def nextTurn
#siguiente práctica
  end

  #lo he puesto igual que el toUI
  def to_s
    out = "Estación actual -> #{@currentStation}\n"
    out +="Enemigo actual --> #{@currentEnemy}"
    return out
  end

end

end
