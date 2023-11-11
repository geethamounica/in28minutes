package com.in28minutes.rest.socialmedia.socialmedia.filetring;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FilterBean {

    @JsonIgnore
    private String field1;
    private String field2;
    private String field3;
}
