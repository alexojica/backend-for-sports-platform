package rowing.commons.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import rowing.commons.Position;
import rowing.commons.entities.utils.DTO;
import rowing.commons.entities.utils.Views;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Dto for any activity.
 */
@Data
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TrainingDTO.class, name = "TrainingDTO"),
        @JsonSubTypes.Type(value = CompetitionDTO.class, name = "CompetitionDTO")
})
@JsonView(Views.Public.class)
public class ActivityDTO implements DTO {

    private UUID id;
    private UUID owner;
    private String name;
    private String type;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date start;
    private List<Position> positions;

    private  List<String> applicants;

    /**
     * Getter for the id.
     *
     * @return the id
     */
    public UUID getId() {
        return id;
    }

    public UUID getOwner() {
        return owner;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    /**
     * Empty constructor for ActivityDTO.
     */
    public ActivityDTO() {
    }

    /**
     * Constructor for ActivityDTO.
     *
     * @param id of the activity
     *
     * @param owner of the activity
     *
     * @param name of the activity
     *
     * @param type of the activity
     *
     * @param start time of the activity
     *
     * @param positions required for the activity
     *
     * @param applicants for this activity
     */
    public ActivityDTO(UUID id, UUID owner, String name, String type, Date start,
                       List<Position> positions, List<String> applicants) {
        this.id = id;
        this.owner = owner;
        this.name = name;
        this.type = type;
        this.start = start;
        this.positions = positions;
        this.applicants = applicants;
    }

    /**
     * Getter for the starting time of the activity.
     *
     * @return the starting time of the activity
     */
    public Date getStart() {
        return start;
    }

    /**
     * Getter for the list of positions.
     *
     * @return the list of positions needed
     */
    public List<Position> getPositions() {
        return positions;
    }

    /**
     * Getter for the list of applicants.
     *
     * @return the list of applicant IDs.
     */
    public List<String> getApplicants() {
        return applicants;
    }

    /**
     * A constructor for ActivityDTO.
     *
     * @param dto to be used
     */
    public ActivityDTO(ActivityDTO dto) {
        this.id = dto.getId();
        this.owner = dto.getOwner();
        this.name = dto.getName();
        this.type = dto.getType();
        this.start = dto.getStart();
        this.positions = dto.getPositions();
        this.applicants = dto.getApplicants();
    }
}
