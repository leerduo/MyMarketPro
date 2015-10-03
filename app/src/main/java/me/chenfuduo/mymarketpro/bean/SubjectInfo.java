package me.chenfuduo.mymarketpro.bean;

/**
 * Created by chenfuduo on 2015/10/3.
 */
public class SubjectInfo {
    private String des;
    private String url;

    public SubjectInfo(String des, String url) {
        this.des = des;
        this.url = url;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return "SubjectInfo{" +
                "des='" + des + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
