package org.wit.macrocount.models

interface MacroCountStore {
    fun findAll(): List<MacroCountModel>
    fun create(macroCount: MacroCountModel)

    fun update(macroCount: MacroCountModel)
}