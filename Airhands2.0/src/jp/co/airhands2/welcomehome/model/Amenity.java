// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Amenity.java

package jp.co.airhands2.welcomehome.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import jp.co.airhands2.welcomehome.application.model.PersistenceEntity;


@Entity(name = "amenity")
@Table(name = "AMENIRY")
public class Amenity extends PersistenceEntity{
	
    private static final long serialVersionUID = 0x91840598adee3753L;
    
    @Id
    @Column(name = "login_id", nullable = false,  unique = true)
    private String amenityId;
    
    /*amenity_type_id(Amenity_typeテーブルのamenity_type_idを外部参照している。)
    */
    @ManyToOne(targetEntity = AmenityType.class)
    @Column(name = "amenity_type_id", nullable = false,  unique = true)
    private AmenityType amenityType;
    
    @Column(name = "amenity_name", nullable = false,  unique = true)
    private String amenityName;
    
    /*HOOM_AMENITYテーブル作成のための外部参照用のカラム
    */
    @ManyToMany(mappedBy = "amenities")
    private List<Home> homes;

    
    /*    setter,getter
    */    

    public String getAmenityId()
    {
        return amenityId;
    }

    public void setAmenityId(String amenityId)
    {
        this.amenityId = amenityId;
    }

    public AmenityType getAmenityType()
    {
        return amenityType;
    }

    public void setAmenityType(AmenityType amenityType)
    {
        this.amenityType = amenityType;
    }

    public String getAmenityName()
    {
        return amenityName;
    }

    public void setAmenityName(String amenityName)
    {
        this.amenityName = amenityName;
    }

    public List<Home> getHomes()
    {
        return homes;
    }

    public void setHomes(List<Home> homes)
    {
        this.homes = homes;
    }


}
