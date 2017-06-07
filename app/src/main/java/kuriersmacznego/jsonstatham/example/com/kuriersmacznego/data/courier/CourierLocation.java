package kuriersmacznego.jsonstatham.example.com.kuriersmacznego.data.courier;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CourierLocation {
    @SerializedName("location")
    @Expose
    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}

// It is done this way due to request
// {"location":
//   {"id":12345,
//    "name":"Jan",
//    "surname":"Kowalski",
//    "longitude":"51.107175",
//    "latitude":"17.031997"
//   }
// }