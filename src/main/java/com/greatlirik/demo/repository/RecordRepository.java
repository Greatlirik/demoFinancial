package com.greatlirik.demo.repository;

import com.greatlirik.demo.model.Record;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RecordRepository extends PagingAndSortingRepository<Record,Long> {
}
