import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class TwoDPoint implements Clusterable<TwoDPoint>{
	double x;
	double y;

	public TwoDPoint(String str){
		String[] split_string = str.split(",");
		this.x = Double.parseDouble(split_string[0]);
		this.y = Double.parseDouble(split_string[1]);
	}
	public TwoDPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public double distance(TwoDPoint other) {
		return Math.sqrt(((this.x - other.x) * (this.x - other.x)) + (this.y - other.y) * (this.y - other.y));
	}

	public static Set<TwoDPoint> readClusterableSet(String path) throws IOException{
		// iterate through all the lines, convert each line to a point, add to set
		try {
			return Files.lines(Paths.get(path)).map(p -> new TwoDPoint(p)).collect(Collectors.toSet());
		}
		catch (IOException e) {
			throw e;
		}
	}

	@Override
	public String toString() {
		return x + "," + y;
	}

	@Override
	public boolean equals(Object other) {
		TwoDPoint otherP = (TwoDPoint) other;
		return (otherP.x == x && otherP.y == y);
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}