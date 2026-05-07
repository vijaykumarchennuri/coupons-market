package CuponCodes.CuponCodes.dto;

public class CouponDTO {

    private String title;
    private String couponCode;
    private Double price;
    private String phoneNumber;
    private String username;
    private Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



    // Getters & Setters

    public String getTitle() {
        return title;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public Double getPrice() {
        return price;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}