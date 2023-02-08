package org.echaselab2;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Integer>{
    List<BuddyInfo> findByName(String name);

    BuddyInfo findById(Long id);
}
