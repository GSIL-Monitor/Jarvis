package heiheihei.d0150_setcoverproblem;

public class ChvatalSolver extends GreedySolver {
	
	public ChvatalSolver() {
		this._name = "Chvatal's algorithm";
		this.reset();
	}
	
	@Override
	public ElementSet nextBestSet() {
//		return null; // TODO: Implement this
		int nextId = 0;
		double minCostRatio = Double.MAX_VALUE;
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
			if (currCover == 0) {
				continue;
			}
			double currCostRatio = currElemSet.getCost() / currCover;
			if (currCostRatio < minCostRatio) {
				nextId = currElemSet.getId();
				minCostRatio = currCostRatio;
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
