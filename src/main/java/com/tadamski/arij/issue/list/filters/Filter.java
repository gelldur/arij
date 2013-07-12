package com.tadamski.arij.issue.list.filters;

/**
 * Created with IntelliJ IDEA.
 * User: tmszdmsk
 * Date: 26.06.13
 * Time: 19:12
 * To change this template use File | Settings | File Templates.
 */
public class Filter {

    public String name;
    public String description;
    public String jql;

    public Filter(String name, String jql) {
        this.name = name;
        this.jql = jql;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Filter filter = (Filter) o;

        if (jql != null ? !jql.equals(filter.jql) : filter.jql != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return jql != null ? jql.hashCode() : 0;
    }
}
