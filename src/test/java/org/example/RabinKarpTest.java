package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RabinKarpTest {
    final static RabinKarp rabinKarpTest1 = new RabinKarp("ABA", "AAAAAAAABBBBBBAAABAABBAAAA");
    final static RabinKarp rabinKarpTest2 = new RabinKarp("AB", "AAAAAAAAAAAAAAAAAABCH");
    final static RabinKarp rabinKarpTest3 = new RabinKarp("C", "AAAAAAAABBBBBBAAABA");

    @Test
    void search() {
        ArrayList<Integer> actual1 = rabinKarpTest1.search();
        ArrayList<Integer> expected1 = new ArrayList<>();
        expected1.add(17);
        assertEquals(expected1, actual1);

    }
    @Test
    void search1(){
        ArrayList<Integer> actual2 = rabinKarpTest2.search();
        ArrayList<Integer> expected2 = new ArrayList<>();
        expected2.add(18);
        assertEquals(expected2, actual2);



    }
    @Test
    void search2(){
        ArrayList<Integer> actual3 = rabinKarpTest3.search();
        ArrayList<Integer> expected3 = new ArrayList<>();
        assertEquals(expected3, actual3);



    }
}