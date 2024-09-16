package com.csc;

public class GroceryCounter 
{
  private int tensDigit;
  private int onesDigit;
  private int tenthsDigit;
  private int hundredthsDigit;
  private int overflowCount;

  public GroceryCounter() 
  {
    tensDigit = 0;
    onesDigit = 0;
    tenthsDigit = 0;
    hundredthsDigit = 0;
    overflowCount = 0;
  }

  public void incrementTens()
  {
    tensDigit++;

    if(tensDigit > 9)
    {
      tensDigit = 0;
      overflowCount++;
    }
  }

  public void incrementOnes()
  {
    onesDigit++;
    
    if(onesDigit > 9)
    {
      onesDigit = 0;
      incrementTens();
    }
  }

  public void incrementTenths() 
  {
    tenthsDigit++;

    if (tenthsDigit > 9) 
    {
        tenthsDigit = 0;
        incrementOnes(); 
    }
  }

  public void incrementHundredths() 
  {
    hundredthsDigit++;

    if (hundredthsDigit > 9) 
    {
        hundredthsDigit = 0;
        incrementTenths();  
    }
  }

  public String total()
  {
    return String.format("$%d%d.%d%d", tensDigit, onesDigit, tenthsDigit, hundredthsDigit);
  }

  public int numberOfOverflows() 
  {
    return overflowCount;
  }

  public void clear() 
  {
    tensDigit = 0;
    onesDigit = 0;
    tenthsDigit = 0;
    hundredthsDigit = 0;
    overflowCount = 0;
  }
}
