package site.entity;

import java.util.Date;

public class EtcInfo
{
  private int carid;
  private String monry;
  private Date etcintime;
  private Date etcouttime;

  public int getCarid()
  {
    return this.carid; }

  public void setCarid(int carid) {
    this.carid = carid; }

  public String getMonry() {
    return this.monry; }

  public void setMonry(String monry) {
    this.monry = monry; }

  public Date getEtcintime() {
    return this.etcintime; }

  public void setEtcintime(Date etcintime) {
    this.etcintime = etcintime; }

  public Date getEtcouttime() {
    return this.etcouttime; }

  public void setEtcouttime(Date etcouttime) {
    this.etcouttime = etcouttime;
  }

  public String toString() {
    return "EtcInfo [carid=" + this.carid + ", monry=" + this.monry + ", etcintime=" + this.etcintime + ", etcouttime=" + 
      this.etcouttime + "]";
  }
}