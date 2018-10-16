
package com.sangbas.tadamuseum.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Facet {

    @SerializedName("facets")
    @Expose
    private List<Facet_> facets = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("otherTerms")
    @Expose
    private Integer otherTerms;
    @SerializedName("prettyName")
    @Expose
    private Integer prettyName;

    public List<Facet_> getFacets() {
        return facets;
    }

    public void setFacets(List<Facet_> facets) {
        this.facets = facets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOtherTerms() {
        return otherTerms;
    }

    public void setOtherTerms(Integer otherTerms) {
        this.otherTerms = otherTerms;
    }

    public Integer getPrettyName() {
        return prettyName;
    }

    public void setPrettyName(Integer prettyName) {
        this.prettyName = prettyName;
    }

}
