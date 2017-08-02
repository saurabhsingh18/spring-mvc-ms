
package com.saurabh.sample.springmvc.json.object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "books"
})
public class Books implements Serializable
{

    @JsonProperty("books")
    private List<Book> books = new ArrayList<Book>();
    private final static long serialVersionUID = -8303886775352075716L;

    /**
     * 
     * @return
     *     The books
     */
    @JsonProperty("books")
    public List<Book> getBooks() {
        return books;
    }

    /**
     * 
     * @param books
     *     The books
     */
    @JsonProperty("books")
    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
