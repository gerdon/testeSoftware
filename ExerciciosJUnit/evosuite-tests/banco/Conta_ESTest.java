/*
 * This file was automatically generated by EvoSuite
 * Mon Nov 12 10:55:04 GFT 2018
 */

package banco;

import static org.evosuite.runtime.EvoAssertions.verifyException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(useVNET = true, separateClassLoader = true, useJEE = true) 
public class Conta_ESTest extends Conta_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Conta conta0 = new Conta("", 0.0);
      try { 
        conta0.creditar((-0.643994140625));
        fail("Expecting exception: OperacaoIlegalException");
      
      } catch(OperacaoIlegalException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("banco.Conta", e);
      }
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Conta conta0 = new Conta("", 0.0);
      try { 
        conta0.debitar((-0.9738774676757812));
        fail("Expecting exception: OperacaoIlegalException");
      
      } catch(OperacaoIlegalException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("banco.Conta", e);
      }
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Conta conta0 = new Conta("", 0.9758600888069466);
      double double0 = conta0.getSaldo();
      assertEquals(0.9758600888069466, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Conta conta0 = new Conta("", (-0.960308466796875));
      double double0 = conta0.getSaldo();
      assertEquals((-0.960308466796875), double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Conta conta0 = new Conta("", 309.5485932529);
      try { 
        conta0.debitar(310.5485932529);
        fail("Expecting exception: OperacaoIlegalException");
      
      } catch(OperacaoIlegalException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("banco.Conta", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Conta conta0 = new Conta("", (-0.5));
      double double0 = conta0.creditar(0.5);
      assertEquals(0.0, conta0.getSaldo(), 0.01);
      assertEquals(0.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Conta conta0 = new Conta("", (-0.5344367635397828));
      double double0 = conta0.creditar(0.5);
      assertEquals((-0.034436763539782755), conta0.getSaldo(), 0.01);
      assertEquals((-0.034436763539782755), double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Conta conta0 = new Conta("", 952.0009843749999);
      // Undeclared exception!
      try { 
        conta0.transferir((Conta) null, 0.9295546875);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("banco.Conta", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Conta conta0 = new Conta("", 0.0);
      double double0 = conta0.creditar(0.9758600888069466);
      assertEquals(0.9758600888069466, conta0.getSaldo(), 0.01);
      assertEquals(0.9758600888069466, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Conta conta0 = new Conta("", 1998.6077885740128);
      double double0 = conta0.debitar(0.9758600888069466);
      assertEquals(1997.631928485206, conta0.getSaldo(), 0.01);
      assertEquals(1997.631928485206, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Conta conta0 = new Conta("", 0.0);
      double double0 = conta0.getSaldo();
      assertEquals(0.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Conta conta0 = new Conta("", 0.0);
      try { 
        conta0.creditar(0.0);
        fail("Expecting exception: OperacaoIlegalException");
      
      } catch(OperacaoIlegalException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("banco.Conta", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Conta conta0 = new Conta("", 0.5845850672998222);
      conta0.transferir(conta0, 0.5);
      assertEquals(0.5845850672998222, conta0.getSaldo(), 0.01);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Conta conta0 = new Conta("", 0.0);
      try { 
        conta0.debitar(0.0);
        fail("Expecting exception: OperacaoIlegalException");
      
      } catch(OperacaoIlegalException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("banco.Conta", e);
      }
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Conta conta0 = new Conta("", 0.0);
      try { 
        conta0.transferir(conta0, 0.5);
        fail("Expecting exception: OperacaoIlegalException");
      
      } catch(OperacaoIlegalException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("banco.Conta", e);
      }
  }
}
