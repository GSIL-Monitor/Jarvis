package com.mrliuxia.heiheihei.d0150_setcoverproblem;

public class GreedyCostSolver extends GreedySolver {
	
	public GreedyCostSolver() {
		this._name = "Greedy cost heuristic";
		this.reset();
	}
	
	@Override
	public ElementSet nextBestSet() {
//		return null; // TODO: Implement this
		int nextId = 0;
		double minCost = Double.MAX_VALUE;
		for (ElementSet currElemSet : this._model.getElementSetIterable()) {
			if (this._solnSets.contains(currElemSet)) {
				continue;
			}
			boolean hasNotCoveredEle = false;
			for (Integer id :currElemSet.getElementIterable()) {
				if (this._elementsNotCovered.contains(id)) {
					hasNotCoveredEle = true;
					break;
				}
			}
			if (hasNotCoveredEle && currElemSet.getCost() < minCost) {
				nextId = currElemSet.getId();
				minCost = currElemSet.getCost();
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
