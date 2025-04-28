package com.crud.library.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class LedgerDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 6438782L;

    private Long Id;

    private Long borrowerId;

    private Long bookId;

    private Date recievedDate;

    private Date returnedDate;
}
