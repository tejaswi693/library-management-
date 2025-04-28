package com.crud.library.controller;

import com.crud.library.dto.BorrowerDto;
import com.crud.library.service.IBorrowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("borrower")
@RequiredArgsConstructor
public class BorrowerEndpoint {

    private final IBorrowerService borrowerService;

    @PostMapping("/")
    public ResponseEntity<BorrowerDto> create(@RequestBody BorrowerDto borrowerDto) {
        BorrowerDto borrowerDto1 = borrowerService.save(borrowerDto);
        return ResponseEntity.ok(borrowerDto1);
    }
    @PutMapping("/{borrowerId}")
    public ResponseEntity<BorrowerDto> update(@PathVariable("borrowerId") Long borrowerId, @RequestBody BorrowerDto borrowerDto){
        borrowerDto.setId(borrowerId);
        BorrowerDto response = borrowerService.update(borrowerDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{borrowerId}")
    public ResponseEntity<Void> delete(@PathVariable("borrowerId") Long borrowerId){
        borrowerService.delete(borrowerId);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{borrowerId}")
    public ResponseEntity<BorrowerDto> getById(@PathVariable("borrowerId") Long borrowerId){
        BorrowerDto byId = borrowerService.getById(borrowerId);
        return ResponseEntity.ok(byId);
    }

    @GetMapping
    public ResponseEntity<List<BorrowerDto>> getAll(){
        List<BorrowerDto> all = borrowerService.getAll();
        return ResponseEntity.ok(all);
    }

}
