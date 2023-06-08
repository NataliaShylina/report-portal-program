package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Launch {
    private String owner;
    private boolean share;
    private int id;
    private String uuid;
    private String name;
    private int number;
    private long startTime;
    private long lastModified;
    private String status;

    @EqualsAndHashCode.Exclude
    private Statistics statistics;
    private List<String> attributes;
    private String mode;
    private List<String> analysing;
    private int approximateDuration;
    private boolean hasRetries;
    private boolean rerun;
}
