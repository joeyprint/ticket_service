package me.wasin.joey.CloudNativeFinal.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import me.wasin.joey.CloudNativeFinal.User.User;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "addresses")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long addressId;

    @NotBlank
    private String address;

    @NotBlank
    private String district;

    @NotBlank
    private String province;

    @NotBlank
    private String postcode;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIgnore
    private User user;

    public Address() {
        super();
    }

    public Address(@NotBlank String address, @NotBlank String district, @NotBlank String province, @NotBlank String postcode) {
        this.address = address;
        this.district = district;
        this.province = province;
        this.postcode = postcode;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getAddressId() {
        return addressId;
    }

    public String getAddress() {
        return address;
    }

    public String getDistrict() {
        return district;
    }

    public String getProvince() {
        return province;
    }

    public String getPostcode() {
        return postcode;
    }

    public User getUser() {
        return user;
    }
}
