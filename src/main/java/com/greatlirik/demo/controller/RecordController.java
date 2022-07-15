package com.greatlirik.demo.controller;

import com.greatlirik.demo.model.Record;
import com.greatlirik.demo.service.RecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * UserRESTController
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/records")
@Tag(name = "Record Controller", description = "Allows to perform CRUD operations on the record")
public class RecordController {

    private final RecordService recordService;

    /**
     * Find all records
     *
     * @return List<Record>
     */
    @Operation(
            summary = "Find all records"
    )
    @GetMapping
    public List<Record> findAllRecords() {
        return recordService.findAll();
    }
}