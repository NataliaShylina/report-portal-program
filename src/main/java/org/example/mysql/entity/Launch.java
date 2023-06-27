package org.example.mysql.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Launch {
    private Integer id;
    private String name;
    private Integer total;
    private Integer passed;
    private Integer skipped;
    private Integer failed;
    private Integer productBug;
    private Integer autoBug;


}
