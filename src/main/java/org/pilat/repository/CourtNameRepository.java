/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.pilat.model.CourtName;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Pilat
 */
public interface CourtNameRepository extends CrudRepository<CourtName, Long> {

    @Query(value = "select cn.courtName1 from CourtName cn")
    List<CourtName> getCourtName1();

    @Query(value = "select cn.courtName2 from CourtName cn")
    List<CourtName> getCourtName2();

    @Query(value = "select cn.courtName3 from CourtName cn")
    List<CourtName> getCourtName3();
}
