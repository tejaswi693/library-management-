package com.crud.library.service.impl;

import com.crud.library.dto.BorrowerDto;
import com.crud.library.entity.Borrower;
import com.crud.library.repository.BorrowerRepository;
import com.crud.library.service.IBorrowerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowerService implements IBorrowerService {

    private final BorrowerRepository borrowerRepository;
    private final ModelMapper modelMapper;
    @Override
    public BorrowerDto save(BorrowerDto borrowerDto) {
        Borrower map = modelMapper.map(borrowerDto, Borrower.class);
        Borrower borrower = borrowerRepository.saveAndFlush(map);
        return modelMapper.map(borrower, BorrowerDto.class);
    }

    @Override
    public BorrowerDto update(BorrowerDto borrowerDto) {
       if(borrowerDto.getId() == null){
           throw new RuntimeException("borrower is not present");
       }
        Borrower existingBorrower = borrowerRepository.findById(borrowerDto.getId()).orElseThrow(() ->  new RuntimeException("borrower not found" + borrowerDto.getId()));
        modelMapper.map(borrowerDto, existingBorrower);
        Borrower borrower = borrowerRepository.saveAndFlush(existingBorrower);
        return modelMapper.map(borrower, BorrowerDto.class);

    }

    @Override
    public void delete(Long borrowerId) {
        if(!borrowerRepository.existsById(borrowerId)){
            throw new RuntimeException("borrower is not present");
        }
        borrowerRepository.deleteById(borrowerId);
    }

    @Override
    public BorrowerDto getById(Long borrowerId) {
        Borrower borrower = borrowerRepository.findById(borrowerId).orElseThrow(()-> new RuntimeException("not found"));
        return modelMapper.map(borrower, BorrowerDto.class);
    }

    @Override
    public List<BorrowerDto> getAll() {
        List<Borrower> all = borrowerRepository.findAll();
        return all.stream().map(ele -> modelMapper.map(ele, BorrowerDto.class)).toList();
    }
}
