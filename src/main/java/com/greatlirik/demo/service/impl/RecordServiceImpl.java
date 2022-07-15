package com.greatlirik.demo.service.impl;

import com.greatlirik.demo.model.Record;
import com.greatlirik.demo.repository.RecordRepository;
import com.greatlirik.demo.service.RecordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Record service implementation
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class RecordServiceImpl implements RecordService {

    private final RecordRepository recordRepository;

    @Override
    public List<Record> findAll() {
        final List<Record> result = (List<Record>) recordRepository.findAll();

        log.info("In getAll - {} records found", result.size());
        return result;
    }
}

