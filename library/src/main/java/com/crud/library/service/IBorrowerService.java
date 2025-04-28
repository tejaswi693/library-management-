package com.crud.library.service;

import com.crud.library.dto.BookDto;
import com.crud.library.dto.BorrowerDto;

import java.util.List;

public interface IBorrowerService {
    BorrowerDto save(BorrowerDto borrowerDto);

    BorrowerDto update(BorrowerDto borrowerId);

    void delete(Long borrowerId);

    BorrowerDto getById(Long borrowerId);

    List<BorrowerDto> getAll();
}
