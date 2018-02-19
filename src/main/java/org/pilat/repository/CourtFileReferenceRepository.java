/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.repository;

import java.io.Serializable;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.pilat.model.CourtFileReference;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Pilat
 */
public interface CourtFileReferenceRepository extends CrudRepository<CourtFileReference, Long> {

    @Query("select cfr.courtFileReference1 from CourtFileReference cfr")
    ArrayList<String> courtFileReference1();

    @Query("select cfr.courtFileReference2 from CourtFileReference cfr")
    ArrayList<String> courtFileReference2();

    @Query("select cfr.courtFileReference3 from CourtFileReference cfr")
    ArrayList<String> courtFileReference3();

    @Query("select cfr.courtFileReference4 from CourtFileReference cfr")
    ArrayList<String> courtFileReference4();

    @Query("select cfr.courtFileReference5 from CourtFileReference cfr")
    ArrayList<String> courtFileReference5();

    @Query("select cfr.courtFileReference6 from CourtFileReference cfr")
    ArrayList<String> courtFileReference6();

    @Query("select cfr.courtFileReference7 from CourtFileReference cfr")
    ArrayList<String> courtFileReference7();

    @Query("select cfr.courtFileReference8 from CourtFileReference cfr")
    ArrayList<String> courtFileReference8();

    @Query("select cfr.courtFileReference9 from CourtFileReference cfr")
    ArrayList<String> courtFileReference9();

    @Query("select cfr.courtFileReference10 from CourtFileReference cfr")
    ArrayList<String> courtFileReference10();

    @Query("select cfr.courtFileReference11 from CourtFileReference cfr")
    ArrayList<String> courtFileReference11();

    @Query("select cfr.courtFileReference12 from CourtFileReference cfr")
    ArrayList<String> courtFileReference12();

}
