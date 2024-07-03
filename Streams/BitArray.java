import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BitArray implements Clusterable<BitArray>{
	private ArrayList<Boolean> bits;

	public BitArray(String str){
		String[] split_string = str.split(",");
		this.bits = Arrays.stream(split_string)
				.map(Boolean::parseBoolean)
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public BitArray(boolean[] bits) {
		this.bits = IntStream.range(0, bits.length)
				.mapToObj(i -> bits[i])  // Map each boolean to Boolean
				.collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public double distance(BitArray other) {
		if (this.bits.size() != other.bits.size()) { // if they are not the same length
			return -1;
		}
		//count the ones that are different -- this is the distance
		return  IntStream.range(0, this.bits.size())
				.filter(i -> !this.bits.get(i).equals(other.bits.get(i)))
				.count();
	}

	public static Set<BitArray> readClusterableSet(String path) throws IOException {
		// iterate through all the lines, convert each line to a BitArray, add to set
		try {
			Set<BitArray> set =  Files.lines(Paths.get(path)).map(line -> new BitArray(line)).collect(Collectors.toSet());
			//find the maximal length
			OptionalInt maxSize = set.stream().mapToInt(line -> line.bits.size())
					.max();
			if (maxSize.isPresent()) {
				int Msize = maxSize.getAsInt();
				return set.stream()
						.filter(bitArray -> bitArray.bits.size() == Msize) // we only want those that are of max size
						.collect(Collectors.toSet());
			}
			return set;
		}
		catch (IOException e) {
			throw e;
		}
	}

	@Override
	public String toString() {
		return bits.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BitArray bitArray = (BitArray) o;
		return bits.equals(bitArray.bits);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bits);
	}
}