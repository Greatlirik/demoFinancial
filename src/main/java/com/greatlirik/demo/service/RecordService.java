package com.greatlirik.demo.service;

import com.greatlirik.demo.model.Record;

import java.util.List;

/**
 * CRUD and simple logic operations on Record
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
public interface RecordService {

    /**
     * Get all records
     *
     * @return list with all records
     */
    List<Record> findAll();
}
