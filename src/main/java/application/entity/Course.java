package application.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * Creator: DreamBoy
 * Date: 2018/6/1.
 */
@NodeEntity
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Relationship(type = "hasMap")
    private Set<MindMap> maps;

    public Course() {
        maps = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<MindMap> getMaps() {
        return maps;
    }

    public void addMap(MindMap map) {
        maps.add(map);
    }

    public void removeMap(MindMap map) {
        maps.remove(map);
        //maps.remove(findMapById(map.getId()));
    }

    private MindMap findMapById(long mapId) {
        for (MindMap mindMap: maps) {
            if (mindMap.getId() == mapId)
                return mindMap;
        }
        return null;
    }
}
