package site.entity;

public class Intersection
{
  private String mark;
  private int red_light_duration;
  private int yellow_light_duration;
  private int green_light_duration;

  public String toString()
  {
    return "intersection [mark=" + this.mark + ", red_light_duration=" + this.red_light_duration + ", yellow_light_duration=" + 
      this.yellow_light_duration + ", green_light_duration=" + this.green_light_duration + "]";
  }

  public String getMark() {
    return this.mark;
  }

  public void setMark(String mark) {
    this.mark = mark;
  }

  public int getRed_light_duration() {
    return this.red_light_duration;
  }

  public void setRed_light_duration(int red_light_duration) {
    this.red_light_duration = red_light_duration;
  }

  public int getYellow_light_duration() {
    return this.yellow_light_duration;
  }

  public void setYellow_light_duration(int yellow_light_duration) {
    this.yellow_light_duration = yellow_light_duration;
  }

  public int getGreen_light_duration() {
    return this.green_light_duration;
  }

  public void setGreen_light_duration(int green_light_duration) {
    this.green_light_duration = green_light_duration;
  }
}