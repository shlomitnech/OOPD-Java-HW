import java.util.*;
import java.util.stream.Collectors;

public class AgglomerativeClustering<T extends Clusterable<T>> implements Clustering<T> {
	double threshold;

	public AgglomerativeClustering(double threshold) {
		this.threshold = threshold;
	}

	public Set<Set<T>> clusterSet(Set<T> elements) {
		if (elements.isEmpty()) {
			return Collections.emptySet();
		}

		// Initialize clusters: each element in its own cluster
		Set<Set<T>> clusters = elements.stream()
				.map(e -> {
					Set<T> singleton = new HashSet<>();
					singleton.add(e);
					return singleton;
				})
				.collect(Collectors.toSet());


		// get a mpa of --> List[point1, point2] : distance between them
		Map<List<T>, Double> distanceMap = elements.stream()
				.flatMap(e1 -> elements.stream() //take each element to compare to others
						.filter(e2 -> !e1.equals(e2)) //go through all the other elements
						//add the value to the dictionary
						.map(e2 -> new AbstractMap.SimpleEntry<>(Arrays.asList(e1, e2), e1.distance(e2))))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		// sort the distance from lowest to highest and filter out any distance above the threshold
		Map<List<T>, Double> sortedDistanceMap = distanceMap.entrySet().stream()
				.filter(entry -> entry.getValue() <= threshold) // only keep those entries <= the threshold
				.sorted(Map.Entry.comparingByValue()) // sort by value (distances)
				.collect(Collectors.toMap(
						Map.Entry::getKey,
						Map.Entry::getValue,
						(e1,e2) -> e1,
						LinkedHashMap::new // we are using LinkedHashMap to preserve the order
				));

		// create an iterator to iterator through the sortedDistanceMap
		Iterator<Map.Entry<List<T>, Double>> iterator = sortedDistanceMap.entrySet().iterator();

		// main while loop of program
		while (clusters.size() != 1 && iterator.hasNext()) //while clusters != 1 and there is more to iterator over
		{
			//	find the two closest clusters, c1,c2 from clusters

			// get the next entry
			Map.Entry<List<T>, Double> nextEntry = iterator.next();
			List<T> closestPair = nextEntry.getKey(); // this is the closest pair

			// extract the two points of the closestPair
			T element1 = closestPair.get(0);
			T element2 = closestPair.get(1);

			// extract the (two) cluster(s) that the closestPair is in
			Set<T> cluster1 = clusters.stream()
					.filter(cluster -> cluster.contains(element1))
					.findFirst()
					.orElse(null);
			Set<T> cluster2 = clusters.stream()
					.filter(cluster -> cluster.contains(element2))
					.findFirst()
					.orElse(null);

			// if null or already in the same cluster
			// don't do this if it already exists
			if (cluster1 != null && cluster2 != null && !cluster1.equals(cluster2)) {
				//create a new cluster with cluster1 and cluster2
				Set<T> newCluster = new HashSet<>(cluster1);
				newCluster.addAll(cluster2);

				// Remove the original clusters
				clusters.remove(cluster1);
				clusters.remove(cluster2);
				clusters.add(newCluster); // add the new cluster to the clusters set

			}
			iterator.remove(); // Remove the processed entry from the iterator

		}
		return clusters;
	}
}