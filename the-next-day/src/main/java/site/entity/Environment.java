package site.entity;

public class Environment
{
  private String day;
  private String PM25;
  private String temperature;
  private String humidity;
  private String CO2;

  public String getDay()
  {
    return this.day; }

  public void setDay(String day) {
    this.day = day; }

  public String getPM25() {
    return this.PM25; }

  public void setPM25(String pM25) {
    this.PM25 = pM25; }

  public String getTemperature() {
    return this.temperature; }

  public void setTemperature(String temperature) {
    this.temperature = temperature; }

  public String getHumidity() {
    return this.humidity; }

  public void setHumidity(String humidity) {
    this.humidity = humidity; }

  public String getCO2() {
    return this.CO2; }

  public void setCO2(String cO2) {
    this.CO2 = cO2;
  }

  public String toString() {
    return "Environment [day=" + this.day + ", PM25=" + this.PM25 + ", temperature=" + this.temperature + ", humidity=" + this.humidity + 
      ", CO2=" + this.CO2 + "]";
  }
}