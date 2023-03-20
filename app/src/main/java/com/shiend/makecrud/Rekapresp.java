package com.shiend.makecrud;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rekapresp {

    @SerializedName("IDMEETING")
    @Expose
    private String idmeeting;

    @SerializedName("PERIHAL")
    @Expose
    private String perihal;

    @SerializedName("NIKPIC")
    @Expose
    private String nikpic;

    @SerializedName("NAMAPIC")
    @Expose
    private String namapic;

    @SerializedName("KETHASIL")
    @Expose
    private String ket;

    @SerializedName("NIKPICOTOR")
    @Expose
    private String tvnik;

    @SerializedName("IDDTLMEETING")
    @Expose
    private String iddlmeeting;

    @SerializedName("NAMAPICOTOR")
    @Expose
    private String tvnamapic;

    @SerializedName("TGLTARGET")
    @Expose
    private String tgltarget;

    @SerializedName("KETERANGAN")
    @Expose
    private String tvket;


    public String getIdmeeting() {
        return idmeeting;
    }

    public void setIdmeeting(String idmeeting) {
        this.idmeeting = idmeeting;
    }

    public String getPerihal() {
        return perihal;
    }

    public void setPerihal(String perihal) {
        this.perihal = perihal;
    }

    public String getNikpic() {
        return nikpic;
    }

    public void setNikpic(String nikpic) {
        this.nikpic = nikpic;
    }

    public String getNamapic() {
        return namapic;
    }

    public void setNamapic(String namapic) {
        this.namapic = namapic;
    }

    public String getKeterangan() {
        return ket;
    }

    public void setKeterangan(String keterangan) {
        this.ket = ket;
    }

    public String getIddlmeeting() {
        return iddlmeeting;
    }

    public void setIddlmeeting(String iddlmeeting) {
        this.iddlmeeting = iddlmeeting;
    }

    public String getTgltarget() {
        return tgltarget;
    }

    public void setTgltarget(String tgltarget) {
        this.tgltarget = tgltarget;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public String getTvket() {
        return tvket;
    }

    public void setTvket(String tvket) {
        this.tvket = tvket;
    }

    public String getTvnik() {
        return tvnik;
    }

    public void setTvnik(String tvnik) {
        this.tvnik = tvnik;
    }

    public String getTvnamapic() {
        return tvnamapic;
    }

    public void setTvnamapic(String tvnamapic) {
        this.tvnamapic = tvnamapic;
    }
}
