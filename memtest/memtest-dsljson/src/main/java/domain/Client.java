package domain;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@CompiledJson(formats = {CompiledJson.Format.OBJECT})
public class Client {

    public long _id;
    public int index;
    public boolean isActive;
    public BigDecimal balance;
    public String picture;
    public int age;
    public EyeColor eyeColor;
    public String name;
    public String gender;
    public String company;
    public String[] emails;
    public String address;
    public String about;
    public double latitude;
    public double longitude;
    @JsonAttribute(nullable = false)
    public List<String> tags;
    @JsonAttribute(nullable = false)
    public List<Partner> partners;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Client)) {
            return false;
        }
        Client client = (Client) o;
        return index == client.index &&
                isActive == client.isActive &&
                age == client.age &&
                Math.abs(Double.doubleToLongBits(client.latitude) - Double.doubleToLongBits(latitude)) < 3 &&
                Math.abs(Double.doubleToLongBits(client.longitude) - Double.doubleToLongBits(longitude)) < 3 &&
                Objects.equals(_id, client._id) &&
                balance.compareTo(client.balance) == 0 &&
                Objects.equals(picture, client.picture) &&
                Objects.equals(eyeColor, client.eyeColor) &&
                Objects.equals(name, client.name) &&
                Objects.equals(gender, client.gender) &&
                Objects.equals(company, client.company) &&
                Arrays.equals(emails, client.emails) &&
                Objects.equals(address, client.address) &&
                Objects.equals(about, client.about) &&
                Objects.equals(tags, client.tags) &&
                Objects.equals(partners, client.partners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, index, isActive, balance, picture, age, eyeColor, name, gender, company, emails, address, about, tags, partners);
    }

    private String toStr(long[] nums) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        boolean first = true;
        for (long l : nums) {
            if (first) first = false;
            else sb.append(',');
            sb.append(l);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override
    public String toString() {
        return "JsonDataObj{" + "_id=" + _id + ", index=" + index + ", " + "isActive=" + isActive + ", balance=" + balance + ", picture=" + picture + ", age=" + age + ", eyeColor=" + eyeColor + ", name=" + name + ", gender=" + gender + ", company=" + company + ", emails=" + (emails != null ? Arrays.asList(emails) : null) + ", address=" + address + ", about=" + about + ", latitude=" + latitude + ", longitude=" + longitude + ", tags=" + tags + ", partners=" + partners + '}';
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean getActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public EyeColor getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(EyeColor eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String[] getEmails() {
        return emails;
    }

    public void setEmails(String[] emails) {
        this.emails = emails;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Partner> getPartners() {
        return partners;
    }

    public void setPartners(List<Partner> partners) {
        this.partners = partners;
    }
}
