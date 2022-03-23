package domain;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import com.bluelinelabs.logansquare.typeconverters.StringBasedTypeConverter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@JsonObject
public class Client {

    @JsonField
    public long _id;
    @JsonField
    public int index;
    @JsonField
    public boolean isActive;
    @JsonField(typeConverter = LoganBigDecimalConverter.class)
    public BigDecimal balance;
    @JsonField
    public String picture;
    @JsonField
    public int age;
    @JsonField(typeConverter = LoganEnumConverter.class)
    public EyeColor eyeColor;
    @JsonField
    public String name;
    @JsonField
    public String gender;
    @JsonField
    public String company;
    @JsonField
    public String[] emails;
    @JsonField
    public String address;
    @JsonField
    public String about;
    @JsonField
    public double latitude;
    @JsonField
    public double longitude;
    @JsonField
    public List<String> tags;
    @JsonField
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

    public static class LoganBigDecimalConverter extends StringBasedTypeConverter<BigDecimal> {
        @Override
        public BigDecimal getFromString(String s) {
            return new BigDecimal(s);
        }

        public String convertToString(BigDecimal object) {
            return object.toPlainString();
        }
    }

    public static class LoganEnumConverter extends StringBasedTypeConverter<EyeColor> {
        @Override
        public EyeColor getFromString(String s) {
            return EyeColor.valueOf(s);
        }

        public String convertToString(EyeColor object) {
            return object.toString();
        }
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
