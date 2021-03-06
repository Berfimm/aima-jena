package aimax.osm.data.entities;

import java.util.List;

import aimax.osm.data.Position;

/**
 * Represents a track. A track is not really part of a map, but essential
 * for displaying route planning results and agent movements. Therefore,
 * it has been added here.
 * @author Ruediger Lunde
 */
public interface Track extends MapEntity {
	
	List<MapNode> getNodes();
	
	MapNode getLastNode();

	void addNode(MapNode node);
	
	void addNode(Position pos);
}
