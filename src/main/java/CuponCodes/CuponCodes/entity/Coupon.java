package CuponCodes.CuponCodes.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;




@Entity
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String couponCode;
    private Double price;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // ✅ GETTERS

    public Long getId() {
        return id;
    }

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

    // ✅ SETTERS

    public void setId(Long id) {
        this.id = id;
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
}