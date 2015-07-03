package jp.co.airhands2.welcomehome.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import jp.co.airhands2.welcomehome.application.model.PersistenceEntity;

@Entity(name = "amenity_type")
public class AmenityType extends PersistenceEntity{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "amenity_type_id", nullable = false,  unique = true)
	private String amenityTypeId;
	
	/*amenity_type_name
	*/
	@Column(name = "amenity_type_name", nullable = false,  unique = true)
    private String amenityTypeName;

	@OneToMany(targetEntity = Amenity.class, mappedBy = "amenityType", cascade = CascadeType.ALL)
	@JoinColumn(name = "amenity_type_id")
	private List<Amenity> amenityTypeIds;

	
    public String getAmenityTypeId()
    {
        return amenityTypeId;
    }

    public void setAmenityTypeId(String amenityTypeId)
    {
        this.amenityTypeId = amenityTypeId;
    }

    public String getAmenityTypeName()
    {
        return amenityTypeName;
    }

    public void setAmenityTypeName(String amenityTypeName)
    {
        this.amenityTypeName = amenityTypeName;
    }

    public List<Amenity> getAmenityTypeIds()
    {
        return amenityTypeIds;
    }

    public void setAmenityTypeIds(List<Amenity> amenityTypeIds)
    {
        this.amenityTypeIds = amenityTypeIds;
    }

}
