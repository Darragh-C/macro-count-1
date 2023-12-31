package org.wit.macrocount.models
import timber.log.Timber.Forest.i

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}
class MacroCountMemStore: MacroCountStore {

    val macroCounts = ArrayList<MacroCountModel>()

    override fun findAll(): List<MacroCountModel> {
        return macroCounts
    }

    override fun create(macroCount: MacroCountModel) {
        macroCount.id = getId()
        macroCounts.add(macroCount)
        logAll()
    }

    override fun update(macroCount: MacroCountModel) {
        var foundMacroCount: MacroCountModel? = macroCounts.find { m -> m.id == macroCount.id }
        if (foundMacroCount != null) {
            foundMacroCount.title = macroCount.title
            foundMacroCount.description = macroCount.description
            foundMacroCount.calories = macroCount.calories
            foundMacroCount.carbs = macroCount.carbs
            foundMacroCount.protein = macroCount.protein
            foundMacroCount.fat = macroCount.fat

            logAll()
        }
    }

    private fun logAll() {
        macroCounts.forEach{ i("$it")}
    }
}