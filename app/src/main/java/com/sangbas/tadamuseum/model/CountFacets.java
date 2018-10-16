
package com.sangbas.tadamuseum.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountFacets {

    @SerializedName("hasimage")
    @Expose
    private Integer hasimage;
    @SerializedName("ondisplay")
    @Expose
    private Integer ondisplay;

    public Integer getHasimage() {
        return hasimage;
    }

    public void setHasimage(Integer hasimage) {
        this.hasimage = hasimage;
    }

    public Integer getOndisplay() {
        return ondisplay;
    }

    public void setOndisplay(Integer ondisplay) {
        this.ondisplay = ondisplay;
    }

}
