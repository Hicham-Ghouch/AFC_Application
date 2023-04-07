package math_box;

public class matrix {
	private double coordinates[][];

	public matrix(double[][] coordinates) {
		this.coordinates = coordinates;
	}

	public double[][] getCoordinates() {
		return coordinates;
	}

	@Override
	public String toString() {
		StringBuilder text = new StringBuilder();
		// rechercher pourqoui StringBuilder a �t� utilis�e
		text.append("[");
		for (int i = 0; i < coordinates.length; i++) {
			text.append(coordinates[i]);
			text.append(" ");
		}
		text.append("]");
		return text.toString();
	}
}
