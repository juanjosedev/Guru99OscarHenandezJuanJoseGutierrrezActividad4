package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CP_001_Transferencia_Campo_Payees_Obligatorio_Test.class, CP_002_Transferencia_Test.class,
		CP_003_Cambio_Password_Test.class })
public class AllTests {

}
