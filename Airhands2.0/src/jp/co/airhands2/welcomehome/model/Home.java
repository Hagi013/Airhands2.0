package jp.co.airhands2.welcomehome.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.airhands2.welcomehome.application.model.PersistenceEntity;

@Entity(name = "home")
public class Home extends PersistenceEntity{

    private static final long serialVersionUID = 0x88224b2a55cd4d12L;
    
    @Id
    @Column(name = "home_id", nullable = false, length = 10, unique = true)
    private String homeId;
       
    @ManyToOne(targetEntity = User.class)
    @NotBlank
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
	@ManyToOne(targetEntity = HomeType.class)
    @NotBlank(message = "住宅のタイプを選択してください。")
    @JoinColumn(name = "home_type_id", nullable = false)
    private HomeType homeType;   
    
    @OneToOne(targetEntity = RoomType.class)
    @NotBlank(message = "部屋のタイプを選択してください。")
    @JoinColumn(name = "room_type_id", nullable = false)
    private RoomType roomType;
    
    
    @Column(name = "number_of_room", nullable = false)
    private int numberOfRoom;
  
    @NotBlank(message = "収容人数を選択してください。")
    @Column(name = "capacity")
    private String capacity;

    @NotBlank(message = "ロケーションを選択してください。")    
    @Column(name = "location", nullable = false)
    private String location;

    @NotBlank(message = "金額を入力してください。")    
    @Column(name = "price", nullable = false)
    private int price;

    @NotBlank(message = "通貨を選択してください。")    
    @Column(name = "currency", nullable = false)
    private String currency;

    @NotBlank(message = "紹介のタイトルを入力してください。")    
    @Column(name = "outline_tittle", nullable = false)
    private String outlineTittle;

    @NotBlank(message = "みなさんにあいさつをしてみましょう。")    
    @Column(name = "outline", nullable = false)
    private String outline;
    
    @NotBlank(message = "住所を追加してください。") 
    @Column(name = "home_address", nullable = false)
    private String homeAddress;
    
    @ManyToMany
    @JoinTable(name = "home_amanity",
            joinColumns = @JoinColumn(name = "home_id"),
            inverseJoinColumns = @JoinColumn(name = "amenity_id"))
    private List<Amenity> amenities;
    

    @ManyToMany
    @JoinTable(name = "home_photo",
            joinColumns = @JoinColumn(name = "home_id"),
            inverseJoinColumns = @JoinColumn(name = "photo_id"))
    private List<Photo> photos;
    
    @OneToMany(targetEntity = Reservation.class, mappedBy = "home")
    @JoinColumn(name = "home_id")
    private List<Reservation> reservation;

    
/*    setter,getter
*/    
    public String getHomeId()
    {
        return homeId;
    }

    public void setHomeId(String homeId)
    {
        this.homeId = homeId;
    }

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public HomeType getHomeType()
    {
        return homeType;
    }

    public void setHomeType(HomeType homeType)
    {
        this.homeType = homeType;
    }

    public RoomType getRoomType()
    {
        return roomType;
    }

    public void setRoomType(RoomType roomType)
    {
        this.roomType = roomType;
    }

    public int getNumberOfRoom()
    {
        return numberOfRoom;
    }

    public void setNumberOfRoom(int numberOfRoom)
    {
        this.numberOfRoom = numberOfRoom;
    }

    public String getCapacity()
    {
        return capacity;
    }

    public void setCapacity(String capacity)
    {
        this.capacity = capacity;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public String getOutlineTittle()
    {
        return outlineTittle;
    }

    public void setOutlineTittle(String outlineTittle)
    {
        this.outlineTittle = outlineTittle;
    }

    public String getOutline()
    {
        return outline;
    }

    public void setOutline(String outline)
    {
        this.outline = outline;
    }

    public String getHomeAddress()
    {
        return homeAddress;
    }

    public void setHomwAddress(String homeAddress)
    {
        this.homeAddress = homeAddress;
    }

    public List<Amenity> getAmenities()
    {
        return amenities;
    }

    public void setAmenities(List<Amenity> amenities)
    {
        this.amenities = amenities;
    }

    public List<Photo> getPhotos()
    {
        return photos;
    }

    public void setPhotos(List<Photo> photos)
    {
        this.photos = photos;
    }

    public List<Reservation> getResevation()
    {
        return reservation;
    }

    public void setResevation(List<Reservation> resevation)
    {
        this.reservation = resevation;
    }

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
}
