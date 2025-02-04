import static globals.Globals.*

MIXER = recipemap('mixer')
DRYER = recipemap('dryer')
ROASTER = recipemap('roaster')
MACERATOR = recipemap('macerator')
ELECTROLYZER = recipemap('electrolyzer')

MIXER.recipeBuilder()
	.inputs(ore('dustBorax'))
	.fluidInputs(fluid('hydrochloric_acid') * 2000)
	.duration(100)
	.fluidOutputs(fluid('boric_acid') * 4000)
	.fluidOutputs(fluid('salt_water') * 1000)
	.EUt(Globals.voltAmps[1])
	.buildAndRegister()
	
//Footnote: This recipe is supposed to have 4000 mb of water, but due to limitations on the slots of the mixer, not in.

DRYER.recipeBuilder()
	.fluidInputs(fluid('boric_acid') * 2000)
	.duration(300)
	.outputs(ore('dustBoronTrioxide').first())
	.fluidOutputs(fluid('water') * 3000)
	.EUt(Globals.voltAmps[1])
	.buildAndRegister()
	
ROASTER.recipeBuilder()
	.inputs(ore('dustBoronTrioxide') * 5)
	.inputs(ore('dustMagnesium') * 3)
	.duration(100)
	.outputs(ore('dustAmorphousBoron').first() * 2)
	.outputs(ore('dustMagnesiumOxide').first() * 3)
	.EUt(Globals.voltAmps[1])
	.buildAndRegister()
	
MACERATOR.recipeBuilder()
	.inputs(ore('dustAmorphousBoron') * 2)
	.duration(100)
	.outputs(ore('dustBoron').first())
	.EUt(Globals.voltAmps[1])
	.buildAndRegister()
	
ELECTROLYZER.recipeBuilder()
	.inputs(ore('dustMagnesiumOxide') * 1)
	.duration(300)
	.outputs(ore('dustMagnesium').first())
	.fluidOutputs(fluid('oxygen') * 1000)
	.EUt(Globals.voltAmps[1])
	.buildAndRegister()
