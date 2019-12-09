package com.size.truetosize.repository;

import com.size.truetosize.entity.TrueToSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrueToSizeRepository extends JpaRepository<TrueToSize, Long> {
    List<TrueToSize> findByShoeId(final Long shoeId);
}
