package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGroceryCounter 
{
  GroceryCounter counter;

  @BeforeEach
  void setUp() 
  {
    counter = new GroceryCounter();
  }

  @Test
  void testOne() 
  {
    assertEquals("$00.00", counter.total());
  }

  @Test
  void testTwo() 
  {
    counter.incrementTens();
    counter.incrementTens();
    counter.incrementHundredths();

    assertEquals("$20.01", counter.total());

    for(int i = 0; i < 35; i++) 
    {
      counter.incrementOnes();
    }

    assertEquals("$55.01", counter.total());
    assertEquals(0, counter.numberOfOverflows());

    for(int i = 0; i < 100; i++) 
    {
      counter.incrementOnes();
    }

    assertEquals("$55.01", counter.total());
    assertEquals(1, counter.numberOfOverflows());

    counter.clear();

    assertEquals("$00.00", counter.total());
    assertEquals(0, counter.numberOfOverflows());
  }

  @Test
  void testThree() 
  {
    for(int i = 0; i < 90; i++) 
    {
      counter.incrementTens();
    }

    assertEquals(9, counter.numberOfOverflows());
  }

  @Test
  void testFour() 
  {
    for(int i = 0; i < 9; i++) 
    {
      counter.incrementTens();
      counter.incrementOnes();
      counter.incrementTenths();
      counter.incrementHundredths();
    }

    assertEquals("$99.99", counter.total());
    assertEquals(0, counter.numberOfOverflows());

    counter.incrementHundredths();

    assertEquals("$00.00", counter.total());
    assertEquals(1, counter.numberOfOverflows());
  }

}
