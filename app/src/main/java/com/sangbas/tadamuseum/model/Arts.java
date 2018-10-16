
package com.sangbas.tadamuseum.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Arts {

    @SerializedName("elapsedMilliseconds")
    @Expose
    private Integer elapsedMilliseconds;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("countFacets")
    @Expose
    private CountFacets countFacets;
    @SerializedName("artObjects")
    @Expose
    private List<ArtObject> artObjects = null;
    @SerializedName("facets")
    @Expose
    private List<Facet> facets = null;

    public Integer getElapsedMilliseconds() {
        return elapsedMilliseconds;
    }

    public void setElapsedMilliseconds(Integer elapsedMilliseconds) {
        this.elapsedMilliseconds = elapsedMilliseconds;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public CountFacets getCountFacets() {
        return countFacets;
    }

    public void setCountFacets(CountFacets countFacets) {
        this.countFacets = countFacets;
    }

    public List<ArtObject> getArtObjects() {
        return artObjects;
    }

    public void setArtObjects(List<ArtObject> artObjects) {
        this.artObjects = artObjects;
    }

    public List<Facet> getFacets() {
        return facets;
    }

    public void setFacets(List<Facet> facets) {
        this.facets = facets;
    }

}
