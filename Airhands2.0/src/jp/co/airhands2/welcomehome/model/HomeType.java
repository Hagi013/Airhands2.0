
package jp.co.airhands2.welcomehome.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import jp.co.airhands2.welcomehome.application.model.PersistenceEntity;

@Entity(name = "home_type")
public class HomeType extends PersistenceEntity{
	
    private static final long serialVersionUID = 0xeb963d4f15f6807aL;
    
    @Id
    @Column(name = "home_type_id")
    private String homeTypeId;
    
    @Column(name = "home_type_name")                                                
    private String homeTypeName;
    
    @OneToMany(targetEntity = Home.class, mappedBy = "homeType", cascade = CascadeType.ALL)
    @JoinColumn(name = "home_id")
    private List<Home> homes;
    
    
    /*セッター、ゲッター
    */
    public String getHomeTypeId()
    {
        return homeTypeId;
    }

    public void setHomeTypeId(String homeTypeId)
    {
        this.homeTypeId = homeTypeId;
    }

    public String getHomeTypeName()
    {
        return homeTypeName;
    }

    public void setHomeTypeName(String homeTypeName)
    {
        this.homeTypeName = homeTypeName;
    }

    public List<Home> getHomeTypeIds()
    {
        return homes;
    }

    public void setHomeTypeIds(List<Home> homes)
    {
        this.homes = homes;
    }


}
