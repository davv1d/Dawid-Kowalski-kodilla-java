package com.kodilla.rps.elements;

import java.util.List;

public class Element {
    private final ElementName name;
    private final List<ElementName> elementsThatIOvercomes;
    private final List<ElementName> elementsWhichDefeatMe;

    public Element(ElementName name, List<ElementName> elementsThatIOvercomes, List<ElementName> elementsWhichDefeatMe) {
        this.name = name;
        this.elementsThatIOvercomes = elementsThatIOvercomes;
        this.elementsWhichDefeatMe = elementsWhichDefeatMe;
    }

    public List<ElementName> getElementsThatIOvercomes() {
        return elementsThatIOvercomes;
    }
    public List<ElementName> getElementsWhichDefeatMe() {
        return elementsWhichDefeatMe;
    }

    public ElementName getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Element element = (Element) o;

        if (getName() != element.getName()) return false;
        if (getElementsThatIOvercomes() != null ? !getElementsThatIOvercomes().equals(element.getElementsThatIOvercomes()) : element.getElementsThatIOvercomes() != null)
            return false;
        return getElementsWhichDefeatMe() != null ? getElementsWhichDefeatMe().equals(element.getElementsWhichDefeatMe()) : element.getElementsWhichDefeatMe() == null;

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getElementsThatIOvercomes() != null ? getElementsThatIOvercomes().hashCode() : 0);
        result = 31 * result + (getElementsWhichDefeatMe() != null ? getElementsWhichDefeatMe().hashCode() : 0);
        return result;
    }
}
