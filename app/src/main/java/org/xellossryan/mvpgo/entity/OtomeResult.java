package org.xellossryan.mvpgo.entity;

import java.util.List;

/**
 * Created by Liang on 2016/3/15.
 */
public class OtomeResult {
    public boolean error;
    public List<WildOtome> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<WildOtome> getResults() {
        return results;
    }

    public void setResults(List<WildOtome> results) {
        this.results = results;
    }
}
