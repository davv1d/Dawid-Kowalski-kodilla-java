package com.kodilla.rps.logic.symbol;

import java.util.List;

public class Symbol {
    private final SymbolName name;
    private final List<SymbolName> symbolsNamesThatIOvercomes;
    private final List<SymbolName> symbolsNamesWhichDefeatMe;

    public Symbol(SymbolName name, List<SymbolName> symbolsNamesThatIOvercomes, List<SymbolName> symbolsNamesWhichDefeatMe) {
        this.name = name;
        this.symbolsNamesThatIOvercomes = symbolsNamesThatIOvercomes;
        this.symbolsNamesWhichDefeatMe = symbolsNamesWhichDefeatMe;
    }

    public List<SymbolName> getSymbolsNamesThatIOvercomes() {
        return symbolsNamesThatIOvercomes;
    }
    public List<SymbolName> getSymbolsNamesWhichDefeatMe() {
        return symbolsNamesWhichDefeatMe;
    }

    public SymbolName getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symbol symbol = (Symbol) o;

        if (getName() != symbol.getName()) return false;
        if (getSymbolsNamesThatIOvercomes() != null ? !getSymbolsNamesThatIOvercomes().equals(symbol.getSymbolsNamesThatIOvercomes()) : symbol.getSymbolsNamesThatIOvercomes() != null)
            return false;
        return getSymbolsNamesWhichDefeatMe() != null ? getSymbolsNamesWhichDefeatMe().equals(symbol.getSymbolsNamesWhichDefeatMe()) : symbol.getSymbolsNamesWhichDefeatMe() == null;

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getSymbolsNamesThatIOvercomes() != null ? getSymbolsNamesThatIOvercomes().hashCode() : 0);
        result = 31 * result + (getSymbolsNamesWhichDefeatMe() != null ? getSymbolsNamesWhichDefeatMe().hashCode() : 0);
        return result;
    }
}
