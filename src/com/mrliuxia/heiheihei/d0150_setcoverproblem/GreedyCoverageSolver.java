package com.mrliuxia.heiheihei.d0150_setcoverproblem;

public class GreedyCoverageSolver extends GreedySolver {

	public GreedyCoverageSolver() {
		this._name = "Greedy coverage heuristic";
		this.reset();
	}

	@Override
	public ElementSet nextBestSet() {
//		return null; // TODO: Implement this
		int nextId = 0;
		int maxCover = 0;
        for (ElementSet currElemSet : this._model.getElementSetIterable()) {
            if (this._solnSets.contains(currElemSet)) {
                continue;
            }
            int currCover = 0;
            for (Integer id : currElemSet.getElementIterable()) {
                if (this._elementsNotCovered.contains(id)) {
                    currCover++;
                }
            }
            if (currCover > maxCover) {
                nextId = currElemSet.getId();
                maxCover = currCover;
            }
        }
        for (ElementSet currElemSet : this._model.getElementSetIterable()) {
            if (currElemSet.getId() == nextId) {
                return currElemSet;
            }
        }
        return null;
	}

}
