
/**
 * The Class WeatherData.
 */
public class WeatherData {

    private String temperature, humidity, pressure, 
            wind, time, name, clouds,longitude,latitude,icon;

    /**
     * Instantiates a new weather data.
     *
     * @param temperature the temperature
     * @param humidity the humidity
     * @param pressure the pressure
     * @param wind the wind
     * @param time the time
     * @param name the name
     * @param clouds the clouds
     * @param longitude the longitude
     * @param latitude the latitude
     * @param icon the icon
     */
    public WeatherData(String temperature, String humidity, String pressure, String wind, String time, String name, String clouds, String longitude, String latitude, String icon) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.wind = wind;
        this.time = time;
        this.name = name;
        this.clouds = clouds;
        this.longitude = longitude;
        this.latitude = latitude;
        this.icon = icon;
       
    }

    /**
     * Gets the icon.
     *
     * @return the icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Sets the icon.
     *
     * @param icon the new icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }



    /**
     * Gets the longitude.
     *
     * @return the longitude
     */
    public String getlongitude() {
        return longitude;
    }

    /**
     * Gets the latitude.
     *
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }
 


    /**
     * Gets the clouds.
     *
     * @return the clouds
     */
    public String getClouds() {
        return clouds;
    }

    /**
     * Gets the temperature.
     *
     * @return the temperature
     */
    public String getTemperature() {
        return temperature;
    }

    /**
     * Gets the humidity.
     *
     * @return the humidity
     */
    public String getHumidity() {
        return humidity;
    }

    /**
     * Gets the pressure.
     *
     * @return the pressure
     */
    public String getPressure() {
        return pressure;
    }

    /**
     * Gets the wind.
     *
     * @return the wind
     */
    public String getWind() {
        return wind;
    }

    /**
     * Gets the time.
     *
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "WeatherData{" + "temperature=" + temperature + ", humidity=" + humidity + ", pressure=" + pressure + 
                "\n, wind=" + wind + ", time=" + time + ", name=" + name + ", clouds=" + clouds +
                "\n, longitude=" + longitude + ", latitude=" + latitude + '}'+
                ",icon="+icon+"\n";
    }



}
